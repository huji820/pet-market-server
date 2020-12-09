package com.yangwang.application.pet.market.model.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yangwang.application.pet.market.model.business.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: trunk
 *
 * @description: 商品资料视图模型
 *
 * @author: LSY
 *
 * @create: 2019-10-30
 **/
@Data
@ApiModel(description = "附近的商家")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessNearResultVo {

    @ApiModelProperty(value = "所在的城市")
    String city;

    @ApiModelProperty(value = "所有的区和县")
    List<AreaBusinessVO> areas;

    public BusinessNearResultVo() {
    }

    public BusinessNearResultVo(String city, List<AreaBusinessVO> areas) {
        this.city = city;
        this.areas = areas;
    }

    public void addAllCity(List<AreaBusinessVO> vo) {
        AreaBusinessVO area = new AreaBusinessVO();
        area.setArea("所有区域");

        List<NearBusinessVO> businessVOS = new ArrayList<>();
        for (AreaBusinessVO areaBusinessVO : vo) {
            businessVOS.addAll(areaBusinessVO.getBusinesses());
        }
        area.setBusinesses(businessVOS);
        area.setNum(businessVOS.size());
        this.getAreas().add(0, area);
    }

    public void addEmtpyAllCity() {
        AreaBusinessVO area = new AreaBusinessVO();
        area.setArea("所有区域");

        int num = 0;

        for (AreaBusinessVO all : areas) {
            num = num + all.getBusinesses().size();
        }

        area.setNum(num);
        this.getAreas().add(0, area);
    }


    public void addCity(List<AreaBusinessVO> vos) {
        AreaBusinessVO areaBusinessVO = vos.get(0);
        for (AreaBusinessVO temp : areas) {
            if (temp.getArea().equals(areaBusinessVO.getArea())) {
                areaBusinessVO.setBusinesses(areaBusinessVO.getBusinesses());
            }
        }
    }
}
