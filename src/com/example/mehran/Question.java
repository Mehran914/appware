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
import com.example.mehran.showquiz;



public class Question extends Activity {

	 
	//String question[]= new String[1000];
	List<String> QuestionArrayList = new ArrayList<String>();
	List<String> Options = new ArrayList<String>();
	List<String> Correct_ans = new ArrayList<String>();
	String hello = "hello world";
	
	public List<String> getQuestions() {
	       return QuestionArrayList;
	   }
	protected boolean syncQuestionData(){
		
        /* getting JSON string from URL */
		JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST", new ArrayList<NameValuePair>());
		try {
			JSONArray JAStuff = json.getJSONArray(TAG_Questions);
                
                    for (int i = 0; i < JAStuff.length(); i++) {
                        JSONObject JOStuff = JAStuff.getJSONObject(i);
                        
                        QuestionArrayList.add(JOStuff.getString("question"));
                        Options.add(JOStuff.getString("option1"));
                        Options.add(JOStuff.getString("option2"));
                        Options.add(JOStuff.getString("option3"));
                        Correct_ans.add(JOStuff.getString("correct_answer"));
                }
            if(QuestionArrayList.size()<1){
            	return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

	}

	
	
	//Object ques= new Object();
	
	 private ProgressDialog pDialog;

	    // JSON parser class
	    JSONParser jsonParser = new JSONParser();
	    //testing on Emulator:
	    private static final String LOGIN_URL = "http://10.99.27.15/retrievequestions.php";

	  //testing from a real server:
	    //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/login.php";

	    //JSON element ids from repsonse of php script:
	    private static final String TAG_SUCCESS = "success";
	    private static final String TAG_MESSAGE = "message";
	    private static final String TAG_Questions= "questiontab";
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	        new question().execute();
	    }
	    
	    class question extends AsyncTask<String, String, String> {

			@Override
			protected String doInBackground(String... args) {
				/* Building Parameters */
		//		List<NameValuePair> params1 = new ArrayList<NameValuePair>();

	            /* getting JSON string from URL */
	//		 JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST", params1);
				
	      //      try {
	                /* Checking for SUCCESS TAG */
	             
				//syncQuestionData();
	                
	              
	        //           JSONArray JAStuff = json.getJSONArray(TAG_Questions);
	                  
	                    /** CHECK THE NUMBER OF RECORDS **/
	          //         int intStuff = JAStuff.length();
	                 
	                    
	            //            for (int i = 0; i < JAStuff.length(); i++) {
	              //              JSONObject JOStuff = JAStuff.getJSONObject(i);
	                            
	                //            QuestionArrayList.add(JOStuff.getString("question"));
	                  //          Options.add(JOStuff.getString("option1"));
	                    //        Options.add(JOStuff.getString("option2"));
	                      //      Options.add(JOStuff.getString("option3"));
	                        //    Correct_ans.add(JOStuff.getString("correct_answer"));
	                            
	                    //}
	                        
	        				
	                        Intent i = new Intent(Question.this, showquiz.class);
	                       	//i.putExtra("username", username);
	                       	finish();
	                       	startActivity(i);
	                        
	                
	            //} catch (Exception e) {
	              //  e.printStackTrace();
	            //}
	            return null;
	        }
			protected void onPostExecute(String aVoid) {
	            super.onPostExecute(aVoid);
	        }
	        
	       
	
			}	    	
	    	
	    
	    }