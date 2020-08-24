package jbr.springmvc.dao;

import java.util.List;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public interface UserDao {

	int register(User user,String verificationCode);

	User validateUser(Login login);

	Float getBalance(String username);

	void createAccount(String username);

	String withdrawMoney(String username, Float amount , Float balance);
	
	String depositMoney(String username, Float amount , Float balance);

	List<String> getUserList();

	boolean validateCode(String verifyCode, String username);
}
