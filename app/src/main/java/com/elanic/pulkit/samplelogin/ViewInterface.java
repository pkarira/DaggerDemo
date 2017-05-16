package com.elanic.pulkit.samplelogin;

/**
 * Created by pulkit on 15/5/17.
 */

public interface ViewInterface {
    void setError(String error);
    void nameError(String Error);
    void passwordError(String Error);
    void verified();
}
