package sparrow;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserDAO implements UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SimpleJdbcInsert userInsert;

	public User save(User user) {
		jdbcTemplate.execute("CREATE TABLE if not exists user (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, email VARCHAR)");
        
        userInsert.withTableName("user").usingColumns("name", "email")
        .usingGeneratedKeyColumns("id");
        
        Map<String,Object> insertParameters = new HashMap<String, Object>();
        insertParameters.put("name", user.getUsername());
        insertParameters.put("email", user.getEmailAddress());
        
        Number generatedUserId = userInsert.executeAndReturnKey(insertParameters);
        user.setId(generatedUserId.longValue());
        return user;
        
    }
}