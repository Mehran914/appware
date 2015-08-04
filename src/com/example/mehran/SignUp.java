package com.example.mehran;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.mehran.login.AttemptLogin;

import android.content.*;
import android.app.*;
import android.os.*;
import android.util.Log;
import android.view.*;
import android.widget.*;


public class SignUp extends Activity implements View.OnClickListener{

    EditText etFirstName, etLastName, etEmail, etAddress, etPhoneNumber,etUsername,etPassword;
    RadioButton radio1,radio2;
    Button tvSignUp;
    TextView SignIn,help;
    String role;
    private ProgressDialog pDialog;

    // JSON parser class
    JSONParser jsonParser = new JSONParser();
    //testing on Emulator:
    private static final String LOGIN_URL = "http://10.99.23.73/signup.php";

  //testing from a real server:
    //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/login.php";

    //JSON element ids from repsonse of php script:
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etFirstName= (EditText) findViewById(R.id.etFirstName);
        etLastName= (EditText) findViewById(R.id.etLastName);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etPhoneNumber= (EditText) findViewById(R.id.etPhoneNumber);
        etUsername= (EditText) findViewById(R.id.etUsername);
        etPassword= (EditText) findViewById(R.id.etPassword);
        etAddress= (EditText) findViewById(R.id.etAddress);
        tvSignUp= (Button) findViewById(R.id.tvSignUp);
        radio1= (RadioButton) findViewById(R.id.radioButton1);
        radio2= (RadioButton) findViewById(R.id.radioButton2);
        SignIn= (TextView) findViewById(R.id.SignIn);
        help= (TextView) findViewById(R.id.help);
        
        
        
        
        tvSignUp.setOnClickListener(this);
        SignIn.setOnClickListener(this);
        etFirstName.setOnClickListener(this);
        etLastName.setOnClickListener(this);
        etEmail.setOnClickListener(this);
        etAddress.setOnClickListener(this);
        etPhoneNumber.setOnClickListener(this);
        etUsername.setOnClickListener(this);
        etPassword.setOnClickListener(this);
    }

    public void onRadioButtonClicked(View v){
        boolean checked = ((RadioButton) v).isChecked();
        
        // Check which radio button was clicked
        switch(radio1.getId()) {
            case R.id.radioButton1:
                if (checked)
                   role="admin"; 
                break;
            case R.id.radioButton2:
                if (checked)
                    role="user";
                break;
                
            
                
            
        }
        }
    
    
    @Override
    public void onClick(View v){

        switch (v.getId()){
            case R.id.tvSignUp:
            	new AttemptSignup().execute();
                break;
            case R.id.SignIn:
                startActivity(new Intent(this, login.class));
                break;
                
            case R.id.etFirstName:
            	etFirstName.setText("");
                break;
            case R.id.etLastName:
            	etLastName.setText("");
                break;

            case R.id.etEmail:
            	etEmail.setText("");
                break;
            case R.id.etAddress:
            	etAddress.setText("");
                break;
            case R.id.etPhoneNumber:
            	etPhoneNumber.setText("");
                break;
            case R.id.etUsername:
            	etUsername.setText("");
                break;
            case R.id.etPassword:
            	etPassword.setText("");
                break;
                
        }
    }

    class AttemptSignup extends AsyncTask<String, String, String> {

		 /**
       * Before starting background thread Show Progress Dialog
       * */
		boolean failure = false;

      @Override
      protected void onPreExecute() {
          super.onPreExecute();
          pDialog = new ProgressDialog(SignUp.this);
          pDialog.setMessage("Attempting for SignUp...");
          pDialog.setIndeterminate(false);
          pDialog.setCancelable(true);
          pDialog.show();
      }

		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			 // Check for success tag
          int success;
          String username = etUsername.getText().toString();
          String password = etPassword.getText().toString();
          String firstname = etFirstName.getText().toString();
          String lastname = etLastName.getText().toString();
          String email = etEmail.getText().toString();
          String phoneno = etPhoneNumber.getText().toString();
          String interest = "anam";
          String score = "123";
          String suggestion = "anam";
          String suggestion1 = "anam";
          
          
          try {
              // Building Parameters
              List<NameValuePair> params = new ArrayList<NameValuePair>();
              params.add(new BasicNameValuePair("username", username));
              params.add(new BasicNameValuePair("password", password));
              params.add(new BasicNameValuePair("firstname",firstname));
              params.add(new BasicNameValuePair("lastname",lastname));
              params.add(new BasicNameValuePair("email",email));
              params.add(new BasicNameValuePair("phoneno",phoneno));
              params.add(new BasicNameValuePair("role",role));
              params.add(new BasicNameValuePair("score",score));
              params.add(new BasicNameValuePair("interest",interest));
              params.add(new BasicNameValuePair("suggestion",suggestion));
              params.add(new BasicNameValuePair("suggestion1",suggestion1));
              
              Log.d("request!", "starting");
              // getting product details by making HTTP request
              JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST", params);
              if(json==null){
           	   Log.d("regustered Failure!", json.getString(TAG_MESSAGE));
           	   return json.getString(TAG_MESSAGE);
              }
              // check your log for json response
              Log.d("register attempt", json.toString());

              // json success tag
              success = json.getInt(TAG_SUCCESS);
              if (success == 1) {
              	Log.d("Registerted Successful!", json.toString());
              	Intent i = new Intent(SignUp.this, login.class);
              	finish();
              	startActivity(i);
             
              	return json.getString(TAG_MESSAGE);
              }else{
              	Log.d("Registered Failure!", json.getString(TAG_MESSAGE));
              	
              	Intent i = new Intent(SignUp.this, SignUp.class);
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

	}


    
}
