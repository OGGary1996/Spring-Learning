package com.annotationBean.utils;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("toolB")
@Lazy(true)
public class ToolB implements Tool {
    @Override
    public void tool() {
        System.out.println("ToolB: tool method called");
    }
}
