package com.yangwang.application.pet.market.common.utils;

import java.util.List;

/**
 * 集合工具类
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CollectionUtils
 * @date 2019/10/25 11:43
 **/
public class CollectionUtils {

    /**
     * 是否是空集合（包括null）
     *
     * @param list 需要判断的对象
     * @return boolean
     * @author LiuXiangLin
     * @date 11:44 2019/10/25
     **/
    public static boolean isEmpty(List list) {
        return list == null || list.isEmpty();
    }

    /**
     * 集合是否不为空
     *
     * @param list 需要判断的集合
     * @return boolean
     * @author LiuXiangLin
     * @date 14:05 2019/10/25
     **/
    public static boolean isNotEmpty(List list) {
        return list != null && !list.isEmpty();
    }
}
