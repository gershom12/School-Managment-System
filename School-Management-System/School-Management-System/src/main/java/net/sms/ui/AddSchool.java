package net.sms.ui;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import net.sms.model.School;
import net.sms.service.SchoolServiceLocal;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.PrimeFaces;

/**
 *
 * @author gershom
 * 
 */
@ManagedBean
@ViewScoped
public class AddSchool implements Serializable {
    @ManagedProperty(value = "#{schoolService}")
    private SchoolServiceLocal schoolService;

    private School school;

    private String schoolId;
    
    private String PanelHeaderName;

    /**
     * Creates a new instance of HomeBean
     */
    public AddSchool() {
    }

    @PostConstruct
    public void init() {

    }

    public SchoolServiceLocal getSchoolService() {
        
        return schoolService;
    }

    public void setSchoolService(SchoolServiceLocal schoolService) {
        
        this.schoolService = schoolService;
    }

    /*This method gets fired before the page is loaded.*/
    public void before(ComponentSystemEvent event) {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            if (!StringUtils.isBlank(getSchoolId())) {
                setPanelHeaderName("UPDATE EMPLOYEE");
                school = schoolService.find(new Long(getSchoolId()));
            } else {
                setPanelHeaderName("ADD NEW EMPLOYEE");
                school = new School();
                school.setCreatedBy("Gershom");
                school.setCreatedDate(new Date());
            }
        }
    }
    /*This method saves or update the employee instance*/
    public void save(School persistentSchool)
    {
        if(persistentSchool.getId() != null)
        {
            schoolService.update(persistentSchool);
        }
        else
        {
            schoolService.save(persistentSchool);
        }
        PrimeFaces.current().dialog().closeDynamic(persistentSchool);
    }
    

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getPanelHeaderName() {
        return PanelHeaderName;
    }

    public void setPanelHeaderName(String PanelHeaderName) {
        this.PanelHeaderName = PanelHeaderName;
    }
    
}
