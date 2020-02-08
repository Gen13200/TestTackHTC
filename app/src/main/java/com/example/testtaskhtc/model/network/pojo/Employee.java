package com.example.testtaskhtc.model.network.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class Employee {
    @SerializedName("skills")
    private List<String> skills;
    @SerializedName("name")
    private String name;
    @SerializedName("phone_number")
    private String phoneNumber;

    public List<String> getSkills ()
    {
        if(skills == null){
            return Collections.emptyList();
        }else return skills;
    }

    public void setSkills (List<String> skills)
    {
        this.skills = skills;
    }

    public String getName ()
    {
        if(name == null) {
            return name = "null";
        }else return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPhoneNumber ()
    {
        return phoneNumber;
    }

    public void setPhoneNumber (String phone_number)
    {
        this.phoneNumber = phone_number;
    }

}
