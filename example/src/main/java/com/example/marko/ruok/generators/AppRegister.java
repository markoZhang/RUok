package com.example.marko.ruok.generators;

import com.example.latte.wechat.template.AppRegisterTemplate;
import com.example.latte_annotations.annotations.AppRegisterGenerator;

/**
 * @author Marko
 * @date 2018/12/18
 */

@AppRegisterGenerator(
        packageName = "com.example.marko.ruok",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
