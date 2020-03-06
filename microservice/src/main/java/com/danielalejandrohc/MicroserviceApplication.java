package com.danielalejandrohc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://www.baeldung.com/spring-data-rest-intro
// docker run --name mysql -e MYSQL_ROOT_PASSWORD=password --network host -d mysql:5.7
@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

}
