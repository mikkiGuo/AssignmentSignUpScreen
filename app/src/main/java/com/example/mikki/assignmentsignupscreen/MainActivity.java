package com.example.mikki.assignmentsignupscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username_txt;
    EditText password_txt;
    EditText email_txt;
    EditText dob_txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username_txt = findViewById(R.id.usernameET);
        password_txt = findViewById(R.id.passwordET);
        email_txt = findViewById(R.id.emailET);
        dob_txt = findViewById(R.id.dobET);
        btn = findViewById(R.id.createBt);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean un = username_validate(username_txt.getText().toString());
                boolean pw = password_validate(password_txt.getText().toString());
                boolean email = email_validate(email_txt.getText().toString());
                boolean dob = dob_validate(dob_txt.getText().toString());

                if(!(un)){
                    Toast.makeText(MainActivity.this, "enter username length between [3,15], " +
                            "and compose only letters, numbers and ._-", Toast.LENGTH_LONG).show();
                }
                if(!pw){
                    Toast.makeText(MainActivity.this, "enter password with at least one lowercase, " +
                            "one uppercase, one digit, one special symbols and length between 8 to 20 characters", Toast.LENGTH_LONG).show();
                }
                if(!email){
                    Toast.makeText(MainActivity.this, "enter emails in a format as myexample@gmail.com", Toast.LENGTH_LONG).show();
                }
                if(!dob){
                    Toast.makeText(MainActivity.this, "date of birth has to be in format: month/day/years",Toast.LENGTH_LONG).show();
                }
                if(un&&pw&&email&&dob){
                    Toast.makeText(MainActivity.this,"Successfully Signed Up", Toast.LENGTH_LONG).show();
                }
            }
        });




    }
    private boolean username_validate(final String username){
        Pattern pattern;
        final String USERNAME_PATTERN = "^[A-Za-z0-9._-]{3,15}$";
        pattern = Pattern.compile(USERNAME_PATTERN);
        return pattern.matcher(username).matches();
    }
    private boolean password_validate(final String password){
        Pattern pattern;
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!.#$@_*+,?-]).{8,20})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        return pattern.matcher(password).matches();
    }

    private boolean email_validate(final String email){
        Pattern pattern;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+" +
                "(\\.[_A-Zaz0-9-]+)*@\"[A-Za-z0-9-]+" +
                "(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(email).matches();
    }

    private boolean dob_validate(final String dob){
        Pattern pattern;
        final String DOB_PATTERN = "^(0[1-9]|1[012])[/](0[1-9]|[12][0-9]|3[01])[/](19|20)[0-9]\\d$";
        pattern = Pattern.compile(DOB_PATTERN);
        return pattern.matcher(dob).matches();
    }



}
