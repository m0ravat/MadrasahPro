package com.mosque.management.users;

public class EmergencyContact implements Person {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String address;
    private int telNo;
    private String relationship;
    private String alternateContact;
    private boolean primaryContact;
    public EmergencyContact(String firstName, String lastName, int age,
                            String email, String address, int telNo,
                            String relationship, String alternateContact,
                            boolean primaryContact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.address = address;
        this.telNo = telNo;
        this.relationship = relationship;
        this.alternateContact = alternateContact;
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
        return "";
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setDoB(String doB) {
        System.out.println(1);
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
    public int getTelNo() {
        return telNo;
    }

    @Override
    public void setTelNo(int telNo) {
        this.telNo = telNo;
    }

    // Additional getters and setters specific to EmergencyContact
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getAlternateContact() {
        return alternateContact;
    }

    public void setAlternateContact(String alternateContact) {
        this.alternateContact = alternateContact;
    }

    public boolean isPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(boolean primaryContact) {
        this.primaryContact = primaryContact;
    }
}
