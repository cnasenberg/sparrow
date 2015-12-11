package sparrow;

import java.util.Map;
import java.util.HashMap;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public User save(User user) {
		jdbcTemplate.execute("CREATE TABLE if not exists user (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, email VARCHAR)");
        
        SimpleJdbcInsert insertUser = new SimpleJdbcInsert(jdbcTemplate)
        .withTableName("user").usingColumns("name", "email")
        .usingGeneratedKeyColumns("id");
        
        Map<String,Object> insertParameters = new HashMap<String, Object>();
        insertParameters.put("name", user.getUsername());
        insertParameters.put("email", user.getEmailAddress());
        
        Number generatedUserId = insertUser.executeAndReturnKey(insertParameters);
        user.setId(generatedUserId.longValue());
        return user;
    }
}