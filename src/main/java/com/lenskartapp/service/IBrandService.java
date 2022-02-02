package com.lenskartapp.service;

import com.lenskartapp.exceptions.BrandNotFoundException;
import com.lenskartapp.model.Brand;

import java.util.List;

public interface IBrandService {

    Brand addBrand(Brand brand);


    void updateBrand(Brand brand);

    void deleteBrand(int brandId) throws BrandNotFoundException;


    Brand getById(int brandId);

    Brand getByBrandName(String brandName);

    List<Brand> getAll();

}
