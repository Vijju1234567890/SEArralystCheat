package com.abhisheksingh.ifbservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    Button Login_new,Register_new;
    EditText username_new,password_new,valid_w;
    String username_admin="sep",password_admin="1234";
    ProgressBar pbar;
    static  int i,emp_no;
    public static String[] user_emp={"Ram","Mahesh","Shankar","Ganesh","Mohan","Pritam","Suraj","Krishna","Mohit","Kishan"};
    public static String[] pass_emp={"sep","sep","sep","sep","sep","sep","sep","sep","sep","sep"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        username_new=(EditText)findViewById(R.id.text_username);
        password_new=(EditText)findViewById(R.id.text_password);
        Login_new=(Button) findViewById(R.id.login_btn);
        Register_new=(Button)findViewById(R.id.register_btn);
        pbar=(ProgressBar)findViewById(R.id.progressBar);
        pbar.setVisibility(View.INVISIBLE);
        valid_w=(EditText)findViewById(R.id.valid_up_text);
        valid_w.setVisibility(View.INVISIBLE);
        Register_new.setVisibility(View.INVISIBLE);

        Login_new.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view)
            {
                //int i;
                boolean flag=false;
                for(i=0;i<10;i++)
                {
                    if(user_emp[i].equals(username_new.getText().toString()) && pass_emp[i].equals(password_new.getText().toString()))
                    {
                        emp_no=i;
                        startActivity(new Intent(LoginPage.this,EmployeePage.class));
                        Toast.makeText(LoginPage.this,"Welcome",Toast.LENGTH_LONG).show();
                        flag=true;
                        break;
                    }
                    else
                        continue;
                }
                if(flag==false)
                {
                    if(username_admin.equals(username_new.getText().toString()) && password_admin.equals(password_new.getText().toString()))
                    {
                        startActivity(new Intent(LoginPage.this,AdministratorPage.class));
                        Toast.makeText(LoginPage.this,"Welcome",Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(LoginPage.this,"Incorrect Username or Password",Toast.LENGTH_LONG).show();
                }
            }
        });
        /*Register_new.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(LoginPage.this, RegisterPage.class));
            }
        });
        */
    }
}
