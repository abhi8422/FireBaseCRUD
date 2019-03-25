package com.example.firebase.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firebase.R;
import com.example.firebase.model.Employee;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    List<Employee> employeeList;

    public RecyclerAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_emp,viewGroup,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        Employee employee=employeeList.get(i);
        recyclerViewHolder.name.setText(employee.getName());
        recyclerViewHolder.department.setText(employee.getDepartment());
        recyclerViewHolder.designation.setText(employee.getDesignation());
        recyclerViewHolder.address.setText(employee.getAddress());

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView name,department,designation,address;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.txtname);
            department=itemView.findViewById(R.id.txtdepartment);
            designation=itemView.findViewById(R.id.txtdesignation);
            address=itemView.findViewById(R.id.txtaddress);
        }
    }
}
