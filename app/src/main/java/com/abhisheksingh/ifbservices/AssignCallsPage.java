package com.abhisheksingh.ifbservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class AssignCallsPage extends AppCompatActivity {
    int IdOnTask=0,IdOnTaskAssign=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_calls_page);
        IdOnTask=0;
        IdOnTaskAssign=0;

        Button assign_btn,logout_calls_btn,next__taskAssigned_btn,taskFinished_btn,next_taskFinished_btn;
        final EditText callAssigned_text, callTally_text, ongoingCall_text, employeeAvailability_text;

        /*Buttons*/
        assign_btn = (Button)findViewById(R.id.assign_btn);
        logout_calls_btn = (Button)findViewById(R.id.logout_calls_btn);
        next__taskAssigned_btn = (Button)findViewById(R.id.next__taskAssigned_btn);
        taskFinished_btn = (Button)findViewById(R.id.taskFinished_btn);
        next_taskFinished_btn = (Button)findViewById(R.id.next_taskFinished_btn);


        /*TextFields*/
        callAssigned_text=(EditText)findViewById(R.id.callAssigned_text);
        callTally_text=(EditText)findViewById(R.id.callTally_text);
        ongoingCall_text=(EditText)findViewById(R.id.ongoingCall_text);
        employeeAvailability_text=(EditText)findViewById(R.id.employeeAvailability_text);

        try {
            Task t = FirstPage.unassigned.get(IdOnTask);
            callTally_text.setText(Integer.toString(IdOnTask) + "/" + Integer.toString(FirstPage.unassigned.size()));
            callAssigned_text.setText(t.getDescription());
            boolean found=false;
            for(int i=0;i<FirstPage.employees.size();i++)
            {
                Employee e=FirstPage.employees.get(i);
                if(e.getJob().equals(t.getExpertise()) && e.getTask().equals("N/A"));
                {
                    found=true;
                }
            }
            if(found)
                employeeAvailability_text.setText("Technicians Available!");
            else
                employeeAvailability_text.setText("No Available Employee!!");

        } catch (Exception e) {
            callAssigned_text.setText("No further tasks!");
            employeeAvailability_text.setText("No Available Employee!!");
            employeeAvailability_text.setText("No Available Employee!!");
        }

        try{
            Task t=FirstPage.assigned.get(IdOnTaskAssign++);
            ongoingCall_text.setText(t.getDescription());
        }
        catch (Exception e)
        {
            ongoingCall_text.setText("No further tasks!");
        }



        logout_calls_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AssignCallsPage.this,FirstPage.class));
            }
        });

        assign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Task t = FirstPage.unassigned.get(IdOnTask);
                    boolean found = false;
                    for (int i = 0; i < FirstPage.employees.size(); i++) {
                        Employee e = FirstPage.employees.get(i);
                        if (e.getJob().equals(t.getExpertise()) && e.getTask().equals("N/A")) ;
                        {
                            found = true;
                            FirstPage.employees.get(i).setTask(t.getExpertise());
                            t.setEid(e.getId());
                        }
                    }
                    if (found) {
                        found=false;
                        employeeAvailability_text.setText("Technicians Available!");
                        t.setStartTime(System.currentTimeMillis());
                        FirstPage.assigned.add(t);
                        FirstPage.unassigned.remove(IdOnTask);
                        try{
                            t=FirstPage.assigned.get(IdOnTaskAssign++);
                            ongoingCall_text.setText(t.getDescription());
                        }
                        catch (Exception e)
                        {
                            ongoingCall_text.setText("No further tasks!");
                        }
                        try {
                            t = FirstPage.unassigned.get(IdOnTask);
                            callTally_text.setText(Integer.toString(IdOnTask) + "/" + Integer.toString(FirstPage.unassigned.size()));
                            callAssigned_text.setText(t.getDescription());

                            for(int i=0;i<FirstPage.employees.size();i++)
                            {
                                Employee e=FirstPage.employees.get(i);
                                if(e.getJob().equals(t.getExpertise()) && e.getTask().equals("N/A"));
                                {
                                    found=true;
                                }
                            }
                            if(found)
                                employeeAvailability_text.setText("Technicians Available!");
                            else
                                employeeAvailability_text.setText("No Available Employee!!");
                        } catch (Exception e) {
                            callAssigned_text.setText("No further tasks!");
                            employeeAvailability_text.setText("No Available Employee!!");
                        }

                    } else {
                        employeeAvailability_text.setText("No Available Employee!!");
                    }
                }
                catch(Exception e)
                {

                }

            }
        });

        next__taskAssigned_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Task t=FirstPage.unassigned.get(IdOnTask++);
                    callTally_text.setText(Integer.toString(IdOnTask)+"/"+Integer.toString(FirstPage.unassigned.size()));
                    callAssigned_text.setText(t.getDescription());
                    boolean found=false;
                    for(int i=0;i<FirstPage.employees.size();i++)
                    {
                        Employee e=FirstPage.employees.get(i);
                        if(e.getJob().equals(t.getExpertise()) && e.getTask().equals("N/A"));
                        {
                            found=true;
                        }
                    }
                    if(found)
                        employeeAvailability_text.setText("Technicians Available!");
                    else
                        employeeAvailability_text.setText("No Available Employee!!");

                }
                catch (Exception e)
                {
                    callAssigned_text.setText("No further tasks!");
                    employeeAvailability_text.setText("No Available Employee!!");
                }
            }
        });

        taskFinished_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Task t = FirstPage.assigned.get(IdOnTaskAssign);
                    t.setEndTime(System.currentTimeMillis());
                    for (int i = 0; i < FirstPage.employees.size(); i++) {
                        Employee e = FirstPage.employees.get(i);
                        if (e.getId() == t.getEid()) ;
                        {
                            FirstPage.employees.get(i).setTask("N/A");
                        }
                    }
                    FirstPage.finished.add(t);
                    FirstPage.assigned.remove(IdOnTaskAssign);

                    try {
                        t = FirstPage.assigned.get(IdOnTaskAssign);
                        ongoingCall_text.setText(t.getDescription());
                    } catch (Exception e) {
                        ongoingCall_text.setText("No further tasks!");
                    }
                }catch (Exception e)
                {

                }
            }
        });

        next_taskFinished_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Task t=FirstPage.assigned.get(IdOnTaskAssign++);
                    ongoingCall_text.setText(t.getDescription());
                }
                catch (Exception e)
                {
                   ongoingCall_text.setText("No further tasks!");
                }

            }
        });
    }
}
