package net.sms.model;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "student")
public class Student extends BaseEntity {

    @Column(name = "year_mark", nullable = true)
    private double yearMark;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Subject> subjects = new ArrayList<Subject>();
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity =Person.class)
    private Person person;
    
    public Student(){
        
    }
     
    public double getYearMark() {
        return yearMark;
    }

    public void setYearMark(double yearMark) {
        this.yearMark = yearMark;
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
