package com.stackroute.spellcorrector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpellCorrectorApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpellCorrectorApplication.class, args);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Query : ");
		String userQuery = input.nextLine();
		System.out.println(QueryAutoCorrector.correctQuery(userQuery));
	}

}
