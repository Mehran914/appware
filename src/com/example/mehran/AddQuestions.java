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
import com.example.mehran.marks.EnterMarks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class AddQuestions extends Activity{
	
	EditText etQuestion,option1,option2,option3,correctAns;
	Button Add,submit;
	Spinner grade_options,complexity_options,category_options;
	String grade,complexity,category;
	public static String but;
	
	 private ProgressDialog pDialog;

	    // JSON parser class
	    JSONParser jsonParser = new JSONParser();
	    //testing on Emulator:
	    private static final String LOGIN_URL = "http://10.99.23.73/questions.php";

	  //testing from a real server:
	    //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/login.php";

	    //JSON element ids from repsonse of php script:
	    private static final String TAG_SUCCESS = "success";
	    private static final String TAG_MESSAGE = "message";
	    
	    
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_addquestion);

	        etQuestion= (EditText) findViewById(R.id.etQuestion);
	        option1= (EditText) findViewById(R.id.option1);
	        option2= (EditText) findViewById(R.id.option2);
	        option3= (EditText) findViewById(R.id.option3);
	        correctAns= (EditText) findViewById(R.id.correctAns);
	        Add = (Button) findViewById(R.id.Add);
	        submit= (Button) findViewById(R.id.submit);
	        
	        grade_options= (Spinner) findViewById(R.id.grade_options);
	        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.option_grade, android.R.layout.simple_spinner_item);
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        grade_options.setAdapter(adapter);
	        grade_options.setOnItemSelectedListener(new OnItemSelectedListener() {

	                @Override
	                public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
	                	grade = grade_options.getItemAtPosition(position).toString();
	                	 //Toast.makeText(grade_options.getContext(), "You selected: " + grade,Toast.LENGTH_LONG).show();
	                }

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub
						
					}
	            });
	        complexity_options= (Spinner) findViewById(R.id.complexity_options);
	        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.option_complexity, android.R.layout.simple_spinner_item);
	        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        complexity_options.setAdapter(adapter1);
	        complexity_options.setOnItemSelectedListener(new OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                	complexity = complexity_options.getItemAtPosition(position).toString();
                	// Toast.makeText(complexity_options.getContext(), "You selected: " + complexity,Toast.LENGTH_LONG).show();
                }

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO Auto-generated method stub
					
				}
            });
	        
	        
	        category_options= (Spinner) findViewById(R.id.category_options);
	        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.option_category, android.R.layout.simple_spinner_item);
	        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        category_options.setAdapter(adapter2);
	        category_options.setOnItemSelectedListener(new OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                	category = category_options.getItemAtPosition(position).toString();
                	 //Toast.makeText(category_options.getContext(), "You selected: " + category,Toast.LENGTH_LONG).show();
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
	        	            	new addquestion().execute();
	        	                break;

	        	        }
	        	    }
	        });
	        
	        submit.setOnClickListener(new OnClickListener(){
	        	
	        	
	        	 @Override
	        	    public void onClick(View v){

	        	        switch (v.getId()){
                      	        	        
	        	            case R.id.submit:
	        	            	but="submit";
	        	            	new addquestion().execute();
	        	                break;

	        	        }
	        	    }
	        });
	    }
	
	    class addquestion extends AsyncTask<String, String, String> { 
	    	
	    	@Override
			protected String doInBackground(String... args) {
	    	
				// TODO Auto-generated method stub
				 // Check for success tag
	    		int success;
		          
		          String question= etQuestion.getText().toString();
		          String optionno1= option1.getText().toString();
		          String optionno2= option2.getText().toString();;
		          String optionno3= option3.getText().toString();;
		          String correctans= correctAns.getText().toString();;
		         
		          
		          try {
		        	  
		              // Building Parameters
		              List<NameValuePair> params = new ArrayList<NameValuePair>();
		              params.add(new BasicNameValuePair("question", question));
		              params.add(new BasicNameValuePair("option1", optionno1));
		              params.add(new BasicNameValuePair("option2", optionno2));
		              params.add(new BasicNameValuePair("option3", optionno3));
		              params.add(new BasicNameValuePair("correctans", correctans));
		              params.add(new BasicNameValuePair("category", category));
		              params.add(new BasicNameValuePair("complexity", complexity));
		              params.add(new BasicNameValuePair("grade", grade));
		              
		          		

		              Log.d("request!", "starting");
		              // getting product details by making HTTP request
		              JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST", params);
		              
		              
		            System.out.println("chuumiii2");              
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
		              	System.out.println("chumiii");
		              	
		              	if(but=="submit")
		              	{
		              		
		              	Intent i = new Intent(AddQuestions.this, MainActivity.class);
		              	startActivity(i);
		              	}
		              	
		              	else 
		              	{ 
		              		
		              		Intent j = new Intent(AddQuestions.this, AddQuestions.class);
		              		startActivity(j);
			              
		              	}
		            	
		              	return json.getString(TAG_MESSAGE);
		              }else{
		              	Log.d("Failed!", json.getString(TAG_MESSAGE));
		              	
		              
		              	Intent k = new Intent(AddQuestions.this, AddQuestions.class);
		              	
		              	finish();
		              	startActivity(k);
		              	return json.getString(TAG_MESSAGE);

		              }
		          } catch (JSONException e) {
		              e.printStackTrace();
		          }

		          
		          
		          return null;
		       
		
			
			}
	    	
	    	
	    }

}
