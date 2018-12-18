package net.sms.service;

import net.sms.model.Classroom;
import net.sms.model.School;
import net.sms.model.Student;
import net.sms.persistence.GenericPersistenceFacade;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gershom.Maluleke
 */
@Service
public class StudentService extends GenericPersistenceFacade<Student> implements StudentServiceLocal{

    public StudentService() {
        super(Student.class);
    }
    
}
