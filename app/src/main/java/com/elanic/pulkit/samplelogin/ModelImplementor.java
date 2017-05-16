package com.elanic.pulkit.samplelogin;

/**
 * Created by pulkit on 15/5/17.
 */

public class ModelImplementor implements ModelInterface {
    private ModelPresentorInterface mModelPresentorInterface;

    ModelImplementor(ModelPresentorInterface modelPresentorInterface) {
        mModelPresentorInterface = modelPresentorInterface;
    }

    @Override
    public void checkNameAndPassword(String name, String passsword) {
        if(name.equals(passsword))
        {
            mModelPresentorInterface.verifiedResult("Correct");
        }else
            mModelPresentorInterface.verifiedResult("Incorrect");
    }
}
