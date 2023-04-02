package com.bumblebee.project.service;

import com.bumblebee.project.dto.BrandDTO;
import com.bumblebee.project.model.Brand;

import java.util.List;

public interface BrandService {
    Brand createBrand(BrandDTO brandDTO);
    Brand getBrandById(Long brandId);
    Brand updateBrand(Long brandId, BrandDTO brandDTO);
    void deleteBrand(Long brandId);
    List<Brand> getAllBrand();

    Long getBrandCount();
}


