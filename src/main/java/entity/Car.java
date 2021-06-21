package entity;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "mark_id")
    private long markId;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "mark_id", referencedColumnName = "id", insertable = false, updatable = false)//, nullable = false)
    private Mark mark;


    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark marks) {
        this.mark = mark;
    }

    public Car() { }

    public Car(long markId) {
        this.markId = markId;
    }

    public Car(long markId, Mark mark) {
        this.markId = markId;
    }

    public long getId() {
        return id;
    }

    public long getMarkId() {
        return markId;
    }

    public void setMarkId(long markId) {
        this.markId = markId;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", markId=" + markId +
                '}';
    }
}
