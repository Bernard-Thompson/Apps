package com.products.moonlight.pathbyfriends;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseUser;


public class UserLogin extends Activity {

    protected EditText mUsername;
    protected EditText mPassword;
    protected Button mLogin;
    protected Button mCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "oQFaYciS8ABD2EIl2NyyE336A1NOZTCx1FqH1jFW", "LujQt7W6zPPSXHQaLvG5S7OKJsSc9tiizPyqZGRj");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        //initialize
        mUsername = (EditText)findViewById(R.id.UserEmail);
        mPassword = (EditText)findViewById(R.id.UserPassword);
        mLogin = (Button)findViewById(R.id.LoginButton);
        mCreate = (Button)findViewById(R.id.SignUpButton);

        //Listen to when the mLoginbtn get clicked
        mLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //get the user input's and convert into a string
                final String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                //login the user through parse
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, com.parse.ParseException e) {
                        if (e == null) {
                            // Nice! The user is logged in.
                            Toast.makeText(UserLogin.this, "welcome" + username + "!", Toast.LENGTH_LONG).show();
                            // Take user to the home page
                            Intent pullUpCalendarIntent = new Intent(UserLogin.this, HomeCalendarActivity.class);
                            startActivity(pullUpCalendarIntent);
                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                            AlertDialog.Builder builder = new AlertDialog.Builder(UserLogin.this);
                            builder.setMessage(e.getMessage());
                            builder.setTitle("Sorry!");
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //close the Dialog
                                    dialogInterface.dismiss();
                                }

                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    }
                });
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_login, menu);
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
    } /*
    public void goToCalendarClick(View view) {
        Intent pullUpCalendarIntent = new Intent(this, HomeCalendarActivity.class);
               startActivity(pullUpCalendarIntent);
    } */

    public void goToSignInClick(View view) {
        Intent openSignInPageIntent = new Intent(this, UserSignUpActivity.class);
             startActivity(openSignInPageIntent);
    }

}
