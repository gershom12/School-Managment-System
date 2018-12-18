package net.sms.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gershom.Maluleke
 */
@Entity
@Table(name = "teacher")
public class Teacher extends BaseEntity {


    @Column(name = "teacher_id", nullable = false)
    private String teacherID;
    @Column(name = "qualificantion ", nullable = false)
    private String qualification;
    @Column(name = "years_of_experience", nullable = false)
    private String yearsOfExperience;
    @Column(name = "salary", nullable = false)
    private double salary;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Subject> subjects = new ArrayList<Subject>();
    @OneToOne( cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity =Person.class)
    private Person person;
    
    public Teacher(){
        
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
