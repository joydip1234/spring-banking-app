package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Account;
import jbr.springmvc.model.User;

class AccountMapper implements RowMapper<Account> {

	public Account mapRow(ResultSet rs, int arg1) throws SQLException {
		Account account = new Account();

		account.setUsername(rs.getString("username"));
		account.setBalance(rs.getFloat("balance"));
		
		return account;
	}

}