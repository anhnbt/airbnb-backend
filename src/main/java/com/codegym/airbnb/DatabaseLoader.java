package com.codegym.airbnb;

import com.codegym.airbnb.common.Constants;
import com.codegym.airbnb.entities.Role;
import com.codegym.airbnb.entities.UserInfo;
import com.codegym.airbnb.services.RoleService;
import com.codegym.airbnb.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@Override
	public void run(String... strings) throws Exception {
		try {
			Iterable<Role> roleList = roleService.findAll();
			if (!roleList.iterator().hasNext()) {
				roleService.save(new Role(Constants.Roles.ROLE_ADMIN));
				roleService.save(new Role(Constants.Roles.ROLE_USER));
			}
			if (!userService.findByUserName("admin").isPresent()) {
				UserInfo admin = new UserInfo();
				Set<Role> roles = new HashSet<>();
				Role roleAdmin = new Role();
				roleAdmin.setId(1L);
				roleAdmin.setName(Constants.Roles.ROLE_ADMIN);
				roles.add(roleAdmin);
				admin.setName("admin");
				admin.setUsername("admin");
				admin.setPassword("123456");
				admin.setRoles(roles);
				userService.save(admin);
				logger.info("Inserting user record for " + admin.getName());
			}
			if (!userService.findByUserName("anhnbt").isPresent()) {
				UserInfo user = new UserInfo();
				Set<Role> roles = new HashSet<>();
				Role roleAdmin = new Role();
				roleAdmin.setId(2L);
				roleAdmin.setName(Constants.Roles.ROLE_USER);
				roles.add(roleAdmin);
				user.setName("Nguyen Ba Tuan Anh");
				user.setUsername("anhnbt");
				user.setEmail("anhnbt@icloud.com");
				user.setPassword("123456");
				user.setPhoneNumber("+84346868928");
				user.setDateOfBirth(LocalDate.now());
				user.setGender(true);
				user.setActive(true);
				user.setCreatedDate(LocalDateTime.now());
				user.setModifiedDate(LocalDateTime.now());
				user.setRoles(roles);
				userService.save(user);
				logger.info("Inserting user record for " + user.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
