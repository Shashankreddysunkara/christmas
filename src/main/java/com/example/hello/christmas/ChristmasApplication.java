package com.example.hello.christmas;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ChristmasApplication {

	public static void main(String[] args) {
		try {
			Thread.sleep(31000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpringApplication.run(ChristmasApplication.class, args);
	}

}

@RestController
class MessageRestController {

	@RequestMapping("/hello")
	String getMessage(@RequestParam(value = "name") String name) {
		String rsp = "Hi " + name + " : responded on - " + new Date();
		System.out.println(rsp);
		return rsp;
	}

}
