
package com.github.framework.core.io;

import com.github.framework.core.IEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;


public enum FileTypeEnum implements IEnum<String> {

    /**
     * JPEG  (jpg)
     */
    JPEG("JPG", "FFD8FF", MediaType.IMAGE_JPEG_VALUE),

    /**
     * PNG
     */
    PNG("PNG", "89504E47",MediaType.IMAGE_PNG_VALUE),

    /**
     * GIF
     */
    GIF("GIF", "47494638",MediaType.IMAGE_GIF_VALUE),

    /**
     * TIFF (tif)
     */
    TIFF("TIF", "49492A00","image/tiff"),

    /**
     * Windows bitmap (bmp)
     */
    BMP("BMP", "424D","image/bmp"),

    BMP_16("BMP", "424D228C010000000000","image/bmp"), //16色位图(bmp)

    BMP_24("BMP", "424D8240090000000000","image/bmp"), //24位位图(bmp)

    BMP_256("BMP", "424D8E1B030000000000","image/bmp"), //256色位图(bmp)

    /**
     * CAD  (dwg)
     */
    DWG("DWG", "41433130","application/acad"),

    /**
     * Adobe photoshop  (psd)
     */
    PSD("PSD", "38425053",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * Rich Text Format  (rtf)
     */
    RTF("RTF", "7B5C727466","application/rtf"),

    /**
     * XML
     */
    XML("XML", "3C3F786D6C",MediaType.TEXT_XML_VALUE),

    /**
     * HTML (html)
     */
    HTML("HTML", "68746D6C3E",MediaType.TEXT_HTML_VALUE),

    /**
     * Email [thorough only] (eml)
     */
    EML("EML", "44656C69766572792D646174653A",MediaType.TEXT_PLAIN_VALUE),

    /**
     * Outlook Express (dbx)
     */
    DBX("DBX", "CFAD12FEC5FD746F ",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * Outlook (pst)
     */
    PST("", "2142444E",MediaType.TEXT_PLAIN_VALUE),

    /**
     * doc;xls;dot;ppt;xla;ppa;pps;pot;msi;sdw;db
     */
    OLE2("OLE2", "0xD0CF11E0A1B11AE1",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * Microsoft Word/Excel 注意：word 和 excel的文件头一样
     */
    XLS("XLS", "D0CF11E0","application/excel"),

    /**
     * Microsoft Word/Excel 注意：word 和 excel的文件头一样
     */
    DOC("DOC", "D0CF11E0","application/msword"),

    /**
     * Microsoft Word/Excel 2007以上版本文件 注意：word 和 excel的文件头一样
     */
    DOCX("DOCX", "504B0304","application/msword"),

    /**
     * Microsoft Word/Excel 2007以上版本文件 注意：word 和 excel的文件头一样 504B030414000600080000002100
     */
    XLSX("XLSX", "504B0304","application/excel"),

    /**
     * Microsoft Access (mdb)
     */
    MDB("MDB", "5374616E64617264204A",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * Word Perfect (wpd)
     */
    WPB("WPB", "FF575043","application/wordperfect"),

    /**
     * Postscript
     */
    EPS("EPS", "252150532D41646F6265",MediaType.TEXT_PLAIN_VALUE),

    /**
     * Postscript
     */
    PS("PS", "252150532D41646F6265",MediaType.TEXT_PLAIN_VALUE),

    /**
     * Adobe Acrobat (pdf)
     */
    PDF("PDF", "255044462D312E",MediaType.APPLICATION_PDF_VALUE),

    /**
     * Quicken (qdf)
     */
    QDF("qdf", "AC9EBD8F",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * QuickBooks Backup (qdb)
     */
    QDB("qbb", "458600000600",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * Windows Password  (pwl)
     */
    PWL("PWL", "E3828596",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * ZIP Archive
     */
    ZIP("ZIP", "504B0304","application/zip"),

    /**
     * ARAR Archive
     */
    RAR("RAR", "52617221",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * WAVE (wav)
     */
    WAV("WAV", "57415645","audio/wav"),

    /**
     * AVI
     */
    AVI("AVI", "41564920","video/avi"),

    /**
     * Real Audio (ram)
     */
    RAM("RAM", "2E7261FD","audio/x-pn-realaudio"),

    /**
     * Real Media (rm) rmvb/rm相同
     */
    RM("RM", "2E524D46","application/vnd.rn-realmedia"),

    /**
     * Real Media (rm) rmvb/rm相同
     */
    RMVB("RMVB", "2E524D46000000120001","application/vnd.rn-realmedia"),

    /**
     * MPEG (mpg)
     */
    MPG("MPG", "000001BA","video/mpeg"),

    /**
     * Quicktime  (mov)
     */
    MOV("MOV", "6D6F6F76","video/quicktime"),

    /**
     * Windows Media (asf)
     */
    ASF("ASF", "3026B2758E66CF11","video/x-ms-asf"),

    /**
     * ARJ Archive
     */
    ARJ("ARJ", "60EA",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * MIDI (mid)
     */
    MID("MID", "4D546864",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * MP4
     */
    MP4("MP4", "00000020667479706D70",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * MP3
     */
    MP3("MP3", "49443303000000002176","audio/mpeg"),

    /**
     * FLV
     */
    FLV("FLV", "464C5601050000000900",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * 1F8B0800000000000000
     */
    GZ("GZ", "1F8B08","application/x-compressed"),

    /**
     * CSS
     */
    CSS("CSS", "48544D4C207B0D0A0942",MediaType.TEXT_PLAIN_VALUE),

    /**
     * JS
     */
    JS("JS", "696B2E71623D696B2E71",MediaType.TEXT_PLAIN_VALUE),

    /**
     * Visio
     */
    VSD("VSD", "d0cf11e0a1b11ae10000","application/x-visio"),

    /**
     * WPS文字wps、表格et、演示dps都是一样的
     */
    WPS("WPS", "d0cf11e0a1b11ae10000",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * torrent
     */
    TORRENT("TORRENT", "6431303A637265617465",MediaType.TEXT_PLAIN_VALUE),

    /**
     * JSP Archive
     */
    JSP("JSP", "3C2540207061676520",MediaType.TEXT_PLAIN_VALUE),

    /**
     * JAVA Archive
     */
    JAVA("JAVA", "7061636B61676520",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * CLASS Archive
     */
    CLASS("CLASS", "CAFEBABE0000002E00",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * JAR Archive
     */
    JAR("JAR", "504B03040A000000",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * MF Archive
     */
    MF("MF", "4D616E69666573742D56",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * EXE Archive
     */
    EXE("EXE", "4D5A9000030000000400",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * ELF Executable
     */
    ELF("ELF", "7F454C4601010100",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * Lotus 123 v1
     */
    WK1("WK1", "2000604060","application/x-123"),

    /**
     * Lotus 123 v3
     */
    WK3("WK3", "00001A0000100400","application/x-123"),

    /**
     * Lotus 123 v5
     */
    WK4("WK4", "00001A0002100400","application/x-123"),

    /**
     * Lotus WordPro v9
     */
    LWP("LWP", "576F726450726F",MediaType.APPLICATION_OCTET_STREAM_VALUE),

    /**
     * Sage(sly.or.srt.or.slt;sly;srt;slt)
     */
    SLY("SLY", "53520100",MediaType.TEXT_PLAIN_VALUE),
    TEXT("TXT","",MediaType.TEXT_PLAIN_VALUE),
    JSON("JSON","",MediaType.APPLICATION_JSON_VALUE),

    /**
     * CHM Archive
     */
    CHM("CHM", "49545346030000006000",MediaType.APPLICATION_OCTET_STREAM_VALUE),
    INI("INI", "235468697320636F6E66",MediaType.TEXT_PLAIN_VALUE),
    SQL("SQL", "494E5345525420494E54",MediaType.TEXT_PLAIN_VALUE),
    BAT("BAT", "406563686F206f66660D",MediaType.TEXT_PLAIN_VALUE),
    PROPERTIES("PROPERTIES", "6C6F67346A2E726F6F74",MediaType.TEXT_PLAIN_VALUE),
    UNKNOW("", "",MediaType.APPLICATION_OCTET_STREAM_VALUE);

    //文件类型对应的魔数
    private String value;



    //文件类型对应的名称
    private String name;


    private String mediaType;

    FileTypeEnum(String name, String value,String mediaType) {
        this.value = value;
        this.name = name;
        this.mediaType = mediaType;
    }

    public String mediaType() {
        return mediaType;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String named() {
        return name;
    }


    /**
     * 根据文件类型后缀名获取枚举
     *
     * @param fileTypeName - 文件类型后缀名
     * @return
     */
    public static FileTypeEnum ofName(String fileTypeName) {
        if (StringUtils.isNotBlank(fileTypeName)) {
            for (FileTypeEnum type : values()) {
                if (type.named().equals(fileTypeName)) {
                    return type;
                }
            }
        }
        return FileTypeEnum.UNKNOW;
    }

    public static FileTypeEnum of(String value) {
        if (StringUtils.isNotBlank(value)) {
            for (FileTypeEnum type : values()) {
                if (StringUtils.startsWithIgnoreCase(value,type.value)) {
                    return type;
                }
            }
        }
        return FileTypeEnum.UNKNOW;
    }


}
