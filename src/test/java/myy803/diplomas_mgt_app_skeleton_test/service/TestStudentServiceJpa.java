package myy803.diplomas_mgt_app_skeleton_test.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Student;
import myy803.diplomas_mgt_app_skeleton.Subject;
import myy803.diplomas_mgt_app_skeleton.User;
import myy803.diplomas_mgt_app_skeleton.dao.StudentDAO;
import myy803.diplomas_mgt_app_skeleton.service.StudentService;
import myy803.diplomas_mgt_app_skeleton.service.SubjectService;
import myy803.diplomas_mgt_app_skeleton.service.UserService;

@ContextConfiguration(classes = StudentService.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(
  locations = "classpath:application.properties")
class TestStudentServiceJpa {

	@Mock 
	StudentService studentService;
	
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("unchecked")
	@Test
	void testUserDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentService);
	}

	@Test
	void testisStudentPresent() {
		Student s=new Student();
		boolean storedStudent = studentService.isStudentPresent(s);
		Assertions.assertNotNull(storedStudent);
		Assertions.assertEquals(false, storedStudent);
	}
	@Test
    void testgetStudent() {
		Student p = new Student();
		p.setUsername("anna2000");
		Mockito.when(studentService.getStudent("anna2000")).thenReturn(p);
		Student storedStudent = studentService.getStudent("anna2000");
        assertNotNull(studentService);
        assertEquals("anna2000", storedStudent.getUsername());
    }
	@Test
	void testSaveApplication() {

	    Application application = new Application();

	    studentService.saveApplication(application);

	    assertNotNull(application.getId());

	}
}