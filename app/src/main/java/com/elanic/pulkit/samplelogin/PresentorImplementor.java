package com.elanic.pulkit.samplelogin;

import android.util.Log;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by pulkit on 15/5/17.
 */

public class PresentorImplementor implements Presentor {

    private String mName;
    private String mPassword;
    private ViewInterface viewInterface;
    ModelInterface modelInterface;

    PresentorImplementor(ViewInterface view,ModelInterface model) {
        viewInterface = view;
        modelInterface=model;
    }

    @Override
    public void setNameAndPassword(String name, String password) {
        mName = name;
        mPassword = password;
        if (mName.equals("")) {
            viewInterface.nameError("Please Enter Name");
        } else if (mPassword.equals("")) {
            viewInterface.passwordError("Please Enter Password");
        } else
            modelInterface.checkNameAndPassword(mName, mPassword).subscribe(new Action1<String>() {
                @Override
                public void call(String s) {
                    if(s.equals("correct"))
                    viewInterface.verified();
                    else
                        viewInterface.setError(s);
                }
            });
    }
}