package sysu;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jni.Local;
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

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
@EnableMongoHttpSession
@SpringBootApplication
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
//
			generator dataGenerate = new generator();
			List<Screening> res = dataGenerate.screeningAllGenerate(latestMovies);
			for (Screening s : res) {
				System.out.println(s.getHall().getCinema().getCity());
				System.out.println(s.getHall().getCinema());
				System.out.println(s.getHall());
				cityRepository.save(s.getHall().getCinema().getCity());
				cinemaRepository.save(s.getHall().getCinema());
				hallRepository.save(s.getHall());
				movieRepository.save(s.getMovie());
				screeningRepository.save(s);
			}

			List<Screening> test = screeningRepository.findAll();
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

class generator {
    public generator() {} //constructor

	public Movie movieGenerate(List<Movie> latestMovies) {
    	int len = latestMovies.size();
		Random r = new Random();
		int code = r.nextInt(len);
		return latestMovies.get(code);
	}

	public List<Screening> screeningHallGenerte(Hall h, List<Movie> latestMovies) {
    	LocalTime[] start = {LocalTime.of(10, 20), LocalTime.of(13, 10),
				LocalTime.of(15, 20), LocalTime.of(17, 0), LocalTime.of(19, 35)};
		LocalTime[] end = {LocalTime.of(12, 15), LocalTime.of(15, 5),
				LocalTime.of(16, 45), LocalTime.of(19, 0), LocalTime.of(21, 45)};
		List<Screening> result = new ArrayList<Screening>();
		for (int i = 0; i < 5; i++) {
			Movie m = this.movieGenerate(latestMovies);
			Screening s = new Screening(start[i], end[i], h, m);
			result.add(s);
		}
		return result;
	}

	public List<Screening> screeningAllGenerate(List<Movie> latestMovies) {
		String[] cityName = {"广州", "深圳", "杭州", "上海", "北京"};
		String[] cinemaName = {"万达影城", "星河电影院", "中影环球影城", "金逸影城"};
		String[] addressName = {"新港东路1234号", "兴业大道3456号", "中山大道5678号", "黄埔东路78号"};
		List<Screening> result = new  ArrayList<Screening>();
		for (int city = 0; city < 1; city++) {
			for (int cinema = 0; cinema < 1; cinema++) {
				for (int h = 0; h < 1; h++) {
					City c = new City(cityName[city], city);
					Cinema ci = new Cinema(cinemaName[cinema], addressName[cinema], c);
					Hall temp = new Hall(h, ci);
					List<Screening> tempResult = this.screeningHallGenerte(temp, latestMovies);
					result.addAll(tempResult);
				}
			}
		}
		return result;
	}
}















