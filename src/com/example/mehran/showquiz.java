package com.example.mehran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.content.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.mehran.AddQuestions.addquestion;
//import com.example.mehran.Question;


public class showquiz extends Activity {

	TextView question;
	RadioButton radioButton1,radioButton2,radioButton3;
	Button Next,Finish;
	Question mehran=new Question();
	List<String> list = new ArrayList<String>();
	
	//List<String> Questions = new ArrayList<String>();
	//List<String> Options = new ArrayList<String>();
	//List<String> Correct_ans = new ArrayList<String>();
	
	//Object ques= new Object();
	
	 private ProgressDialog pDialog;

	 
	    // JSON parser class
	    JSONParser jsonParser = new JSONParser();
	    //testing on Emulator:
	  

	  //testing from a real server:
	    //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/login.php";

	    //JSON element ids from repsonse of php script:
	   
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_questions);
	        
	        question=(TextView) findViewById(R.id.question);
	        radioButton1=(RadioButton) findViewById(R.id.radioButton1);
	        radioButton2=(RadioButton) findViewById(R.id.radioButton2);
	        radioButton3=(RadioButton) findViewById(R.id.radioButton3);
	        Next=(Button) findViewById(R.id.Next);
	        Finish=(Button) findViewById(R.id.Finish);
	            
	        
	      new question().execute();
	     
	        Next.setOnClickListener(new OnClickListener(){
	        	
	        	
	        	 @Override
	        	    public void onClick(View v){

	        	        switch (v.getId()){
                      	        	        
	        	            case R.id.Next:
	        	            	
	        	                break;

	        	        }
	        	    }
	        });
	        
	        Finish.setOnClickListener(new OnClickListener(){
	        	
	        	
	        	 @Override
	        	    public void onClick(View v){

	        	        switch (v.getId()){
                      	        	        
	        	            case R.id.Finish:
	        	            	
	        	                break;

	        	        }
	        	    }
	        });
	        
	        
	       }
	    

	    class question extends AsyncTask<String, String, String> {

			@Override
			protected String doInBackground(String... args) {
				/* Building Parameters */
				question.setText("sdf");		
			
				
						  if(mehran.getQuestions().size()<1){
								System.out.println("Question size was less than 1, calling sync resulted in "+mehran.syncQuestionData());
							}
					
			
						//Body of your click handler
						  Thread thread = new Thread(new Runnable(){
						    @Override
						    public void run(){
						    	list = mehran.getQuestions();
								
								
								int size = list.size();
			System.out.println("dfghncm "+ size);	
			
						    }
						  });
						  thread.start();		
				
				
		question.setText("asdfghsadfghjkdsfgh");
				/*Iterator it= list.iterator();
				 while(it.hasNext()){
              	
                 	Object ques=it.next();
                 	System.out.println("Questions is: "+ques);
                 	
                 }
				
                 
                 Iterator<String> it2= mehran.Options.iterator();
                 while(it2.hasNext()){
                 	Object opt1= it2.next();
                 	Object opt2= it2.next();
                 	Object opt3= it2.next();
                 	System.out.println("option 1 is: "+opt1);
                 	//radioButton1.setText((CharSequence) opt1);
                 	System.out.println("option 2 is: "+opt2);
                 	//radioButton2.setText((CharSequence) opt2);
                 	System.out.println("option 3 is: "+opt3);
                 	//radioButton3.setText((CharSequence) opt3);
                 }
                 
                 Iterator<String> it3= mehran.Correct_ans.iterator();
                 while(it3.hasNext()){
                 	System.out.println("Correct_ans is: "+it3.next());
                 }*/
	                        
	                        
	                
	             
	            return null;
	        }

	       
	        
	       
	
			}	    	
	    	
	    
}

