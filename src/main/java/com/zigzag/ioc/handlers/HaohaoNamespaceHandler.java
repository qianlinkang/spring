package com.zigzag.ioc.handlers;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author qlk
 */
public class HaohaoNamespaceHandler extends NamespaceHandlerSupport {

    // 初始化,一般情况下,一个命名空间下有多个标签
    // 会在init方法中为每一个标签注册一个标签解析器
    @Override
    public void init() {
        this.registerBeanDefinitionParser("annotation-driven",new HaohaoBeanDefinitionParser());
    }
}
