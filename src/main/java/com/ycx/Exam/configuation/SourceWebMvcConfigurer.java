package com.ycx.Exam.configuation;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ycx.Exam.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SourceWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    /*
            /* :拦截所有的请求，请求只有一级
            /** :拦截所有的请求    可以拦截多级请求
     */
    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/user/login","/user/logout");
    }

    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        //1.需要定义一个convert转换消息的对象
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        //2.添加fastJson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //3.设置Long为字符串
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
        fastJsonConfig.setSerializeConfig(serializeConfig);

        //4.在convert中添加配置信息.
        converter.setFastJsonConfig(fastJsonConfig);
        return converter;
    }

    }
