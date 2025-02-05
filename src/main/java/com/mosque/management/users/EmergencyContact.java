package com.mosque.management.users;

public class EmergencyContact implements Person {
    private String firstName;
    private String lastName;
    private String doB;
    private String email;
    private String address;
    private String telNo;
    private String relationship;
    private String alternatePhone;
    private boolean primaryContact;
    public EmergencyContact(String firstName, String lastName, String doB,
                            String email, String address, String telNo,
                            String relationship, String alternatePhone,
                            boolean primaryContact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.doB = doB;
        this.email = email;
        this.address = address;
        this.telNo = telNo;
        this.relationship = relationship;
        this.alternatePhone = alternatePhone;
        this.primaryContact = primaryContact;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getDoB() {
        return doB;
    }

    @Override
    public void setDoB(String doB) {
        this.doB = doB;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getTelNo() {
        return telNo;
    }

    @Override
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    // Additional getters and setters specific to EmergencyContact
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    public boolean isPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(boolean primaryContact) {
        this.primaryContact = primaryContact;
    }
}
