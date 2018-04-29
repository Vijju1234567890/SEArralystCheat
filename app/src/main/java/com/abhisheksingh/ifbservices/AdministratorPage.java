package com.abhisheksingh.ifbservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdministratorPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_page);
        Button assignCalls=findViewById(R.id.assignCalls_btn);
        Button billing=findViewById(R.id.billing_btn);
        Button logout=findViewById(R.id.logout_btn);
        TextView adname=findViewById(R.id.adminstrator_name_text);
        adname.setText("Mr. Abhishek Pandey");

        assignCalls.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent( AdministratorPage.this, AssignCallsPage.class));
            }
        });
        billing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    int n=FirstPage.finished.size() ;//length no. of query
                    int id[]=new int[n];//will store id of query
                    String tech[]=new String[n];//Plumer, etc. Technician type
                    double rate[]=new double[n];//Rate
                    long st[]=new long[n];//Start time
                    long end[]=new long[n];//end time
                    long []duration =new long[n];
                    double cost[]=new double[n];
                    double sum=0;
                    Task temp;
                    for(int i=0;i<n;i++){
                        temp=FirstPage.finished.get(i);
                        id[i]=temp.getEid();
                        tech[i]=temp.getExpertise();
                        for(int j=0;j<FirstPage.job.length;j++)
                        {
                            if(FirstPage.job[j].equals(tech[i]))
                            {
                                rate[i]=FirstPage.rateOfTechnician[j];
                                break;
                            }
                        }

                        st[i]=temp.getStartTime()/1000;
                        end[i]=temp.getEndTime()/1000;
                        cost[i]=(end[i]-st[i])*rate[i];
                        rate[i]*=100;
                        rate[i]=(long)rate[i];
                        rate[i]/=100;
                        duration[i]=end[i]-st[i];

                        cost[i]*=100;
                        cost[i]=(long)cost[i];
                        cost[i]/=100;

                        sum+=cost[i];
                    }

                    sum*=100;
                    sum=(long)sum;
                    sum/=100;


                    String text="Dear Sir/Ma'am\n Thank you for using IFB Services. Please find the payment details below-\n";
                    text+="Id.  \t Technican  \t Duration \t Rate \t Cost\n";
                    for(int i=0;i<n;i++)
                    {
                        text+=Integer.toString(id[0])+"  \t"+tech[0]+"  \t";
                        text+=Long.toString(duration[i])+"\t"+Double.toString(rate[i])+"\t"+Double.toString(cost[i])+"\n";
                    }
                    text+="\n Hence, your total cost is equal to Rs"+Double.toString(sum)+"\n\n Thanking You,\n IFB Admin.";
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"f20160081@hyderabad.bits-pilani.ac.in"});
                    i.putExtra(Intent.EXTRA_SUBJECT, "Bill of IFB Services");
                    i.putExtra(Intent.EXTRA_TEXT   , text);

                    try
                    {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        ex.getStackTrace();
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent( AdministratorPage.this, FirstPage.class));
            }
        });


    }
}
