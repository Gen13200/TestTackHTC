package com.example.testtaskhtc.ui.employee;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.testtaskhtc.R;
import com.example.testtaskhtc.di.DIManager;
import com.example.testtaskhtc.model.network.pojo.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity implements EmployeeView {

    private RecyclerView list;
    private EmployeeAdapter adapter = new EmployeeAdapter();
    private EmployeePresenter employeePresenter = new EmployeePresenter(DIManager.getInstance().getMockyApi());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        employeePresenter.onAttach(this);

        list.setAdapter(adapter);

    }

    @Override
    public void showList(List<Employee> emp) {
        adapter.setEmployees(emp);
    }

    @Override
    protected void onDestroy() {
        employeePresenter.onDetach();
        super.onDestroy();
    }
}
