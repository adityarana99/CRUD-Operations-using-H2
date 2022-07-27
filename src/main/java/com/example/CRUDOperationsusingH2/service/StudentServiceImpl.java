package com.example.CRUDOperationsusingH2.service;

import com.example.CRUDOperationsusingH2.entity.Student;
import com.example.CRUDOperationsusingH2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

//    List<Student> studentList = new ArrayList<>();

    @Override
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student updateStudent(Student stud){
        Optional<Student> optionalStudent = studentRepository.findById(stud.getStudentId());
        Student student = optionalStudent.get();
        student.setFirstName(stud.getFirstName());
        student.setLastName(stud.getLastName());
        student.setGender(stud.getGender());
        student.setDepartment(stud.getDepartment());

        studentRepository.save(student);
        return stud;
    }

    @Override
    public void deleteStudent(int studentId){
//        studentList = this.studentList.stream().filter(e -> e.getStudentId()!= studentId).collect(Collectors.toList());

        Student stud = studentRepository.getById(studentId);
        studentRepository.delete(stud);
    }
}
