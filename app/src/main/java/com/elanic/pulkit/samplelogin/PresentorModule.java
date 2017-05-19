package com.elanic.pulkit.samplelogin;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pulkit on 16/5/17.
 */
@Module
public class PresentorModule {
    @Provides
    public ModelInterface createModelObject() {
        return new ModelImplementor();
    }
}
