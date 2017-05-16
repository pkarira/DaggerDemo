package com.elanic.pulkit.samplelogin;

import dagger.Component;

/**
 * Created by pulkit on 16/5/17.
 */
@Component(modules = {PresentorModule.class})
public interface PresentorComponent {
    void inject(Presentor presentor);
}
