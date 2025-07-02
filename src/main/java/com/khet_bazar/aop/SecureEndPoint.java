package com.khet_bazar.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecureEndPoint {
    String requiredHeader() default "namespace-id";

    String expectedValue() default "";
}
