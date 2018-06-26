package com.box;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.box.sdk.BoxUser;
import com.box.util.BoxConnections;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
		System.out.println("login");
		model.put("message", "Login!..");
		return "login";
	}

	@RequestMapping("/login-action")
	public String loginAction(Map<String, Object> model,@RequestParam("un") String userName) throws Exception	{
		System.out.println("login-action---  "+userName);
		model.put("message", "Login action!..");
		BoxConnections boxConnection = new BoxConnections();
		// create user
		String userId = boxConnection.createOrLoginUser(userName, "Some User");
		System.out.println("USer Id -- "+userId);
		String userToken = boxConnection.getAppUserAccessToken(userId);
		BoxUser.Info userInfo = boxConnection.getBoxUserInfo(userName);
		if(userInfo == null )
			throw new Exception("User does not exist");
		System.out.println("is managed user -- "+boxConnection.isManagedUser(userName));
		model.put("userName", userInfo.getName());
		model.put("accessToken",userToken);
		if(userInfo.getLogin().endsWith("@boxdevedition.com"))
			return "app-user";
		else
			return "managed-user";
	}

	@RequestMapping("/logout")
	public String logout(Map<String, Object> model) {
		System.out.println("logout");
		model.put("message", "Successfully logged out!..");
		return "login";
	}

}
