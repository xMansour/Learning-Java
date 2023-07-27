package com.mansour.applicationcontextaware;

import com.mansour.applicationcontextaware.entities.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class ApplicationContextAwareApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationContextAwareApplication.class, args);
    }

    @Bean
    public ApplicationContextAware getApplicationContext(){
        return new ApplicationContextAware() {
            @Override
            public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
                System.out.println("applicationContext = " + applicationContext);
                System.out.println("applicationContext.getApplicationName() = " + applicationContext.getApplicationName());
                System.out.println("applicationContext.getId() = " + applicationContext.getId());
                System.out.println("applicationContext.getDisplayName() = " + applicationContext.getDisplayName());
                //System.out.println("applicationContext.getBean = " + applicationContext.getBean("getApplicationContext", ApplicationContextAware.class));
            }
        };
    }


    @Bean
    public BeanNameAware getBeanName(){
        return new BeanNameAware() {
            @Override
            public void setBeanName(String name) {
                System.out.println("name = " + name);
            }
        };
    }

    @Bean
    //@Primary
    public Person getFirstPerson(){
        return new Person("First", "Person", 1);
    }
    @Bean("SecondPerson")
    public Person getSecondPerson(){
        return new Person("Second", "Person", 2);
    }

}
