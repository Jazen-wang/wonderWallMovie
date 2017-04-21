package sysu.persistence.models;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shower on 2017/4/20 0020.
 */
@Entity
@Table(name = "celebrity")
public class Celebrity {
    @Id
    @Column(name = "id")
    private long id;
    private String name;
    @ElementCollection
    private Map<String, String> avatars = new HashMap<>();

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

    public Map<String, String> getAvatars() {
        return avatars;
    }

    public void setAvatars(Map<String, String> avatars) {
        this.avatars = avatars;
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatars=" + avatars +
                '}';
    }
}
