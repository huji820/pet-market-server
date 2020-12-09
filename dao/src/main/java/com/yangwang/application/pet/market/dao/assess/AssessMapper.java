package com.yangwang.application.pet.market.dao.assess;

import com.yangwang.application.pet.market.model.assess.Assess;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AssessMapper {

    /**
     * 添加商品评测
     * @param assess
     * @return
     */
    int save(@Param("assess")Assess assess);

    /**
     * 获取所有推荐的评测
     *
     * @return
     */
    List<Assess> listReCommend();

    /**
     * 获取普通的评测
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Assess> list(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 修改评测的申请人数
     *
     * @param assessNo
     * @param applyNum
     * @return
     */
    int updateAssessApplyNum(@Param("assessNo")Long assessNo,@Param("applyNum")int applyNum);

    /**
     * 修改评测数量
     * @param assessNo
     * @param num
     * @return
     */
    int updateAssessNum(@Param("assessNo")Long assessNo,@Param("num")int num);

    /**
     * 通过评测编号获取评测信息
     * @param assessNo
     * @return
     */
    Assess getByAssessNo(@Param("assessNo")Long assessNo);

    /**
     * 通过各种条件获取所有评测信息
     * @param title
     * @param releaseTime
     * @param list
     * @param offset
     * @param limit
     * @return
     */
    List<Assess> listAllAssess(@Param("title")String title,
                               @Param("releaseTime")String releaseTime,
                               @Param("list")List<Integer> list,
                               @Param("offset")Integer offset,
                               @Param("limit")Integer limit);
}
