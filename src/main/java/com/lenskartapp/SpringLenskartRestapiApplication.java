package com.lenskartapp;

import com.lenskartapp.model.*;
import com.lenskartapp.service.IBrandService;
import com.lenskartapp.service.ICategoryService;
import com.lenskartapp.service.IFrameService;
import com.lenskartapp.service.IUserService;
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
    IUserService userService;

    @Autowired
    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

        brandService.getAll().forEach(System.out::println);

//        Brand brand2 = new Brand(Shape.ROUND, Type.BLUERAY, "ray-ban");
//        Category category3 = new Category("Reading", "Plastic");
//        Set<Category> categories = new HashSet<>(Arrays.asList(category3));
//        Lens lens1 = new Lens("John Jacobs", 0.75);
//        Frame frame=new Frame("Float Pop","Medium","Blue",ShopBy.MEN,1350,lens1,5.0,brand2,"assets/reading/g1.jpg",categories);
//        frameService.addFrame(frame);

//        Brand brand1 = new Brand(Shape.ROUND, Type.AVITORSUNGLASSES, "OAKLEY");
//        Category category2 = new Category("Sun Glasses", "Fiber");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Oakley", 0.5);
//        Frame frame=new Frame("Pop Float","Small","Grey",ShopBy.KIDS,1000,lens2,4.6,brand1,"assets/sunglass/g2.jpg",categories1);
//
//
//       frameService.addFrame(frame);

//        Brand brand2 = new Brand(Shape.CATEYEGLASSES, Type.ASPHERICALLENS, "Fasttrack");
//        Category category2 = new Category("Computer Glasses", "Fiber");
//        Set<Category> categories2 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Oakley", 0.5);
//        Frame frame=new Frame("Sphere Style","Medium","Black",ShopBy.UNISEX,2500,lens2,4.7,brand2,"assets/comglass/g3.jpg",categories2);
//
//        frameService.addFrame(frame);

//        Brand brand1 = new Brand(Shape.OVAL, Type.AVITORSUNGLASSES, "Focus");
//        Category category2 = new Category("Aqualens", "Glass");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Focus", 0.5);
//
//        Frame frame=new Frame("Convex Style","Medium","LightPink",ShopBy.WOMEN,2200,lens2,4.3,brand1,"assets/sunglass/g4.jpg",categories1);
//
//        frameService.addFrame(frame);

//        Brand brand1 = new Brand(Shape.CATEYEGLASSES, Type.BROWLINE, "Hooper");
//        Category category2 = new Category("Sun Glasses", "Fiber");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("hooper", 0.5);
//        Frame frame= new Frame("Oval Style","Small","Shadow grey",ShopBy.MEN,1800,lens2,4.3,brand1,"assets/sunglass1/g5.jpg",categories1);
//
//    frameService.addFrame(frame);
//
//        Brand brand1 = new Brand(Shape.RECTANGLE, Type.ASPHERICALLENS, "Lenskart BLU");
//        Category category2 = new Category("Normal Glass ", "Ancient Steel");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Lenskart blu", 0.5);
//        Frame frame=new Frame("Full Rim Style","Medium","Brown",ShopBy.UNISEX,4000,lens2,4.9,brand1,"assets/normalglass/g6.jpg",categories1);
//
//        frameService.addFrame(frame);

//        Brand brand1 = new Brand(Shape.CATEYEGLASSES, Type.ASPHERICALLENS, "Lenskart Air");
//        Category category2 = new Category("Reading", "Fiber");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Lenskart Air", 0.5);
//        Frame frame=new Frame("Half Rim Style","Medium", "skyblue",ShopBy.WOMEN,3500,lens2,3.9,brand1,"assets/readglass/g7.jpg" ,categories1);
//        frameService.addFrame(frame);

//
//        Brand brand1 = new Brand(Shape.OVAL, Type.PHOTOCHROMIC, "John Jacobs");
//        Category category2 = new Category("Normal glass", "Glass");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("John Jacobs", 1.5);
//        Frame frame=new Frame("Cat Style", "Medium", "Light grey", ShopBy.MEN, 3000, lens2,4.6,brand1,"assets/normalglass/g8.jpg",categories1);
//        frameService.addFrame(frame);

//        Brand brand1 = new Brand(Shape.RECTANGLE, Type.TRIVE, "Vincent Chase");
//        Category category2 = new Category("reading", "Fiber");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Vincent Chase", 0.0);
//
//        Frame frame = new Frame("Convex  Style", "small", "pink", ShopBy.KIDS, 1200, lens2,5.0  , brand1,"assets/reading2/g9.jpg" ,categories1 );
//        frameService.addFrame(frame);


