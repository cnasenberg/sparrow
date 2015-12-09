package sparrow;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void save(User user) {
		jdbcTemplate.execute("CREATE TABLE if not exists user (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, email VARCHAR)");
		jdbcTemplate.update(String.format("INSERT INTO user (name, email) VALUES (\"%s\", \"%s\")", user.getUsername(), user.getEmailAddress()));
    }
}