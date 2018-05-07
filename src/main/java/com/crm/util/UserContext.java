package com.crm.util;

import javax.servlet.http.HttpSession;

public class UserContext {
	public static final String USER_IN_SESSION = "user_in_session";
	public static final String PERMISSION_IN_SESSION = "permission_in_session";

	public static HttpSession session;
}
