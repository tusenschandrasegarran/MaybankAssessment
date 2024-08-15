package com.tusen.springBootProject.service;

import com.tusen.springBootProject.entity.Students;

import java.util.List;
import java.util.Optional;

public interface StudentsService {

    Students save(Students theStudents);

    Optional<Students> findById(Integer id);

    List<Students> findAll();

    List<Students> findAll(int page, int size);

    void deleteById(int id);
}
