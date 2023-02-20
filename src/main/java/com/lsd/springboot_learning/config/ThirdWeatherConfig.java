package com.lsd.springboot_learning.config;
// 读取配置文件中的值
// 方式3: 将配置文件中的内容封装成一个JavaBean
// Config文件夹下创建一个类，用来接收配置文件中的这些内容

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// 这里没有指定配置文件的名称，因为默认读取application.yml的内容
// 如果配置内容不在application.yml中，那么需要在类中指定文件的位置：使用如下注解：
// @PropertySource("classpath:config/my.yml")
@Configuration
@ConfigurationProperties(prefix = "third.weather")
public class ThirdWeatherConfig {
    private  String url;
    private  Integer port;
    private  String username;

    //添加数组属性
    private String[] cities;

    private List<String> list;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public Integer getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public java.lang.String[] getCities() {
        return cities;
    }

    public List<String> getList(){
        return list;
    }

    public void setList(List<String> list){
        this.list=list;
    }
}
