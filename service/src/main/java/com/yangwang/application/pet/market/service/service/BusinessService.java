package com.yangwang.application.pet.market.service.service;


import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.params.LonAndLat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商家
 * </p>
 *
 * @author LiuXiangLin
 * @date 11:01 2020/3/16
 **/
public interface BusinessService {

    /**
     * <p>
     * 新增数据
     * </p>
     *
     * @param business 商家对象
     * @return int
     * @author LiuXiangLin
     * @date 11:03 2020/3/16
     **/
    int save(Business business);

    /**
     * <p>
     * 删除
     * </p>
     *
     * @param businessNo 商家编号
     * @return int
     * @author LiuXiangLin
     * @date 11:03 2020/3/16
     **/
    int delete(String businessNo);

    /**
     * <p>
     * 更新数据
     * </p>
     *
     * @param business 商家对象
     * @return int
     * @author LiuXiangLin
     * @date 11:04 2020/3/16
     **/
    int update(Business business);

    /**
     * <p>
     * 通过商家编号查询商家（所有状态的均可查询）
     * </p>
     *
     * @param businessNo 商家编号
     * @return com.yangwang.application.pet.market.model.business.Business
     * @author LiuXiangLin
     * @date 11:04 2020/3/16
     **/
    Business getByBusinessNoWithOutState(String businessNo);

    /**
     * <p>
     * 通过商家编号以及状态查询商家
     * </p>
     *
     * @param businessNo 商家编号
     * @param state      商家状态
     * @return com.yangwang.application.pet.market.model.business.Business
     * @author LiuXiangLin
     * @date 11:04 2020/3/16
     **/
    Business getByBusinessNoAndState(String businessNo, int state);

    /**
     * <p>
     * 通过微信unionid查询数据
     * </p>
     *
     * @param unionId 微信unionid
     * @return com.yangwang.application.pet.market.model.business.Business
     * @author LiuXiangLin
     * @date 14:07 2020/3/16
     **/
    Business getByUnionId(String unionId);

    /**
     * <p>
     * 通过open查询商家信息
     * </p>
     *
     * @param openId openid
     * @return com.jxywkj.application.pet.model.business.Business
     * @author LiuXiangLin
     * @date 15:13 2020/4/7
     **/
    Business getByOpenId(String openId);

    /**
     * <p>
     * 更新认证状态
     * </p>
     *
     * @param businessNo 商家编号
     * @param authType   认证状态
     * @return int
     * @author LiuXiangLin
     * @date 17:12 2020/3/19
     **/
    int updateAuthType(String businessNo, int authType);

    /**
     * <p>
     * 更新是否缴纳保证金状态
     * </p>
     *
     * @param businessNo 商家编号
     * @param payBond    缴纳保证金状态
     * @return int
     * @author LiuXiangLin
     * @date 17:13 2020/3/19
     **/
    int updatePayBond(String businessNo, int payBond);

    /**
     * <p>
     * 更新经纬度
     * </p>
     *
     * @param lonAndLat  经纬度对象
     * @param businessNo 商家编号
     * @return int
     * @author LiuXiangLin
     * @date 17:58 2020/3/19
     **/
    int updateLonAndLat(LonAndLat lonAndLat, String businessNo);

    /**
     * <p>
     * 新增粉丝数量
     * </p>
     *
     * @param businessNo 商家编号
     * @param fans       粉丝数
     * @return int
     * @author LiuXiangLin
     * @date 17:32 2020/3/20
     **/
    int updateFansAdd(String businessNo, Integer fans);

    /**
     * <p>
     * 减少粉丝数量
     * </p>
     *
     * @param businessNo 商家编号
     * @param fans       粉丝数量
     * @return int
     * @author LiuXiangLin
     * @date 17:32 2020/3/20
     **/
    int updateFansSub(String businessNo, Integer fans);

    /**
     * <p>
     * 添加关注数量
     * </p>
     *
     * @param businessNo 商家编号
     * @param follow     需要添加的数量
     * @return int
     * @author LiuXiangLin
     * @date 17:53 2020/3/22
     **/
    int updateFollowAdd(String businessNo, int follow);

    /**
     * <p>
     * 减少关注的数量
     * </p>
     *
     * @param businessNo 商家编号
     * @param follow     减少的关注量
     * @return int
     * @author LiuXiangLin
     * @date 17:54 2020/3/22
     **/
    int updateFollowSub(String businessNo, int follow);

    /**
     * <p>
     * 添加用户积分
     * </p>
     *
     * @param businessNo 商家编号
     * @param credit     积分
     * @return int
     * @author LiuXiangLin
     * @date 13:53 2020/4/2
     **/
    int updateCreditAdd(String businessNo, int credit);

    /**
     * <p>
     * 减少用户积分
     * </p>
     *
     * @param businessNo 商家编号
     * @param credit     积分
     * @return int
     * @author LiuXiangLin
     * @date 13:54 2020/4/2
     **/
    int updateCreditSub(String businessNo, int credit);

    /**
     * <p>
     * 更新用户服务状态
     * </p>
     *
     * @param businessNo  商家编号
     * @param haveService 是否含有服务
     * @return int
     * @author LiuXiangLin
     * @date 18:12 2020/6/4
     **/
    int updateHaveService(String businessNo, boolean haveService);

    /**
     * 获取所有商家
     * @param offset
     * @param limit
     * @return
     */
    List<Business> getAllBusiness(int offset, int limit);

    /**
     * 通过商家编号查看是否领取新客礼包
     * @param businessNo
     * @return  true 未领取  false 已领取
     */
    boolean getNewGiftBag(String businessNo);

    /**
     * 领取新客礼包
     * @param businessNo
     * @return
     */
    Integer updateNewGiftBag(String businessNo);
}
