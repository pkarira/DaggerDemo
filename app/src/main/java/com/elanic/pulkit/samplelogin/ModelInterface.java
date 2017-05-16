package com.elanic.pulkit.samplelogin;

/**
 * Created by pulkit on 15/5/17.
 */

public interface ModelInterface {

    void checkNameAndPassword(String name , String passsword);
    interface ModelPresentorInterface {
        void verifiedResult(String result);
    }
}
