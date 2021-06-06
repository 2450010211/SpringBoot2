package com.lhf.config;

import com.lhf.bean.Pet;
import com.lhf.converter.DIYMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: lhf
 * @Date: 2021/2/27 15:32
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 自定义内容协商
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        Map<String, MediaType> mediaTypeMap = new HashMap<>();
        //指定支持的参数类型
        mediaTypeMap.put("json", MediaType.APPLICATION_JSON);
        mediaTypeMap.put("xml", MediaType.APPLICATION_XML);
        mediaTypeMap.put("lhf", MediaType.parseMediaType("application/x-lhf"));
        ParameterContentNegotiationStrategy negotiationStrategy = new ParameterContentNegotiationStrategy(mediaTypeMap);
        configurer.strategies(Arrays.asList(negotiationStrategy));
    }

    /**
     * 自定义的Message Converter
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new DIYMessageConverter());
    }

    /**
     * 自定义转换器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addFormatter(new Formatter<Date>() {

            @Override
            public String print(Date date, Locale locale) {
                return null;
            }

            @Override
            public Date parse(String source, Locale locale) throws ParseException {
                if(!StringUtils.isEmpty(source)){
                    System.out.println(source);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = simpleDateFormat.parse(source);
                    return date;
                }
                return null;
            }
        });

        registry.addConverter(new Converter<String, Pet>() {
            @Override
            public Pet convert(String source) {
                if(!StringUtils.isEmpty(source)){
                    Pet pet = new Pet();
                    String[] split = source.split(",");
                    pet.setName(split[0]);
                    pet.setAge(Integer.parseInt(split[1]));
                    return pet;
                }
                return null;
            }
        });
    }

    /**
     * 开启矩阵变量
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false); //关闭截取已分号的请求参数
        configurer.setUrlPathHelper(urlPathHelper);
    }
}
