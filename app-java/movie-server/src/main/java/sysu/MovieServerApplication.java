package sysu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import sysu.persistence.models.Celebrity;
import sysu.persistence.models.Subject;
import sysu.persistence.models.Work;
import sysu.persistence.repositories.CelebrityRepository;
import sysu.persistence.repositories.RatingRepository;
import sysu.persistence.repositories.SubjectRepository;
import sysu.persistence.repositories.WorkRepository;
import sysu.persistence.wrappers.SubjectWrapper;

@SpringBootApplication
public class MovieServerApplication {

	private static final Logger logger = LoggerFactory.getLogger(MovieServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MovieServerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(SubjectRepository subjectRepository,
						   RatingRepository ratingRepository,
						   WorkRepository workRepository,
						   CelebrityRepository celebrityRepository) {
		return (evt) -> {
//			final String api = "https://api.douban.com";
//			final String latest = "/v2/movie/in_theaters";
//			final String coming_soon = "/v2/movie/coming_soon";
//
//			RestTemplate restTemplate = new RestTemplate();
//
//			SubjectWrapper subjectWrapper = restTemplate.getForObject(api + latest, SubjectWrapper.class);
//			Subject s = subjectWrapper.getSubjects().get(1);
//			System.out.println("Subject: " + s);
//			System.out.println("Rating: " + s.getRating());
//			System.out.println("Cast: " + s.getCasts().get(0));
//			System.out.println("Director: " + s.getDirectors().get(0));
////			System.out.println("Work: " + s.getDirectors().get(0).getWorks().get(0));
////			System.out.println("Work Subject: " + s.getDirectors().get(0).getWorks().get(0).getSubject());
////
//			subjectRepository.save(s);
		};
	}
}















