package net.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Gershom.Maluleke
 */
@Entity
@Table(name = "subject")
public class Subject extends BaseEntity {

    @Column(name = "name_of_subject", nullable = false)
    private String name;
    @Column(name = "abbreviation", nullable = false)
    private String abbreviation;
    @Column(name = "hours_per_week", nullable = false)
    private int hoursPerWeek;
    @Column(name = "description", nullable = false)
    private String description;
    
    public Subject(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
