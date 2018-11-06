package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	//@Value("${app.environment}")
	//private String whichEnv;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	//@RequestMapping(value = "/which-env", method=RequestMethod.GET)
	//public String getWhichEnv() {
	//	return this.whichEnv;
	//}
}
