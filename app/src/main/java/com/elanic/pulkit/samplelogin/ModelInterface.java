package com.elanic.pulkit.samplelogin;

import rx.Observable;

/**
 * Created by pulkit on 15/5/17.
 */

public interface ModelInterface {

    Observable<String> checkNameAndPassword(String name , String passsword);
    interface ModelPresentorInterface {
        void verifiedResult(String result);
    }
}
