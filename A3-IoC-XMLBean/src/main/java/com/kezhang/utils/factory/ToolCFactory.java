package com.kezhang.utils.factory;

import com.kezhang.utils.ToolC;
import org.springframework.beans.factory.FactoryBean;

public class ToolCFactory implements FactoryBean<ToolC> {
    // 由于getObject方法无法传递参数，所以无法使用普通的有参工厂方法
    // 改用构造器传参的方式
    private final String host;
    private final Integer port;
    public ToolCFactory(String host, Integer port) {
        this.host = host;
        this.port = port;
    }


    @Override
    public ToolC getObject() throws Exception {
        return new ToolC(host, port);
    }

    @Override
    public Class<?> getObjectType() {
        return ToolC.class;
    }

    @Override
    public boolean isSingleton() {
        return true; // 返回true表示该工厂方法创建的对象是单例的
    }
}
