package com.springMVCRequestResponse.controller;

import com.springMVCRequestResponse.pojo.QueryDTO;
import com.springMVCRequestResponse.pojo.QueryParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {
    // 1. 演示@RequestParam
     // 1.1 基本使用
    @GetMapping("/param1")
    public String hello(@RequestParam("msg") String message){
        System.out.println("message = " + message);
        return "hello";
    }
     // 1.2 常用属性,value,required,defaultValue
    @GetMapping("/param2")
    public String hello2(
            // 给了defaultValue之后，required属性可以省略,为false
            @RequestParam(value = "username", defaultValue = "guest") String username,
            @RequestParam(value = "alias",required = false) String alias,
            @RequestParam(value = "password" , required = true) String password){
        System.out.println("Username = " + username + ", alias = " + alias + ", password = " + password);
        return "hello";
    }
    // 1.3 省略@RequestParam，POJO类
    @GetMapping("/param3")
    public String hello3(QueryParam queryParam){
        System.out.println(queryParam);
        return "hello";
    }
     // 1.4 数组/集合
    @GetMapping("/param4")
    public String hello4(@RequestParam("ids") List<Long> ids){
        ids.forEach(System.out::print);
        System.out.println();
        return "hello";
    }
     // 1.5 Map
    @GetMapping("/param5")
    public String hello5(@RequestParam Map<String,String> skills){
        skills.forEach((k,v) -> System.out.println(k + " : " + v));
        return "hello";
    }

    // 2. 演示@PathVariable
    @GetMapping("/param6/{id}")
    public String hello6(@PathVariable("id") Long id){
        System.out.println("id = " + id);
        return "hello";
    }

    // 3. 演示@RequestBody
    @GetMapping("/param7")
    public String hello7(@RequestBody QueryDTO queryDTO){
        System.out.println(queryDTO);
        return "hello";
    }

    // 4. 演示文件上传
    @PostMapping("/upload")
    public String hello8(@RequestPart("file") MultipartFile file) {
        // 1. 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null){
            System.out.println("File name could not be null");
            return null;
        }
        // 2. 获取文件大小
        long size = file.getSize();
        // 3. 保存文件
        File dest = new File("/Users/zhangke/Documents/Programming/Spring-Learning/D2-SpringMVC-RequestResponse/upload");
        if (!dest.exists()){
            dest.mkdirs();
        }
        try {
            file.transferTo(new File(dest,originalFilename));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("File name: " + originalFilename + ", size: " + size + " bytes, saved to " + dest.getAbsolutePath());
        return "hello";
    }

    // 5. 演示获取请求头和Cookie
     // 5.1 获取指定请求头
    @GetMapping("/headers")
    // defaultValue属性通过设置默认值，可以避免请求头不存在时，报400错误
    public String header(@RequestHeader(value = "User-Agent" ,defaultValue = "N/A") String userAgent){
        System.out.println("User-Agent: " + userAgent);
        return "hello";
    }
     // 5.2 获取所有请求头
    @GetMapping("/headers/all")
    public String headers(@RequestHeader Map<String,String> headers){
        headers.forEach( (k,v) -> System.out.println(k + " : " + v) );
        return "hello";
    }
     // 5.3 获取指定Cookie
    @GetMapping("/cookie")
    public String cookie(@CookieValue(value = "JSESSIONID", defaultValue = "N/A") String jsessionId){
        System.out.println("JSESSIONID: " + jsessionId);
        return "hello";
    }
     // 5.4 获取所有Cookie
     // 直接使用HttpServletRequest对象
    @GetMapping("/cookie/all")
    public String cookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        return "hello";
    }

    // 6. 演示获取Request域和Session域中的数据
     // 6.1 获取Request域数据
    @GetMapping("/request")
    public String requestInfo(HttpServletRequest request){
        request.setAttribute("attr1","value1");
        request.setAttribute("attr2","value2");
        System.out.println("Request attributes set.");
        System.out.println("attr1: " + request.getAttribute("attr1"));
        System.out.println("attr2: " + request.getAttribute("attr2"));
        return "hello";
    }
     // 6.2 获取Session域数据
    @GetMapping("/session")
    public String sessionInfo(HttpSession session){
        session.setAttribute("sattr1","svalue1");
        session.setAttribute("sattr2","svalue2");
        System.out.println("Session attributes set.");
        System.out.println("sattr1: " + session.getAttribute("sattr1"));
        System.out.println("sattr2: " + session.getAttribute("sattr2"));
        return "hello";
    }

    // 7. 演示@ResponseBody
    @GetMapping("/response-body")
    @ResponseBody // 作用：将方法的返回值作为响应体返回给客户端，而不是解析为视图
    // @Controller + @ResponseBody = @RestController
    public QueryDTO responseBody() {
        QueryDTO queryDTO = new QueryDTO();
        queryDTO.setUsername("john_doe");
        queryDTO.setPassword("securepassword");
        return queryDTO;
    }
}
