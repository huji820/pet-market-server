package com.yangwang.application.pet.market.service.spring.wiki;

import com.yangwang.application.pet.market.dao.wiki.WikiMapper;
import com.yangwang.application.pet.market.model.wiki.Wiki;
import com.yangwang.application.pet.market.service.facade.wiki.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-05-17 17:10
 * @Version 1.0
 */
@Service
public class WikiServiceImpl implements WikiService {

    @Autowired
    WikiMapper wikiMapper;

    @Override
    public List<Wiki> list(int petGenreNo, int wikiType, int offset, int limit) {
        return wikiMapper.list(petGenreNo, wikiType, offset, limit);
    }

    @Override
    public Wiki get(long wikiId) {
        return wikiMapper.get(wikiId);
    }
}
