package com.example.mehran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.mehran.SignUp.AttemptSignup;
import com.example.mehran.login.AttemptLogin;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class marks extends Activity {

	public static String but;
	EditText percentage,marks,subject,educationLevel;
	Button submit,addSubject,Add;
	LinearLayout container;
	String username, interest,grade;
	Spinner level_options;
	 Map<String, String> matric = new HashMap<String, String>();
	 Map<String, String> inter = new HashMap<String, String>();
	
	
	private ProgressDialog pDialog;

    // JSON parser class
    JSONParser jsonParser = new JSONParser();
    //testing on Emulator:
    private static final String LOGIN_URL = "http://10.99.23.73/education.php";
    private static final String LOGIN_URL1 = "http://10.99.23.73/subjects.php";

  //testing from a real server:
    //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/login.php";

    //JSON element ids from repsonse of php script:
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_marks);
		
		 Bundle extras = getIntent().getExtras();
	        if (extras != null) 
	        {
	        	username = extras.getString("username");
	        	interest = extras.getString("interest");
	        	System.out.println("username is "+username);
	        	System.out.println("interest is "+interest);
	        }
	        
	        
	        percentage = (EditText) findViewById(R.id.percentage);
	        marks = (EditText) findViewById(R.id.marks);
	        subject = (EditText) findViewById(R.id.subject);
	        addSubject = (Button) findViewById(R.id.addSubject);
	        submit = (Button) findViewById(R.id.submit);
	        Add = (Button) findViewById(R.id.Add);
	        container = (LinearLayout)findViewById(R.id.container);
	        
	        level_options= (Spinner) findViewById(R.id.level_options);
	        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.option_grade, android.R.layout.simple_spinner_item);
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        level_options.setAdapter(adapter);
	        level_options.setOnItemSelectedListener(new OnItemSelectedListener() {

	                @Override
	                public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
	                	grade = level_options.getItemAtPosition(position).toString();
	                	 //Toast.makeText(grade_options.getContext(), "You selected: " + grade,Toast.LENGTH_LONG).show();
	                }

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub
						
					}
	            });
           
	        
	        Add.setOnClickListener(new OnClickListener(){
	        	
	        	
	        	 @Override
	        	    public void onClick(View v){

	        	        switch (v.getId()){
                        	        	        
	        	            case R.id.Add:
	        	            	but="Add";
	        	            	new EnterMarks().execute();
	        	                break;

	        	        }
	        	    }
	        });

	        addSubject.setOnClickListener(new OnClickListener(){

	        	   @Override
	        	   public void onClick(View arg0) {
	        		  
	        	    LayoutInflater layoutInflater = 
	        	      (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        	    final View addView = layoutInflater.inflate(R.layout.row, null);
	        	    TextView textOut = (TextView)addView.findViewById(R.id.textout);
	        	    TextView textOut1 = (TextView)addView.findViewById(R.id.textout1);
	        	    textOut.setText(subject.getText().toString()+"\n\n");
	        	   
	        	    textOut1.setText(marks.getText().toString());
	        	  
	        	    matric.put(subject.getText().toString(),marks.getText().toString());
	        	  subject.setText(" ");
	        	  marks.setText("  ");
	        	    Button buttonRemove = (Button)addView.findViewById(R.id.remove);
	        	    buttonRemove.setOnClickListener(new OnClickListener(){

	        	     @Override
	        	     public void onClick(View v) {
	        	      ((LinearLayout)addView.getParent()).removeView(addView);
	        	     }});
	        	    
	        	    container.addView(addView);
	        	   }});
	        
	        
	        
	        submit.setOnClickListener(new OnClickListener() {
				
			      @Override
			
			      public void onClick(View v) {
			    	  
			    	  switch (v.getId()){
			            case R.id.submit:
			            	
			            	but="submit";
			            	System.out.println("username is ");
				        	System.out.println("interest is ");
			            	new EnterMarks().execute();
			                break;
			      }
    }
	
	        
    });
    }
    

	

	
    
class EnterMarks extends AsyncTask<String, String, String> {

		
		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			 // Check for success tag
			educationinfo();
			matinfo();
	
