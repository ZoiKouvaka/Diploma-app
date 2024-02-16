package myy803.diplomas_mgt_app_skeleton_test.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Subject;

class TestSubject {
   
	Subject subject;
    List<Application> applications;
    Professor supervisor;

    @BeforeEach
    public void setUp() {
        subject = new Subject();
        applications = new ArrayList<Application>();
        supervisor = new Professor();
    }
    
    @Test
    public void testGetAndSetTitle() {
        String title = "Test Subject";
        subject.setTitle(title);
        assertEquals(title, subject.getTitle());
    }
    
    @Test
    public void testSetObjectives() {
        String objectives = "Test objectives";
        subject.setObjectives(objectives);
        assertEquals(objectives, subject.getObjectives());
    }
    
    @Test
    public void testSetIsavailable() {
        boolean isAvailable = false;
        subject.setIsavailable(isAvailable);
        assertFalse(subject.isAvailable());
    }
    
    @Test
    public void testGetAndSetSupervisor() {
        subject.setSupervisor(supervisor);
        assertEquals(supervisor, subject.getSupervisor());
    }
    
    @Test
    public void testGetAndSetApplications() {
        Application app1 = new Application();
        Application app2 = new Application();
        applications.add(app1);
        applications.add(app2);
        subject.setApplications(applications);
        assertEquals(applications, subject.getApplications());
    }
    
    @Test
    public void testGetAndSetId() {
        int id = 1234;
        subject.setId(id);
        assertEquals(id, subject.getId());
    }

}