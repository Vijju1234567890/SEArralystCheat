package com.abhisheksingh.ifbservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ContactUsPage extends AppCompatActivity {

    /*
    This page includes-
    1. A spinner for selection
    2. A texrfield where the task is described
    3. The submit button
     */
    Spinner spinner;
    EditText editText;//Stores the task information
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_page);



        editText = (EditText)findViewById(R.id.editText);
        submit = (Button)findViewById(R.id.submit_btn);
        spinner = (Spinner)findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(this, R.array.status_select, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(adapter);
        
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        String spinnerText = (String)spinner.getSelectedItem().toString();
        addTask(spinnerText);
    }

    private void addTask(final String spinnerText) {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use spinnerText to take text for spinner
                //use editText to access task name
                String description= editText.getText().toString();
                int id=FirstPage.unassigned.size()+1;
                String expertise=spinner.getSelectedItem().toString();

                /*
                 Task(int start,int end,int id,String expertise,String desc) - Constructor of Task
                 */
                FirstPage.unassigned.add(new Task(0,0,id,expertise,description,-1));
                //Task is now added to unassigned task pool!!
                Toast.makeText(ContactUsPage.this, "request accepted", Toast.LENGTH_LONG).show();
                startActivity(new Intent(ContactUsPage.this, FirstPage.class));
            }
        });
    }
}
