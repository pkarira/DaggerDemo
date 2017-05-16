package com.elanic.pulkit.samplelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements ViewInterface {
    private EditText name;
    private EditText password;
    private Button login;
    @Inject Presentor presentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);
        name = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);
        login = (Button) findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presentor.setNameAndPassword(name.getText().toString(), password.getText().toString());
            }
        });
    }

    @Override
    public void setError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nameError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void verified() {
        Toast.makeText(getApplicationContext(), "Congratulations", Toast.LENGTH_SHORT).show();
    }
}
