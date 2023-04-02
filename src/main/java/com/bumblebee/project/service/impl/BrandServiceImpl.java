package com.bumblebee.project.service.impl;

import com.bumblebee.project.dto.BrandDTO;
import com.bumblebee.project.exception.AdminNotFoundException;
import com.bumblebee.project.exception.ValidateException;
import com.bumblebee.project.model.Brand;
import com.bumblebee.project.repository.BrandRepository;
import com.bumblebee.project.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Brand createBrand(BrandDTO brandDTO) {

        System.out.println("brandDTO :"+brandDTO.getBrandName());
        if (brandRepository.existsByBrand_name(brandDTO.getBrandName()) == 1){
            throw new ValidateException("This Brand  Already Exists");
        }
        Brand brand = modelMapper.map(brandDTO, Brand.class);
        return brandRepository.save(brand);
    }

    @Override
    public Brand getBrandById(Long brandId) {
        return brandRepository.findById(brandId).orElseThrow(() -> new AdminNotFoundException("Brand not found with Brand ID: " + brandId));
    }

    @Override
    public Brand updateBrand(Long brandId, BrandDTO brandDTO) {
        Brand brand = getBrandById(brandId);
        brand.setBrandName(brandDTO.getBrandName());
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Long brandId) {
        Brand brand = getBrandById(brandId);
        brandRepository.delete(brand);
    }

    @Override
    public List<Brand> getAllBrand() {
     return brandRepository.findAll();
    }

    @Override
    public Long getBrandCount() {
        return brandRepository.count();
    }

}
