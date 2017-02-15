package it.reply;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Value("${reply.message}")
    private String replyMessage;

	private static double rnd = Math.random()*1000;

	@RequestMapping(value = "/example", method = RequestMethod.GET)
	public String example(){
		return replyMessage + rnd;
	}
}
