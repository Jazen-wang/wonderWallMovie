package sysu.persistence.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private String name_en;
    @ElementCollection
    private Map<String, String> avatars = new HashMap<>();
    private String gender;
    private String born_place;
    @OneToMany
    @JoinColumn(name = "work_id")
    private List<Work> works = new ArrayList<>();

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
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

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public Map<String, String> getAvatars() {
        return avatars;
    }

    public void setAvatars(Map<String, String> avatars) {
        this.avatars = avatars;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBorn_place() {
        return born_place;
    }

    public void setBorn_place(String born_place) {
        this.born_place = born_place;
    }

    public Celebrity() {}

    @Override
    public String toString() {
        return "Celebrity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", name_en='" + name_en + '\'' +
                ", avatars=" + avatars +
                ", gender='" + gender + '\'' +
                ", born_place='" + born_place + '\'' +
                ", works=" + works +
                '}';
    }
}
