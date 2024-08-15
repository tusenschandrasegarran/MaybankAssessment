package com.tusen.springBootProject.rest;

import com.tusen.springBootProject.entity.CatFactNinjaCustom;
import com.tusen.springBootProject.entity.Students;
import com.tusen.springBootProject.service.CatFactNinjaService;
import com.tusen.springBootProject.service.StudentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentsRestController {

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private CatFactNinjaService catFactNinjaService;

    @Autowired
    public StudentsRestController(StudentsService theStudentsService){
        studentsService = theStudentsService;
    }

    private static final Logger logger = LoggerFactory.getLogger(StudentsRestController.class);

    @GetMapping("/hello")
    public String hello(){
        logger.debug("Debug log from TestController 123");
        return "hello world";
    }

    // must do pagination
//    @GetMapping("/findAll")
//    public List<Students> findStudent(){
//        return studentsService.findAll();
//    }

    @GetMapping("/findAll")
    public List<Students> findStudent(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return studentsService.findAll(page,size);
    }

    // find by id
    @GetMapping("/{studentId}")
    public Optional<Students> getStudents(@PathVariable int studentId){
        Optional<Students> students = studentsService.findById(studentId);

        if (students.isEmpty()){
            throw new StudentsNotFoundException("Student id not found : " + studentId);
        }

        return students;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Students addStudents(@RequestBody Students newStudent){
        newStudent.setId(0);
        return studentsService.save(newStudent);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Students updateStudents(@RequestBody Students newStudent){

        Optional<Students> students = studentsService.findById(newStudent.getId());

        if (students.isEmpty()){
            throw new StudentsNotFoundException("Student id not found - " + newStudent.getId());
        }

        return studentsService.save(newStudent);
    }

    @RequestMapping(value = "/{studentId}", method = RequestMethod.DELETE)
    public String deleteStudents(@PathVariable int studentId){

        Optional<Students> students = studentsService.findById(studentId);

        if (students.isEmpty()){
            throw new StudentsNotFoundException("Student id not found - " + studentId);
        }

        studentsService.deleteById(studentId);

        return "Successfully deleted student id : " + studentId;
    }

    //catFactNinjaService
    @GetMapping("/third-party-api")
    public Mono<CatFactNinjaCustom> getCustomData(){
        String url = "https://catfact.ninja/fact";
        return catFactNinjaService.callCatFactNinjaApi(url);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentsNotFoundException exc){

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

}
