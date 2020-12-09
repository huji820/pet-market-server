package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.model.params.QueryQueryListParam;
import com.yangwang.application.pet.market.model.vo.QueryVo;
import com.yangwang.application.pet.market.service.facade.common.QueryFacedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryFacedServiceImpl
 * @date 2020/3/25 10:37
 **/
@Service
public class QueryFacedServiceImpl implements QueryFacedService {
    @Resource
    QueryItemServiceImpl queryItemService;

    @Resource
    QueryBusinessServiceImpl queryBusinessService;

    @Resource
    QueryPetGenreServiceImpl queryPetGenreService;


    @Override
    public QueryVo query(String keyWord) {
        // 查询参数
        QueryQueryListParam queryQueryListParam = new QueryQueryListParam();
        queryQueryListParam.setKeyWord(keyWord);
        queryQueryListParam.setOffset(0);

        // 返回值
        QueryVo result = new QueryVo();

        // 商家
        queryQueryListParam.setLimit(10);
        result.setBusinesses(queryBusinessService.query(queryQueryListParam));

        // 宠物分类
        queryQueryListParam.setLimit(30);
        result.setPetGenreList(queryPetGenreService.query(queryQueryListParam));

        // 商品
        queryQueryListParam.setLimit(5);
        result.setItemList(queryItemService.query(queryQueryListParam));

        return result;
    }
}
