package com.box;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
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
//        logger.info("boxSDK service access token",boxSDK.getServiceAccountAccessToken());
//        String token =  boxSDK.getAppUserAccessToken("3761782458");
//        logger.info("boxSDK user access token "+token);
//        token =  boxSDK.getAppUserAccessToken("3761782458");
//        logger.info("boxSDK user access token1 "+ token);

    }

}