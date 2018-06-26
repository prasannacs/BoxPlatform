package com.box;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String hello(Map<String, Object> model) {
		System.out.println("hello");
		model.put("message", "Hello!..");
		return "hello";
	}

}
