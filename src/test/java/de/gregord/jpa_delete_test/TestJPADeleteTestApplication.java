package de.gregord.jpa_delete_test;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.AbstractEnvironment;

public class TestJPADeleteTestApplication {

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "test");
		SpringApplication.from(JPADeleteTestApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
