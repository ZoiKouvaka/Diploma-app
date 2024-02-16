package myy803.diplomas_mgt_app_skeleton_test.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
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
import myy803.diplomas_mgt_app_skeleton.Subject;
import myy803.diplomas_mgt_app_skeleton.Thesis;
import myy803.diplomas_mgt_app_skeleton.User;
import myy803.diplomas_mgt_app_skeleton.dao.StudentDAO;
import myy803.diplomas_mgt_app_skeleton.service.SubjectService;
import myy803.diplomas_mgt_app_skeleton.service.UserService;

@ContextConfiguration(classes = SubjectService.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(
  locations = "classpath:application.properties")
class TestSubjectServiceJpa {

	@Mock 
	SubjectService subjectService;
	
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("unchecked")
	@Test
	void testUserDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(subjectService);
	}
    @Test
	void testsaveSubject() {
	
    	Subject s = new Subject();
    	subjectService.saveSubject(s);
	    assertNotNull(s.getId());
	}
	@Test
	void testFindById() {
		Subject s=new Subject();
		Mockito.when(subjectService.findById(s.getId())).thenReturn(s);
		Subject storedSubject = subjectService.findById(s.getId());
		Assertions.assertNotNull(storedSubject);
		Assertions.assertEquals(s.getId(), storedSubject.getId());
	}
	@Test
    void testfindAvailableSubjects() {
		Subject s=new Subject();
		List<Subject> l=new ArrayList<Subject>();
		l.add(s);
		Mockito.when(subjectService.findAvailableSubjects()).thenReturn(l);
        List<Subject> storedSubject = subjectService.findAvailableSubjects();
        assertNotNull(storedSubject);
        assertEquals(s, storedSubject.get(0));
    }
	@Test
    void testfindAll() {
		Subject s=new Subject();
		List<Subject> l=new ArrayList<Subject>();
		l.add(s);
		Mockito.when(subjectService.findAll()).thenReturn(l);
        List<Subject> storedSubject = subjectService.findAll();
        assertNotNull(storedSubject);
        assertEquals(s, storedSubject.get(0));
    }
	@Test
    void testfindAllBySubject() {
		Subject s=new Subject();
		Application a=new Application();
		List<Application> l=new ArrayList<Application>(); 
		l.add(a);
		s.setApplications(l);
		Mockito.when(subjectService.findAllBySubject(s)).thenReturn(l);
        List<Application> storedSubject = subjectService.findAllBySubject(s);
        assertNotNull(storedSubject);
        assertEquals(a.getId(), storedSubject.get(0).getId());
    }
	@Test
	void testDeleteSubject() {
	    Subject subject = new Subject();

	    subjectService.deleteSubject(subject);

	    Mockito.verify(subjectService).deleteSubject(subject);

	}
	
	@Test
    void testfindBySubject() {
		Subject s=new Subject();
		Thesis a=new Thesis();
		a.setSubject(s);
		Mockito.when(subjectService.findBySubject(s)).thenReturn(a);
        Thesis storedSubject = subjectService.findBySubject(s);
        assertNotNull(storedSubject);
        assertEquals(a.getId(), storedSubject.getId());
    }

}