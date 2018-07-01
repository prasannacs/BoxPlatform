package com.box;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.box.sdk.BoxUser;
import com.box.service.BoxSDK;
import com.box.util.BoxAppAPI;

@Controller
public class LoginController {
	
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private BoxSDK javaSDK;
	
	@Autowired
	public LoginController(BoxSDK javaSDK)	{
		this.javaSDK = javaSDK;
	}	

	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
		logger.info("login");
		model.put("message", "Login!..");
		return "login";
	}

	@RequestMapping("/login-action")
	public String loginAction(Map<String, Object> model,@RequestParam("un") String userName) throws Exception	{
		logger.info("login-action---  "+userName);
		model.put("message", "Login action!..");
		// create user
		String userId = BoxAppAPI.createOrLoginUser(javaSDK.getServiceAccountConnection(), userName, "Some User");
		String userToken = javaSDK.getAppUserAccessToken(userId);
		logger.info("User Token "+userToken+" for userId "+userId);
		BoxUser.Info userInfo = BoxAppAPI.getBoxUserInfo(javaSDK.getServiceAccountConnection(), userName);
		if(userInfo == null )
			throw new Exception("User does not exist");
		logger.info("is managed user -- "+BoxAppAPI.isManagedUser(javaSDK.getServiceAccountConnection(), userName));
		model.put("userName", userInfo.getName());
		model.put("accessToken",userToken);
		if(userInfo.getLogin().endsWith("@boxdevedition.com"))
			return "app-user";
		else
			return "managed-user";
	}

	@RequestMapping("/logout")
	public String logout(Map<String, Object> model) {
		logger.info("logout");
		model.put("message", "Successfully logged out!..");
		return "login";
	}

}
