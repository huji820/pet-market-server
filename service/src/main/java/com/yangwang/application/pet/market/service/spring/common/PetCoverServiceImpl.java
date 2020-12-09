package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.dao.market.pet.PetCoverMapper;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.model.common.PetCover;
import com.yangwang.application.pet.market.service.facade.common.PetCoverService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetCoverServiceImpl
 * @date 2020/3/12 16:55
 **/
@Service
public class PetCoverServiceImpl implements PetCoverService {
    @Resource
    PetCoverMapper petCoverMapper;

    @Override
    public int save(PetCover petCover) {
        return petCoverMapper.save(petCover);
    }

    @Override
    public int delete(String petNo) {
        return petCoverMapper.delete(petNo);
    }

    @Override
    public List<PetCover> getByPetNo(String petNo) {
        return petCoverMapper.getByPetNo(petNo);
    }

    @Override
    public int saveList(List<PetCover> petCovers) {
        if (CollectionUtils.isNotEmpty(petCovers)) {
            return petCoverMapper.saveList(petCovers);
        }
        return 0;
    }

    @Override
    public int updateList(List<PetCover> petCoverList, Pet pet) {
        delete(pet.getPetNo());
        petAddToList(petCoverList, pet);
        saveList(petCoverList);
        return 1;
    }

    /**
     * <p>
     * 将宠物信息添加到列表中
     * </p>
     *
     * @param petCoverList 宠物图片列表
     * @param pet          宠物对象
     * @return void
     * @author LiuXiangLin
     * @date 9:35 2020/3/22
     **/
    private void petAddToList(List<PetCover> petCoverList, Pet pet) {
        if (CollectionUtils.isNotEmpty(petCoverList)) {
            for (PetCover petCover : petCoverList) {
                petCover.setPet(pet);
            }
        }
    }
}
