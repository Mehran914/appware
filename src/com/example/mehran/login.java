package com.example.mehran;

import android.content.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends Activity implements View.OnClickListener {

    Button bLogin;
    EditText etUsername,etPassword;
    TextView newUser,help;
    // Progress Dialog
    private ProgressDialog pDialog;

    // JSON parser class
    JSONParser jsonParser = new JSONParser();
    //testing on Emulator:
    private static final String LOGIN_URL = "http://10.99.23.73/login.php";

  //testing from a real server:
    //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/login.php";

    //JSON element ids from repsonse of php script:
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    private static final String TAG_ROLE= "role";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        etUsername=(EditText) findViewById(R.id.etUsername);
        etPassword=(EditText) findViewById(R.id.etPassword);
        bLogin= (Button) findViewById(R.id.bLogin);
        help=(TextView) findViewById(R.id.help);
        newUser=(TextView) findViewById(R.id.newUser);

        etUsername.setOnClickListener(this);
        etPassword.setOnClickListener(this);
        bLogin.setOnClickListener(this);
        newUser.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){

        switch (v.getId()){
            case R.id.bLogin:
            	new AttemptLogin().execute();
            	
                break;

            case R.id.newUser:
                startActivity(new Intent(this, SignUp.class));
                break;
                
           case R.id.etUsername:
        	   etUsername.setText("");
                	
                    break;

            case R.id.etPassword:
            	etPassword.setText("");
                    break;
           

        }
    }


    class AttemptLogin extends AsyncTask<String, String, String> {

		 /**
        * Before starting background thread Show Progress Dialog
        * */
		boolean failure = false;

       @Override
       protected void onPreExecute() {
           super.onPreExecute();
           pDialog = new ProgressDialog(login.this);
           pDialog.setMessage("Attempting login...");
           pDialog.setIndeterminate(false);
           pDialog.setCancelable(true);
           pDialog.show();
       }

		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			 // Check for success tag
           int success;
           String role;
          
           String username = etUsername.getText().toString();
           String password = etPassword.getText().toString();
           try {
               // Building Parameters
               List<NameValuePair> params = new ArrayList<NameValuePair>();
               params.add(new BasicNameValuePair("username", username));
               params.add(new BasicNameValuePair("password", password));

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
           
                role=json.getString(TAG_ROLE);
               System.out.println(role);
                if (success == 1 ) {
            	   
               	Log.d("Login Successful!", json.toString());
                            
               	
               	if(role.equals("admin"))
               	{
               		
               	Intent i = new Intent(login.this, AddQuestions.class);
               	i.putExtra("username", username);
                   
                     startActivity(i);
               	}
               	else if(role.equals("user"))
               	{
               		System.out.println("in elseif ");
               		Intent i = new Intent(login.this, ApptitudeTest.class);
                   	i.putExtra("username", username);
                   	
                   	startActivity(i);
               	}
               	else
               	{
               		System.out.println("else");
               		Intent i = new Intent(login.this, login.class);
                   	i.putExtra("username", username);
                   	
                   	startActivity(i);
               	}
             	
               	return json.getString(TAG_MESSAGE);
               }else{
               	Log.d("Login Failure!", json.getString(TAG_MESSAGE));
               	
               	Intent i = new Intent(login.this, login.class);
               	
               	finish();
               	startActivity(i);
               	return json.getString(TAG_MESSAGE);

               }
           } catch (JSONException e) {
               e.printStackTrace();
           }

           return null;

		}
		/**
        * After completing background task Dismiss the progress dialog
        * **/
       protected void onPostExecute(String file_url) {
           // dismiss the dialog once product deleted
           pDialog.dismiss();
           if (file_url != null){
           	Toast.makeText(login.this, file_url, Toast.LENGTH_LONG).show();
           }

       }

	}

}