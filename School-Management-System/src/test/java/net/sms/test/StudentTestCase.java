/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sms.test;

import java.util.Date;
import java.util.List;
import net.sms.config.ApplicationConfig;
import net.sms.model.Person;
import net.sms.model.Student;
import net.sms.model.Subject;
import net.sms.service.StudentServiceLocal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Gershom.Maluleke
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = ApplicationConfig.class)

public class StudentTestCase {

    @Autowired
    private StudentServiceLocal studentService;

    private Student student;
    private Subject subject;
    private Person person;
    private Long studentId;

    public StudentTestCase() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        subject = new Subject();
        student = new Student();
        person = new Person();

        subject.setCreatedBy("Gershom");
        subject.setCreatedDate(new Date());
        subject.setUpdatedBy("Gershom");
        subject.setUpdatedDate(new Date());
        subject.setAbbreviation("MATH");
        subject.setHoursPerWeek(12);
        subject.setDescription("Mathematical expressions");
        subject.setName("Mathematics");

        student.setCreatedBy("Gershom");
        student.setCreatedDate(new Date());
        student.setUpdatedBy("Gershom");
        student.setUpdatedDate(new Date());
        student.setYearMark(56);

        person.setAddress("Pretoria, Sunnyside");
        person.setDateOfBirth(new Date());
        person.setCreatedBy("Gershom");
        person.setCreatedDate(new Date());
        person.setUpdatedBy("Gershom");
        person.setUpdatedDate(new Date());
        person.setEmail("u13229908@tuks.co.za");
        person.setGender("Male");
        person.setMobileNumber("0823454838");
        person.setMotherTongue("Xitsonga");
        person.setName("Gershom");
        person.setNationality("South African");
        person.setSurname("Maluleke");
        student.setPerson(person);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPersistAndFind() {

        studentId = testPersistStudent();
        Student persistedStudent = studentService.find(studentId);
        Assert.assertEquals(student.getPerson().getContactNumber(), persistedStudent.getPerson().getContactNumber());
        Assert.assertEquals(student.getPerson().getName(), persistedStudent.getPerson().getName());
    }

    @Test
    public void testFindAll() {

        List<Student> students = studentService.findAll();
        Assert.assertTrue(!students.isEmpty());
    }

    @Test
    public void testUpdate() {

        Long id = testPersistStudent();

        Student student = studentService.find(id);
        student.getPerson().setSurname("Maluleke");
        student.getPerson().setName("Nhluri");
        studentService.update(student);

        Assert.assertEquals("Nhluri", student.getPerson().getName());
        Assert.assertEquals("Maluleke", student.getPerson().getSurname());
    }

    @Ignore
    public void testDelete() {

    }

    public Long testPersistStudent() {

        student.addSubject(subject);
        return studentService.save(student);
    }
}
