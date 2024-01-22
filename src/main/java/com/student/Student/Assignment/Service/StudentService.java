package com.student.Student.Assignment.Service;

import com.student.Student.Assignment.Model.Student;
import com.student.Student.Assignment.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    //Add a student
    public Student addStudent(Student student){
        Student student1 = studentRepo.save(student);
        return student1;
    }

    //to get by roll num, then same
//    public Student getByRoll
    public Student findByRoll(int roll_num){
        Student student = studentRepo.findById(roll_num).get();
        return student;
    }

    //get roll number of student getting max marks
    public List<Integer> getRollMaxMarks(){
        //in repo we find what is max marks
        int max = studentRepo.findMaxMarks();
        return studentRepo.findStudentsWithMaxMarks(max);
    }

}
