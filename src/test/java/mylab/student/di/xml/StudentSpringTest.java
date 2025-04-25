package mylab.student.di.xml;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-student-di.xml")
public class StudentSpringTest {
	@Autowired
	@Qualifier("javaCourse")
	Course course;
	
	@Resource(name="gradeService")
	GradeService service;
	
	// gradeService 테스트
	@Test
	void testService() {
		assertNotNull(service);
		assertEquals("Java Programming", service.getCourse().getCourseName());
		System.out.println(service.getHighScoreStudents(70));
		List<Student> list = service.getCourse().getStudents();
		for(Student s : list) {
			System.out.println(s.getName() + " : " + s.getScore());
			System.out.println(service.calculateGrade(s.getId()));
		}
	}
	
	// Course 테스트
	@Test @Disabled
	void testCourse() {
		assertNotNull(course);
		assertEquals("Java Programming", course.getCourseName());
		assertEquals(3, course.getStudents().size());
		assertEquals("엠마", course.getStudents().get(0).getName());
		/*
 		 * course.getStudents() => List<Student>  학생목록
 		 * course.getStudents().get(0) => Student 학생
 		 * course.getStudents().get(0).getName() => String 학생의 이름
 		*/
		System.out.println(course.getAverageScore());
		assertEquals(78.3, course.getAverageScore(),0.1);
	}
	
	
}
