package com.yangwang.application.pet.market.service.facade.wiki;

import com.yangwang.application.pet.market.model.wiki.Wiki;

import java.util.List;

public interface WikiService {

    /**
     * 查询百科列表
     * @param petGenreNo
     * @param wikiType
     * @param offset
     * @param limit
     * @return
     */
    List<Wiki> list(int petGenreNo, int wikiType,int offset, int limit);

    /**
     * 获取百科详情
     * @param wikiId
     * @return
     */
    Wiki get(long wikiId);
}
