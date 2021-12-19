package com.lenskartapp.service;

import com.lenskartapp.exceptions.BrandNotFoundException;
import com.lenskartapp.model.Brand;
import com.lenskartapp.repository.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {

    IBrandRepository brandRepository;

    @Autowired
    public void setBrandRepository(IBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand addBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(int brandId) {
        brandRepository.deleteById(brandId);
    }

    @Override
    public Brand getById(int brandId) {
        return brandRepository.findById(brandId).orElseThrow(() -> new BrandNotFoundException("This brand not found"));
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
}
