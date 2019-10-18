package edu.cst438.sprint3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Sprint3Application {
	
	@RequestMapping("/")
	@ResponseBody

	String home() {
		return "Hello Pernille";
	}

	public static void main(String[] args) {
		SpringApplication.run(Sprint3Application.class, args);
	}

}
