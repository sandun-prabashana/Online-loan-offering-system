package com.bumblebee.project.controller;

import com.bumblebee.project.dto.BrandDTO;
import com.bumblebee.project.model.Brand;
import com.bumblebee.project.service.BrandService;
import com.bumblebee.project.utility.Util2.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


    @PostMapping
    public ResponseEntity<Brand> createBrand(@Valid @RequestBody BrandDTO brandDTO) {
        System.out.println("brandDTO 1 :"+brandDTO.getBrandName());
        Brand brand = brandService.createBrand(brandDTO);
        return new ResponseEntity(new StandardResponse("200", "Brand Create successfully", brandDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{brand_id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long brand_id) {
        Brand brand = brandService.getBrandById(brand_id);
        return new ResponseEntity(new StandardResponse("200", "Brand retrieved successfully", brand), HttpStatus.OK);
    }

    @PutMapping("/{brand_id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long brand_id, @RequestBody BrandDTO brandDTO) {
        Brand brand = brandService.updateBrand(brand_id, brandDTO);
        return new ResponseEntity(new StandardResponse("200", "Brand updated successfully", brand), HttpStatus.OK);
    }

    @DeleteMapping("/{brand_id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long brand_id) {
        brandService.deleteBrand(brand_id);
        return new ResponseEntity(new StandardResponse("200", "Brand deleted successfully", brand_id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrand() {
        List<Brand> brand = brandService.getAllBrand();
        return new ResponseEntity(new StandardResponse("200", "Brand retrieved successfully", brand), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCustomerCount() {
        Number count = brandService.getBrandCount();
        return new ResponseEntity(new StandardResponse("200", "Brand Count", count), HttpStatus.OK);
    }
}
