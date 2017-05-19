package com.elanic.pulkit.samplelogin;

import rx.Observable;

/**
 * Created by pulkit on 15/5/17.
 */

public class ModelImplementor implements ModelInterface {

    @Override
    public Observable<String> checkNameAndPassword(String name, String passsword) {
        if(name.equals(passsword))
        {
             return Observable.just("Correct");
        }else
            return Observable.just("Incorrect");

    }
}
