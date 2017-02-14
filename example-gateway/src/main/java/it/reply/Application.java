
package it.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class Application {
	
    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    
    @Value("${services.endpoint.example}")
    private String endpoint;
 
    @Autowired
    RestTemplate restTemplate;
 
    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public String consume() {
        return this.restTemplate.getForObject(endpoint, String.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
