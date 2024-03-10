package com.mdx.xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 测试bean生命周期
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emp implements BeanFactoryAware, ApplicationContextAware {
    private String name;

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

}
