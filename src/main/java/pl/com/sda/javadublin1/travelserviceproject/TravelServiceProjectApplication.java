package pl.com.sda.javadublin1.travelserviceproject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TravelServiceProjectApplication {

	//	w springu mozna uzyc properties dzieki adnotacji @Value
	//	sluzy to do parametryzacji systemu
	//	mozna uzywac w controllerach, service'ach itp.
	//	spojrz do application.properties
	@Value("${currency}")
	private String currency;

	public static void main(String[] args) {
		SpringApplication.run(TravelServiceProjectApplication.class, args);
	}

	// taka funkcje mozna wykorzystac do testowania komponentow springa
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> System.out.println(currency);
	}
}
