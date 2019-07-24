package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public void addPerson(Person person) {
		Long pid = 0L;
		String maxB = "Select max(id) from Person p";

		pid = jdbcTemplate.query(maxB, new ResultSetExtractor<Long>() {

			@Override
			public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
				long maxid;
				rs.next();
				maxid = rs.getLong(1);
				return maxid;
			}
		});
		pid = pid + 1;

		String sql = "INSERT INTO "
				+ "`person`(`id`, `first_name`, `last_name`)" + " VALUES ("
				+ pid + "," + "'" + person.getFirstName() + "'," + "'" + person.getLastName() + "')";

		jdbcTemplate.update(sql);
	}

}
