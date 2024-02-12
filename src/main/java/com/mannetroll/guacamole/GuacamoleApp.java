package com.mannetroll.guacamole;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GuacamoleApp implements CommandLineRunner {
	private static final Logger LOG = LogManager.getLogger(GuacamoleApp.class);
	private static ConfigurableApplicationContext context;

	@Override
	public void run(String... args) {
		LOG.info("################################################## run...");
	}

	public static void doLog() {
		Map<String, Object> tmp = new HashMap<String, Object>();
		tmp.put("a_string", "hello");
		tmp.put("a_number", 11L);
		tmp.put("a_float", 1.1234F);
		tmp.put("a_boolean", true);
		LOG.info(tmp);
	}

	public static void main(String[] args) {
		context = SpringApplication.run(GuacamoleApp.class, args);
		LOG.info("context: " + context.getBeanDefinitionCount());
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(GuacamoleApp::doLog, 0, 1, TimeUnit.SECONDS);
	}

}
