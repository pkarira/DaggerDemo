package com.elanic.pulkit.samplelogin;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by pulkit on 15/5/17.
 */

public class PresentorImplementor implements Presentor, ModelInterface.ModelPresentorInterface {

    private String mName;
    private String mPassword;
    private ViewInterface viewInterface;
    @Inject
    ModelInterface modelInterface;

    PresentorImplementor(ViewInterface view) {
        viewInterface = view;
        DaggerPresentorComponent.builder().presentorModule(new PresentorModule(this)).build().inject(this);
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
            modelInterface.checkNameAndPassword(mName, mPassword);
    }

    @Override
    public void verifiedResult(String result) {
        if (result.equals("Correct"))
            viewInterface.verified();
        else
            viewInterface.setError(result);
    }
}