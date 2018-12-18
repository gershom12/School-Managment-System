package net.sms.service;

import net.sms.model.School;
import net.sms.persistence.GenericPersistenceFacade;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gershom.Maluleke
 */
@Service
public class SchoolService extends GenericPersistenceFacade<School> implements SchoolServiceLocal{

    public SchoolService() {
        super(School.class);
    }
    
}
