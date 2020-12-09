package com.yangwang.application.pet.market.dao.wiki;

import com.yangwang.application.pet.market.model.wiki.Wiki;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WikiMapper {

    /**
     * 查询百科列表
     * @param petGenreNo
     * @param wikiType
     * @param offset
     * @param limit
     * @return
     */
    List<Wiki> list(@Param("petGenreNo") int petGenreNo, @Param("wikiType") int wikiType, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 获取百科详情
     * @param wikiId
     * @return
     */
    Wiki get(@Param("wikiId") long wikiId);
}
