package com.abhisheksingh.ifbservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class EmployeePage extends AppCompatActivity {

    Button logout;//Logout
    RatingBar rb;//Rating Bar of Employee
    TextView name,task,job;//Name of Employee
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_page);
        logout=(Button)findViewById(R.id.logout_employee_btn);
        rb=(RatingBar)findViewById(R.id.ratingBar_employee);
        name=(TextView)findViewById(R.id.employeeName_text);
        /*Set the rating and name using the emp_no obtained*/
        rb.setRating(FirstPage.employees.get(LoginPage.emp_no).getRating());
        task=(TextView) findViewById(R.id.taskAssigned_text);
        task.setText(FirstPage.employees.get(LoginPage.emp_no).getTask());
        if(task.getText().toString().equals("N/A"))
            task.setText("No Task Assigned");
        job=(TextView)findViewById(R.id.Job_text);
        job.setText(FirstPage.employees.get(LoginPage.emp_no).getJob());
        name.setText(LoginPage.user_emp[LoginPage.emp_no]);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Logout Functionality.*/
                startActivity(new Intent(EmployeePage.this, FirstPage.class));
            }
        });
    }
}
