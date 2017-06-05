package sysu.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import sysu.persistence.models.*;

/**
 * Created by Shower on 2017/6/5 0005.
 */
@Configuration
public class MyRepositoryRestConfiguration extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(City.class);
        config.exposeIdsFor(Cinema.class);
        config.exposeIdsFor(Hall.class);
        config.exposeIdsFor(Movie.class);
        config.exposeIdsFor(Screening.class);
        config.exposeIdsFor(Seat.class);
        config.exposeIdsFor(UserOrder.class);
    }
}
