package myy803.diplomas_mgt_app_skeleton_test.dao;

import myy803.diplomas_mgt_app_skeleton.dao.ProfessorDAO;
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

@ContextConfiguration(classes = ProfessorDAO.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(
  locations = "classpath:application.properties")


public class TestProfessorDAOJpa {

    @Mock
    private ProfessorDAO professortDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("unchecked")
	@Test
	void testfindByUsername() {
    	Professor p = new Professor();
	    p.setUsername("a");
	    Mockito.when(professortDAO.findByUsername("a")).thenReturn(Optional.of(p));
    	Optional<Professor> storedProfessor =professortDAO.findByUsername("a");
	    Assertions.assertNotNull(storedProfessor);
	    Assertions.assertTrue(storedProfessor.isPresent()); 
	    assertEquals("a", storedProfessor.get().getUsername());
        
	    Professor professor = storedProfessor.orElseThrow(); 
	    Assertions.assertEquals("a", professor.getUsername());
    }
    @Test
    void testfindBySurname() {
    	Professor p = new Professor();
	    p.setSurname("papadopoulos");
	    Mockito.when(professortDAO.findBySurname("papadopoulos")).thenReturn(Optional.of(p));
    	Optional<Professor> storedProfessor = professortDAO.findBySurname("papadopoulos");
	    Assertions.assertNotNull(storedProfessor);
	    Assertions.assertTrue(storedProfessor.isPresent()); 

	    Professor professor = storedProfessor.orElseThrow(); 
	    Assertions.assertEquals("papadopoulos", professor.getSurname());
    }

}