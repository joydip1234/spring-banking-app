package jbr.springmvc.service;

import java.util.HashMap;

public class RolesMapping {

	private static final String USER_ROLES = "WithdrawMoney,CheckBalance,DepositMoney";
	private static final String ACCOUNTANT_ROLES = "CheckBalanceofUser";
	private static final String ADMIN_ROLES = "CreateUser,CreateAccountant";

	public static final String getUserRoles(Integer roleId) {

		if (roleId == 1) {
			return USER_ROLES;
		}
		if (roleId == 2) {
			return ACCOUNTANT_ROLES;
		}
		if (roleId == 3) {
			return ADMIN_ROLES;
		}

		return null;
	}

	public static final String getEndUserRoles() {
		return USER_ROLES;
	}

	public static final String getAccountantRoles() {
		return ACCOUNTANT_ROLES;
	}

	public static final String getAdminRoles() {
		return ADMIN_ROLES;
	}

}
