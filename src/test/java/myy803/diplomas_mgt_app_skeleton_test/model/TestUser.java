package myy803.diplomas_mgt_app_skeleton_test.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import myy803.diplomas_mgt_app_skeleton.Role;
import myy803.diplomas_mgt_app_skeleton.User;

class TestUser {
    
	User user;
	
	@BeforeEach
	void setUp() throws Exception {
		user = new User();
	}

	
	@Test
	public void testSetAndGetId() {
		user.setId(164545);
		assertEquals(164545, user.getId());
	}
	public void testSetAndGetUsername() {
		user.setUsername("test");
		assertEquals("test", user.getUsername());
	}
	public void testSetAndGetPassword() {
		user.setPassword("password");
		assertEquals("password", user.getPassword());
	}
	public void testSetAndGetRole() {
		user.setRole(Role.PROFESSOR);
		assertEquals(Role.PROFESSOR, user.getRole());
		
		user.setRole(Role.STUDENT);
		assertEquals(Role.STUDENT, user.getRole());
	}

    @Test
    public void testGetAuthorities() {
        user.setRole(Role.PROFESSOR);

        SimpleGrantedAuthority professorAuthority = new SimpleGrantedAuthority(Role.PROFESSOR.name());
        assertEquals(Collections.singletonList(professorAuthority), user.getAuthorities());
        
        user.setRole(Role.STUDENT);

        SimpleGrantedAuthority studentAuthority = new SimpleGrantedAuthority(Role.STUDENT.name());
        assertEquals(Collections.singletonList(studentAuthority), user.getAuthorities());
    }
    
    @Test
	void testIsAccountNonExpired() { 
		assertTrue(user.isAccountNonExpired());
	}

	@Test
	void testIsAccountNonLocked() {
		assertTrue(user.isAccountNonLocked());
	}

	@Test
	void testIsCredentialsNonExpired() {
		assertTrue(user.isCredentialsNonExpired());
	}

	@Test
	void testIsEnabled() {
		assertTrue(user.isEnabled());
	}
    
	

}