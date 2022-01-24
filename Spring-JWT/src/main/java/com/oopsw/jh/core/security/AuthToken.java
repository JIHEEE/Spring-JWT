package com.oopsw.jh.core.security;

public interface AuthToken<T> {
    boolean validate();
    T getData();
}