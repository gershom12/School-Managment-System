package net.sms.service;

import net.sms.model.Classroom;
import net.sms.model.School;
import net.sms.model.Teacher;
import net.sms.persistence.GenericPersistenceFacade;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gershom.Maluleke
 */
@Service
public class TeacherService extends GenericPersistenceFacade<Teacher> implements TeacherServiceLocal{

    public TeacherService() {
        super(Teacher.class);
    }
    
}
