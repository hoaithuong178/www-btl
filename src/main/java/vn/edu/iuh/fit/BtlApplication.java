package vn.edu.iuh.fit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.services.AuthenticationService;
import vn.edu.iuh.fit.dto.request.RegisterRequest;
import vn.edu.iuh.fit.models.Role;

@SpringBootApplication
public class BtlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtlApplication.class, args);
	}



	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		System.out.println(Role.ADMIN.getName());
		System.out.println(Role.ADMIN.getName().toUpperCase());

		return args -> {
			var admin = RegisterRequest.builder()
					.id(1)
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(Role.ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var admin2 = RegisterRequest.builder()
					.id(3)
					.firstname("Admin")
					.lastname("Admin")
					.email("admin2@mail.com")
					.password("password")
					.role(Role.CUSTOMER)
					.build();
			System.out.println("Admin token: " + service.register(admin2).getAccessToken());

			var manager = RegisterRequest.builder()
					.id(2)
					.firstname("Admin")
					.lastname("Admin")
					.email("manager@mail.com")
					.password("password")
					.role(Role.CUSTOMER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());

		};
	}
}
