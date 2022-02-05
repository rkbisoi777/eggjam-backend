package com.eggjam.EggJam;

import com.eggjam.EggJam.entity.Role;
import com.eggjam.EggJam.entity.User;
import com.eggjam.EggJam.entity.UserRole;
import com.eggjam.EggJam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EggJamApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(EggJamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting Code");

		
//		User user  = new User();
//		user.setFirstName("Roshankumar");
//		user.setLastName("Bisoi");
//		user.setUsername("rkbisoi777");
//		user.setPassword(bCryptPasswordEncoder.encode("qhmxg8"));
//		user.setEmail("rkbisoi777@gmail.com");
//		user.setProfile("default.png");
//
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("admin");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());


	}
}
