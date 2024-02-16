package myy803.diplomas_mgt_app_skeleton_test.dao;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import myy803.diplomas_mgt_app_skeleton.dao.StudentDAO;
import myy803.diplomas_mgt_app_skeleton.dao.UserDAO;
import myy803.diplomas_mgt_app_skeleton.User;
import org.springframework.context.annotation.ComponentScan;

@ContextConfiguration(classes = UserDAO.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(
  locations = "classpath:application.properties")
public class TestUserDAOJpa {


	@Mock 
	UserDAO userDAO;
		
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("unchecked")
	@Test
	void testEmployeeDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(userDAO);
	}

    @Test
    void testFindByIdReturnsEmployee() {
        User user = new User();
        user.setPassword("aa");

        Mockito.when(userDAO.findByUsername("a")).thenReturn(Optional.of(user));

        Optional<User> storedUser = userDAO.findByUsername("a");
        Assertions.assertNotNull(storedUser);
        Assertions.assertTrue(storedUser.isPresent());

        User retrievedUser = storedUser.orElseThrow();
        Assertions.assertEquals("aa", retrievedUser.getPassword());
    }
}
