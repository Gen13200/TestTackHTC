package com.example.testtaskhtc.ui.employee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testtaskhtc.R;
import com.example.testtaskhtc.model.network.pojo.Employee;

import java.util.Collections;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder>{

    private List<Employee> employees = Collections.emptyList();

    public void setEmployees(List<Employee> employees){
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutListItem = R.layout.item_employe;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutListItem, parent, false);
        return  new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class EmployeeHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView phone;
        TextView skills;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            skills = itemView.findViewById(R.id.skills);

        }

        void bind(int listIndex){
            name.setText(employees.get(listIndex).getName());
            phone.setText(employees.get(listIndex).getPhoneNumber());
            skills.setText(employees.get(listIndex).getSkills().toString());
        }
    }
}
