package com.tusen.springBootProject.service;

import com.tusen.springBootProject.dao.StudentsRepository;
import com.tusen.springBootProject.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsServiceImpl implements StudentsService{

    private StudentsRepository studentsRepository;

    @Autowired
    public StudentsServiceImpl(StudentsRepository theStudentsRepository){
        studentsRepository = theStudentsRepository;
    }

    @Transactional
    @Override
    public Students save(Students theStudents) {
        return studentsRepository.save(theStudents);
    }

    @Override
    public Optional<Students> findById(Integer id) {
        return studentsRepository.findById(id);
    }

    @Override
    public List<Students> findAll() {
        return studentsRepository.findAll();
    }

    @Override
    public List<Students> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        studentsRepository.findAll(pageable);
        return studentsRepository.findAll(pageable).getContent();
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        studentsRepository.deleteById(id);
    }
}
