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
import net.sms.service.SchoolServiceLocal;
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
public class SchooManagementSystemlTests 
{
    @Autowired
    private SchoolServiceLocal schoolService;

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

    }

    @Test
    public void testPersistSchool(){
        
        List classrooms = new ArrayList();
        List students = new ArrayList();
        List teachers = new ArrayList();
        List subjects = new ArrayList();
        
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
        classrooms.add(classroom);
        
        Teacher teacher = new Teacher();
        teacher.setCreatedBy("Gershom");
        teacher.setCreatedDate(new Date());
        teacher.setUpdatedBy("Gershom");
        teacher.setUpdatedDate(new Date());
        teacher.setQualification("Diploma in education");
        teacher.setSalary(23403.45);
        teacher.setTeacherID("45");
        teacher.setYearsOfExperience("5");
        teachers.add(teachers);
        
        Student student = new Student();
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
        students.add(student);
        
        Subject subject = new Subject();
        subject.setCreatedBy("Gershom");
        subject.setCreatedDate(new Date());
        subject.setUpdatedBy("Gershom");
        subject.setUpdatedDate(new Date());
        subject.setAbbreviation("MATH");
        subject.setHoursPerWeek(12);
        subject.setDescription("Mathematical expressions");
        subject.setName("Mathematics");
        subjects.add(subject);
        
//        school.setClassrooms(classrooms);
//        school.setStudents(students);
//        school.setTeachers(teachers);
//        
//        classroom.setStudents(students);
//        classroom.setSubjects(subjects);
//        classroom.setTeachers(teachers);
//        
//        student.setSubjects(subjects);
//        teacher.setSubjects(subjects);
        
        schoolService.save(school);
    }
}
