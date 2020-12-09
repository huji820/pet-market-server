package com.yangwang.application.pet.market.service.spring.consign;

import com.yangwang.application.pet.market.model.params.LonAndLat;
import com.yangwang.sysframework.utils.JsonUtil;
import com.yangwang.sysframework.utils.StringUtil;
import com.yangwang.sysframework.utils.network.HttpUtil;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GaoDeMapUtils
 * @Description 高德地图工具类
 * @Author LSY
 * @Date 2019-10-14
 */
@Component
public class GaoDeMapUtils {
    @Value("${gaode.key}")
    String gaoDeKey;
    @Resource
    HttpUtil httpUtil;

    // 地里编码地址
    private static final String GEO_CODING_BASE_URL = "https://restapi.amap.com/v3/geocode/geo";
    // 开车路径规划
    private static final String DrIVER_PLANNING_BASE_RUL = "https://restapi.amap.com/v3/direction/driving";

    /**
     * @return com.yangwang.application.pet.market.model.params.LonAndLat
     * @param address
     * @Date 2019/10/23
     * @throws Exception
     */
    public LonAndLat getLonAndLat(String address) throws Exception {
        // 发送请求并获取返回数据
        Response response = httpUtil.get(GEO_CODING_BASE_URL + "?address=" + address + "&key=" + gaoDeKey);
        // 将请求数据转换为Map集合
        Map<String ,Object> msg = JsonUtil.formObject(response.body().string(),Map.class);
        // 获取返回值
        List<Map<String, Object>> geocodes = ((ArrayList<Map<String, Object>>) msg.get("geocodes"));

        if (geocodes == null || geocodes.size() == 0) {
            throw new RuntimeException("获取地址位置失败");
        }
        // 获取经纬度
        String lonAndLat = StringUtil.$Str(((ArrayList<Map<String, Object>>) msg.get("geocodes")).get(0).get("location"));

        // 将经纬度拆成数组
        String[] lonAndLatArray = lonAndLat.split(",");

        return new LonAndLat(lonAndLatArray[0], lonAndLatArray[1]);
    }
}
