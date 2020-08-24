package jbr.springmvc.service;

import java.util.List;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public interface UserService {

	int register(User user);

	User validateUser(Login login);

	Float getBalance(String username);

	void createAccount(String username);

	String withdrawMoney(String username, Float amount);

	String depositMoney(String username, Float amount);

	List<String> getUserList();

	String validateCode(String verifyCode, String username);
}
