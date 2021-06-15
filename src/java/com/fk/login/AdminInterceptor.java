/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * author : Ahsan, Hasan Mobarak
 */
package com.fk.login;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AdminInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> sessionAttributes = invocation
				.getInvocationContext().getSession();

		if (sessionAttributes == null || sessionAttributes.get("loginId") == null) {
			System.out.println("I am in first phase of LoginInterceptor");
			return "login";
		} else {
			if (!((String) sessionAttributes.get("loginId")).equals(null)) {
				System.out.println("I am in third phase of LoginInterceptor");
				return invocation.invoke();
			} else {
				System.out.println("I am in second phase of LoginInterceptor");
				return "login";
			}
		}

	}

}