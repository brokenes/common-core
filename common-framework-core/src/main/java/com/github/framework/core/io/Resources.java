package com.github.framework.core.io;

import com.github.framework.core.exception.Ex;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源操作类类
 */
public class Resources extends org.springframework.util.ResourceUtils {

    private static ResourceLoader resourceLoader;
    private static ResourcePatternResolver resourceResolver;
    static {
        resourceLoader = new DefaultResourceLoader();
        resourceResolver = new PathMatchingResourcePatternResolver(resourceLoader);
    }

    /**
     * 获取资源加载器（可读取jar内的文件）
     * 
     */
    public static ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    /**
     * 获取ClassLoader
     */
    public static ClassLoader getClassLoader() {
        return resourceLoader.getClassLoader();
    }

    /**
     * 获取资源加载器（可读取jar内的文件）
     */
    public static Resource getResource(String location) {
        return resourceLoader.getResource(location);
    }

    /**
     * 获取资源文件流（用后记得关闭）
     * @param location
     * @throws IOException
     */
    public static InputStream getResourceFileStream(String location) throws IOException {
        final Resource resource = resourceLoader.getResource(location);
        return resource.getInputStream();
    }

    /**
     * 获取资源文件内容
     * @param location
     * 
     */
    public static String getResourceFileContent(String location) {
        try (InputStream is = getResourceFileStream(location)) {
            return Streams.toString(is, "UTF-8");
        }
        catch (final IOException e) {
            throw Ex.systemError(e,e.getMessage());
        }
    }

    /**
     * Spring 搜索资源文件
     * @param locationPattern
     * 
     */
    public static Resource[] getResources(String locationPattern) {
        try {
            final Resource[] resources = resourceResolver.getResources(locationPattern);
            return resources;
        }
        catch (final IOException e) {
            throw Ex.systemError(e,e.getMessage());
        }
    }

}
