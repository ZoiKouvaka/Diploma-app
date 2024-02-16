package myy803.diplomas_mgt_app_skeleton_test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myy803.diplomas_mgt_app_skeleton.Role;

class TestRole {

	@Test
    public void testGetValue() {
        assertEquals("Student", Role.STUDENT.getValue());
        assertEquals("Professor", Role.PROFESSOR.getValue());
    }

}