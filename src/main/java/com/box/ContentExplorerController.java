package com.box;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.box.sdk.BoxUser;
import com.box.sdk.EncryptionAlgorithm;
import com.box.sdk.JWTEncryptionPreferences;
import com.box.service.BoxSDK;

@Controller
public class ContentExplorerController {
	
	private BoxSDK javaSDK;
	
	@Autowired
	public ContentExplorerController(BoxSDK javaSDK)	{
		this.javaSDK = javaSDK;
	}	


	@RequestMapping("/content-explorer")
	public String contenetExplorer(Map<String, Object> model) {
		System.out.println("content explorer");
		model.put("accessToken", appuserJWTCrednetials());
		return "content-explorer";
	}
	
	@RequestMapping("/content-previewer")
	public String contenetPreviewer(Map<String, Object> model) throws Exception	{
		System.out.println("content explorer");
		model.put("accessToken", javaSDK.getServiceAccountAccessToken());
		model.put("fileId", "300817774971");
		return "content-previewer";
	}
	

	@RequestMapping("/content-picker")
	public String contentPicker(Map<String, Object> model) {
		System.out.println("content picker");
		model.put("accessToken", appuserJWTCrednetials());
		return "content-picker";
	}

	@RequestMapping("/content-picker-folder")
	public String contentPickerFolder(Map<String, Object> model) {
		System.out.println("content picker");
		model.put("accessToken", appuserJWTCrednetials());
		return "content-picker-folder";
	}
	
	@RequestMapping("/content-uploader")
	public String contentUploader(Map<String, Object> model) {
		System.out.println("content uploader");
		model.put("accessToken", appuserJWTCrednetials());
		return "content-uploader";
	}	
	private String appuserJWTCrednetials()	{
		JWTEncryptionPreferences jwtPreferences = new JWTEncryptionPreferences();
		jwtPreferences.setPublicKeyID("0omrzk8v");
		jwtPreferences.setPrivateKeyPassword("befa15037f355ffc84357363f097f84c");
		jwtPreferences.setPrivateKey("-----BEGIN ENCRYPTED PRIVATE KEY-----\nMIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIG5eV0YFEFkkCAggA\nMBQGCCqGSIb3DQMHBAjs7GzE56yeqwSCBMiLkKZCAcnJKwTqwu6vjPbTkHmxYPgq\nW2hJ/dbfhm32Yssweg6ZBsCVvuKBHF8k88Q6UTpq9pD5rL6/TipUVb0uwSy4m4Va\nch1MEQ4NJU0lmu1i38dQMtqdQRT8dvXG0AtnCKdI85rU57dLHRK9aQi7Hw6Eeb6X\nxMnITIiTBfTsJRseVGgE2ZZUxuRb4dcdVNBdh/FtKNw5xRhXIXXTa/Zw5uFcaUMD\ndBNlEmM//Kxz1OK53grn3IBXZFr9K+gz1qoBKtnA7W1oaaHDTzdQZCLMfK4v22/D\nBPMMuj6GQcfcsBKq2bOPfheOr9LbfEVdePKO0F0sTVacecYLZEvO7UArJdaFB/8K\nDelwCx+9WUlPTnHXafsnf/Kr60xmea7N3xNaxSMbf0KPLuDvYIMBAkTpCB09Te07\nvvjPfODXYvi2/v2oK4FgB14z//6qQifdm4x9IQPEZV03PlZaatNorHguMU3jm/lb\n2C+kr7niLRpSXNBj1M3xWHwapZQ75HlUFfyotq9c4Rp7LaljPJaNSrZRjWtZTn5p\ne0YMGWgEruXBM3+6rDJkryEd5tiUsHxvzbbfahlZKmU0hn1+kXj0WhS7MDlRC42k\n3Qk/7hYo4PG+E7id8ozNoh9DHKj17LZtXmJuTOCecF0q0D3xo0v4PoQ7ML7zis6s\nZHOH7l4JRX8RIUPAHstvtM5ImWNuP5mdEy3QqG+em5nN3y7kZmwRwlDlECO9zqg4\nCBD6dEcyKilaRsfp4hGx1iFjEj0f1TgqiOvBn/TanIR8PDCLf7sNIDSuvbq1va1V\nT+og+th/H6EnLbbN+9GHWb/uqw8TZa86u1KPuBJ/HKj2LvC4t8VFcTjs3fGLjlip\nOIyZ7ZHNzXebUv0kfQ5lzpbb2b9apCAX9u6MhDCEBy9cC7RDq47QM3BJAqLb60It\nYxhef3bH3woH3zWv2sfx/sk2G0ti4xKs+vVOUVgtBR1Fafq4z2me8BbMlyhphBza\nISexjQpj14LUhbprqbI80ZRmbDrAQ2YfUxsd+5u8VCGFeVxmtnTXuXiSGskocMXY\n1HUcwDOH9gxvXYUC9CpL/V8lNc8AfEPcssREn7aDGGzRF40q+Vpybyp7cvcXS8Ay\nGNyQjKZuo3XbIGRGPlpTNb/+X3nACerdLG2/g8XDNzn5gSd+NBesIh79s+e+Y3ng\n+QjJ27fi+K+UkorV/25zJkg+n+IlN8jxqHmVeYAcVIe7XdFQyF6y17rUMLcWs4bv\nQ/L5DDF6DjSE7BwN7C8MwY8pOXM/jfhRGZC73dmQ0yhwozMIJK3Z2AxacbEKH+Ms\ntdXgaOY7V4Bj1eXsuo8FbKy2rlKAlfrcHB5WV5DNCAlNQn8OV9SRlUCZExkVsSeu\n2E7Qfa/mKdUlnB/ZTtAsOwfe68QyRhm3a/qP2Y4nYmj+jTpVvDbMRBwTjHkv64/o\nXia62EzOc4K4j/xyT38UeJ5ZMC7MuJIbM2UIyH9kYGTffhPg8i6lz+CYLl5qiiEA\ntJZrbwbNd84xtz4fV35W06Q5MxAPVjgIbKM/l0ciigGcMF2G6Q1/q3tv4jazHbvH\nPpd6X4T4eKoUmDDxSud3TxIgfi3yZU83/MMqZ5OAxgykjBLeiH7lstywHVGP5+FN\nCgM=\n-----END ENCRYPTED PRIVATE KEY-----\n");
		jwtPreferences.setEncryptionAlgorithm(EncryptionAlgorithm.RSA_SHA_256);

		BoxDeveloperEditionAPIConnection api = BoxDeveloperEditionAPIConnection.getAppUserConnection("prasannacs+box@gmail.com", "w406k3vniv790emaoxxdxcgb5a5rb3s2",
		"6Ghg39Q5Ta52TpKZyR5Ye4MvecFCXuCR", jwtPreferences);

		BoxUser.Info userInfo = BoxUser.getCurrentUser(api).getInfo();	
		System.out.println("userInfo -- "+userInfo.getName()+" access token "+api.getAccessToken());
		return api.getAccessToken();
	}
}
