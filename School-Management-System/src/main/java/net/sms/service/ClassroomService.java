package net.sms.service;

import net.sms.model.Classroom;
import net.sms.model.School;
import net.sms.persistence.GenericPersistenceFacade;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gershom.Maluleke
 */
@Service
public class ClassroomService extends GenericPersistenceFacade<Classroom> implements ClassroomServiceLocal{

    public ClassroomService() {
        super(Classroom.class);
    }
    
}
