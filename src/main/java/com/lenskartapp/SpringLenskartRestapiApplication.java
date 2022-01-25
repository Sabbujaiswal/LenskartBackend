package com.lenskartapp;

import com.lenskartapp.model.*;
import com.lenskartapp.service.IBrandService;
import com.lenskartapp.service.ICategoryService;
import com.lenskartapp.service.IFrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringLenskartRestapiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringLenskartRestapiApplication.class, args);
    }

    IFrameService frameService;

    @Autowired
    public void setLenskartService(IFrameService frameService) {
        this.frameService = frameService;
    }

    IBrandService brandService;

    @Autowired
    public void setBrandService(IBrandService brandService) {
        this.brandService = brandService;
    }

    ICategoryService categoryService;

    @Autowired
    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

//        Brand brand2 = new Brand(Shape.ROUND, Type.BLUERAY, "ray-ban");
//        Category category3 = new Category("Reading", "Plastic");
//        Set<Category> categories = new HashSet<>(Arrays.asList(category3));
//        Lens lens1 = new Lens("John Jacobs", 0.75);
//
//        Frame frame = new Frame("Float Pop", "medium", "blue", ShopBy.MEN, 1350, lens1, brand2,"assets/reading/blueray", categories,5);



        Brand brand1 = new Brand(Shape.ROUND, Type.AVITORSUNGLASSES, "OAKLEY");
        Category category2 = new Category("Sun Glasses", "Fiber");
        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
        Lens lens2 = new Lens("Oakley", 0.5);

        Frame frame = new Frame("Pilat Style", "Medium", "gray", ShopBy.MEN, 1200, lens2,5.0  , brand1,"assets/sunglass/oakley" ,categories1 );


        frameService.addFrame(frame);


    }
}
