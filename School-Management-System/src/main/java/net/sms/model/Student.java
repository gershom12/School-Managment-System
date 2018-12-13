package net.sms.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Gershom.Maluleke
 */
@Entity
@Table(name = "student")
public class Student extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "mobile_number", nullable = true)
    private String mobileNumber;
    @Column(name = "email", nullable = true)
    private String email;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "year_mark", nullable = false)
    private double yearMark;
    @Column(name = "nationality", nullable = false)
    private String nationality;
    @Column(name = "mother_tongue", nullable = false)
    private String motherTongue;
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getYearMark() {
        return yearMark;
    }

    public void setYearMark(double yearMark) {
        this.yearMark = yearMark;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
