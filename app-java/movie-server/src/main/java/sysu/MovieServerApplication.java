package sysu;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.session.data.mongo.JdkMongoSessionConverter;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.springframework.web.client.RestTemplate;
import sysu.persistence.models.*;
import sysu.persistence.repositories.*;
import sysu.services.DoubanService;

import java.nio.charset.Charset;
import java.util.List;

@SpringBootApplication
@EnableMongoHttpSession
public class MovieServerApplication {

	private static final Logger logger = LoggerFactory.getLogger(MovieServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MovieServerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CityRepository cityRepository,
						   CinemaRepository cinemaRepository,
						   HallRepository hallRepository,
						   SeatRepository seatRepository,
						   MovieRepository movieRepository,
						   ScreeningRepository screeningRepository,
						   DoubanService doubanService) {
		return (String... evt) -> {
			City city1 = new City("广州", 1);
			cityRepository.save(city1);
			Cinema cinema1 = new Cinema("WonderWall", "小谷围", city1);
			cinemaRepository.save(cinema1);
			Hall hall1 = new Hall(1, cinema1);
			hallRepository.save(hall1);

			String latest = doubanService.getLatestMovies("广州").get();
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			JsonNode subjects = objectMapper.readTree(latest).findPath("subjects");
			List<Movie> latestMovies = objectMapper.readValue(subjects.toString(),
					objectMapper.getTypeFactory().constructCollectionType(List.class, Movie.class));
			movieRepository.save(latestMovies);
		};
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters()
				.add(0, new StringHttpMessageConverter(Charset.forName("utf-8")));
		return restTemplate;
	}

	@Bean
	ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public JdkMongoSessionConverter jdkMongoSessionConverter() {
		return new JdkMongoSessionConverter();
	}
}















