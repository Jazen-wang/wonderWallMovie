package sysu.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Shower on 2017/5/6 0006.
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @JsonIgnore
    private String password;
    private int gender = 0;// 0 --- female, 1 ---- male;

    public User() {}

}
