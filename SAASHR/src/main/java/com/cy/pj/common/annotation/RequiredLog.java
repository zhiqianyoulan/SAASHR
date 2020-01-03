package com.cy.pj.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 所有注解默认继承自Annotation
 * @Target用于描述自己定义的注解，可以对那些元素进行描述（类，方法...）
 * @Retention用于描述自己定义的注解何时有效
 * 
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value= {ElementType.METHOD})
public @interface RequiredLog {
	//定义属性
    String value() default "";
//    String operation() default "operation";
}
