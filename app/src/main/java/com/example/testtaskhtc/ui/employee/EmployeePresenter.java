package com.example.testtaskhtc.ui.employee;

import com.example.testtaskhtc.model.network.MockyApi;
import com.example.testtaskhtc.model.network.pojo.Employee;
import com.example.testtaskhtc.model.network.pojo.CompanyInfo;

import java.util.Comparator;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class  EmployeePresenter {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private EmployeeView employeeView;
    private MockyApi mockyApi;

    public EmployeePresenter(MockyApi mockyApi){
        this.mockyApi = mockyApi;
    }

    public void onAttach(EmployeeView employeeView){
        this.employeeView = employeeView;
        Disposable disposable = mockyApi
                .getMockyApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapObservable(new Function<CompanyInfo, ObservableSource<Employee>>() {
                    @Override
                    public ObservableSource<Employee> apply(CompanyInfo companyInfo) throws Exception {
                        return Observable.fromIterable(companyInfo.getCompany().getEmployees());
                    }
                })
                .sorted(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                })
                .toList()
                .subscribe(new Consumer<List<Employee>>() {
                    @Override
                    public void accept(List<Employee> emoloyees) throws Exception {
                        employeeView.showList(emoloyees);
                    }
                });
        compositeDisposable.add(disposable);
    }

    public void onDetach(){
        compositeDisposable.dispose();
        employeeView = null;
    }


}
