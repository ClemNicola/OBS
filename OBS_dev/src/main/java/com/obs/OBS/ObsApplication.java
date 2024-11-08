package com.obs.OBS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ObsApplication {

	public static void main(String[] args) {
    SpringApplication.run(ObsApplication.class, args);
	}

}
