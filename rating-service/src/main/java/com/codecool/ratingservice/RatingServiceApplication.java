package com.codecool.ratingservice;

import com.codecool.ratingservice.model.Rating;
import com.codecool.ratingservice.repository.RatingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RatingServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(RatingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RatingRepository ratingRepository) {

		return args -> {
			ratingRepository.saveAll
					(Arrays.asList(
							Rating.builder()
									.userId(1L)
									.productId(2L)
									.id(3L)
									.rating(4)
									.comment("I like it!")
									.build(),
							Rating.builder()
									.userId(2L)
									.productId(1L)
									.id(2L)
									.rating(3)
									.comment("Not so much!")
									.build(),
							Rating.builder()
									.userId(3L)
									.productId(4L)
									.id(1L)
									.rating(2)
									.comment("Ugly!")
									.build(),
							Rating.builder()
									.userId(4L)
									.productId(3L)
									.id(5L)
									.rating(5)
									.comment("Super!")
									.build(),
							Rating.builder()
									.userId(5L)
									.productId(3L)
									.id(4L)
									.rating(5)
									.comment("Super!")
									.build()
					));
		};
	}
}
