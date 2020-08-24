package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Account;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.RolesMapping;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int register(User user, String verificationCode) {
		String sql = "insert into users(username,password,firstname,lastname,email,address,role,roles,verify) values(?,?,?,?,?,?,?,?,?)";

		return jdbcTemplate.update(sql,
				new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(),
						user.getEmail(), user.getAddress(), user.getRole(), RolesMapping.getUserRoles(user.getRole()),
						verificationCode });
	}

	public User validateUser(Login login) {
		String sql = "select * from users where username='" + login.getUsername() + "' and password='"
				+ login.getPassword() + "' and verify='Yes'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());

		return users.size() > 0 ? users.get(0) : null;
	}

	public Float getBalance(String username) {

		String sql = "select * from account where username='" + username + "'";
		List<Account> accounts = jdbcTemplate.query(sql, new AccountMapper());

		return accounts.size() > 0 ? accounts.get(0).getBalance() : null;

	}

	public void createAccount(String username) {
		String sql = "insert into account(username) values(?)";
		jdbcTemplate.update(sql, username);
		return;
	}

	public String withdrawMoney(String username, Float amount, Float balance) {
		Float newBalance = balance - amount;
		String sql = "update account set balance = " + newBalance + " where username=?";
		jdbcTemplate.update(sql, username);
		return "Withdrawn Successful";
	}

	public String depositMoney(String username, Float amount, Float balance) {
		Float newBalance = balance + amount;
		String sql = "update account set balance = " + newBalance + " where username=?";
		jdbcTemplate.update(sql, username);
		return "Deposit Successful";
	}

	public List<String> getUserList() {
		String sql = "select * from users where role = 1";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		List<String> userList = new ArrayList<String>();
		for (User user : users) {
			userList.add(user.getUsername());
		}

		return userList;
	}

	public boolean validateCode(String verifyCode, String username) {
		String sql = "select * from users where username='" + username + "' and verify='" + verifyCode + "'";

		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		boolean returnValue = users.size() > 0 ? true : false;

		if (returnValue) {

			String updateSql = "update users set verify = 'Yes' " + "where username=?";
			jdbcTemplate.update(updateSql, username);

		}

		return returnValue;
	}

}

class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();

		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setRoles(rs.getString("roles"));

		return user;
	}
}