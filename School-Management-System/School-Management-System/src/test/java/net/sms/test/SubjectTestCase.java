package net.sms.test;

import java.util.Date;
import java.util.List;
import net.sms.config.ApplicationConfig;
import net.sms.model.Subject;
import net.sms.model.Teacher;
import net.sms.service.SubjectServiceLocal;
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
public class SubjectTestCase {

    @Autowired
    private SubjectServiceLocal subjectService;

    private Subject subject;
    private Long subjectId;

    public SubjectTestCase() {
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

        subject.setCreatedBy("Gershom");
        subject.setCreatedDate(new Date());
        subject.setUpdatedBy("Gershom");
        subject.setUpdatedDate(new Date());
        subject.setAbbreviation("MATH");
        subject.setHoursPerWeek(12);
        subject.setDescription("Mathematical expressions");
        subject.setName("Mathematics");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPersistAndFind() {

        subjectId = testPersistSubject();
        Subject persistedSubject = subjectService.find(subjectId);
        Assert.assertEquals(subject.getAbbreviation(), persistedSubject.getAbbreviation());
        Assert.assertEquals(subject.getHoursPerWeek(), persistedSubject.getHoursPerWeek());
    }

    @Test
    public void testFindAll() {

        List<Subject> subjects = subjectService.findAll();
        Assert.assertTrue(!subjects.isEmpty());
    }

    @Test
    public void testUpdate() {

        Long id = testPersistSubject();

        Subject subject = subjectService.find(id);
        subject.setAbbreviation("PHY");
        subject.setHoursPerWeek(8);
        subjectService.update(subject);

        Assert.assertEquals("PHY", subject.getAbbreviation());
        Assert.assertEquals(8, subject.getHoursPerWeek());
    }

    @Ignore
    public void testDelete() {

    }

    public Long testPersistSubject() {

        return subjectService.save(subject);
    }
}
