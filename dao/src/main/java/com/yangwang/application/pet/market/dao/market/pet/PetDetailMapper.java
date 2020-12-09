package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.vo.PetVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 宠物明细
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:09 2020/3/18
 **/
@Mapper
public interface PetDetailMapper {
    /**
     * <p>
     * 通过宠物编号查询宠物明细
     * </p>
     *
     * @param petNo 宠物编号
     * @return com.yangwang.application.pet.market.model.vo.PetVo
     * @author LiuXiangLin
     * @date 9:09 2020/3/18
     **/
    PetVo get(String petNo);
}
