package com.yangwang.application.pet.market.dao.common;

import com.yangwang.application.pet.market.model.common.InitiateRefund;
import com.yangwang.application.pet.market.model.common.InitiateRefundImg;
import com.yangwang.application.pet.market.model.vo.InitiateRefundVo;
import org.apache.ibatis.annotations.Param;

/**
 * @program: trunk
 * @description:
 * @author: lsy
 * @create: 2019-12-06 :
 **/
public interface InitiateRefundMapper {
    /**

     * @description 退款申请表
     * @return
     * @author lsy
     * @date 16:21 2019/12/6
     **/
    int saveInitiateRefund(@Param("initiateRefund") InitiateRefund initiateRefund);
    /**

     * @description 退款申请表 - 图片
     * @return
     * @author lsy
     * @date 10:20 2019/12/7
     **/
    int saveInitiateRefundImg(@Param("initiateRefundImg") InitiateRefundImg initiateRefundImg);

    /**

     * @description 是否确认退款 - 拒绝退款
     * @return
     * @author lsy
     * @date 15:16 2019/12/7
     **/
    int updateInitiateRefund(@Param("initiateRefund") InitiateRefund initiateRefund);

    /**

     * @description 查询退款订单详情
     * @return
     * @author lsy
     * @date 18:08 2019/12/7
     **/
    InitiateRefund selectRefundOrderDetail(@Param("initiateRefund") InitiateRefundVo initiateRefund);
}
