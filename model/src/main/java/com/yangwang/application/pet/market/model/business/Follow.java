package com.yangwang.application.pet.market.model.business;

import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 关注
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className MarletFollow
 * @date 2020/3/20 15:47
 **/
@ApiModel(description = "关注")
@Data
public class Follow {
    /**
     * 商家
     */
    public static final int TYPE_BUSINESS = 1;
    /**
     * 宠物
     */
    public static final int TYPE_PET = 2;
    /**
     * 商品
     */
    public static final int TYPE_ITEM = 3;

    @ApiModelProperty(value = "主键")
    Integer followNo;

    @ApiModelProperty(value = "商家")
    Business business;

    @ApiModelProperty(value = "被关注商家")
    Business followBusiness;

    @ApiModelProperty(value = "宠物")
    Pet pet;

    @ApiModelProperty(value = "商品")
    Item item;

    @ApiModelProperty(value = "关注时间")
    String followDate;

    @ApiModelProperty(value = "关注类型")
    Integer followType;

    public static Follow toObject(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                return JsonUtil.formObject(jsonStr, Follow.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * <p>
     * 校验类型是否匹配
     * </p>
     *
     * @return boolean
     * @author LiuXiangLin
     * @date 14:06 2020/3/21
     **/
    public boolean checkUsefulType() {
        boolean resultType = false;
        if (business == null || business.getBusinessNo() == null) {
            return false;
        }

        if (followType != null) {
            switch (followType) {
                case TYPE_BUSINESS:
                    resultType = followBusiness != null && followBusiness.getBusinessNo() != null && item == null && pet == null;
                    break;
                case TYPE_PET:
                    resultType = pet != null && pet.getPetNo() != null && followBusiness == null && item == null;
                    break;
                case TYPE_ITEM:
                    resultType = item != null && item.getItemNo() != null && followBusiness == null && pet == null;
                    break;
                default:
                    resultType = false;
            }
        }
        return resultType;
    }
}
