package com.zigzag.aop.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用全注解方式,解析aop
 * @author qlk
 */
public class ApplicationContextConfigTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TargetImpl target = (TargetImpl) context.getBean("target");
        target.show3();
    }
}
