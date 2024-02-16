package myy803.diplomas_mgt_app_skeleton_test.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Student;

class TestStudent {

	    Student student;
	    
	    @BeforeEach
	    void setUp() throws Exception {
	        student = new Student();
	    }

	    @Test
	    void testSetAndGetName() {
	    	student.setName("Jane");
	        assertEquals("Jane", student.getName());
	    }
	    
	    @Test
	    void testSetAndGetSurName() {
	    	student.setSurname("Smith");
	        assertEquals("Smith", student.getSurname());
	    }
	    
	    @Test
	    void testSetAndGetYearsofstudies() {
	    	student.setYearsofstudies(2);
	        assertEquals(2, student.getYearsofstudies());
	    }
	    
	    @Test
	    void testSetAndGetAM() {
	    	student.setAM(5890);
	        assertEquals(5890, student.getAM());
	    }
	    
	    @Test
	    void testSetAndGetCurrenAvgGrade() {
	    	student.setCurrenAvgGrade(8.0);
	        assertEquals(8.0, student.getCurrenAvgGrade());
	    }
	    
	    @Test
	    void testSetAndGetNumberRemainingCoursesForGrad() {
	    	student.setNumberRemainingCoursesForGrad(34);
	        assertEquals(34, student.getNumberRemainingCoursesForGrad());
	    }
	    
	    @Test
	    void testSetAndGetUsername() {
	    	student.setUsername("janesmith");
	        assertEquals("janesmith", student.getUsername());
	    }
	    
	    
	    @Test
	    void testAccessSubjects() {
	        ArrayList<Professor> profList = new ArrayList<>();
	        Professor prof1 = new Professor();
	        prof1.setName("Mary");
	        prof1.setSurname("Jones");
	        profList.add(prof1);
	        
	        student.accessSubjects(profList);
	    }
	    
	    @Test
	    void testSeeSubjects() {

	        ArrayList<Professor> profList = new ArrayList<>();
	        Professor prof1 = new Professor();
	        Professor prof2 = new Professor();
	        Professor prof3 = new Professor();
	        profList.add(prof1);
	        profList.add(prof2);
	        profList.add(prof3);


	        Student student = new Student();
	        student.setName("Marios");
	        student.setSurname("Papadopoulos");
	        
	        student.seeSubjects(profList);

	        assertTrue(true);
	    }
	    

}