package com.products.moonlight.pathbyfriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class UserSignUpActivity extends Activity {
    protected EditText mUsername;
    protected EditText mEmail;
    protected EditText mPassword;
    protected Button mReadyup;
    protected Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "oQFaYciS8ABD2EIl2NyyE336A1NOZTCx1FqH1jFW", "LujQt7W6zPPSXHQaLvG5S7OKJsSc9tiizPyqZGRj");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);

        //Initialize
        mUsername = (EditText)findViewById(R.id.UserSignUp);
        mEmail = (EditText)findViewById(R.id.UserEmail);
        mPassword = (EditText)findViewById(R.id.UserPassword);
        mReadyup = (Button)findViewById(R.id.RegisterButton);
        mLogin = (Button)findViewById(R.id.ToLogin);

        //listen to "register = Ready up" button click
        mReadyup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                //Get the username, email, password and convert to string
                final String username = mUsername.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();



                //Store user in Parse
                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            //user sign up success
                            Toast.makeText(UserSignUpActivity.this, "Welcome" + username, Toast.LENGTH_LONG).show();
                            //Intent to next page
                            Intent pullUpCalendarIntent = new Intent(UserSignUpActivity.this, HomeCalendarActivity.class);
                            startActivity(pullUpCalendarIntent);
                        }else {
                            // there was a sign up error
                        }
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_sgn_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToCalendarClick(View view){
        Intent pullUpCalendarIntent = new Intent(this, HomeCalendarActivity.class);
              startActivity(pullUpCalendarIntent);
    }

    public void goToLoginClick(View view){
        Intent openLoginIntent = new Intent(this, UserSignUpActivity.class);
        startActivity(openLoginIntent);
    }
}
