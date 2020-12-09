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
 * @className AbstractItemAdd
 * @date 2020/4/8 17:58
 **/
public abstract class AbstractItemAdd {
    /**
     * 商品
     */
    Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * <p>
     * 给每个类添加item对象
     * </p>
     *
     * @param abstractItemAdds 集合
     * @param item             宠物对象
     * @return void
     * @author LiuXiangLin
     * @date 11:01 2020/3/13
     **/
    public static void addPetToList(List<? extends AbstractItemAdd> abstractItemAdds, Item item) {
        if (CollectionUtils.isNotEmpty(abstractItemAdds)) {
            for (AbstractItemAdd abstractItemAdd : abstractItemAdds) {
                abstractItemAdd.setItem(item);
            }
        }
    }
}
