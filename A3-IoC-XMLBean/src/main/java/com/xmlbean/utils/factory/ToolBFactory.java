package com.xmlbean.utils.factory;

import com.xmlbean.utils.ToolB;

public class ToolBFactory {
    // 无参工厂方法
    public ToolB createToolB() {
        System.out.println("ToolBFactory: createToolB method called.");
        return new ToolB();
    }
    // 有参工厂方法
    public ToolB createToolBWithArgs(String type, Integer level) {
        System.out.println("ToolBFactory: createToolBWithArgs method called.");
        return new ToolB(type, level);
    }
}
