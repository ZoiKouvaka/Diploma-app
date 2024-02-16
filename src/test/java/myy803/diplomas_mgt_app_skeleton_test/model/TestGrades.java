package myy803.diplomas_mgt_app_skeleton_test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myy803.diplomas_mgt_app_skeleton.Grades;

class TestGrades {
	
	Grades grades;
	
	@BeforeEach
	void setUp() throws Exception {
		grades = new Grades();
	}

	@Test
	void testSetAndGetImpl() {
		grades.setImpl(5.8);
		assertEquals(5.8, grades.getImpl());
	}
	
	@Test
	void testSetAndGetPres() {
		grades.setPres(2.3);
		assertEquals(2.3,grades.getPres());
	}
	
	@Test
	void testSetAndGetRep() {
		grades.setRep(6.5);
		assertEquals(6.5,grades.getRep());
	}

}