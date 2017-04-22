package sysu.persistence.wrappers;

import sysu.persistence.models.Subject;

import java.util.List;

/**
 * Created by Shower on 2017/4/20 0020.
 */
public class SubjectWrapper {
    private String title;
    private int total;
    private int start;
    private int count;
    private List<Subject> subjects;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "SubjectWrapper{" +
                "title='" + title + '\'' +
                ", total=" + total +
                ", start=" + start +
                ", count=" + count +
                ", subjects=" + subjects +
                '}';
    }
}
