package com.box;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.box.util.BoxConnections;

@SpringBootApplication
public class BoxPlatformApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BoxPlatformApplication.class, args);

		/* Connect Box via Dev token
		BoxAPIConnection api = new BoxAPIConnection("t3sT1RK2SAwvqP6NODxhGeabuaVpfHJP");
		BoxFolder rootFolder = BoxFolder.getRootFolder(api);
		for (BoxItem.Info itemInfo : rootFolder) {
		    System.out.format("[%s] %s\n", itemInfo.getID(), itemInfo.getName());
		}
		*/
		BoxPlatformApplication boxsdk = new BoxPlatformApplication();
		new BoxConnections().getServiceAccountAccessToken();
		boxsdk.configureJCE();
		
//		EventWebClient event = new EventWebClient();
//		System.out.println(event.getResult());

	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BoxPlatformApplication.class);
	}
	
	private void configureJCE()	throws Exception {
		// hack for JCE Unlimited Strength
		Field field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
		field.setAccessible(true);
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
		field.set(null, false);		
	}
	
	
}
