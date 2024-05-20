package com.zigzag.aop.anno;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 使用配置类
 * @author qlk
 */
@Configuration  // 配置类
@ComponentScan("com.zigzag.ch1.aop")  // 代替<context:component-scan base-package="com.zigzag.ch1.aop" />
@EnableAspectJAutoProxy  // 替代 <aop:aspectj-autoproxy/>
public class SpringConfig {
}
