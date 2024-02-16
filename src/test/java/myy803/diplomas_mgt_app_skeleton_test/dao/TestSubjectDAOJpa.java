package myy803.diplomas_mgt_app_skeleton_test.dao;

import myy803.diplomas_mgt_app_skeleton.dao.StudentDAO;
import myy803.diplomas_mgt_app_skeleton.dao.SubjectDAO;
import myy803.diplomas_mgt_app_skeleton.Professor;
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

import myy803.diplomas_mgt_app_skeleton.Subject;

@ContextConfiguration(classes = SubjectDAO.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(
  locations = "classpath:application.properties")


public class TestSubjectDAOJpa {

    @Mock
    private SubjectDAO subjectDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAllBySupervisor() {
    	Professor p = new Professor();
	    p.setSurname("papadopoulos");
	    Subject s=new Subject();
	    s.setSupervisor(p);
	    p.addSubject(s);
	    List <Subject> list=p.getSubjects();
	    Mockito.when(subjectDAO.findAllBySupervisor(p)).thenReturn(list);
        List<Subject> storedSubjects = subjectDAO.findAllBySupervisor(p);
        assertNotNull(storedSubjects);
        assertEquals("papadopoulos", storedSubjects.get(0).getSupervisor().getSurname());
    }
    @Test
    void testfindById() {
    	Subject p = new Subject();
	    p.setTitle("aa");
	  
	    Mockito.when(subjectDAO.findById(p.getId())).thenReturn(Optional.of(p));
    	Optional<Subject> storedSubject = subjectDAO.findById(p.getId());
	    Assertions.assertNotNull(storedSubject);
	    Assertions.assertTrue(storedSubject.isPresent()); 

	    Subject sub = storedSubject.orElseThrow(); 
	    Assertions.assertEquals("aa", sub.getTitle());
    }
}