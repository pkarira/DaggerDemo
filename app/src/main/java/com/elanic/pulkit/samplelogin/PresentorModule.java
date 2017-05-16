package com.elanic.pulkit.samplelogin;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pulkit on 16/5/17.
 */
@Module
public class PresentorModule {
    ModelInterface.ModelPresentorInterface mPresentor;

    PresentorModule(ModelInterface.ModelPresentorInterface presentor) {
        mPresentor = presentor;
    }

    @Provides
    public ModelInterface createModelObject() {
        return new ModelImplementor(mPresentor);
    }
}
