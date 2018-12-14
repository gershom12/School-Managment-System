package net.sms.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gershom.Maluleke
 */
@Entity
@Table(name = "classroom")
public class Classroom extends BaseEntity {

    @Column(name = "class_room_number", nullable = false)
    private String classRoomNumber;
    @Column(name = "number_of_students", nullable = false)
    private int numberOfStudents;
    @Column(name = "teachers", nullable = false)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Teacher> teachers = new ArrayList<Teacher>();
    @Column(name = "students", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<Student>();
    @Column(name = "subjects", nullable = false)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Subject> subjects = new ArrayList<Subject>();

    public String getClassRoomNumber() {
        return classRoomNumber;
    }

    public void setClassRoomNumber(String name) {
        this.classRoomNumber = name;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }
    
    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }
    
    public void addStudent(Student student) {
        this.students.add(student);
    }
}
