package com.yangwang.application.pet.market.service.spring.consign;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * @description: 根据经纬度计算距离
 *
 * @author: LSY
 *
 * @create: 2019-10-24
 **/
@Component
public class LocationUtils {
    private static double EARTH_RADIUS = 6378.137;

    private  double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * @description 根据两个位置的经纬度，来计算两地的距离（单位Km）
     * @Author LSY
     * @param lonCus 用户经度
     * @param latCus 用户纬度
     * @param lonMar 商家经度
     * @param latMar 商家纬度
     * @return
     */
    public  double getDistance(String lonCus,String latCus,String lonMar,String latMar) {

        double radLat1 = rad(Double.parseDouble(latCus));
        double radLat2 = rad(Double.parseDouble(latMar));
        double difference  = radLat1 - radLat2;
        double mdifference  = rad(Double.parseDouble(lonCus)) - rad(Double.parseDouble(lonMar));
        double distanceStr = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference  / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(mdifference  / 2), 2)));
        distanceStr = distanceStr * EARTH_RADIUS;
        // 保留两位小数
        distanceStr = Math.round(distanceStr * 100d) / 100d;

        return distanceStr;
    }

    /**
     * @description 根据经纬度查询一个范围内的区域
     * @Author LSY
     * @param lon 经度
     * @param lat 纬度
     * @param distance 半径 0.5(半径500米)
     * @return java.util.Map
     */
    public Map gindNeighPosition(String lon,String lat,String distance) {
        Map map = new HashMap();

        double longitude = Double.parseDouble(lon);
        double latitude = Double.parseDouble(lat);
        double dis = Double.parseDouble(distance);

        // 先计算查询点的经纬度范围
        double dlon = 2*Math.asin(Math.sin(dis/(2*EARTH_RADIUS))/Math.cos(latitude*Math.PI/180));
        // 角度转为弧度
        dlon = dlon*180/Math.PI;
        double dlat = dis/EARTH_RADIUS;
        dlat = dlat*180/Math.PI;

        double minLat = latitude - dlat;
        double maxLat = latitude+dlat;
        double minlon = longitude - dlon;
        double maxlon = longitude + dlon;

        map.put("minLat",minLat);
        map.put("maxLat",maxLat);
        map.put("minlon",minlon);
        map.put("maxlon",maxlon);

        return map;
    }

    /**
     * @description 获取当前用户一定距离内的经纬度
     * @author Lsy
     * @param latStr
     * @param lngStr
     * @param raidus
     * @return
     */
    public  Map getAround(String latStr,String lngStr,String raidus) {
        Map map = new HashMap();
        // 经度
        Double latitude = Double.parseDouble(latStr);
        // 纬度
        Double longitude = Double.parseDouble(lngStr);

        // 获取每度
        Double degree = (24901 * 1609) / 360.0;
        double raidusMile = Double.parseDouble(raidus);

        Double mpdLng = Double.parseDouble(
                ((degree * Math.cos(latitude * Math.PI / 180))+"")
                        .replace("-",","));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidusMile;
        // 获取最小经度
        Double minLat = longitude - radiusLng;
        // 获取最大经度
        Double maxLat = longitude + radiusLng;

        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidusMile;

        // 获取最小经度
        Double minLng = latitude - radiusLat;
        // 获取最大纬度
        Double maxLng = latitude + radiusLat;

        map.put("minLat",minLat);
        map.put("maxLat",maxLat);
        map.put("minLng",minLng);
        map.put("maxLng",maxLng);

        return map;
    }
}
