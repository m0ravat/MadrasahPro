package com.mosque.management.users;

import java.sql.Date;

public interface Person {
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    Date getDoB();

    void setDoB(java.sql.Date doB);
    String getEmail();
    void setEmail(String email);
    String getAddress();
    void setAddress(String address);
    String getTelNo();
    void setTelNo(String telNo);
}
