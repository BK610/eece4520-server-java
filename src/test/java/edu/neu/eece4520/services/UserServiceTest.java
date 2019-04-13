package edu.neu.eece4520.services;

import edu.neu.eece4520.models.User;
import edu.neu.eece4520.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class UserServiceTest {
    private User alice;
    private User bob;
    private User charlotte;
    private User dorothy;

    @TestConfiguration
    static class UserServiceTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserService();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        alice = new User();
        alice.setName("Alice");

        bob = new User();
        bob.setName("Bob");

        charlotte = new User();
        charlotte.setName("Charlotte");

        dorothy = new User();
        dorothy.setName("Dorothy");

        List<User> allUsers = Arrays.asList(alice, bob, charlotte);

        Mockito.when(userRepository.findUserById(alice.getId())).thenReturn(alice);
        Mockito.when(userRepository.findAllUsers()).thenReturn(allUsers);
        Mockito.when(userRepository.save(dorothy)).thenReturn(dorothy);
        Mockito.when(userRepository.save(alice)).thenReturn(alice);

    }

    @Test
    public void testFindUserById() {
        User found = userService.findUserById(alice.getId());

        assertEquals(found.getId(), alice.getId());
    }

    @Test
    public void testFindAllUsers() {
        List<User> foundUsers = userService.findAllUsers();
        assertEquals(foundUsers.size(), 3);
        assertTrue("Contains Alice", foundUsers.contains(alice));
        assertTrue("Contains Bob", foundUsers.contains(bob));
        assertTrue("Contains Charlotte", foundUsers.contains(charlotte));
    }

    @Test
    public void testCreateUser() {
        User created = userService.createUser(dorothy);

        assertEquals(created.getId(), dorothy.getId());
    }
}
