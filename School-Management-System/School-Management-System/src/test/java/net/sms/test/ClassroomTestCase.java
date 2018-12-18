package net.sms.test;

import java.util.Date;
import java.util.List;
import net.sms.config.ApplicationConfig;
import net.sms.model.Classroom;
import net.sms.model.Person;
import net.sms.model.School;
import net.sms.model.Student;
import net.sms.model.Subject;
import net.sms.model.Teacher;
import net.sms.service.ClassroomServiceLocal;
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
public class ClassroomTestCase {

    @Autowired
    private ClassroomServiceLocal classroonService;

    private Subject subject;
    private Student student;
    private Teacher teacher;
    private Person teacherPerson;
    private Person studentPerson;
    private Classroom classroom;
    private Long classroomId;

    public ClassroomTestCase() {
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
        teacher = new Teacher();
        classroom = new Classroom();

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
        teacherPerson = new Person();
        teacherPerson.setCreatedBy("Gershom");
        teacherPerson.setCreatedDate(new Date());
        teacherPerson.setUpdatedBy("Gershom");
        teacherPerson.setUpdatedDate(new Date());
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
        student.setCreatedBy("Gershom");
        student.setCreatedDate(new Date());
        student.setUpdatedBy("Gershom");
        student.setUpdatedDate(new Date());
        student.setYearMark(56);
        studentPerson = new Person();
        studentPerson.setCreatedBy("Gershom");
        studentPerson.setCreatedDate(new Date());
        studentPerson.setUpdatedBy("Gershom");
        studentPerson.setUpdatedDate(new Date());
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
        classroom.setClassRoomNumber("Grade 12B");
        classroom.setCreatedBy("Gershom");
        classroom.setCreatedDate(new Date());
        classroom.setUpdatedBy("Gershom");
        classroom.setUpdatedDate(new Date());
        classroom.setNumberOfStudents(45);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPersistAndFind() {

        classroomId = testPersistClassroom();
        Classroom persistedClassroom = classroonService.find(classroomId);
        Assert.assertEquals(classroom.getClassRoomNumber(), persistedClassroom.getClassRoomNumber());
        Assert.assertEquals(classroom.getNumberOfStudents(), persistedClassroom.getNumberOfStudents());
    }

    @Test
    public void testFindAll() {
        
        classroomId = testPersistClassroom();
        List<Classroom> classrooms = classroonService.findAll();
        Assert.assertTrue(!classrooms.isEmpty());
    }

    @Test
    public void testUpdate() {

        Long id = testPersistClassroom();
        Classroom classroom = classroonService.find(id);
        classroom.setClassRoomNumber("Grade11");
        classroom.setNumberOfStudents(60);
        classroonService.update(classroom);
        Assert.assertEquals("Grade11", classroom.getClassRoomNumber());
        Assert.assertEquals(60, classroom.getNumberOfStudents());
    }

    @Ignore
    public void testDelete() {

    }

    public Long testPersistClassroom() {

        classroom.addStudent(student);
        classroom.addSubject(subject);
        classroom.addTeacher(teacher);
        return classroonService.save(classroom);
    }
}
