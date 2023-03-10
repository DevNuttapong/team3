package com.example.accessingdatamysql.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.example.accessingdatamysql.model.Course;
=======
>>>>>>> 6039cba66c4e205e30c4739a365eb7a79c854240
import com.example.accessingdatamysql.model.Student;
import com.example.accessingdatamysql.service.repo.StudentRepository;
import com.example.accessingdatamysql.service.repo.entity.StudentEntity;

@Service    
public class CourseService {

	@Autowired // This means to get the bean called userRepository which is auto-generated by Spring, we will use it to handle the data
<<<<<<< HEAD
	// private CourseRepository courseRepository;

    // public List<Course> findAll() {   
    //     Iterable<couresEntity> iter = courseRepository.findAll();
        
        
    //     List<Course> ls = new ArrayList<>();    
    //     iter.forEach(courseEntity -> {
    //         Course course = new course();
    //         course.setCourseId(courseEntity.getCourseId());
    //         course.setCourseName(courseEntity.getCourseName());
    //         course.setCredit(courseEntity.getCredit());
    //         course.setMaxSeat(course.Entity.getMaxSeat());
    //         ls.add(course);
    //     });    
    //     return ls;    
    // }


    public Course save(Course course) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseId(course.getCourseId());
		courseEntity.setCourseName(course.getCourseName());
		courseEntity.setCredit(course.getCredit());
		courseEntity.setMaxSeat(course.getMaxSeat());


		StudentEntity resultStudentEntity = courseRepository.save(courseEntity);
=======
	private CourseRepository studentRepository;

    public List<Student> findAll() {   
        Iterable<StudentEntity> iter = studentRepository.findAll();
        
        
        List<Student> ls = new ArrayList<>();    
        iter.forEach(studentEntity -> {
            Student student = new Student();
            student.setId(studentEntity.getId());
            student.setName(studentEntity.getName());
            student.set(studentEntity.getEmail());
            student.setIsActive(1 == studentEntity.getState());
            ls.add(student);
        });    
        return ls;    
    }


    public Student save(Student student) {
        StudentEntity studentEntity = new StudentEntity();
		studentEntity.setName(student.getName());
		studentEntity.setEmail(student.getEmail());
		studentEntity.setState(1);                                         // 0: Expired, 1: Active (Default)
		studentEntity.setCreated(new Timestamp(System.currentTimeMillis()));


		StudentEntity resultStudentEntity = studentRepository.save(studentEntity);
>>>>>>> 6039cba66c4e205e30c4739a365eb7a79c854240


        Student resultStudent = new Student();
        resultStudent.setId(resultStudentEntity.getId());
        resultStudent.setName(resultStudentEntity.getName());
        resultStudent.setEmail(resultStudentEntity.getEmail());
        resultStudent.setIsActive(1 == studentEntity.getState());

        return resultStudent;
    }


<<<<<<< HEAD
    // public int countStudents(boolean isActive) {   
    //     Integer count = studentRepository.countStudents(isActive? 1: 0);
    //     return Optional.ofNullable(count).orElse(0);    
    // }
=======
    public int countStudents(boolean isActive) {   
        Integer count = studentRepository.countStudents(isActive? 1: 0);
        return Optional.ofNullable(count).orElse(0);    
    }
>>>>>>> 6039cba66c4e205e30c4739a365eb7a79c854240
}