//        Brand brand1 = new Brand(Shape.SQUARE, Type.BLUERAY, "POloroid");
//        Category category2 = new Category("Reading", "Fiber");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Poloroid", 0.5);
//
//        Frame frame = new Frame("Fully Rimmed Style", "Medium", "light pink", ShopBy.WOMEN, 2200, lens2,4.6  , brand1,"assets/reading3glass/g10.jpg" ,categories1 );
//
//
//        frameService.addFrame(frame);




        //---------> user part--------------------<
        //  public User(String userName, String password, Integer mobile, String email, String address, Integer zipcode) {
      //  User user=new User("Divya","divya1000","1234577809","divya@email.com","Housing Board Colony",515001);
        //userService.addUser(user);

        User user=new User("Nayeem","nayeem1000","9087651232","nayeem@email.com","Vijayawada",515303);
        //userService.addUser(user);
       // User user=new User("Thanmayi","thanu09","3456788920","thanmayi@email.com","Madhapur",515004);
     //userService.addUser(user);
//
//        User user=new User("Sharmila","sharmi08","2334908765","sharmi@email.com","Kukatpally",515009);
//        userService.addUser(user);

//        Brand brand1 = new Brand(Shape.RECTANGLE, Type.TRIVE, "Optic");
//        Category category2 = new Category("Shades", "Fiber");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Optic", 1.5);
//        Frame frame=new Frame("convex","Medium","Black",ShopBy.UNISEX,1500,lens2,4.8,brand1,"assets/shades/g11.jpg",categories1);
//
//
//        frameService.addFrame(frame);

//        Brand brand1 = new Brand(Shape.SQUARE, Type.BLUERAY, "Ray-Ban");
//        Category category2 = new Category("Full Rim Aviators", "Fiber");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Ray-Ban", 0.0);
//        Frame frame=new Frame("Rim Shape","Medium","Brown",ShopBy.MEN,3000,lens2,4.9,brand1,"assets/fullrim/g12.jpg",categories1);
//
//
//        frameService.addFrame(frame);


//        Brand brand1 = new Brand(Shape.CATEYEGLASSES, Type.PHOTOCHROMIC, "Armani");
//        Category category2 = new Category("Googles", "Fiber");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Armani", 1.5);
//        Frame frame=new Frame("Round","Medium","Blue",ShopBy.WOMEN,2000,lens2,4.5,brand1,"assets/goggles/g13.jpg",categories1);
//
//
//        frameService.addFrame(frame);

//        Brand brand1 = new Brand(Shape.OVAL, Type.ASPHERICALLENS, "Poloroid");
//        Category category2 = new Category("Glasses", "Glass");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Polaroid", 1.5);
//        Frame frame=new Frame("Polo","Medium","Black",ShopBy.UNISEX,3500,lens2,5.0,brand1,"assets/glass/g14.jpg",categories1);
//        frameService.addFrame(frame);

//        Brand brand1 = new Brand(Shape.OVAL, Type.BROWLINE, "Farenheit");
//        Category category2 = new Category("Sun shades", "Fiber");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Farenheit", 1.5);
//        Frame frame=new Frame("Shades","Medium","Grey",ShopBy.WOMEN,4000,lens2,4.6,brand1,"assets/sunshades/g15.jpg",categories1);
//        frameService.addFrame(frame);

//        Brand brand1 = new Brand(Shape.OVAL, Type.AVITORSUNGLASSES, "Fasttrack");
//        Category category2 = new Category("Reading", "Glass");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("FastTrack", 1.5);
//        Frame frame=new Frame("Fasttrack","small","Pink",ShopBy.KIDS,2000,lens2,5.0,brand1,"assets/reading/g16.jpg",categories1);
//        frameService.addFrame(frame);

//        Brand brand1 = new Brand(Shape.ROUND, Type.BROWLINE, "Poloroid");
//        Category category2 = new Category("sunshades", "Fiber");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Poloroid", 0.5);
//        Frame frame=new Frame("Poloroid","small","light blue",ShopBy.KIDS,2500,lens2,4.8,brand1,"assets/sunshades/g17.jpg",categories1);
//        frameService.addFrame(frame);
//
//        Brand brand1 = new Brand(Shape.RECTANGLE, Type.PHOTOCHROMIC, "Oakley");
//        Category category2 = new Category("Glasses", "glass");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Oakley", 0.5);
//        Frame frame=new Frame("Fully rimmed","medium","light green",ShopBy.WOMEN,2500,lens2,3.8,brand1,"assets/glasses/g18.jpg",categories1);
//        frameService.addFrame(frame);

//        Brand brand1 = new Brand(Shape.ROUND, Type.ASPHERICALLENS, "IDEE");
//        Category category2 = new Category("protection", "glass");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("IDEE", 0.5);
//        Frame frame=new Frame("Half rimmed","medium","light grey",ShopBy.MEN,2800,lens2,4.7,brand1,"assets/protection/g19.jpg",categories1);
//       frameService.addFrame(frame);

//        Brand brand1 = new Brand(Shape.CATEYEGLASSES, Type.PHOTOCHROMIC, "Vogue");
//        Category category2 = new Category("Glasses", "glass");
//        Set<Category> categories1 = new HashSet<>(Arrays.asList(category2));
//        Lens lens2 = new Lens("Vogue", 0.5);
//        Frame frame=new Frame("Fully rimmed","medium","light brown",ShopBy.WOMEN,4500,lens2,5.0,brand1,"assets/glasses/g20.jpg",categories1);
//        frameService.addFrame(frame);
//












    }
}
