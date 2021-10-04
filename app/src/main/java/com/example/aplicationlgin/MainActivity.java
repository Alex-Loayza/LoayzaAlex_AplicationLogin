package com.example.aplicationlgin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//We develop the login of our application
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //we create inputs for the login process
        Button btnLogin = findViewById(R.id.btnLogin);
        EditText txtUsername = findViewById(R.id.txtUsername);
        EditText txtPassword = findViewById(R.id.txtPassword);
        TextView lblLoginResult = findViewById(R.id.lblLoginResult);


        //An event listener is created that will contain the callback method that will be triggered by user interaction

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log log = null;
                if (txtPassword.getText().toString().equals("123")) {
                    log.i("test", "login ok");
                    lblLoginResult.setText("login ok");
                } else {
                    log.i("test", "login ko");
                    lblLoginResult.setText("login not ok");
                }
            }

        });

    }
}