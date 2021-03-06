package be.ehb.finalwork.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

@Entity(name = "users")
@Where(clause = "is_active=true  and is_teacher=true")
@Validated
public class Teacher{
    @NotNull
    @NotEmpty
    private String firstname;
    @NotNull @NotEmpty
    private String lastname;
    @NotNull @NotEmpty
    private String fieldOfStudy;
    private Integer progressyear;
    private Date birthDate;
    @NotNull @NotEmpty @Email
    private String email;
    @NotNull @NotEmpty @Length(min=3, max=30)
    private String username;
    @NotNull @NotEmpty @Length(min=8, max=30)
    private String password;
    private String salt;
    @Column(name = "is_teacher") @ColumnDefault(value = "1")
    private Boolean isTeacher = false;
    private Integer rank;
    private Long experience;
    private String slogan;
    @Column(name = "is_active") @ColumnDefault(value = "1")
    private boolean active = true;


    public Teacher() {
        setTeacher(true);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany @JoinTable(name = "teachers",
            joinColumns = {@JoinColumn(name="teacher_id")}, inverseJoinColumns={@JoinColumn(name="course_id")} )
    @JsonBackReference
    private Collection<Course> subjects;

    public Collection<Course> getSubjects() {
        return subjects;
    }

    public void setSubjects(Collection<Course> subjects) {
        this.subjects = subjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public Integer getProgressyear() {
        return progressyear;
    }

    public void setProgressyear(Integer progressyear) {
        this.progressyear = progressyear;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getTeacher() {
        return isTeacher;
    }

    public void setTeacher(Boolean teacher) {
        isTeacher = teacher;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
