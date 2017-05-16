package com.elanic.pulkit.samplelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

public class LoginActivity extends AppCompatActivity implements ViewInterface {
    private EditText name;
    private EditText password;
    private Button login;
    @Inject
    Presentor presentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);
        name = (EditText) findViewById(R.id.editText1);
        name.setCursorVisible(true);
        password = (EditText) findViewById(R.id.editText2);
        login = (Button) findViewById(R.id.button);
        login.setVisibility(View.INVISIBLE);
        Observable<CharSequence> observable = RxTextView.textChanges(name);
        observable.map(new Func1<CharSequence, String>() {
            @Override
            public String call(CharSequence charSequence) {
                return charSequence.toString();
            }
        }).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                if(s.length()<=6&&s.length()>0)
                    name.setError("Enter More Letters");
                return s.length() > 6;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                name.setCursorVisible(false);
                password.setCursorVisible(true);
                Observable<CharSequence> observable = RxTextView.textChanges(password);
                observable.map(new Func1<CharSequence, String>() {
                    @Override
                    public String call(CharSequence charSequence) {
                        return charSequence.toString();
                    }
                }).filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        if(s.length()<=6&&s.length()>0)
                            password.setError("Enter More Letters");
                        return s.length() > 6;
                    }
                }).subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        login.setVisibility(View.VISIBLE);
                        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
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
