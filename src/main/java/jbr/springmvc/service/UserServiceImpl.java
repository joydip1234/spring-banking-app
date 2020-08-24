package jbr.springmvc.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.util.SendEmail;
import jbr.springmvc.util.VerificationCodeUtil;

public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	public int register(User user) {
		String verificationCode = VerificationCodeUtil.createCode();

		try {
			SendEmail.sendmail(user.getEmail(), verificationCode);
			if (RolesMapping.getUserRoles(user.getRole()) == RolesMapping.getEndUserRoles())
				userDao.createAccount(user.getUsername());
			return userDao.register(user, verificationCode);
		} catch (MessagingException | IOException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

	public Float getBalance(String username) {

		return userDao.getBalance(username);
	}

	public void createAccount(String username) {
		userDao.createAccount(username);
	}

	public String withdrawMoney(String username, Float amount) {

		Float balance = userDao.getBalance(username);
		if (balance < amount) {
			return "You do not have sufficient balance to withdraw this amount";
		} else if (amount <= 0) {
			return "The amount you entered to withdraw is not allowed";
		}

		return userDao.withdrawMoney(username, amount, balance);
	}

	public String depositMoney(String username, Float amount) {

		Float balance = userDao.getBalance(username);

		if (amount <= 0) {
			return "The amount you entered to deposit is invalid";
		}

		return userDao.depositMoney(username, amount, balance);

	}

	public List<String> getUserList() {
		return userDao.getUserList();
	}

	public String validateCode(String verifyCode, String username) {
		boolean isVerifyCodeCorrect = userDao.validateCode(verifyCode,username);
		if(isVerifyCodeCorrect) {
			return "Account verification successful";
		}else {
			return "Wrong Code";
		}
	}

}
