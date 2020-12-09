package com.yangwang.application.pet.market.dao.business;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.params.LonAndLat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商家
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:16 2020/3/16
 **/
@Mapper
public interface BusinessMapper {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @param business 商家对象
     * @return int
     * @author LiuXiangLin
     * @date 10:18 2020/3/16
     **/
    int save(@Param("business") Business business);

    /**
     * <p>
     * 通过删除编号删除一条数据
     * </p>
     *
     * @param businessNo 商家编号
     * @return int
     * @author LiuXiangLin
     * @date 10:18 2020/3/16
     **/
    int delete(@Param("businessNo") String businessNo);

    /**
     * <p>
     * 更新商家信息
     * </p>
     *
     * @param business 商家对象
     * @return int
     * @author LiuXiangLin
     * @date 10:18 2020/3/16
     **/
    int update(@Param("business") Business business);

    /**
     * <p>
     * 更新商家状态
     * </p>
     *
     * @param businessNo 商家编号
     * @param state      商家状态
     * @return int
     * @author LiuXiangLin
     * @date 10:19 2020/3/16
     **/
    int updateState(@Param("businessNo") String businessNo, @Param("state") int state);

    /**
     * <p>
     * 通过商家编号查询商家
     * </p>
     *
     * @param businessNo 商家编号
     * @return com.yangwang.application.pet.market.model.business.Business
     * @author LiuXiangLin
     * @date 10:19 2020/3/16
     **/
    Business getByBusinessNoAndNoState(@Param("businessNo") String businessNo);

    /**
     * <p>
     * 通过商家编号以及状态查询商家
     * </p>
     *
     * @param businessNo 商家编号
     * @param state      状态
     * @return com.yangwang.application.pet.market.model.business.Business
     * @author LiuXiangLin
     * @date 10:20 2020/3/16
     **/
    Business getByBusinessNoAndState(@Param("businessNo") String businessNo, @Param("state") int state);

    /**
     * <p>
     * 通过unionid查询商家数据
     * </p>
     *
     * @param unionId 微信unionid
     * @return com.yangwang.application.pet.market.model.business.Business
     * @author LiuXiangLin
     * @date 14:08 2020/3/16
     **/
    Business getByUnionId(@Param("unionId") String unionId);

    /**
     * <p>
     * 通过openId查询商家信息
     * </p>
     *
     * @param openId openid
     * @return com.jxywkj.application.pet.model.business.Business
     * @author LiuXiangLin
     * @date 15:14 2020/4/7
     **/
    Business getByOpenId(@Param("openId") String openId);

    /**
     * <p>
     * 更新认证状态
     * </p>
     *
     * @param businessNo 商家状态
     * @param authType   认证状态
     * @return int
     * @author LiuXiangLin
     * @date 17:06 2020/3/19
     **/
    int updateAuthType(@Param("businessNo") String businessNo, @Param("authType") int authType);

    /**
     * <p>
     * 更新是否缴纳保证金状态
     * </p>
     *
     * @param businessNo 商家编号
     * @param payBond    缴纳保证金状态
     * @return int
     * @author LiuXiangLin
     * @date 17:10 2020/3/19
     **/
    int updatePayBond(@Param("businessNo") String businessNo, @Param("payBond") int payBond);

    /**
     * <p>
     * 更新用户经纬度
     * </p>
     *
     * @param lonAndLat  经纬度对象
     * @param businessNo 商家编号
     * @return int
     * @author LiuXiangLin
     * @date 17:55 2020/3/19
     **/
    int updateLonAndLat(@Param("lonAndLat") LonAndLat lonAndLat, @Param("businessNo") String businessNo);

    /**
     * <p>
     * 新增粉丝数量
     * </p>
     *
     * @param businessNo 商家编号
     * @param fans       粉丝数量
     * @return int
     * @author LiuXiangLin
     * @date 17:38 2020/3/20
     **/
    int updateFansAdd(@Param("businessNo") String businessNo, @Param("fans") int fans);

    /**
     * <p>
     * 减少粉丝数量
     * </p>
     *
     * @param businessNo 商家编号
     * @param fans       粉丝数量
     * @return int
     * @author LiuXiangLin
     * @date 17:37 2020/3/20
     **/
    int updateFansSub(@Param("businessNo") String businessNo, @Param("fans") int fans);

    /**
     * <p>
     * 添加关注数量
     * </p>
     *
     * @param businessNo 商家编号
     * @param addFollow  关注数量
     * @return int
     * @author LiuXiangLin
     * @date 17:51 2020/3/22
     **/
    int addFollowQty(@Param("businessNo") String businessNo, @Param("addFollow") int addFollow);

    /**
     * <p>
     * 添加用户的积分
     * </p>
     *
     * @param businessNo 商家编号
     * @param credit     积分数量
     * @return int
     * @author LiuXiangLin
     * @date 13:55 2020/4/2
     **/
    int addCreditQty(@Param("businessNo") String businessNo, @Param("credit") int credit);


    /**
     * <p>
     * 更新用户时候含有服务
     * </p>
     *
     * @param businessNo  商家编号
     * @param haveService 是否含有服务
     * @return int
     * @author LiuXiangLin
     * @date 18:10 2020/6/4
     **/
    int updateHaveService(@Param("businessNo") String businessNo, @Param("haveService") boolean haveService);

    /**
     * 获取所有商家
     * @param offset
     * @param limit
     * @return
     */
    List<Business> getAllBusiness(@Param("offset")int offset,@Param("limit")int limit);

    /**
     * 通过商家编号查看是否领取新客礼包
     * @param businessNo
     * @return
     */
    Integer getHaveNewGiftBagByBusinessNo(@Param("businessNo")String businessNo);

    /**
     * 领取新客礼包
     * @param businessNo
     * @return
     */
    Integer updateNewGiftBag(@Param("businessNo")String businessNo);
}
