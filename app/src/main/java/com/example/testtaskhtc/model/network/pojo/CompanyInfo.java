package com.example.testtaskhtc.model.network.pojo;

import com.google.gson.annotations.SerializedName;

public class CompanyInfo {
    @SerializedName("company")
    private Company company;

    public Company getCompany ()
    {
        return company;
    }

    public void setCompany (Company company)
    {
        this.company = company;
    }

}
