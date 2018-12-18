package net.sms.service;

import net.sms.model.Classroom;
import net.sms.model.School;
import net.sms.model.Subject;
import net.sms.persistence.GenericPersistenceFacade;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gershom.Maluleke
 */
@Service
public class SubjectService extends GenericPersistenceFacade<Subject> implements SubjectServiceLocal{

    public SubjectService() {
        super(Subject.class);
    }
    
}
