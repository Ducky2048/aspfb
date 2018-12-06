package ch.bfh.aspfb.camp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:application-context.xml"})
@EnableDiscoveryClient
public class CampApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampApplication.class, args);
	}
}
