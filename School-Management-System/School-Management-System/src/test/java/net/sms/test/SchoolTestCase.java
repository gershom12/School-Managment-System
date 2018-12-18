package net.sms.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.sms.config.ApplicationConfig;
import net.sms.model.Classroom;
import net.sms.model.Person;
import net.sms.model.School;
import net.sms.model.Student;
import net.sms.model.Subject;
import net.sms.model.Teacher;
import net.sms.service.SchoolServiceLocal;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = ApplicationConfig.class)
public class SchoolTestCase {

    @Autowired
    private SchoolServiceLocal schoolService;

    private Student student;
    private Teacher teacher;
    private Classroom classroom;
    private School school;
    private Person teacherPerson;
    private Person studentPerson;
    private Long schoolId;

    public SchoolTestCase() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        school = new School();
        school.setName("Shingwedzi high school");
        school.setAddress("Pretoria, sunnyside");
        school.setContactNumber("083456345");
        school.setWebsite("www.shingwedzi.co.za");
        school.setCreatedBy("Gershom");
        school.setCreatedDate(new Date());
        school.setUpdatedBy("Gershom");
        school.setUpdatedDate(new Date());

        Classroom classroom = new Classroom();
        classroom.setCreatedBy("Gershom");
        classroom.setCreatedDate(new Date());
        classroom.setUpdatedBy("Gershom");
        classroom.setUpdatedDate(new Date());
        classroom.setClassRoomNumber("Grade 12B");
        classroom.setNumberOfStudents(45);

        Teacher teacher = new Teacher();
        teacher.setCreatedBy("Gershom");
        teacher.setCreatedDate(new Date());
        teacher.setUpdatedBy("Gershom");
        teacher.setUpdatedDate(new Date());
        teacher.setQualification("Diploma in education");
        teacher.setSalary(23403.45);
        teacher.setTeacherID("45");
        teacher.setYearsOfExperience("5");

        teacherPerson = new Person();

        teacherPerson.setAddress("Pretoria, Sunnyside");
        teacherPerson.setDateOfBirth(new Date());
        teacherPerson.setEmail("Gershom@gmail.com");
        teacherPerson.setMobileNumber("0839929293");
        teacherPerson.setMotherTongue("Xitsonga");
        teacherPerson.setName("Micheal");
        teacherPerson.setNationality("South African");
        teacherPerson.setSurname("Baloyi");
        teacherPerson.setGender("Male");

        teacher.setPerson(teacherPerson);

        Student student = new Student();
        student.setCreatedBy("Gershom");
        student.setCreatedDate(new Date());
        student.setUpdatedBy("Gershom");
        student.setUpdatedDate(new Date());
        student.setYearMark(56);
        studentPerson = new Person();
        studentPerson.setAddress("Pretoria, Sunnyside");
        studentPerson.setDateOfBirth(new Date());
        studentPerson.setEmail("u13229908@tuks.co.za");
        studentPerson.setGender("Male");
        studentPerson.setMobileNumber("0823454838");
        studentPerson.setMotherTongue("Xitsonga");
        studentPerson.setName("Gershom");
        studentPerson.setNationality("South African");
        studentPerson.setSurname("Maluleke");
        student.setPerson(studentPerson);
        Subject subject = new Subject();
        subject.setCreatedBy("Gershom");
        subject.setCreatedDate(new Date());
        subject.setUpdatedBy("Gershom");
        subject.setUpdatedDate(new Date());
        subject.setAbbreviation("MATH");
        subject.setHoursPerWeek(12);
        subject.setDescription("Mathematical expressions");
        subject.setName("Mathematics");
        student.addSubject(subject);
        teacher.addSubject(subject);
        classroom.addStudent(student);
        classroom.addSubject(subject);
        classroom.addTeacher(teacher);
    }

    @Test
    public void testPersistAndFind() {

        schoolId = testPersistSchool();
        School persistedSchool = schoolService.find(schoolId);
        Assert.assertEquals(school.getName(), persistedSchool.getName());
        Assert.assertEquals(school.getContactNumber(), persistedSchool.getContactNumber());
        Assert.assertEquals(school.getWebsite(), persistedSchool.getWebsite());
    }

    @Test
    public void testFindAll() {

        schoolId = testPersistSchool();
        List<School> schools = schoolService.findAll();
        Assert.assertTrue(!schools.isEmpty());
    }

    @Test
    public void testUpdate() {

        Long id = testPersistSchool();
        School school = schoolService.find(id);
        school.setName("Mahlahle");
        school.setWebsite("www.mahlahle.com");
        schoolService.update(school);
        Assert.assertEquals("Mahlahle", school.getName());
        Assert.assertEquals("www.mahlahle.com", school.getWebsite());
    }

    @Ignore
    public void testDelete() {

    }

    public Long testPersistSchool() {

        school.addClassrooms(classroom);
        school.addStudent(student);
        school.addTeacher(teacher);
        return schoolService.save(school);
    }
}
