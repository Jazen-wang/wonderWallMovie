package sysu.persistence.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shower on 2017/4/20 0020.
 */
@Entity
@Table(name = "work")
public class Work {
    @Id
    @Column(name = "id")
    private long id;

    @ElementCollection
    private List<String> roles = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Work() {}

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", roles=" + roles +
                ", subject=" + subject +
                '}';
    }
}
