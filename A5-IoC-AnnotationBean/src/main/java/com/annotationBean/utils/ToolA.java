package com.annotationBean.utils;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("toolA")
@Lazy(true)
public class ToolA implements Tool {
    @Override
    public void tool() {
        System.out.println("ToolA: tool method called");
    }
}
