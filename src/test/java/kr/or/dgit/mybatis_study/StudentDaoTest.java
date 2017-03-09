package kr.or.dgit.mybatis_study;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.service.StudentService;

public class StudentDaoTest {
	private static StudentService studentService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = StudentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentService = null;
	}

	@Test
	public void testSelectStudentByAll() {
		List<Student> lists = studentService.selectStudentByAll();
		Assert.assertNotNull(lists);
	}
	
	/*@Test
	public void testinsertStudentByAll() {
		Student student = new Student(4, "홍길동", "hgd@test.co.kr", new Date());
		int res = studentService.insertStudent(student);
		Assert.assertEquals(1, res);
	}*/
	
	@Test
	public void testSelectStudentByNo() {
		Student student = studentService.selectStudentByNo(1);
		Assert.assertNotNull(student);
	}

}
