package myy803.diplomas_mgt_app_skeleton_test.dao;

import myy803.diplomas_mgt_app_skeleton.dao.ApplicationDAO;
import myy803.diplomas_mgt_app_skeleton.dao.StudentDAO;
import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Student;
import myy803.diplomas_mgt_app_skeleton.Subject;
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

@ContextConfiguration(classes = ApplicationDAO.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(
  locations = "classpath:application.properties")


public class TestApplicationDAOJpa {

    @Mock
    private ApplicationDAO applicationDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void testFindById() {
        Application application = new Application();
        Student s=new Student();
        s.setName("anna");
        application.setStudent(s);
        Mockito.when(applicationDAO.findById(4)).thenReturn(Optional.of(application));

        Optional<Application> storedApplication = applicationDAO.findById(4);
        assertNotNull(storedApplication);
        assertTrue(storedApplication.isPresent());

        Application actualApplication = storedApplication.orElseThrow();
        assertEquals("anna", actualApplication.getStudent().getName());
    }

}
