package net.sms.ui;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gershom
 */
@ManagedBean
@ViewScoped
public class MenuBean implements Serializable{


    /**
     * Creates a new instance of HomeBean
     */
    public MenuBean() {
    }
    
    public String switchToEmployee(){
        return "schools.xhtml?faces-redirect=true";
    }

}
