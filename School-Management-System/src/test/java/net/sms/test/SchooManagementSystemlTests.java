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
        
//        List<Classroom> classrooms = new ArrayList<Classroom>();
//        List<Student> studentsOne = new ArrayList<Student>();
//        List<Student> studentsTwo = new ArrayList<Student>();
//        List<Teacher> teachers = new ArrayList<Teacher>();
//        List<Subject> subjects = new ArrayList<Subject>();
//        
//        school =  new School();
//        school.setCreatedBy("Gershom");
//        school.setUpdatedBy("Gershom");
//        school.setUpdatedDate(new Date());
//        school.setCreatedDate(new Date());
//        school.setName("Shingwedzi High School");
//        school.setAddress("504 Jorrisen and Johnston street, 043 Philresa, Sunnyside Pretoria");
//        school.setContactNumber("0826329674");
//        school.setWebsite("www.shingwedzi.co.za");
//        
//        Subject subject = new Subject();
//        subject.setCreatedBy("Gershom");
//        subject.setCreatedDate(new Date());
//        subject.setUpdatedBy("Gershom");
//        subject.setUpdatedDate(new Date());
//        subject.setName("Mathematics");
//        subject.setHoursPerWeek(8);
//        subject.setDescription("Mathematical principle");
//        subject.setAbbreviation("MATH");
//                
//        subjects.add(subject);
//        
//        Student studentOne = new Student();
//        Student studentTwo = new Student();
//        Student studentThree = new Student();
//        Student studentFour = new Student();
//        
//        studentOne.setCreatedBy("Gershom");
//        studentOne.setCreatedDate(new Date());
//        studentOne.setUpdatedBy("Gershom");
//        studentOne.setUpdatedDate(new Date());
//        studentOne.setName("Gershom");
//        studentOne.setSurname("Maluleke");
//        studentOne.setMobileNumber("0718790606");
//        studentOne.setNationality("South African");
//        studentOne.setGender("Male");
//        studentOne.setEmail("u13229908@tuks.co.za");
//        studentOne.setDateOfBirth(new Date());
//        studentOne.setAddress("Sunnyside Pretoria");
//        studentOne.setYearMark(65);
//        studentOne.setMotherTongue("Xitsonga");
//        
//        studentTwo.setCreatedBy("Gershom");
//        studentTwo.setCreatedDate(new Date());
//        studentTwo.setUpdatedBy("Gershom");
//        studentTwo.setUpdatedDate(new Date());
//        studentTwo.setName("Glad");
//        studentTwo.setSurname("Baloyi");
//        studentTwo.setMobileNumber("082674839");
//        studentTwo.setNationality("South African");
//        studentTwo.setGender("Male");
//        studentTwo.setEmail("u162343728@tuks.co.za");
//        studentTwo.setDateOfBirth(new Date());
//        studentTwo.setAddress("Sunnyside Pretoria");
//        studentTwo.setYearMark(50);
//        studentTwo.setMotherTongue("Xitsonga");
//        
//        studentThree.setCreatedBy("Gershom");
//        studentThree.setCreatedDate(new Date());
//        studentThree.setUpdatedBy("Gershom");
//        studentThree.setUpdatedDate(new Date());
//        studentThree.setName("Nhluri");
//        studentThree.setSurname("Maluleke");
//        studentThree.setMobileNumber("071348383");
//        studentThree.setNationality("South African");
//        studentThree.setGender("Male");
//        studentThree.setEmail("u16542524@tuks.co.za");
//        studentThree.setDateOfBirth(new Date());
//        studentThree.setAddress("Sunnyside Pretoria");
//        studentThree.setYearMark(65);
//        studentThree.setMotherTongue("Xitsonga");
//        
//        studentFour.setCreatedBy("Gershom");
//        studentFour.setCreatedDate(new Date());
//        studentFour.setUpdatedBy("Gershom");
//        studentFour.setUpdatedDate(new Date());
//        studentFour.setName("Gershom");
//        studentFour.setSurname("Maluleke");
//        studentFour.setMobileNumber("0718790606");
//        studentFour.setNationality("South African");
//        studentFour.setGender("Male");
//        studentFour.setEmail("u13229908@tuks.co.za");
//        studentFour.setDateOfBirth(new Date());
//        studentFour.setAddress("Sunnyside Pretoria");
//        studentFour.setYearMark(65);
//        studentFour.setMotherTongue("Xitsonga");
//        
//        studentsOne.add(studentOne);
//        studentsOne.add(studentTwo);
//        studentsOne.add(studentThree);
//        studentsOne.add(studentFour);
//        
//        school.setStudents(studentsOne);
//        
//        Teacher teacherOne = new Teacher();
//        teacherOne.setCreatedBy("Gershom");
//        teacherOne.setCreatedDate(new Date());
//        teacherOne.setUpdatedBy("Gershom");
//        teacherOne.setUpdatedDate(new Date());
//        teacherOne.setName("J Smith");
//        teacherOne.setQualification("Diploma in Education");
//        teacherOne.setSalary(23093.78);
//        teacherOne.setYearsOfExperience("6");
//        teacherOne.setTeacherID("34");
//        teacherOne.setAddress("Pretoria");
//        teacherOne.setContactNumber("073883392");
//        
//        Teacher teacherTwo = new Teacher();
//        teacherTwo.setCreatedBy("Gershom");
//        teacherTwo.setCreatedDate(new Date());
//        teacherTwo.setUpdatedBy("Gershom");
//        teacherTwo.setUpdatedDate(new Date());
//        teacherTwo.setName("J Griezman");
//        teacherTwo.setQualification("Diploma in Education");
//        teacherTwo.setSalary(20000.78);
//        teacherTwo.setYearsOfExperience("4");
//        teacherTwo.setTeacherID("45");
//        teacherTwo.setAddress("Pretoria");
//        teacherTwo.setContactNumber("073883392");
//        
//        teachers.add(teacherOne);
//        teachers.add(teacherTwo);
//        
//        school.setTeachers(teachers);
//        
//        studentsOne.remove(studentFour);
//        studentsTwo.add(studentFour);
//        
//        Classroom classroomOne = new Classroom();
//        classroomOne.setCreatedBy("Gershom");
//        classroomOne.setCreatedDate(new Date());
//        classroomOne.setUpdatedBy("Gershom");
//        classroomOne.setUpdatedDate(new Date());
//        classroomOne.setClassRoomNumber("Grade 12A");
//        classroomOne.setNumberOfStudents(45);
//        classroomOne.setStudents(studentsOne);
//        classroomOne.setTeachers(teachers);
//        classroomOne.setSubjects(subjects);
//        
//        Classroom classroomTwo = new Classroom();
//        classroomTwo.setCreatedBy("Gershom");
//        classroomTwo.setCreatedDate(new Date());
//        classroomTwo.setUpdatedBy("Gershom");
//        classroomTwo.setUpdatedDate(new Date());
//        classroomTwo.setClassRoomNumber("Grade 10A");
//        classroomTwo.setNumberOfStudents(45);
//        classroomTwo.setStudents(studentsTwo);
//        classroomTwo.setTeachers(teachers);
//        classroomTwo.setSubjects(subjects);
//        
//        classrooms.add(classroomOne);
//        classrooms.add(classroomTwo);
//        
//        school.setClassrooms(classrooms);
//        
//        schoolService.save(school);
    }
}
