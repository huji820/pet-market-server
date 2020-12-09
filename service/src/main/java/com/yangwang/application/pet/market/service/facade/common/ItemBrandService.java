package com.yangwang.application.pet.market.service.facade.common;


import com.yangwang.application.pet.market.model.common.ItemBrand;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;

import java.util.List;

/***
 * <p>
 * 商品品牌
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:33 2020/3/22
 **/
public interface ItemBrandService {
    /**
     * <p>
     * 通过参数参训
     * </p>
     *
     * @param pagingQueryParam 参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.common.ItemBrand>
     * @author LiuXiangLin
     * @date 10:34 2020/3/22
     **/
    List<ItemBrand> listByParam(PagingQueryParam pagingQueryParam);
}
