package com.example.mehran;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.mehran.SignUp.AttemptSignup;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class ApptitudeTest extends Activity {

	
	 CheckBox chk1, chk2, chk3, chk4,chk5,chk6 ,chk7,chk8,chk9,chk10,chk11,chk12,chk13,chk14,chk15,chk16,chk17,chk18,chk19,chk20,chk21,chk22,chk23,chk24,chk25,chk26,chk27,chk28,chk29,chk30,chk31,chk32,chk33,chk34,chk35,chk36,chk37,chk38,chk39,chk40,chk41,chk42,chk43,chk44,chk45,chk46,chk47,chk48;
	 Button etsubmit;
	String first,second,interest;
	String username;
	String[] array1= new String[6];
	int[] array= new int[6];
	int Realistic=0,Investigative=0,Artistic=0,Social=0,Enterprising=0,Conventional=0,total=0;
	
	
	private ProgressDialog pDialog;

    // JSON parser class
    JSONParser jsonParser = new JSONParser();
    //testing on Emulator:
    private static final String LOGIN_URL = "http://10.99.23.51/education.php";

  //testing from a real server:
    //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/login.php";

    //JSON element ids from repsonse of php script:
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
	@Override
	  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apptitudetest);
		 Bundle extras = getIntent().getExtras();
	        if (extras != null) 
	        {
	        	username = extras.getString("username");
	        	System.out.println("type of education is"+username);
	        }
		chk1 = (CheckBox) findViewById(R.id.chk1);
		 //System.out.println("mejsdf");
		chk1.setOnClickListener(new OnClickListener() {
		
		  @Override
		  public void onClick(View v) {
			     //is chkIos checked?
			if (((CheckBox) v).isChecked()) {
				if(total<8)
				{
				Realistic++;
				total++;
				}
				else
				{
					((CheckBox) v).setChecked(false);
				}
			}
	 
		  }
		});
		
		chk2 = (CheckBox) findViewById(R.id.chk2);
		 
		chk2.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Investigative++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk3 = (CheckBox) findViewById(R.id.chk3);
		 
		chk3.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Artistic++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk4 = (CheckBox) findViewById(R.id.chk4);
		 
		chk4.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Social++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk5 = (CheckBox) findViewById(R.id.chk5);
		 
		chk5.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Enterprising++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk6 = (CheckBox) findViewById(R.id.chk6);
		 
		chk6.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Conventional++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		
		chk7 = (CheckBox) findViewById(R.id.chk7);
		 //System.out.println("mejsdf");
		chk7.setOnClickListener(new OnClickListener() {
		
		  @Override
		  public void onClick(View v) {
			     //is chkIos checked?
			if (((CheckBox) v).isChecked()) {
				if(total<8)
				{
				Realistic++;
				total++;
				}
				else
				{
					((CheckBox) v).setChecked(false);
				}
			}
	 
		  }
		});
		
		chk8 = (CheckBox) findViewById(R.id.chk8);
		 
		chk8.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Investigative++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk9 = (CheckBox) findViewById(R.id.chk9);
		 
		chk9.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Artistic++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk10 = (CheckBox) findViewById(R.id.chk10);
		 
		chk10.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Social++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk11 = (CheckBox) findViewById(R.id.chk11);
		 
		chk11.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Enterprising++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk12 = (CheckBox) findViewById(R.id.chk12);
		 
		chk12.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Conventional++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		
		chk13 = (CheckBox) findViewById(R.id.chk13);
		 //System.out.println("mejsdf");
		chk13.setOnClickListener(new OnClickListener() {
		
		  @Override
		  public void onClick(View v) {
			     //is chkIos checked?
			if (((CheckBox) v).isChecked()) {
				if(total<8)
				{
				Realistic++;
				total++;
				}
				else
				{
					((CheckBox) v).setChecked(false);
				}
			}
	 
		  }
		});
		
		chk14 = (CheckBox) findViewById(R.id.chk14);
		 
		chk14.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Investigative++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk15 = (CheckBox) findViewById(R.id.chk15);
		 
		chk15.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Artistic++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk16 = (CheckBox) findViewById(R.id.chk16);
		 
		chk16.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Social++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk17 = (CheckBox) findViewById(R.id.chk17);
		 
		chk17.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Enterprising++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk18 = (CheckBox) findViewById(R.id.chk18);
		 
		chk18.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Conventional++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		
		chk19 = (CheckBox) findViewById(R.id.chk19);
		 //System.out.println("mejsdf");
		chk19.setOnClickListener(new OnClickListener() {
		
		  @Override
		  public void onClick(View v) {
			     //is chkIos checked?
			if (((CheckBox) v).isChecked()) {
				if(total<8)
				{
				Realistic++;
				total++;
				}
				else
				{
					((CheckBox) v).setChecked(false);
				}
			}
	 
		  }
		});
		
		chk20 = (CheckBox) findViewById(R.id.chk20);
		 
		chk20.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Investigative++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk21 = (CheckBox) findViewById(R.id.chk21);
		 
		chk21.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Artistic++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk22 = (CheckBox) findViewById(R.id.chk22);
		 
		chk22.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Social++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk23 = (CheckBox) findViewById(R.id.chk23);
		 
		chk23.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Enterprising++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk24 = (CheckBox) findViewById(R.id.chk24);
		 
		chk24.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Conventional++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		
		chk25 = (CheckBox) findViewById(R.id.chk25);
		 //System.out.println("mejsdf");
		chk25.setOnClickListener(new OnClickListener() {
		
		  @Override
		  public void onClick(View v) {
			     //is chkIos checked?
			if (((CheckBox) v).isChecked()) {
				if(total<8)
				{
				Realistic++;
				total++;
				}
				else
				{
					((CheckBox) v).setChecked(false);
				}
			}
	 
		  }
		});
		
		chk26 = (CheckBox) findViewById(R.id.chk26);
		 
		chk26.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Investigative++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk27 = (CheckBox) findViewById(R.id.chk27);
		 
		chk27.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Artistic++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk28 = (CheckBox) findViewById(R.id.chk28);
		 
		chk28.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Social++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk29 = (CheckBox) findViewById(R.id.chk29);
		 
		chk29.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Enterprising++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk30 = (CheckBox) findViewById(R.id.chk30);
		 
		chk30.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Conventional++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk31 = (CheckBox) findViewById(R.id.chk31);
		 //System.out.println("mejsdf");
		chk31.setOnClickListener(new OnClickListener() {
		
		  @Override
		  public void onClick(View v) {
			     //is chkIos checked?
			if (((CheckBox) v).isChecked()) {
				if(total<8)
				{
				Realistic++;
				total++;
				}
				else
				{
					((CheckBox) v).setChecked(false);
				}
			}
	 
		  }
		});
		
		chk32 = (CheckBox) findViewById(R.id.chk32);
		 
		chk32.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Investigative++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk33 = (CheckBox) findViewById(R.id.chk33);
		 
		chk33.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Artistic++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk34 = (CheckBox) findViewById(R.id.chk34);
		 
		chk34.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Social++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk35 = (CheckBox) findViewById(R.id.chk35);
		 
		chk35.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Enterprising++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk36 = (CheckBox) findViewById(R.id.chk36);
		 
		chk36.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Conventional++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		
		chk37 = (CheckBox) findViewById(R.id.chk37);
		 //System.out.println("mejsdf");
		chk37.setOnClickListener(new OnClickListener() {
		
		  @Override
		  public void onClick(View v) {
			     //is chkIos checked?
			if (((CheckBox) v).isChecked()) {
				if(total<8)
				{
				Realistic++;
				total++;
				}
				else
				{
					((CheckBox) v).setChecked(false);
				}
			}
	 
		  }
		});
		
		chk38 = (CheckBox) findViewById(R.id.chk38);
		 
		chk38.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Investigative++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk39 = (CheckBox) findViewById(R.id.chk39);
		 
		chk39.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Artistic++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk40 = (CheckBox) findViewById(R.id.chk40);
		 
		chk40.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Social++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk41 = (CheckBox) findViewById(R.id.chk41);
		 
		chk41.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Enterprising++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk42 = (CheckBox) findViewById(R.id.chk42);
		 
		chk42.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Conventional++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		
		chk43 = (CheckBox) findViewById(R.id.chk43);
		 //System.out.println("mejsdf");
		chk43.setOnClickListener(new OnClickListener() {
		
		  @Override
		  public void onClick(View v) {
			     //is chkIos checked?
			if (((CheckBox) v).isChecked()) {
				if(total<8)
				{
				Realistic++;
				total++;
				}
				else
				{
					((CheckBox) v).setChecked(false);
				}
			}
	 
		  }
		});
		
		chk44 = (CheckBox) findViewById(R.id.chk44);
		 
		chk44.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Investigative++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk45 = (CheckBox) findViewById(R.id.chk45);
		 
		chk45.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Artistic++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk46 = (CheckBox) findViewById(R.id.chk46);
		 
		chk46.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Social++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk47 = (CheckBox) findViewById(R.id.chk47);
		 
		chk47.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Enterprising++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		chk48 = (CheckBox) findViewById(R.id.chk48);
		 
		chk48.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			  if (((CheckBox) v).isChecked()) {
					if(total<8)
					{
					Conventional++;
					total++;
					}
					else
					{
						((CheckBox) v).setChecked(false);
					}
				}
	 
		  }
		});
		
		etsubmit = (Button) findViewById(R.id.etsubmit);
		etsubmit.setOnClickListener(new OnClickListener() {
			
			      @Override
			
			      public void onClick(View v) {
			    	  System.out.println(Realistic+"this");
			    	  array1[0]= "Realistic";
			    	  array[0]=Realistic;
			    	  array1[1]= "Investigative";
			    	  array[1]=Investigative;
			    	  array1[2]= "Artistic";
			    	  array[2]=Artistic;
			    	  array1[3]= "Social";
			    	  array[3]=Social;
			    	  array1[4]= "Enterprising";
			    	  array[4]=Enterprising;
			    	  array1[5]= "Conventional";
			    	  array[5]=Conventional;
			    	 System.out.println("lskfhlsdhflasd"); 
			    	  for(int i=5;i>0;i--){
			    		  for(int j=0;j<i;j++){
			    			  if(array[j] > array[j+1]){
			    				  int temp1 = array[j];
			    				  array[j] = array[j+1];
			    				  array[j+1] = temp1;
			    				  
			    				  String temp2= array1[j];
			    				  array1[j] = array1[j+1];
			    				  array1[j+1] = temp2;
			    				  }
			    			  }
			    	  }
			    	  
			    	  System.out.println("first is:"+array1[5]);
			    	  System.out.println("second is:"+array1[4]);
			    	  	
			    	  interest = array1[5];
			    	  interest= interest.concat(" ");
			    	  interest = interest.concat(array1[4]);
			    	  
			    	  System.out.println("string is: "+interest);
			    	  
			    	  switch (v.getId()){
			            case R.id.etsubmit:
			            	Intent i = new Intent(ApptitudeTest.this, marks.class);
			              	i.putExtra("username", username);
			              	i.putExtra("interest", interest);
			              	finish();
			              	startActivity(i);
			                break;

			        }
			      }
			
			    });

		
	  }
	
	
	
	
	
}
