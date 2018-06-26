package com.box.util;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

import com.box.sdk.BoxCollaborator;
import com.box.sdk.BoxCollaboration;
import com.box.sdk.BoxConfig;
import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxGroup;
import com.box.sdk.BoxGroupMembership;
import com.box.sdk.BoxUser;
import com.box.sdk.CreateUserParams;
import com.box.sdk.DeveloperEditionEntityType;
import com.box.sdk.EncryptionAlgorithm;
import com.box.sdk.IAccessTokenCache;
import com.box.sdk.InMemoryLRUAccessTokenCache;
import com.box.sdk.JWTEncryptionPreferences;

public class BoxConnections {
	
	private static String PUBLIC_ID = "yc2y4m23";
	private static String PRIVATE_KEY_PASSWORD = "de6a6c059830424bda18ad379ea5474a";
	private static String PRIVATE_KEY = "-----BEGIN ENCRYPTED PRIVATE KEY-----\nMIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIPYVMZsBG6ZECAggA\nMBQGCCqGSIb3DQMHBAgPGdLY28xsDwSCBMigLClMATaq5zLycgM6kNwCUbdG9E2W\nfiQtj0P+wtYEiKX21RL7j83xd39kiOy7JmtDkpLhJ/3mfNMNtGcR1I7VR7PrZH8j\nMjvXyXEnSKCpTKMdS1pO8fLOo03JqvDiA1U2PiskpBynkbmQdZU2smXcvyEYVc6P\n6Mowam2lFg8KKwUEh6Ga/YgCgJ9/w/yiDJ/UcOykpkFYo3aZUBAyb3eMXiqlJsXy\n9vNu4Ic8XnXwzhRkfvm84fawn3CvOQKHRdYsFkADNJeK2WQrsKO7m2YlIVAAADpq\n2Phquvesi8qB8K2Ho/dlyN2BeNQ3fjkWOeuFu/r+FfzVV0DXYKCCs/qwTC0lYX8B\nobfto+zjLehBH9DmQuFiahxNaFO1pQfa2/K3kgxIn38hyQyM5FDww3PZKHQE1+Qd\nFs7g/KCC70IZb/OSBx7u/NmadxS6TUn5iIUfcxBIUdiBRoqBskD0ZqFf9P318ACA\ne+QbBmHoamXpCye0q5cqpnfRgOY0cWkwK35nNBXjJeHpYEsrVJ4Ajqr2QEwBYN45\nf8Uj+Gv0a5fM6THENTQfOvx81+JVTo8vyzPzpayqJXRkKgQ8rTuEp4cL/CSKmeHd\nIDkIzUQ7M9jzHiESD5H8HUCHRHeP6BntxYoW63m2z4vMzdfjSZLq3LU+E+sNwq6x\nBjoqO0D7Himle2eIv92mWSV5vp0ipZiyLCubYYS1nqDpVNLVnVS6wCA0swE7E2n8\nV5N+yWJFHvIcOFboVAU+ZMIkF4VYDY9MVdJ37ej9pNgz2LOYpciTjtbmS9Fe75o2\nnRcFbQTNm4kRDidETL5J5igUSp1nolT4oSusQdS+H7VgdapYKMUDfXykA8F5rsyi\ndISdRFZedLP84e7YwUkpXiCYqCF7RcYRUlbYT8u4tYbPbEt4woZ22sGcsQfRXOD0\na4nHSrwxUU1G0voBItHIp9xbxSHkY/ZS/F2XVDbzQ1doPWj4/+IGm/4KetrIrRdq\ndVjuKntdxQBqm3r/01nUHsyG2so/yrX9r6c9WiA/LO3toSJlTV/Hc/tRW2QqWVcR\nBn1i9UUNo47SFTAOwXhNqv1dParu/cWwMNqOKVyoqh5rVxs1e1qOQLFGjAXKDrSO\nYxhVIqU9Sr+TcY7MCyECbptraIbhC9MbqHqnAKH1ZnY/x0G6FxpOku42ePR9nTn2\nYJ/A/bZDH/rQpRDm/QAKxIqavIIzsJLV+9r2ofZ1IVU4DiCpLP0EYQUKBel9WWys\n9nZ9Pn/sXvCl69WtST1rkawziR/aPjdVs09jo+BfWEBMA8PxlHhz8lZxn2oa9X17\nMmxHh52+CBlBkJd9nfis3aT5SvvNlcgcxyhN3VjJZHNPTizw6pxENHFsgs2hNAma\nQll0p8UgubETtrFy9nvw0cAqDdaOOIEXgyXlqoryzrXA5IKh10ksqJ0LrTc4fxfq\ncslv+XRsLRUJJDTUKOYJgcCXeiZ6sftfGUsRHrdFv+FBaJEeVV1Vl0owIgBv1xjE\n7mYCPHtMuZFE47LO1HFPCTYAFrIEwOwQ1Sz6rIUPuSWtg7xKmizr59uKhbtgUHoO\nljDJZjP3jaXlhW0gc37hX20W/yPRvdGvNuidLJoootHMtsPstnqiH5cY34/Lm8QT\nRqw=\n-----END ENCRYPTED PRIVATE KEY-----\n";
	private static String CLIENT_ID = "quctsqlnvjtanl507z6axh22jyd9jzg1";
	private static String CLIENT_SECRET = "37isljVOklKg3CY91Z737sEU1ORisS84";
	private static String ENTEPRISE_ID = "59194496";
	private static String CLIENT_DOCS_FOLDER_ID = "50549221099";
	private static String CLIENTS_GROUP_ID = "1130473120";

