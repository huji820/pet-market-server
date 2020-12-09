package com.yangwang.application.pet.market.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName LonAndLat
 * @Description
 * @Author LSY
 * @Date 2019/10/23
 */

@Data
@ApiModel("经纬度找对象")
public class LonAndLat {
    @ApiModelProperty(value = "经度")
    String longitude;

    @ApiModelProperty(value = "纬度")
    String latitude;

    public LonAndLat() { }

    public LonAndLat(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getStringLonAndLat() {
        return this.longitude + "," + this.latitude;
    }
}
