package com.cs544;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmailApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("application is up and running and listening for the RabbitMQ incoming email messages");
    }

}
