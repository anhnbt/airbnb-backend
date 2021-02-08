package com.codegym.airbnb;

import com.codegym.airbnb.model.User;
import com.codegym.airbnb.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

	@Autowired
	private UserService userService;

	@Override
	public void run(String... strings) throws Exception {
		if (!userService.findByEmail("anhnbt@icloud.com").isPresent()) {
			User user = new User();
			user.setName("Nguyen Ba Tuan Anh");
			user.setEmail("anhnbt@icloud.com");
			user.setPassword("123456");
			user.setPhone("+84346868928");
			user.setDateOfBirth(LocalDate.now());
			user.setGender((byte) 1);
			user.setActive(true);
			user.setCreatedAt(LocalDateTime.now());
			user.setUpdatedAt(LocalDateTime.now());
			this.userService.save(user);
			logger.info("Inserting customer record for " + user.getName());
		}

	}
}
