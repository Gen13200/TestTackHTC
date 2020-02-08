package com.example.testtaskhtc.model.network.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Company {

        @SerializedName("employees")
        private List<Employee> employees;

        public List<Employee> getEmployees ()
        {
            return employees;
        }


}
