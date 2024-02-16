package myy803.diplomas_mgt_app_skeleton_test.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import myy803.diplomas_mgt_app_skeleton.service.ProfessorService;
import myy803.diplomas_mgt_app_skeleton.service.SubjectService;
import myy803.diplomas_mgt_app_skeleton.service.UserService;

@ContextConfiguration(classes = ProfessorService.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(
  locations = "classpath:application.properties")
class TestProfessorServiceJpa {

	@Mock 
	ProfessorService professorService;
	
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("unchecked")
	@Test
	void testUserDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(professorService);
	}

	@Test
	void testiisProfessorPresent() {
		Professor p=new Professor();
		boolean storedProfessor = professorService.isProfessorPresent(p);
		Assertions.assertNotNull(storedProfessor);
		Assertions.assertEquals(false, storedProfessor);
	}
	@Test
    void testseeSubjects() {
		Professor p=new Professor();
		Subject s=new Subject();
		s.setTitle("math");
		p.addSubject(s);
		Mockito.when(professorService.seeSubjects(p)).thenReturn(p.getSubjects());
		List<Subject> storedProfessor = professorService.seeSubjects(p);
        assertNotNull(professorService);

        assertEquals("math", storedProfessor.get(0).getTitle());
    }
	@Test
	void testSeeApplications() {
	    Professor p = new Professor();
	    Subject s = new Subject();
	    s.setTitle("math");
	    Application a = new Application();
	    a.setSubject(s);
	    s.getApplications().add(a);
	    s.setSupervisor(p);
	    Mockito.when(professorService.seeApplications(p)).thenReturn(s.getApplications());
	    List<Application> storedProfessor = professorService.seeApplications(p);
	    assertNotNull(professorService);
	    assertEquals("math", storedProfessor.get(0).getSubject().getTitle());
	}
	@Test
    void testgetProfessor() {
		Professor p = new Professor();
		p.setUsername("anna2000");
		Mockito.when(professorService.getProfessor("anna2000")).thenReturn(p);
		Professor storedProfessor = professorService.getProfessor("anna2000");
        assertNotNull(professorService);
        assertEquals("anna2000", storedProfessor.getUsername());
    }
	@Test
    void testgetRandomStudent() {
		Student s=new Student();
		s.setName("anna");
		Application a=new Application();
		a.setStudent(s);
		List <Application> l=new ArrayList <Application>();
		l.add(a);
		s.setappl(l);
		Mockito.when(professorService.getRandomStudent(l)).thenReturn(s);
		Student storedProfessor = professorService.getRandomStudent(s.getappl());
        assertNotNull(professorService);
        assertEquals("anna", storedProfessor.getName());
    }
	@Test
    void testgetBestGradeStudent() {
		Student s=new Student();
		s.setName("anna");
		Application a=new Application();
		a.setStudent(s);
		List <Application> l=new ArrayList <Application>();
		l.add(a);
		s.setappl(l);
		Mockito.when(professorService.getBestGradeStudent(l)).thenReturn(s);
		Student storedProfessor = professorService.getBestGradeStudent(s.getappl());
        assertNotNull(professorService);
        assertEquals("anna", storedProfessor.getName());
    }
	@Test
    void testgetFewestCoursesStudent() {
		Student s=new Student();
		s.setName("anna");
		Application a=new Application();
		a.setStudent(s);
		List <Application> l=new ArrayList <Application>();
		l.add(a);
		s.setappl(l);
		Mockito.when(professorService.getFewestCoursesStudent(l)).thenReturn(s);
		Student storedProfessor = professorService.getFewestCoursesStudent(s.getappl());
        assertNotNull(professorService);
        assertEquals("anna", storedProfessor.getName());
    }
	@Test
    void testgetThresholdGradeStudent() {
		double t1=0.1;
		double t2=0.2;
		Student s=new Student();
		s.setName("anna");
		Application a=new Application();
		a.setStudent(s);
		List <Application> l=new ArrayList <Application>();
		l.add(a);
		s.setappl(l);
		Mockito.when(professorService.getThresholdGradeStudent(l,t1,t2)).thenReturn(s);
		Student storedProfessor = professorService.getThresholdGradeStudent(s.getappl(),t1,t2);
        assertNotNull(professorService);
        assertEquals("anna", storedProfessor.getName());
    }
}