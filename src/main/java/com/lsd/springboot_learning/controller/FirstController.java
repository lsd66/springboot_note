package com.lsd.springboot_learning.controller;

import com.lsd.springboot_learning.config.ThirdWeatherConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;


@RestController
// 代表这是一个Controller 并且以json的形式进行返回
public class FirstController {

//    @Value("${third.weather.url}")
//    private String weatherUrl;

//    @Resource
//    private Environment env;

      @Resource
      private ThirdWeatherConfig thirdWeatherConfig;

    @RequestMapping("/hello")
    public String HelloWorld(){
        // System.out.println("获取到的天气地址"+weatherUrl);
        // 使用env 对象获取配置文件中的值
//        String weatherUrl=env.getProperty("third.weather.url");
//        System.out.println("获取到的天气地址:"+weatherUrl);

        //使用封装好的对象获取内容
        String weatherUrl=thirdWeatherConfig.getUrl();
        System.out.println("获取到的天气地址为："+weatherUrl);
        System.out.println("获取到的天气城市为："+thirdWeatherConfig.getCities());
        System.out.println("获取到的天气城市为："+thirdWeatherConfig.getList());
        return "hello world";
    }
}