	public static BoxDeveloperEditionAPIConnection getServiceAccountConnection()	{
		JWTEncryptionPreferences jwtPreferences = new JWTEncryptionPreferences();
		jwtPreferences.setPublicKeyID(PUBLIC_ID);
		jwtPreferences.setPrivateKeyPassword(PRIVATE_KEY_PASSWORD);
		jwtPreferences.setPrivateKey(PRIVATE_KEY);
		jwtPreferences.setEncryptionAlgorithm(EncryptionAlgorithm.RSA_SHA_256);

		BoxConfig boxConfig = new BoxConfig(CLIENT_ID, CLIENT_SECRET, ENTEPRISE_ID, jwtPreferences);

		BoxDeveloperEditionAPIConnection api = BoxDeveloperEditionAPIConnection.getAppEnterpriseConnection(boxConfig);
		return api;
		
	}
	
	public String getServiceAccountAccessToken()	{
		BoxDeveloperEditionAPIConnection api = BoxConnections.getServiceAccountConnection();
		BoxUser.Info userInfo = BoxUser.getCurrentUser(api).getInfo();	
		System.out.println("Service Account App -- "+userInfo.getName()+" access token "+api.getAccessToken());
		return api.getAccessToken();
		
	}
	
	public String getAppUserAccessToken(String userId) throws Exception	{
		BoxDeveloperEditionAPIConnection session = new BoxDeveloperEditionAPIConnection(userId, DeveloperEditionEntityType.USER, getBoxConfig(), getAccessTokenCache());
		String userToken = session.getAccessToken();
		System.out.println("User Token "+userToken);
		return userToken;
	}
	
	public String createOrLoginUser(String userName, String jobTitle)	{
		long spaceAmount = 1073741824;

		// Create param object
		CreateUserParams params = new CreateUserParams();
		params.setJobTitle(jobTitle);
		params.setSpaceAmount(spaceAmount);

		String isUser = isUserExists(userName);
		// Create app user
		if( isUser == null )	{
			BoxDeveloperEditionAPIConnection api = BoxConnections.getServiceAccountConnection();
			BoxUser.Info createdUserInfo = BoxUser.createAppUser(api, userName);
			System.out.println("app user created");
			createAppUserFolders(api, createdUserInfo.getID(), userName);
			return createdUserInfo.getID();
		} else	{
			return isUser;
		}
	}
	
	private void createAppUserFolders(BoxDeveloperEditionAPIConnection api, String userId, String userName)	{
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
	
	private String isUserExists(String userName)	{
		Iterable<BoxUser.Info> appUsers = BoxUser.getAllEnterpriseUsers(BoxConnections.getServiceAccountConnection());
		Iterator<BoxUser.Info> itr = appUsers.iterator();
		while (itr.hasNext()) {
			BoxUser.Info type = (BoxUser.Info) itr.next();
			System.out.println("itr user (app) | login "+type.getName()+" | " + type.getLogin()+ " | "+type.getRole());

			if(userName.equals(type.getName()) || userName.equals(type.getLogin()))	{
				System.out.println("Username already exists");
				//throw new Exception("Username already exists");
				return type.getID();
			}
			
		}
		return null;
	}
	
	//todo - user filters -- expensive call
	public BoxUser.Info getBoxUserInfo(String userName)	{
		Iterable<BoxUser.Info> appUsers = BoxUser.getAllEnterpriseUsers(BoxConnections.getServiceAccountConnection());
		Iterator<BoxUser.Info> itr = appUsers.iterator();
		while (itr.hasNext()) {
			BoxUser.Info type = (BoxUser.Info) itr.next();
			if(userName.equals(type.getName()) || userName.equals(type.getLogin()))	{
				return type;
			}
		}
		return null;
	}
	
	public boolean isManagedUser(String userName) throws Exception	{
		BoxUser.Info userInfo = this.getBoxUserInfo(userName);
		if(userInfo == null )
			throw new Exception("User does not exist");
		if(userInfo.getLogin().endsWith("@boxdevedition.com"))
			return false;
		return true;
	}
	

	private static BoxConfig getBoxConfig() throws Exception	{
		File file = new File(ClassLoader.getSystemClassLoader().getResource("key.json").getFile());
		Reader reader = new FileReader(file);
		BoxConfig boxConfig = BoxConfig.readFrom(reader);
		return boxConfig;
	}
	
	private static IAccessTokenCache getAccessTokenCache() throws Exception	{
		BoxConfig boxConfig = getBoxConfig();
		// Set cache info
		int MAX_CACHE_ENTRIES = 100;
		IAccessTokenCache accessTokenCache = new 
		  InMemoryLRUAccessTokenCache(MAX_CACHE_ENTRIES);

		return accessTokenCache;
	}

}
