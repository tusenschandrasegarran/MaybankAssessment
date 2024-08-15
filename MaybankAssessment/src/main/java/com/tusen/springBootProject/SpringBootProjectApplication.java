package com.tusen.springBootProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(StudentsDAO studentsDao){
//		return runner -> {
//			//createStudents(studentsDao);
//			findStudents(studentsDao);
//		};
//	}

//	private void createStudents(StudentsDAO studentsDao) {
//		Students newStudent = new Students("Teddy", "GSD", "teddyGSD@gmail.com");
//		studentsDao.save(newStudent);
//		System.out.println("Student saved: " + newStudent.getId());
//	}

//	private void findStudents(StudentsDAO studentsDao) {
//		Students newStudent = new Students("T12", "G12", "t12@gmail.com");
//		studentsDao.save(newStudent);
//		System.out.println("Student saved: " + newStudent.getId());
//
//		Students theStudent = studentsDao.findById(newStudent.getId());
//		System.out.println("Found the student : " + theStudent.toString());
//	}

}
