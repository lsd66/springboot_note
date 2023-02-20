package com.lsd.springboot_learning.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Configurable
@Component("com.lsd")
// 上述两个注解表示需要启动类进行扫描这里
public class MyConfig {
}
