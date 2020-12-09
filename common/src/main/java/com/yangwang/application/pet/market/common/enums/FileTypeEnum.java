package com.yangwang.application.pet.market.common.enums;

/**
 * 文件类型枚举
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className FileTypeEnum
 * @date 2019/10/31 18:12
 **/
public enum FileTypeEnum {
    /**
     * 图片
     */
    JPG("图片", "jpg"),
    JPEG("图片", "jpeg"),
    PNG("图片", "png"),
    HEIC("图片", "heic"),
    BMP("图片", "bmp"),
    JP2("图片", "jp2"),
    GIF("图片", "gif"),
    TIFF("图片", "tiff"),
    EXIF("图片", "exif"),
    WBMP("图片", "wbmp"),
    MBM("图片", "mbm"),
    /**
     * 视频
     */
    MP4("视频", "mp4"),
    MOV("视频", "mov"),
    FLV("视频", "flv"),
    WEBM("视频", "webm"),
    M4V("视频", "m4v"),
    THREE_GP("视频", "3gp"),
    THREE_G_TWO("视频", "3g2"),
    RM("视频", "rm"),
    RMVB("视频", "rmvb"),
    WMV("视频", "wmv"),
    AVI("视频", "avi"),
    ASF("视频", "asf"),
    MPG("视频", "mpg"),
    MPEG("视频", "mpeg"),
    MPE("视频", "mpe"),
    TS("视频", "ts"),
    DIV("视频", "div"),
    DV("视频", "dv"),
    DIVX("视频", "divx"),
    VOB("视频", "vob"),
    DAT("视频", "dat"),
    MKV("视频", "mkv"),
    SWF("视频", "swf"),
    LAVF("视频", "lavf"),
    CPK("视频", "cpk"),
    DIRAC("视频", "dirac"),
    RAM("视频", "ram"),
    QT("视频", "qt"),
    FLI("视频", "fli"),
    FLC("视频", "flc"),
    MOD("视频", "mod"),
    /**
     * 音频
     */
    MP3("音频", "mp3");


    /**
     * 文件类型名称
     */
    String typeName;
    /**
     * 文件后缀
     */
    String suffix;

    FileTypeEnum(String typeName, String suffix) {
        this.typeName = typeName;
        this.suffix = suffix;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getSuffix() {
        return suffix;
    }

    /**
     * 通过后缀名称获取相应的枚举
     *
     * @param suffix 文件后缀
     * @return com.yangwang.application.pet.common.enums.FileTypeEnum
     * @author LiuXiangLin
     * @date 18:15 2019/10/31
     **/
    public static FileTypeEnum filter(String suffix) {
        for (FileTypeEnum fileTypeEnum : values()) {
            if (fileTypeEnum.getSuffix().equalsIgnoreCase(suffix.toLowerCase())) {
                return fileTypeEnum;
            }
        }
        return null;
    }
}
