package com.zigzag.aop;

import com.zigzag.aop.anno.TargetImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qlk
 */
public class ApplicationContextTest {
    public static void main(String[] args) {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        UserService bean = context.getBean(UserService.class);
        bean.show1();*/

//        bean.show2();

        ApplicationContext context = new ClassPathXmlApplicationContext("aop-anno.xml");
        TargetImpl bean = (TargetImpl) context.getBean("target");
        bean.show1();
        /*bean.show2();*/
        bean.show3();
        bean.throwEx();
    }
}
