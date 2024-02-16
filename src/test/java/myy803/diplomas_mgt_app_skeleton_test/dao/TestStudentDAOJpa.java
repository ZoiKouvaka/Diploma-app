package myy803.diplomas_mgt_app_skeleton_test.dao;

import myy803.diplomas_mgt_app_skeleton.dao.StudentDAO;
import myy803.diplomas_mgt_app_skeleton.Student;
import myy803.diplomas_mgt_app_skeleton.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = StudentDAO.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(
  locations = "classpath:application.properties")


public class TestStudentDAOJpa {

    @Mock
    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("unchecked")
	@Test
	void testfindByAM() {
	    Student student = new Student();
	    student.setAM(4);
	    Mockito.when(studentDAO.findByAM(4)).thenReturn(Optional.of(student));

	    Optional<Student> storedStudent = studentDAO.findByAM(4); 

	    assertNotNull(storedStudent);
	    assertTrue(storedStudent.isPresent());
	    assertEquals(4, storedStudent.get().getAM());
	    Student retrievedstudent = storedStudent.orElseThrow();
        Assertions.assertEquals(4, retrievedstudent.getAM());

	}
    @Test
    void testfindByUsername() {
    	Student student = new Student();
	    student.setUsername("a");
	    Mockito.when(studentDAO.findByUsername("a")).thenReturn(Optional.of(student));
    	Optional<Student> storedStudent = studentDAO.findByUsername("a");

    	assertNotNull(storedStudent);
	    assertTrue(storedStudent.isPresent());
	    assertEquals("a", storedStudent.get().getUsername());
	    Student retrievedstudent = storedStudent.orElseThrow();
        Assertions.assertEquals("a", retrievedstudent.getUsername());
    }

}