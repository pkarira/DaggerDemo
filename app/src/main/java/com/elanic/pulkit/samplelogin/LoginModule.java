package com.elanic.pulkit.samplelogin;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pulkit on 15/5/17.
 */
@Module
public class LoginModule {
    private ViewInterface mViewInterface;

    LoginModule(ViewInterface viewInterface) {
        mViewInterface = viewInterface;
    }

    @Provides
    public Presentor createPresentor() {
        return new PresentorImplementor(mViewInterface);
    }
}
