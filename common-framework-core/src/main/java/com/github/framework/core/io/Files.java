package com.github.framework.core.io;

import com.github.framework.core.exception.Ex;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @ClassName: Files
 * @Description: file操作工具类
 *
 *
 */
public class Files extends FileUtils {

    public static final int HEADER_LEN = 28;

    /**
     * 通过文件路径判断文件类型
     * @return
     */
    public static FileTypeEnum getFileType(File file) {
        // 获取文件头
        String magicNumberCode = null;
        try {
            magicNumberCode = getFileHeader(file);
        } catch (Exception e) {
            return FileTypeEnum.UNKNOW;
        }

        if (StringUtils.isNotBlank(magicNumberCode)) {
            return getFileTypeByMagicNumber(magicNumberCode,file.getName());
        }

        return FileTypeEnum.UNKNOW;
    }

    public static FileTypeEnum getFileType(byte[] fileContent,String fileName) {
        if (fileContent != null && fileContent.length > 1) {
            byte[] b = new byte[HEADER_LEN];
            System.arraycopy(fileContent,0,b,0, HEADER_LEN);
            String magicNumberCode = getFileHexString(b);
            return getFileTypeByMagicNumber(magicNumberCode,fileName);
        }
        return FileTypeEnum.UNKNOW;
    }

    /**
     * 通过文件路径获取文件头（即文件魔数）
     * @param file
     */
    public static String getFileHeader(File file) {
        byte[] b = new byte[28];
        try (InputStream inputStream = new FileInputStream(file)) {
            inputStream.read(b, 0, 28);
        } catch (Exception ex) {
            throw Ex.systemError(ex,"Read File Header Error:%s!",ex.getMessage());
        }

        return getFileHexString(b);
    }

    /**
     * 从魔数获取对应文件类型，如果没有再按文件名
     * @param magicNumberCode
     * @param fileName
     * @return
     */
    private static FileTypeEnum getFileTypeByMagicNumber(String magicNumberCode,String fileName) {
        FileTypeEnum fileType = FileTypeEnum.of(magicNumberCode);
        if (fileType == null) {
            String extName = FilePaths.getExtensionName(fileName).toUpperCase();
            return NAME_TYPE_MAPPINGS.getOrDefault(extName,FileTypeEnum.UNKNOW);
        }
        return fileType;
    }


    /**
     * 把文件二进制流转换成十六进制数据
     * @param b
     * @return fileTypeHex
     */
    private final static String getFileHexString(byte[] b) {
        StringBuilder builder = new StringBuilder();
        if (b == null || b.length <= 0) {
            return null;
        }

        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString();
    }

    private static final Map<String,FileTypeEnum> NAME_TYPE_MAPPINGS = new HashMap<>();

    static {
        NAME_TYPE_MAPPINGS.put(FileTypeEnum.TEXT.named(),FileTypeEnum.TEXT);
        NAME_TYPE_MAPPINGS.put(FileTypeEnum.JSON.named(),FileTypeEnum.JSON);
    }

}
