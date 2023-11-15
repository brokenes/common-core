package com.github.framework.core.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

public class I18nMessageUtils {

    private I18nMessageUtils() {

    }
    private static MessageSourceAccessor accessor;
    private static MessageSource messageSource;
    private static final String PATH_PARENT = "classpath:i18n/";
    private static final String SUFFIX = ".properties";
    private static ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();


    private static void initMessageSourceAccessor(String language) throws IOException {
        Resource resource = resourcePatternResolver.getResource("classpath:" + language + ".properties");
        String fileName = resource.getURL().toString();
        int lastIndex = fileName.lastIndexOf(".");
        String baseName = fileName.substring(0, lastIndex);
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename(baseName);
        reloadableResourceBundleMessageSource.setCacheSeconds(5);
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
        accessor = new MessageSourceAccessor(reloadableResourceBundleMessageSource);
        messageSource = reloadableResourceBundleMessageSource;
    }

    public static String resolveMessage(String language, String message, String defaultMessage) throws IOException {
        initMessageSourceAccessor(language);
        return accessor.getMessage(message, defaultMessage, LocaleContextHolder.getLocale());
    }

}
