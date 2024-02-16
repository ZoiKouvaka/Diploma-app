package myy803.diplomas_mgt_app_skeleton_test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Student;
import myy803.diplomas_mgt_app_skeleton.Subject;


class TestApplication {
	
	Student student;
	Subject subject;
	Application application;
	
	@BeforeEach
	public void setUp() {
		student = new Student();
		subject = new Subject();
		application = new Application(student, subject);
	}
	
	@Test
	public void testSetAndGetStudent() {
		Student newStudent = new Student();
		application.setStudent(newStudent);
		assertEquals(newStudent, application.getStudent());
	}
	
	@Test
	public void testSetAndGetSubject() {
		Subject newSubject = new Subject();
		application.setSubject(newSubject);
		assertEquals(newSubject, application.getSubject());
	}
	
}