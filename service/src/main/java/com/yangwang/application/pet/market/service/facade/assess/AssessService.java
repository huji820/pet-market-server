package com.yangwang.application.pet.market.service.facade.assess;

import com.yangwang.application.pet.market.model.assess.Assess;

import java.util.List;

public interface AssessService {

    /**
     * 添加商品评测
     * @param assess
     * @return
     */
    int save(Assess assess);

    /**
     * 获取所有推荐的评测
     * @return
     */
    List<Assess> listReCommend();

    /**
     * 获取普通的评测
     * @param offset
     * @param limit
     * @return
     */
    List<Assess> list(int offset, int limit);

    /**
     * 通过评测编号获取评测信息
     * @param assessNo
     * @return
     */
    Assess getByAssessNo(Long assessNo);

    /**
     * 获取所有评测信息,通过各种查询条件
     * @param query  查询条件
     * @param releaseTime  发布时间
     * @param offset
     * @param limit
     * @return
     */
    List<Assess> listAllAssess(String query, String releaseTime,
                   Integer offset, Integer limit);
}
