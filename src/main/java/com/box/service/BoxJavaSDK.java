package com.box.service;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import com.box.sdk.BoxConfig;
import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.box.sdk.BoxUser;
import com.box.sdk.DeveloperEditionEntityType;
import com.box.sdk.EncryptionAlgorithm;
import com.box.sdk.IAccessTokenCache;
import com.box.sdk.InMemoryLRUAccessTokenCache;
import com.box.sdk.JWTEncryptionPreferences;

@ApplicationScope
@Component
public class BoxJavaSDK implements BoxSDK	{
	
	private static final Logger logger = LoggerFactory.getLogger(BoxJavaSDK.class);

	@Override
	@Cacheable("serviceAccessToken")
	public String getServiceAccountAccessToken() throws Exception {
		logger.info("Cache not used --> for service access token");
		BoxDeveloperEditionAPIConnection api = this.getServiceAccountConnection();
		BoxUser.Info userInfo = BoxUser.getCurrentUser(api).getInfo();	
		logger.info("Service Account App -- "+userInfo.getName()+" access token "+api.getAccessToken());
		return api.getAccessToken();	}

	@Override
	@Cacheable("userAccessToken")
	public String getAppUserAccessToken(String userId) throws Exception {
		logger.info("Cache not used --> for user access token");
		BoxDeveloperEditionAPIConnection session = new BoxDeveloperEditionAPIConnection(userId, DeveloperEditionEntityType.USER, getBoxConfig(), getAccessTokenCache());
		String userToken = session.getAccessToken();
		logger.info("User access token for "+userId+" access token "+userToken);
		return userToken;
	}
	
	@Override
	@Cacheable("serviceAccountConnection")
	public BoxDeveloperEditionAPIConnection getServiceAccountConnection()	{
		JWTEncryptionPreferences jwtPreferences = new JWTEncryptionPreferences();
		jwtPreferences.setPublicKeyID(PUBLIC_ID);
		jwtPreferences.setPrivateKeyPassword(PRIVATE_KEY_PASSWORD);
		jwtPreferences.setPrivateKey(PRIVATE_KEY);
		jwtPreferences.setEncryptionAlgorithm(EncryptionAlgorithm.RSA_SHA_256);

		BoxConfig boxConfig = new BoxConfig(CLIENT_ID, CLIENT_SECRET, ENTEPRISE_ID, jwtPreferences);

		BoxDeveloperEditionAPIConnection api = BoxDeveloperEditionAPIConnection.getAppEnterpriseConnection(boxConfig);
		return api;
		
	}
	
	@Override
	public BoxDeveloperEditionAPIConnection getAppUserConnection(String userId)	throws Exception {
		BoxDeveloperEditionAPIConnection api = BoxDeveloperEditionAPIConnection.getAppUserConnection(userId, getBoxConfig(), getAccessTokenCache());
		return api;
	}
	
	private BoxConfig getBoxConfig() throws Exception	{
		File file = new File(ClassLoader.getSystemClassLoader().getResource("key.json").getFile());
		Reader reader = new FileReader(file);
		BoxConfig boxConfig = BoxConfig.readFrom(reader);
		return boxConfig;
	}
	
	private IAccessTokenCache getAccessTokenCache() throws Exception	{
		// Set cache info
		int MAX_CACHE_ENTRIES = 100;
		IAccessTokenCache accessTokenCache = new 
		  InMemoryLRUAccessTokenCache(MAX_CACHE_ENTRIES);

		return accessTokenCache;
	}


}
