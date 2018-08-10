package com.box;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.box.sdk.BoxFolder;
import com.box.service.*;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BoxSDK boxSDK;

    public AppRunner(BoxSDK boxSDK) {
        this.boxSDK = boxSDK;
    }

    @Override
    public void run(String... args) throws Exception {
    	logger.info("Command line runner -> App Runner");
        logger.info("boxSDK service access token",boxSDK.getServiceAccountAccessToken());
        // user access token for Prasannq Selvaraj - Admin managed user
        logger.info("box SDK Prasanna - Admin user token ",boxSDK.getAppUserAccessToken("3725141744"));
        // create folder structure for Marsh demo
        //marshDemo();
    }
    
    private void marshDemo()	throws Exception	{
    	final String project2018_folder_id = "51888599350";
    	BoxDeveloperEditionAPIConnection api = boxSDK.getAppUserConnection("3725141744");
    	BoxFolder parentFolder = new BoxFolder(api, project2018_folder_id);
    	BoxFolder.Info client_folder_id = parentFolder.createFolder("Dell");
    	BoxFolder subFolder = new BoxFolder(api, client_folder_id.getID());
		BoxFolder.Info child1 = subFolder.createFolder("Endorsements");
		BoxFolder.Info child2 = subFolder.createFolder("Compliance");
		BoxFolder.Info child3 = subFolder.createFolder("Insurance Partners");
		BoxFolder.Info child4 = subFolder.createFolder("My Document Vault");
    	
    }

}