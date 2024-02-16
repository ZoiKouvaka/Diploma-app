package myy803.diplomas_mgt_app_skeleton_test.service;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.User;
import myy803.diplomas_mgt_app_skeleton.dao.StudentDAO;
import myy803.diplomas_mgt_app_skeleton.service.UserService;

@ContextConfiguration(classes = UserService.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(
  locations = "classpath:application.properties")
class TestUserServiceJpa {

	@Mock 
	UserService userService;
	
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("unchecked")
	@Test
	void testUserDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(userService);
	}

	@Test
	void testisUserPresent() {
		User u = new User();
		boolean storedEmployee = userService.isUserPresent(u);
		Assertions.assertNotNull(storedEmployee);
		Assertions.assertEquals(false, storedEmployee);
	}
	@Test
	void testsaveUser() {

		User u = new User();

	    userService.saveUser(u);

	    assertNotNull(u.getId());

	}
}