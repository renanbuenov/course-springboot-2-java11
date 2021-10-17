package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Renan Bueno", "renanbueno@gmail.com", "5543984458553", "12345");
		User u2 = new User(null, "Fernanda Marie", "fernandamarie@gmail.com", "55439139-8991", "12345");
		
		Order o1 = new Order(null, Instant.parse("2021-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2021-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2021-07-22T15:21:22Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
