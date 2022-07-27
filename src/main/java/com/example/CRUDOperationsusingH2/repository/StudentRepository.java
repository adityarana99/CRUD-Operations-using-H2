package com.example.CRUDOperationsusingH2.repository;

import com.example.CRUDOperationsusingH2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
