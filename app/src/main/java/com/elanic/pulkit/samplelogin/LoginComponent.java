package com.elanic.pulkit.samplelogin;

import javax.inject.Scope;

import dagger.Component;

/**
 * Created by pulkit on 15/5/17.
 */

@Component(
        modules = {LoginModule.class}
)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
