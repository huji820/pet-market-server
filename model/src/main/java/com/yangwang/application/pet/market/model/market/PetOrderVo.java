package com.yangwang.application.pet.market.model.market;

import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.sysframework.utils.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 宠物订单
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetOrderVo
 * @date 2020/3/26 16:00
 **/
@Data
@ApiModel(value = "宠物订单Vo")
public class PetOrderVo extends BaseOrderVo {
    @ApiModelProperty(value = "宠物")
    Pet pet;

    @ApiModelProperty(value = "运输方式")
    Integer transportType;


    @ApiModelProperty(value = "校验状态")
    boolean checkState;

    public PetOrder convertToPetOrder(String transportOrderNo) {
        PetOrder result = new PetOrder();
        result.setShop(getPet().getBusiness());
        result.setDistributor(getShareBusiness());
        result.setBuyer(getBusiness());
        result.setCreateDate(DateUtil.format(new Date(), DateUtil.FORMAT_SIMPLE));
        result.setCreateTime(DateUtil.format(new Date(), DateUtil.FORMAT_TIME));
        result.setQty(getQty());
        result.setCoupon(getCoupon());
        result.setCouponAmount(getCouponDisCountAmount());
        result.setCarriage(getTransportAmount());
        result.setFreeShipping(getPet().getFreeShipping());
        result.setRetailPrice(getGoodsPrice());
        result.setPaymentAmount(getPaymentAmount());
        result.setReceivingName(getReceivingAddress().getContacts());
        result.setReceivingPhone(getReceivingAddress().getPhone());
        result.setReceivingAddress(getReceivingAddress().getProvince() + getReceivingAddress().getCity() + getReceivingAddress().getCounty() + getReceivingAddress().getDetailedAddress());
        result.setPaymentState(0);
        result.setDriverState(0);
        result.setReceiveState(0);
        result.setEvaluateState(0);
        result.setRefundsState(0);
        result.setWayBill(transportOrderNo);
        result.setPetNo(getPet().getPetNo());
        result.setPetName(getPet().getPetName());
        result.setPetSortNo(getPet().getPetSort().getPetSortNo());
        result.setPetGenreNo(getPet().getPetGenre().getPetGenreNo());
        result.setPetSex(getPet().getPetSex());
        result.setPetSterilization(getPet().getPetSterilization());
        result.setPetBirthday(getPet().getPetBirthday());
        result.setPetUniqueCode(getPet().getPetUniqueCode());
        result.setWeight(getPet().getWeight());
        result.setInsurance(getPet().getInsurance());
        result.setSevenWarranty(getPet().getSevenWarranty());
        result.setPetImg(getPet().getPetImg());
        result.setGroupon(getPet().getGroupon());

        return result;
    }
}
