package net.sms.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import net.sms.model.School;
import net.sms.service.SchoolServiceLocal;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Gershom.Maluleke
 */
@ManagedBean
@ViewScoped
public class SchoolBean {

    @ManagedProperty(value = "#{schoolService}")
    private SchoolServiceLocal schoolService;

    private List<School> schools = new ArrayList<>();
    private School selectedSchool;

    public SchoolBean() {
    }

    @PostConstruct
    public void init() {
        
        schools = schoolService.findAll();
    }

    public void addSchool(School school) {
        Map<String, List<String>> parameters = new HashMap();
        List<String> values = new ArrayList<>();
        if (school != null) {
            values.add(String.valueOf(school.getId()));
        } else {
            values.add(String.valueOf(""));
        }
        parameters.put("schoolId", values);
        openDialogBox("addschool", parameters, 1000, 570);
    }


    public void onSchoolAdded(SelectEvent event) {
        School school = (School) event.getObject();
        Iterator<School> ite = schools.listIterator();
        while (ite.hasNext()) {
            if (ite.next().getId().equals(school.getId())) {
                ite.remove();
                break;
            }
        }
        schools.add(0, school);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Employee successfully updated or added"));
    }


    public void openDialogBox(String targetPageName, Map<String, List<String>> parameters, Integer width, Integer height) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        options.put("width", width);
        options.put("height", height);
        options.put("contentHeight", "100%");
        options.put("contentWidth", "100%");
        options.put("dynamic", false);

        PrimeFaces.current().dialog().openDynamic(targetPageName, options, parameters);
    }


    public void delete(School school) {
        schoolService.delete(school);
        Iterator<School> ite = schools.listIterator();
        while (ite.hasNext()) {
            if (ite.next().getId().equals(school.getId())) {
                ite.remove();
                break;
            }
        }
    }
    

    public String viewEmployee(School school) {

        return "dashboard.xhtml?faces-redirect=true";
    }

    public SchoolServiceLocal getSchoolService() {
        return schoolService;
    }

    public void setSchoolService(SchoolServiceLocal schoolService) {
        this.schoolService = schoolService;
    }

    public List<School> getSchools() {
        return schools;
    }

    public School getSelectedSchool() {
        return selectedSchool;
    }

    public void setSelectedEmployee(School selectedSchool) {
        this.selectedSchool = selectedSchool;
    }
}
