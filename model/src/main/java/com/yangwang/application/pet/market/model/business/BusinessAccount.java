package com.yangwang.application.pet.market.model.business;

import com.yangwang.application.pet.market.model.check.BusinessAccountBankGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 商家收款账户
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessAccount
 * @date 2020/5/20 10:42
 **/
@Data
@ApiModel(value = "商家收款账户")
public class BusinessAccount {
    @ApiModelProperty(value = "主键")
    Long accountNo;

    @ApiModelProperty(value = "商家对象")
    @NotNull(message = "商家对象不能为空")
    Business business;

    @ApiModelProperty(value = "收款类型")
    Integer accountType;

    @ApiModelProperty(value = "收款人姓名")
    @NotBlank(message = "收款账户为空")
    String name;

    @ApiModelProperty(value = "收款账户")
    @NotBlank(message = "收款账户不能为空")
    String accountNum;

    @ApiModelProperty(value = "收款银行")
    @NotBlank(message = "收款银行不能为空", groups = BusinessAccountBankGroup.class)
    String bankName;
}
