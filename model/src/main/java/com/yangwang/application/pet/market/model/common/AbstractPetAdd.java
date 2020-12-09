package com.yangwang.application.pet.market.model.common;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className AbstractPetAdd
 * @date 2020/3/13 9:48
 **/
public abstract class AbstractPetAdd {
    Pet pet;

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    /**
     * <p>
     * 给每个类添加pet对象
     * </p>
     *
     * @param abstractPetAddLis 集合
     * @param pet               宠物对象
     * @return void
     * @author LiuXiangLin
     * @date 11:01 2020/3/13
     **/
    public static void addPetToList(List<? extends AbstractPetAdd> abstractPetAddLis, Pet pet) {
        if (CollectionUtils.isNotEmpty(abstractPetAddLis)) {
            for (AbstractPetAdd abstractPetAdd : abstractPetAddLis) {
                abstractPetAdd.setPet(pet);
            }
        }
    }
}
