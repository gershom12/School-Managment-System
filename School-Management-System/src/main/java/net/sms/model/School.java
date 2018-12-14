package net.sms.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gershom.Maluleke
 */

@Entity
@Table(name = "school")
public class School extends BaseEntity{
    
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "website", nullable = true)
    private String website;
    @Column(name = "contact_number", nullable = false)
    private String contactNumber;
    @Column(name = "class_rooms", nullable = false)
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER )
    private List<Classroom> classrooms = new ArrayList<Classroom>();
    @Column(name = "teachers", nullable = false)
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Teacher> teachers = new ArrayList<Teacher>();
    @Column(name = "students", nullable = false)
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<Student>();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }
    
    public void addStudent(Student student) {
        this.students.add(student);
    }
    
    public void addClassrooms(Classroom classroom) {
        this.classrooms.add(classroom);
    }
}
