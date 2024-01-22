package com.student.Student.Assignment.Repo;

import com.student.Student.Assignment.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query("select max(s.marks) from Student s")
    int findMaxMarks();

    @Query("select roll_num from Student s where s.marks =:max_marks ")
    List<Integer> findStudentsWithMaxMarks(@Param("max_marks") int max_marks);
}
