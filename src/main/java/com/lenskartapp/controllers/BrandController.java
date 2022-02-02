package com.lenskartapp.controllers;

import com.lenskartapp.exceptions.CategoryNotFoundException;
import com.lenskartapp.model.Brand;
import com.lenskartapp.model.Category;
import com.lenskartapp.service.IBrandService;
import com.lenskartapp.service.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("brand-api")
public class BrandController {
    private Logger logger = LoggerFactory.getLogger(BrandController.class);

    IBrandService brandService;

    @Autowired
    public void setBrandService(IBrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping("/brands")
    ResponseEntity<Brand> addBrand(@RequestBody Brand brand) {
        logger.debug("inside add brand method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding brand");
        Brand nbrand = brandService.addBrand(brand);
        logger.info(" add brand" + nbrand);
        return ResponseEntity.status(HttpStatus.CREATED).body(nbrand);
    }

    @PutMapping("/brands")
    ResponseEntity<Void> updateBrand(@RequestBody Brand brand) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating brand");
        brandService.updateBrand(brand);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/brands/id/{brandid}")
    public ResponseEntity<String> deletBrand(@PathVariable("brandid") int brandId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating brand");
        brandService.deleteBrand(brandId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    @GetMapping("/totalbrands")
    public ResponseEntity<List<Brand>> getAll() {
        logger.debug("inside all");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All brands");
        List<Brand> brands = brandService.getAll();
        logger.info("got one " + brands);
        return ResponseEntity.ok().headers(headers).body(brands);
    }

    @GetMapping("/brands/id/{brandid}")
    public ResponseEntity<Brand> getById(@PathVariable("brandid") int brandId) {
        logger.debug("inside id");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Brand by id");
        Brand nbrand = brandService.getById(brandId);
        logger.info("got one " + nbrand);
        return ResponseEntity.ok().headers(headers).body(nbrand);
    }
    @GetMapping("/brands/brand/{brand}")
    public ResponseEntity<Brand> getByBrandName(@PathVariable("brand") String brandName) {
        logger.debug("inside id");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Brand by name");
        Brand nbrand = brandService.getByBrandName(brandName);
        logger.info("got one " + nbrand);
        return ResponseEntity.ok().headers(headers).body(nbrand);
    }


}
