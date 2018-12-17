package com.example.latte_annotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Marko
 * @date 2018/12/14
 * 用来传入我们的包名以及微信所需要的模板代码
 */


/**
 * @Target:注解的作用目标
 * @Target(ElementType.TYPE)   //接口、类、枚举、注解
 * 　　　　　　　 @Target(ElementType.FIELD) //字段、枚举的常量
 * 　　　　　　　　@Target(ElementType.METHOD) //方法
 * 　　　　　　　　@Target(ElementType.PARAMETER) //方法参数
 * 　　　　　　　　@Target(ElementType.CONSTRUCTOR)  //构造函数
 * 　　　　　　　　@Target(ElementType.LOCAL_VARIABLE)//局部变量
 * 　　　　　　　　@Target(ElementType.ANNOTATION_TYPE)//注解
 * 　　　　　　　　@Target(ElementType.PACKAGE) ///包   
 * ---------------------
 * 作者：SingleShu888
 * 来源：CSDN
 * 原文：https://blog.csdn.net/sw5131899/article/details/54947192
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface EntryGenerator {

    String packageName();

    Class<?> entryTemplete();
}
