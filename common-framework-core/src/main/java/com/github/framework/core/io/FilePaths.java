
package com.github.framework.core.io;

/**
 * @ClassName FilePaths
 * @Description 文件路径处理工具类
 */
public class FilePaths {

    /**
     * 获取文件的扩展名
     * @param filename
     * @return
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }
}
