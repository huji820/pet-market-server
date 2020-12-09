package com.yangwang.application.pet.market.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.yangwang.sysframework.utils.JsonUtil;
import com.yangwang.sysframework.utils.network.HttpUtil;
import okhttp3.Response;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信检测工具类
 */
@Component
public class WeChatCheckUtils {

    @Value("${weChat.appID}")
    String appID;

    @Value("${weChat.appsecret}")
    String appSecret;

    String accessToken;

    @Resource
    HttpUtil httpUtil;

    /**
     * 获取access_token方法
     */
    public void getAccessToken(){
        String url = " https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                +this.appID+"&secret="+this.appSecret;
        try {
            Response response = httpUtil.get(url);
            Map<String ,Object> msg = JsonUtil.formObject(response.body().string(), Map.class);
            String accessToken = (String)msg.get("access_token");
            this.accessToken = accessToken;
            System.err.println("access_token: "+this.accessToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 检测文本并返回返回值的map集合
     * @param content
     * @return
     */
    public Map<String ,Object> msgSecCheck(String content){
        if(this.accessToken == null){
            getAccessToken();
        }
        String url = "https://api.weixin.qq.com/wxa/msg_sec_check?access_token="+this.accessToken;
        Map<String, Object> params = new HashMap<>();
        params.put("content", content);
        try {
            Response post = httpUtil.postRequestBody(url, params);
            Map<String ,Object> msg = JsonUtil.formObject(post.body().string(), Map.class);
            return msg;
        } catch (Exception e) {
            System.err.println("检测文本发生异常");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 检测图片并返回返回值的map集合
     * @param media
     * @return
     */
    public Map<String ,Object> imgSecCheck(MultipartFile media){
        if(this.accessToken == null){
            getAccessToken();
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();

        CloseableHttpResponse response = null;

        HttpPost request = new HttpPost("https://api.weixin.qq.com/wxa/img_sec_check?access_token=" + this.accessToken);
        request.addHeader("Content-Type", "application/octet-stream");

        InputStream inputStream = null;
        try {
            inputStream = media.getInputStream();
            byte[] byt = new byte[inputStream.available()];
            inputStream.read(byt);
            request.setEntity(new ByteArrayEntity(byt, ContentType.create(media.getContentType())));
            response = httpclient.execute(request);
            HttpEntity httpEntity = response.getEntity();
            String result = EntityUtils.toString(httpEntity, "UTF-8");// 转成string
            Map<String ,Object> map = JsonUtil.formObject(result, Map.class);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 异步校验图片/音频是否含有违法违规内容
     * @param mediaUrl  要检测的多媒体url
     * @param mediaType
     * @return
     */
    public Map<String, Object> mediaCheckAsync(String mediaUrl, String mediaType){
        if(this.accessToken == null){
            this.getAccessToken();
        }
        String url = "https://api.weixin.qq.com/wxa/media_check_async?access_token="+this.accessToken;
        Map<String, Object> params = new HashMap<>();
        params.put("mediaUrl", mediaUrl);
        params.put("mediaType", mediaType);
        try {
            Response response = httpUtil.postRequestBody(url, params);
            Map<String ,Object> map = JsonUtil.formObject(response.body().string(), Map.class);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 检测文本是否含有敏感内容  false 含有敏感内容   true 不含有敏感内容
     * @param content
     * @return
     */
    public boolean checkMsg(String content){
        Map<String, Object> map = this.msgSecCheck(content);
        Integer errcode = (Integer)map.get("errcode");
        if(errcode.equals(87014)){
            return false;
        }
        return true;
    }

    /**
     * 检测图片是否是敏感图片  false 是敏感图片   true 不是敏感图片
     * @param media
     * @return
     */
    public boolean checkImg(MultipartFile media){
        Map<String, Object> map = this.imgSecCheck(media);
        Integer errcode = (Integer)map.get("errcode");
        if(errcode.equals(87014)){
            return false;
        }
        return true;
    }
}
