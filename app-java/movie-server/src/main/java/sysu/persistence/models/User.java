package sysu.persistence.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by shower on 17-4-14.
 */
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    public User() {
        super();
    }

    public User(String name, String pwd) {
        super();

        this.name = name;
        this.password = pwd;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
