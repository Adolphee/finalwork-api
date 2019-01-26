package be.ehb.finalwork.api.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Collection;

@Entity(name = "courses")
@Where(clause = "is_active=true")
@Validated
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty @Length(max = 100)
    private String description;
    @NotNull @NotEmpty
    private Integer progressyear;
    @NotNull @NotEmpty
    private Integer weight;
    @NotNull @NotEmpty
    private String fieldOfStudy;
    @NotNull @NotEmpty @CreationTimestamp
    private Timestamp createdOn;
    @NotNull @NotEmpty @UpdateTimestamp
    private Timestamp updatedOn;
    @Column(name = "is_active") @ColumnDefault(value = "1")
    private boolean isActive = true;
    // Relations
    @ManyToMany @JoinTable(name = "subscriptions",
            joinColumns = {@JoinColumn(name="course_id")}, inverseJoinColumns={@JoinColumn(name="student_id")} )
    private Collection<Student> subscriptions;
    @ManyToMany @JoinTable(name = "teachers",
            joinColumns = {@JoinColumn(name="course_id")}, inverseJoinColumns={@JoinColumn(name="teacher_id")} )
    private Collection<Teacher> teachers;

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProgressyear() {
        return progressyear;
    }

    public void setProgressyear(Integer progressyear) {
        this.progressyear = progressyear;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Collection<Student> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Collection<Student> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Collection<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Collection<Teacher> teachers) {
        this.teachers = teachers;
    }
}
