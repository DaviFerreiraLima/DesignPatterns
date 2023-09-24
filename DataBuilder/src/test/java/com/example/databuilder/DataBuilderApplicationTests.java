package com.example.databuilder;

import com.example.databuilder.utils.UserBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DataBuilderApplicationTests {


	@Test
	void CriarUsuarioSemBuilder() {

		var user = new User();
		user.setCpf("123.456.789-00");
		user.setEmail("daviferreilima@gmail.com");
		user.setIdade(17);
		user.setSalario(10000);
		user.setUsername("Davi");

		assertAll("User",
				() -> assertEquals("Davi", user.getUsername()),
				() -> assertEquals("daviferreilima@gmail.com", user.getEmail()),
				() -> assertEquals(10000.0, user.getSalario()),
				() -> assertEquals(17, user.getIdade()),
				() -> assertEquals("123.456.789-00", user.getCpf())
		);
	}

	@Test
	 void CriarUsuarioComBuilder() {

		var user = new UserBuilder()
				.withUsername("johndoe")
				.withEmail("johndoe@example.com")
				.withSalario(50000.0)
				.withIdade(30)
				.withCpf("123.456.789-00")
				.build();

		assertAll("User",
				() -> assertEquals("Davi", user.getUsername()),
				() -> assertEquals("daviferreilima@gmail.com", user.getEmail()),
				() -> assertEquals(10000.0, user.getSalario()),
				() -> assertEquals(17, user.getIdade()),
				() -> assertEquals("123456789", user.getCpf())
		);
	}

	@Test
	 void voidCriarUsuarioSemEmail(){

		var user = new UserBuilder()
				.withUsername("johndoe")
				.withSalario(50000.0)
				.withIdade(30)
				.withCpf("123.456.789-00")
				.build();

		assertAll("User",
				() -> assertEquals("Davi", user.getUsername()),
				() -> assertEquals("daviferreilima@gmail.com", user.getEmail()),
				() -> assertEquals(10000.0, user.getSalario()),
				() -> assertEquals(17, user.getIdade()),
				() -> assertEquals("123456789", user.getCpf())
		);
	}


	@Test
	void voidCriarUsuarioSemEmailESemIdade(){

		var user = new UserBuilder()
				.withUsername("johndoe")
				.withSalario(50000.0)
				.withCpf("123.456.789-00")
				.build();

		assertAll("User",
				() -> assertEquals("Davi", user.getUsername()),
				() -> assertEquals("daviferreilima@gmail.com", user.getEmail()),
				() -> assertEquals(10000.0, user.getSalario()),
				() -> assertEquals(17, user.getIdade()),
				() -> assertEquals("123456789", user.getCpf())
		);
	}

}
