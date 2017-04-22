package sysu.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sysu.persistence.models.Subject;

/**
 * Created by Shower on 2017/4/20 0020.
 */
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
