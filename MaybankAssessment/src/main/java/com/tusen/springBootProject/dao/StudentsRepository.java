package com.tusen.springBootProject.dao;

import com.tusen.springBootProject.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
}