		return null;
		}
		
		
		
		protected String educationinfo ( )
		{
			 int success;
	          String username1 = username;
	          String interest1= interest;
	          String matmarks= percentage.getText().toString();
	          String level=educationLevel.getText().toString();
	          String suggestion1= " vncmcx";
	          String suggestion2= " vncmcx";
	          String suggestion3= " vncmcx";
	         
	          
	          try {
	        	  
	              // Building Parameters
	              List<NameValuePair> params = new ArrayList<NameValuePair>();
	              params.add(new BasicNameValuePair("username", username1));
	              params.add(new BasicNameValuePair("percentage", matmarks));
	              params.add(new BasicNameValuePair("levelofeducation", level));
	              params.add(new BasicNameValuePair("interest", interest1));
	              params.add(new BasicNameValuePair("suggestion1", suggestion1));
	              params.add(new BasicNameValuePair("suggestion2", suggestion2));
	              params.add(new BasicNameValuePair("suggestion3", suggestion3));
	              System.out.println("here");
	              

	              Log.d("request!", "starting");
	              // getting product details by making HTTP request
	              JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST", params);
	              
	              
	              
	              if(json==null){
	           	   Log.d("Login Failure!", json.getString(TAG_MESSAGE));
	           	   return json.getString(TAG_MESSAGE);
	              }
	              // check your log for json response
	              Log.d("Login attempt", json.toString());
	             
	              // json success tag
	              success = json.getInt(TAG_SUCCESS);
	              if (success == 1) {
	              	Log.d("Interest added succesfully!", json.toString());
	              
	              	
	              	if(but=="submit")
	              	{
	              	Intent i = new Intent(marks.this, Question.class);
	              	i.putExtra("username", username1);
	              	
	              	startActivity(i);
	              	}
	              	
	              	else 
	              	{ 
	              		System.out.println("chumiii");
	              		Intent j = new Intent(marks.this, marks.class);
	              		
	              		j.putExtra("username", username1);
		               startActivity(j);
		              
	              	}
	            	
	              	return json.getString(TAG_MESSAGE);
	              }else{
	              	Log.d("Failed!", json.getString(TAG_MESSAGE));
	              	
	              
	              	Intent k = new Intent(marks.this, marks.class);
	              	
	              	finish();
	              	startActivity(k);
	              	return json.getString(TAG_MESSAGE);

	              }
	          } catch (JSONException e) {
	              e.printStackTrace();
	          }

	          
	          
	          return null;
	       

		}
		
		
		protected String matinfo ( )
		{
			 int success;
	          String username1 = username;
	          System.out.println("hahahaha");  
	         
	          
	          try {
	        	  
	              // Building Parameters
	              List<NameValuePair> params1 = new ArrayList<NameValuePair>();
	              
	              Iterator<Map.Entry<String, String>> it = matric.entrySet().iterator();
	              while (it.hasNext()) {
	            	  Map.Entry<String, String> pair = it.next();
	                  System.out.println("marks"+(String) pair.getValue());
	                  params1.add(new BasicNameValuePair("username", username1));
	                  System.out.println("mehran");
	                  params1.add(new BasicNameValuePair("subject", (String) pair.getKey()));
	                  params1.add(new BasicNameValuePair("marks", (String) pair.getValue()));
	                  params1.add(new BasicNameValuePair("Level", "10th level"));
	                  JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL1, "POST", params1);
	                  if(json==null){
	   	           	   Log.d("Login Failure!", json.getString(TAG_MESSAGE));
	   	           	   return json.getString(TAG_MESSAGE);
	   	              }
	   	              // check your log for json response
	   	              Log.d("Login attempt", json.toString());
	   	             
	   	              // json success tag
	   	              success = json.getInt(TAG_SUCCESS);
	   	              if (success == 1) {
	   	              	Log.d("Interest added succesfully!", json.toString());
	   	              
	   	             if(but=="submit")
		              	{
		              	Intent i = new Intent(marks.this, Question.class);
		              	i.putExtra("username", username1);
		              	
		              	startActivity(i);
		              	}
		              	
		              	else 
		              	{ 
		              		System.out.println("chumiii");
		              		Intent j = new Intent(marks.this, marks.class);
		              		
		              		j.putExtra("username", username1);
			               startActivity(j);
			              
		              	}
	   	            	
	   	              	return json.getString(TAG_MESSAGE);
	   	              }else{
	   	              	Log.d("Failed!", json.getString(TAG_MESSAGE));
	   	              	
	   	              	Intent i = new Intent(marks.this, marks.class);
	   	              	
	   	              	finish();
	   	              	startActivity(i);
	   	              	return json.getString(TAG_MESSAGE);
	              }
	              
	              }
	          } catch (JSONException e) {
	              e.printStackTrace();
	          }

	          
	          
	          return null;
	       

		}
		
		
		
		/**
       * After completing background task Dismiss the progress dialog
       * **/
     /* protected void onPostExecute(String file_url) {
          // dismiss the dialog once product deleted
          pDialog.dismiss();
          if (file_url != null){
          	Toast.makeText(ApptitudeTest.this, file_url, Toast.LENGTH_LONG).show();
          }

      }*/

	}
}
	
	
	
	
	
	
	        
	
	
	
	

