package sysu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@SpringBootApplication
public class MovieServerApplication {

	private static final Logger logger = LoggerFactory.getLogger(MovieServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MovieServerApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return (evt) -> {
			final String api = "https://api.douban.com";
			final String latest = "/v2/movie/in_theaters";
			final String coming_soon = "/v2/movie/coming_soon";

			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		};
	}
}















