package myy803.diplomas_mgt_app_skeleton_test.model;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Subject;
import myy803.diplomas_mgt_app_skeleton.Thesis;

class TestProfessor {
	
    Professor professor;
	
	@BeforeEach
	void setUp() throws Exception {
		professor = new Professor();
	}
	
	@Test
	public void testSetAndGetName() {
		professor.setName("Ioannis");
		assertEquals("Ioannis", professor.getName());
	}
	
	@Test
	public void testSetAndGetSurname() {
		professor.setSurname("Ioannou");
		assertEquals("Ioannou", professor.getSurname());
	}
	
	@Test
	public void testSetAndGetUsername() {
		professor.setUsername("johnioannou");
		assertEquals("johnioannou",professor.getUsername());
	}
	
	@Test
	public void testSetAndGetSpecialty() {
		professor.setSpecialty("Discrete Maths");
		assertEquals("Discrete Maths",professor.getSpecialty());
	}
	
	@Test
	public void testSetAndGetId() {
		professor.setId(562154);
		assertEquals(562154,professor.getId());
	}
	
	@Test
	public void testSetAndGetThesis() {
		List<Thesis> thesis = new ArrayList<Thesis>();
		professor.setThesis(thesis);
		assertEquals(thesis,professor.getThesis());
	}
	
	@Test
	public void testSetAndGetSubjects() {
		List<Subject> subjects = new ArrayList<Subject>();
		professor.setSubjects(subjects);
		assertEquals(subjects,professor.getSubjects());
	}
	
	@Test
    public void testSetAndGetProfile() {
        Professor professor = new Professor();
        professor.setProfile("Ioannis", "Ioannou", "Computer Science");

        assertEquals("Ioannis", professor.getName());
        assertEquals("Ioannou", professor.getSurname());
        assertEquals("Computer Science", professor.getSpecialty());
    }

    @Test
    public void testAddAndDeleteSubject() {
        Professor professor = new Professor();
        Subject subject = new Subject();
        
        List<Subject> subjects = new ArrayList<Subject>();
        professor.setSubjects(subjects);

        professor.addSubject(subject);
        assertTrue(professor.getSubjects().contains(subject));

        professor.deleteSubject(subject);
        assertFalse(professor.getSubjects().contains(subject));
    }
 

}