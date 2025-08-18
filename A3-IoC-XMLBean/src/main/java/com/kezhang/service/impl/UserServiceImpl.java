package com.kezhang.service.impl;

import com.kezhang.dao.OrderDAO;
import com.kezhang.dao.UserDAO;
import com.kezhang.service.UserService;
import com.kezhang.utils.ToolA;
import com.kezhang.utils.ToolB;
import com.kezhang.utils.ToolC;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UserServiceImpl implements UserService, InitializingBean, DisposableBean {
    // 无参构造器，在XML中，默认采用无参构造器创建对象
    // 承担了实例化的职责
    public UserServiceImpl(){
        System.out.println("UserServiceImpl: UserServiceImpl instance created.");
    }
    // 模拟注入UserDAO,这里采用Setter注入方式
    // 注意：在实际项目中，建议使用构造器注入方式，这里为了演示不同的注入方式，使用了Setter注入。
    // 承担了依赖注入的职责
    private UserDAO userDAO;
    private ToolA toolA;
    private ToolB toolB;
    private ToolC toolC;
    private OrderDAO orderDAO;
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
        System.out.println("UserServiceImpl: UserDAO injected successfully.");
    }
    public void setOrderDAO(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
        System.out.println("UserServiceImpl: OrderDAO injected successfully.");
    }
    public void setToolA(ToolA toolA){
        this.toolA = toolA;
        System.out.println("UserServiceImpl: ToolA injected successfully.");
    }
    public void setToolB(ToolB toolB){
        this.toolB = toolB;
        System.out.println("UserServiceImpl: ToolB injected successfully.");
    }
    public void setToolC(ToolC toolC){
        this.toolC = toolC;
        System.out.println("UserServiceImpl: ToolC injected successfully.");
    }

    public void initUserServiceImpl(){
        System.out.println("UserServiceImpl: init method called.");
    }
    public void destroyUserServiceImpl(){
        System.out.println("UserServiceImpl: destroy method called.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("UserServiceImpl: destroy method called from DisposableBean.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserServiceImpl: afterPropertiesSet method called from InitializingBean.");
    }

    @Override
    public void saveUser() {
        userDAO.insertUser();
        orderDAO.insertOrder();
        toolA.toolA();
        toolB.toolB();
        toolC.toolC();
        // 模拟保存用户
        System.out.println("UserServiceImpl: User saved successfully.");
    }
}
