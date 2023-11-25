package org.example.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
//Repeatable annotation should contain annotation class which contains array of annotation which should be repeatable
//java compiler creates this container when you using your repeatable annotation to hold all annotations
@Repeatable(ExceptionTestRepeatable.MyContainer.class)
public @interface ExceptionTestRepeatable {

    Class<? extends Throwable> value();

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface MyContainer {
        ExceptionTestRepeatable[] value();
    }
}
