package eu.nasenberg.sparrow;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import eu.nasenberg.sparrow.HibernateUserDAO;
import eu.nasenberg.sparrow.User;

@RunWith(MockitoJUnitRunner.class)
public class HibernateUserDAOTest {
    
    private String username;
    private String emailAddress;
    private User testUser;
        
	@Autowired
	@InjectMocks  
    private HibernateUserDAO testHibernateUserDAO;
	
	@Mock private SessionFactory sessionFactory;
	@Mock private Session session;
	@Mock private Transaction transaction;
	@Mock private List<User> result;
    @Mock private Query query;
    
    @Before
    public void setUp() {
		
        username = "Blackbird";
        emailAddress = "black@bird.tree";
        testUser = new User(username, emailAddress);
        result = new ArrayList<User>();
        result.add(testUser);
                
        when(sessionFactory.openSession()).thenReturn(session);
        when(session.getTransaction()).thenReturn(transaction);
        when(session.createQuery(any(String.class))).thenReturn(query);
        when(query.list()).thenReturn(result);
    }    
    
	@Test
    public void testSaveUser() {
		User savedUser = testHibernateUserDAO.save(testUser);
		assertNotNull(savedUser);
    }
	
	@Test
    public void testGetUser() {
		User retrievedUser = testHibernateUserDAO.get(testUser);
		assertNotNull(retrievedUser);
    }
}