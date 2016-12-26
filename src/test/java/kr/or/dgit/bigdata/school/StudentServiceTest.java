package kr.or.dgit.bigdata.school;
import java.util.Calendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.school.dto.Student;
import kr.or.dgit.bigdata.school.service.StudentService;

public class StudentServiceTest {
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
	public void testSelectByAll() {
		List<Student> list = studentService.findAllStudent();
		Assert.assertNotNull(list);
		for(Student s : list){
			System.out.println(s);
		}
	}
	
	@Test
	public void testSelectByNo() {
		Student std = studentService.selectBtNo(1);
		Assert.assertNotNull(std);		
		System.out.println(std);		
	}
	/*
	@Test
	public void testInsertItem() {
		Calendar cal = Calendar.getInstance();
		cal.set(1977, 9, 7);
			
		Student insStd = new Student(2, "공유", "ky@test.co.kr", cal.getTime());
		studentService.insertItem(insStd);
		
		Student std = studentService.selectBtNo(insStd.getStudId());
		
		Assert.assertNotNull(std);
	}
	*/
	/*
	@Test
	public void testDeleteItem(){
		studentService.deleteItem(4);
		Student std = studentService.selectBtNo(4);
		Assert.assertNull(std);
	}
	*/
	
	@Test
	public void testUpdateItem(){
		Calendar cal = Calendar.getInstance();
		// 시, 분, 초를 0으로 초기화
		cal.clear();
		cal.set(2000, 01,01);
		
		Student updStd = studentService.selectBtNo(2);
		updStd.setName("잘생긴 공유");
		updStd.setDob(cal.getTime());
		
		studentService.updateItem(updStd);
		
		Student std = studentService.selectBtNo(updStd.getStudId());
		Assert.assertEquals(updStd, std);//equals 오버라이딩을 해야 함(Student Class에서)
	}
}
