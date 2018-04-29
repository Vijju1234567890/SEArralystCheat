package com.abhisheksingh.ifbservices;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.io.*;

/*End of imports*/


public class FirstPage extends AppCompatActivity {

    /*
    Declaring all the needed data structures &etc. on starting of the app. This is to prevent any
    unwanted or unforeseen exception and to make the app more robust and bug-free.
    Names are self-Explanatory
     */
    public static ArrayList <Employee> employees= new ArrayList<Employee>();
    public static ArrayList<Task> assigned=new ArrayList<Task>();
    public static ArrayList<Task> unassigned=new ArrayList<Task>();;
    public static ArrayList<Task> finished=new ArrayList<Task>();;

    static public float total=20;//Total stars achieved in rating.
    static public int num=5;//Total number of customers who rated.
    //App Rating = Total/num;-Simple Average.

    public static File root;

    /*
    Much part of the page is dedicated to initialising things so that other pages can do their job
    without any hindrance. As such, this class is not given any particular functionality except for
    assuring that all required data structures, variables etc. are declared.
     */




    String[] user_emp={"Ram","Mahesh","Shankar","Ganesh","Mohan","Pritam","Suraj","Krishna","Mohit","Kishan"};
    String[] pass_emp={"sep","sep","sep","sep","sep","sep","sep","sep","sep","sep"};
    public static String[] job={"Plumber","Electrician","Technician","Carpenter","Mechanic"};
    public static double rateOfTechnician[]={0.07,0.15,0.12,0.16,0.09};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        Button Administrator=findViewById(R.id.administrator_login_btn);
        Button Employee=findViewById(R.id.employee_login_btn);
        Button Guest=findViewById(R.id.guest_login_btn);
        if(employees.size()==0) {
            for (int i = 0; i < 10; i++) {
                employees.add(new Employee(user_emp[i], pass_emp[i], user_emp[i], job[i % 5], "N/A", i + 1, 3 + (float) Math.random()));
            }
        }

       /* try {
            root = new File(Environment.getExternalStorageDirectory(), "IFB");
            if (!root.exists()) {
                root.mkdirs();
            }
            File file = new File(root, "Employee.txt");
            BufferedReader br=new BufferedReader(new FileReader(file));
            String line;
            int i=0;
            while ((line = br.readLine()) != null) {
               i++;
               if(i==1) {
                   String arr[]=line.split(" ");
                   total=Integer.parseInt(arr[0]);
                   num=Integer.parseInt(arr[1]);
               }
               else
               {
                   String arr[]=line.split(" ");
                   employees.add(new Employee(arr[0],arr[1],arr[2],arr[3],arr[5],Integer.parseInt(arr[6]),Float.parseFloat(arr[7])));
               }
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/



        Administrator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(FirstPage.this, LoginPage.class));
            }
        });
        Employee.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(FirstPage.this, LoginPage.class));
            }
        });
        Guest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(FirstPage.this, GuestPage.class));
            }
        });
    }
}
