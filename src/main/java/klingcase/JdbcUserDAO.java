package klingcase;

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

	public void insert(User user) {
		jdbcTemplate.execute("CREATE TABLE if not exists user (name varchar, email varchar)");
		jdbcTemplate.update(String.format("INSERT INTO user (name, email) VALUES (\"%s\", \"%s\")", user.getUsername(),
				user.getEmailAddress()));

	}
}