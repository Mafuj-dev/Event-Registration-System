package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import model.User;

public class UserDAOTest {

    @Test
    public void testRegisterUser() {

        UserDAO dao = new UserDAO();

        User user = new User();
        user.setName("Test User");
        user.setEmail("testuser@gmail.com");
        user.setPassword("1234");
        user.setRole("user");

        boolean result = dao.registerUser(user);

        assertTrue(result);
    }

    @Test
    public void testLoginUser() {

        UserDAO dao = new UserDAO();

        User user = dao.loginUser("testuser@gmail.com", "1234");

        assertNotNull(user);
    }
}