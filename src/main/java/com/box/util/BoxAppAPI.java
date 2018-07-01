package com.box.util;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.box.EventController;
import com.box.sdk.BoxCollaboration;
import com.box.sdk.BoxCollaborator;
import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxGroup;
import com.box.sdk.BoxGroupMembership;
import com.box.sdk.BoxUser;
import com.box.sdk.CreateUserParams;

public class BoxAppAPI {
	
	private static final Logger logger = LoggerFactory.getLogger(BoxAppAPI.class);

	
	private static String CLIENT_DOCS_FOLDER_ID = "50549221099";
	private static String CLIENTS_GROUP_ID = "1130473120";
	
	public static String createOrLoginUser(BoxDeveloperEditionAPIConnection api, String userName, String jobTitle)	{
		long spaceAmount = 1073741824;

		// Create param object
		CreateUserParams params = new CreateUserParams();
		params.setJobTitle(jobTitle);
		params.setSpaceAmount(spaceAmount);

		String isUser = isUserExists(api, userName);
		// Create app user
		if( isUser == null )	{
			BoxUser.Info createdUserInfo = BoxUser.createAppUser(api, userName);
			logger.info("app user created");
			createAppUserFolders(api, createdUserInfo.getID(), userName);
			return createdUserInfo.getID();
		} else	{
			return isUser;
		}
	}
	
	private static void createAppUserFolders(BoxDeveloperEditionAPIConnection api, String userId, String userName)	{
		// add to group - clients which has preset permissions
		BoxGroup group = new BoxGroup(api, CLIENTS_GROUP_ID);
		BoxUser user = new BoxUser(api, userId);
		BoxGroupMembership.Info groupMembershipInfo = group.addMembership(user);
		BoxFolder parentFolder = new BoxFolder(api, CLIENT_DOCS_FOLDER_ID);
		BoxFolder.Info childFolderInfo = parentFolder.createFolder(userName+" Docs");
		childFolderInfo.getResource().createFolder("W2");
		childFolderInfo.getResource().createFolder("Paystubs");
		// add collaboration to the newly created child folder so that only this app user and the managed user can see
		BoxCollaborator cuser = new BoxUser(api, userId);
		BoxFolder folder = new BoxFolder(api, childFolderInfo.getID());
		folder.collaborate(user, BoxCollaboration.Role.PREVIEWER_UPLOADER);

	}
	
	public static String isUserExists(BoxDeveloperEditionAPIConnection api, String userName)	{
		Iterable<BoxUser.Info> appUsers = BoxUser.getAllEnterpriseUsers(api);
		Iterator<BoxUser.Info> itr = appUsers.iterator();
		while (itr.hasNext()) {
			BoxUser.Info type = (BoxUser.Info) itr.next();
	//		logger.info("itr user (app) | login "+type.getName()+" | " + type.getLogin()+ " | "+type.getRole());

			if(userName.equals(type.getName()) || userName.equals(type.getLogin()))	{
				logger.info("Username already exists "+type.getID());
				//throw new Exception("Username already exists");
				return type.getID();
			}
			
		}
		return null;
	}
	
	//todo - user filters -- expensive call
	public static BoxUser.Info getBoxUserInfo(BoxDeveloperEditionAPIConnection api, String userName)	{
		Iterable<BoxUser.Info> appUsers = BoxUser.getAllEnterpriseUsers(api);
		Iterator<BoxUser.Info> itr = appUsers.iterator();
		while (itr.hasNext()) {
			BoxUser.Info type = (BoxUser.Info) itr.next();
			if(userName.equals(type.getName()) || userName.equals(type.getLogin()))	{
				return type;
			}
		}
		return null;
	}
	
	public static boolean isManagedUser(BoxDeveloperEditionAPIConnection api, String userName) throws Exception	{
		BoxUser.Info userInfo = getBoxUserInfo(api, userName);
		if(userInfo == null )
			throw new Exception("User does not exist");
		if(userInfo.getLogin().endsWith("@boxdevedition.com"))
			return false;
		return true;
	}
	

}
