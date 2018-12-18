package net.sms.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.sms.config.ApplicationConfig;
import net.sms.model.Classroom;
import net.sms.model.School;
import net.sms.model.Student;
import net.sms.model.Subject;
import net.sms.model.Teacher;
import net.sms.service.ClassroomServiceLocal;
import net.sms.service.SchoolServiceLocal;
import net.sms.service.StudentServiceLocal;
import net.sms.service.SubjectServiceLocal;
import net.sms.service.TeacherServiceLocal;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = ApplicationConfig.class)
public class SchooManagementSystemlTests {

    @Autowired
    private SubjectServiceLocal subjectService;

    @Autowired
    private StudentServiceLocal studentService;

    @Autowired
    private TeacherServiceLocal teacherService;

    @Autowired
    private ClassroomServiceLocal classroonService;

    @Autowired
    private SchoolServiceLocal schoolService;

    private Subject subject;
    private Student student;
    private Teacher teacher;
    private Classroom classroom;
    private School school;

    public SchooManagementSystemlTests() {
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
        school = new School();

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
        teacher.setAddress("Pretoria, Sunnyside");
        teacher.setDateOfBirth(new Date());
        teacher.setEmail("u13229908@tuks.co.za");
        teacher.setGender("Male");
        teacher.setMobileNumber("0823454838");
        teacher.setMotherTongue("Xitsonga");
        teacher.setName("Gershom");
        teacher.setNationality("South African");
        teacher.setSurname("Maluleke");

        student.setCreatedBy("Gershom");
        student.setCreatedDate(new Date());
        student.setUpdatedBy("Gershom");
        student.setUpdatedDate(new Date());
        student.setAddress("Pretoria, Sunnyside");
        student.setDateOfBirth(new Date());
        student.setEmail("u13229908@tuks.co.za");
        student.setGender("Male");
        student.setMobileNumber("0823454838");
        student.setMotherTongue("Xitsonga");
        student.setName("Gershom");
        student.setNationality("South African");
        student.setSurname("Maluleke");
        student.setYearMark(56);

        classroom.setClassRoomNumber("Grade 12B");
        classroom.setCreatedBy("Gershom");
        classroom.setCreatedDate(new Date());
        classroom.setUpdatedBy("Gershom");
        classroom.setUpdatedDate(new Date());
        classroom.setNumberOfStudents(45);

        school.setAddress("Pretoria, sunnyside");
        school.setContactNumber("08356278");
        school.setCreatedBy("Gershom");
        school.setCreatedDate(new Date());
        school.setName("Shingwedzi high school");
        school.setUpdatedBy("Gershom");
        school.setUpdatedDate(new Date());
        school.setWebsite("www.shingwedzi.co.za");
    }

    @Test
    public void testPersistSubject() {

        subjectService.save(subject);
    }

    @Test
    public void testPersistTeacher() {

        teacher.addSubject(subject);
        teacherService.save(teacher);
    }

    @Test
    public void testPersistStudent() {

        student.addSubject(subject);
        studentService.save(student);
    }

    @Test
    public void testPersistClassroom() {

        classroom.addStudent(student);
        classroom.addSubject(subject);
        classroom.addTeacher(teacher);

        classroonService.save(classroom);
    }

    @Test
    public void testPersistSchool() {
        
        school.addClassrooms(classroom);
        school.addStudent(student);
        school.addTeacher(teacher);
        
        schoolService.save(school);
    }
}
