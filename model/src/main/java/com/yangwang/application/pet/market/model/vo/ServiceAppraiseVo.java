package com.yangwang.application.pet.market.model.vo;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.model.market.ItemAppraiseImg;
import com.yangwang.application.pet.market.model.service.ServiceAppraise;
import com.yangwang.application.pet.market.model.service.ServiceAppraiseImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 服务评价VO
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemAppraiseVo
 * @date 2020/3/24 9:14
 **/
@Data
@ApiModel(value = "服务评价VO")
public class ServiceAppraiseVo {

    @ApiModelProperty(value = "服务评价")
    ServiceAppraise serviceAppraise;

    @ApiModelProperty(value = "服务评价图片")
    List<ServiceAppraiseImg> serviceAppraiseImgList;

    public ServiceAppraiseVo addAppraiseToList() {
        if (CollectionUtils.isNotEmpty(serviceAppraiseImgList)) {
            for (ServiceAppraiseImg serviceAppraiseImg : serviceAppraiseImgList) {
                serviceAppraiseImg.setServiceAppraise(serviceAppraise);
            }
        }
        return this;
    }
}
