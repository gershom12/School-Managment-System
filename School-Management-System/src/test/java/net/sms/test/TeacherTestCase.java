package net.sms.test;

import java.util.Date;
import java.util.List;
import net.sms.config.ApplicationConfig;
import net.sms.model.Person;
import net.sms.model.Subject;
import net.sms.model.Teacher;
import net.sms.service.TeacherServiceLocal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class TeacherTestCase {

    @Autowired
    private TeacherServiceLocal teacherService;

    private Teacher teacher;
    private Subject subject;
    private Person person;
    private Long teacherId;

    public TeacherTestCase() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        teacher = new Teacher();
        subject = new Subject();
        person = new Person();

        subject.setCreatedBy("Gershom");
        subject.setCreatedDate(new Date());
        subject.setUpdatedBy("Gershom");
        subject.setUpdatedDate(new Date());
        subject.setAbbreviation("MATH");
        subject.setHoursPerWeek(12);
        subject.setDescription("Mathematical expressions");
        subject.setName("Mathematics");
        teacher.setCreatedBy("Gershom");
        teacher.setCreatedDate(new Date());
        teacher.setUpdatedBy("Gershom");
        teacher.setUpdatedDate(new Date());
        teacher.setQualification("Diploma in education");
        teacher.setSalary(23403.45);
        teacher.setTeacherID("45");
        teacher.setYearsOfExperience("5");
        teacher.setCreatedBy("Gershom");
        teacher.setCreatedDate(new Date());
        teacher.setUpdatedBy("Gershom");
        teacher.setUpdatedDate(new Date());

        person.setCreatedBy("Gershom");
        person.setCreatedDate(new Date());
        person.setUpdatedBy("Gershom");
        person.setUpdatedDate(new Date());
        person.setAddress("Pretoria, Sunnyside");
        person.setDateOfBirth(new Date());
        person.setEmail("u13229908@tuks.co.za");
        person.setGender("Male");
        person.setMobileNumber("0823454838");
        person.setMotherTongue("Xitsonga");
        person.setName("Gershom");
        person.setNationality("South African");
        person.setSurname("Maluleke");
        teacher.setPerson(person);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPersistAndFind() {
        
        teacherId = testPersistTeacher();
        Teacher persistedTeacher = teacherService.find(teacherId);
        Assert.assertEquals(teacher.getTeacherID(), persistedTeacher.getTeacherID());
        Assert.assertEquals(teacher.getQualification(), persistedTeacher.getQualification());
    }

    @Test
    public void testFindAll() {
        
        List<Teacher> teachers = teacherService.findAll();
        Assert.assertTrue(!teachers.isEmpty());
    }

    @Test
    public void testUpdate() {
        
        Long id = testPersistTeacher();

        Teacher teacher = teacherService.find(id);
        teacher.setSalary(10000.00);
        teacher.setTeacherID("453");
        teacher.getPerson().setMotherTongue("Pedi");
        teacherService.update(teacher);

        Assert.assertEquals("453", teacher.getTeacherID());
        Assert.assertEquals("Pedi", teacher.getPerson().getMotherTongue());
    }

    @Ignore
    public void testDelete() {

    }

    private Long testPersistTeacher() {

        teacher.addSubject(subject);
        return teacherService.save(teacher);
    }
}
