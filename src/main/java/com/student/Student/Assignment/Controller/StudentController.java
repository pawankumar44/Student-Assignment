package com.student.Student.Assignment.Controller;

import com.student.Student.Assignment.Model.Student;
import com.student.Student.Assignment.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudnet(@RequestBody Student student){
        Student student1 = studentService.addStudent(student);
        String response = "";
        if(student1!= null) {
            response = "Student added successfully";
        }
        else response = "Failed to add student";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("find-by-roll")
    public ResponseEntity<Student> findByRoll(@RequestParam int roll_num){
        Student student = studentService.findByRoll(roll_num);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    //find roll nums of getting max marks
    @GetMapping("find-with-max-marks")
    public ResponseEntity<List<Integer>> findRollMaxMarks(){
        return new ResponseEntity<>(studentService.getRollMaxMarks(),HttpStatus.OK);
    }
}
