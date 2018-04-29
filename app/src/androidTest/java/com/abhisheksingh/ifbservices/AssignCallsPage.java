package com.abhisheksingh.ifbservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AssignCallsPage extends AppCompatActivity {
    int IdOnTask=0,IdOnTaskAssign=0;
    Button prevTask,prevFin;

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
        prevTask=(Button) findViewById(R.id.previous_taskassigned_btn);
        prevFin=(Button) findViewById(R.id.previous_taskfinished_btn);

        prevTask.setVisibility(View.INVISIBLE);
        prevFin.setVisibility(View.INVISIBLE);


        /*TextFields*/
        callAssigned_text=(EditText)findViewById(R.id.callAssigned_text);
        callTally_text=(EditText)findViewById(R.id.callTally_text);
        ongoingCall_text=(EditText)findViewById(R.id.ongoingCall_text);
        employeeAvailability_text=(EditText)findViewById(R.id.employeeAvailability_text);

        try {
            Task t = FirstPage.unassigned.get(IdOnTask);
            IdOnTask++;
            callTally_text.setText(Integer.toString(IdOnTask) + "/" + Integer.toString(FirstPage.unassigned.size()));
            callAssigned_text.setText(t.getDescription());
            boolean found=false;
            for(int i=0;i<FirstPage.employees.size();i++)
            {
                Employee e=FirstPage.employees.get(i);
                if(e.getJob().equals(t.getExpertise()) && e.getTask().equals("N/A"))
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
            Task t=FirstPage.assigned.get(IdOnTaskAssign);
            IdOnTaskAssign++;
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
                if(1<=IdOnTask && IdOnTask<=FirstPage.unassigned.size()) {
                    IdOnTask--;
                    try {
                        Task t = FirstPage.unassigned.get(IdOnTask);
                        IdOnTask++;
                        boolean found = false;
                        for (int i = 0; i < FirstPage.employees.size(); i++) {
                            Employee e = FirstPage.employees.get(i);
                            //System.out.println(e.getJob() + " " + t.getExpertise() + " " + e.getJob().equals(t.getExpertise()));
                            if (e.getJob().equals(t.getExpertise()) && e.getTask().equals(("N/A"))) {
                                found = true;
                                FirstPage.employees.get(i).setTask(t.getDescription());
                                t.setEid(e.getId());
                                Toast.makeText(AssignCallsPage.this,"Assigned employee number #"+Integer.toString(e.getId()),Toast.LENGTH_LONG).show();
                                break;
                            }
                        }
                        if (found) {
                            found = false;
                            employeeAvailability_text.setText("Technicians Available!");
                            t.setStartTime(System.currentTimeMillis());
                            FirstPage.assigned.add(t);
                            FirstPage.unassigned.remove(--IdOnTask);
                            try {
                                //System.out.print(IdOnTask+" "+FirstPage.assigned.size());
                                t = FirstPage.assigned.get(IdOnTaskAssign);
                                IdOnTaskAssign++;
                                ongoingCall_text.setText(t.getDescription());
                                prevFin.setVisibility(View.VISIBLE);
                            } catch (Exception e) {
                                e.printStackTrace();
                                ongoingCall_text.setText("No further tasks!");

                            }
                            try {
                                t = FirstPage.unassigned.get(IdOnTask);
                                IdOnTask++;
                                callTally_text.setText(Integer.toString(IdOnTask) + "/" + Integer.toString(FirstPage.unassigned.size()));
                                callAssigned_text.setText(t.getDescription());

                                for (int i = 0; i < FirstPage.employees.size(); i++) {
                                    Employee e = FirstPage.employees.get(i);
                                    if (e.getJob().toString().equals(t.getExpertise().toString()) && e.getTask().toString().equals(("N/A").toString())) {
                                        found = true;
                                    }
                                }
                                if (found)
                                    employeeAvailability_text.setText("Technicians Available!");
                                else
                                    employeeAvailability_text.setText("No Available Employee!!");
                            } catch (Exception e) {
                                callAssigned_text.setText("No further tasks!");
                                callTally_text.setText(Integer.toString(FirstPage.unassigned.size()) + "/" + Integer.toString(FirstPage.unassigned.size()));
                                employeeAvailability_text.setText("No Available Employee!!");
                            }


                        } else {

                            employeeAvailability_text.setText("No Available Employee!!");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        next__taskAssigned_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IdOnTask < FirstPage.unassigned.size()) {
                    try {

                        Task t = FirstPage.unassigned.get(IdOnTask);
                        IdOnTask++;
                        callTally_text.setText(Integer.toString(IdOnTask) + "/" + Integer.toString(FirstPage.unassigned.size()));
                        callAssigned_text.setText(t.getDescription());
                        boolean found = false;
                        prevTask.setVisibility(View.VISIBLE);
                        for (int i = 0; i < FirstPage.employees.size(); i++) {
                            Employee e = FirstPage.employees.get(i);
                            if (e.getJob().equals(t.getExpertise()) && e.getTask().equals(("N/A"))) {
                                found = true;
                            }
                        }
                        if (found)
                            employeeAvailability_text.setText("Technicians Available!");
                        else
                            employeeAvailability_text.setText("No Available Employee!!");

                    } catch (Exception e) {
                        callAssigned_text.setText("No further tasks!");
                        employeeAvailability_text.setText("No Available Employee!!");
                    }
                }
            }
        });

       prevTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(IdOnTask<=1)
                {
                    prevTask.setVisibility(View.INVISIBLE);
                }
                else{
                   try {
                        IdOnTask--;
                        callTally_text.setText(Integer.toString(IdOnTask) + "/" + Integer.toString(FirstPage.unassigned.size()));
                        Task t = FirstPage.unassigned.get(IdOnTask-1);
                        callAssigned_text.setText(t.getDescription());
                        boolean found = false;
                        for (int i = 0; i < FirstPage.employees.size(); i++)
                        {
                            Employee e = FirstPage.employees.get(i);
                            if (e.getJob().equals(t.getExpertise()) && e.getTask().equals("N/A"))
                            {
                                found = true;
                            }
                        }
                        if (found)
                            employeeAvailability_text.setText("Technicians Available!");
                        else
                            employeeAvailability_text.setText("No Available Employee!!");

                    } catch (Exception e) {
                        callAssigned_text.setText("No tasks!");
                        employeeAvailability_text.setText("No Employee Available!!");
                    }
                }
            }
        });

        taskFinished_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (1<=IdOnTaskAssign && IdOnTaskAssign <= FirstPage.assigned.size()) {
                    try {
                        Task t = FirstPage.assigned.get(--IdOnTaskAssign);
                        t.setEndTime(System.currentTimeMillis());
                        for (int i = 0; i < FirstPage.employees.size(); i++) {
                            Employee e = FirstPage.employees.get(i);
                            if (e.getId() == t.getEid()) {
                                FirstPage.employees.get(i).setTask("N/A");
                            }
                        }
                        FirstPage.finished.add(t);
                        FirstPage.assigned.remove(IdOnTaskAssign);

                        try {
                            t = FirstPage.assigned.get(IdOnTaskAssign);
                            IdOnTaskAssign++;
                            ongoingCall_text.setText(t.getDescription());
                        } catch (Exception e) {
                            ongoingCall_text.setText("No further tasks!");
                        }
                    } catch (Exception e) {

                        ongoingCall_text.setText("No further tasks!");

                    }
                }
                else if(IdOnTaskAssign <=0)
                {
                    ongoingCall_text.setText("No further tasks!");
                }
            }
        });

        next_taskFinished_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(IdOnTaskAssign<FirstPage.assigned.size()) {
                    try {
                        Task t = FirstPage.assigned.get(IdOnTaskAssign);
                        IdOnTaskAssign++;
                        ongoingCall_text.setText(t.getDescription());
                        prevFin.setVisibility(View.VISIBLE);
                    } catch (Exception e) {
                        ongoingCall_text.setText("No further tasks!");
                    }
                }

            }
        });
        prevFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(IdOnTaskAssign<=1)
                    prevFin.setVisibility(View.INVISIBLE);
                else {
                    try {
                        --IdOnTaskAssign;
                        Task t = FirstPage.assigned.get(IdOnTaskAssign-1);
                        ongoingCall_text.setText(t.getDescription());
                        prevFin.setVisibility(View.VISIBLE);
                    } catch (Exception e) {
                        ongoingCall_text.setText("No further tasks!");
                    }
                }

            }
        });
    }
}
