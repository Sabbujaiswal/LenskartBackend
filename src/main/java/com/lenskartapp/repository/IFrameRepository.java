package com.lenskartapp.repository;

import com.lenskartapp.exceptions.FrameNotFoundException;
import com.lenskartapp.model.Frame;
import com.lenskartapp.model.ShopBy;
import com.lenskartapp.model.Shape;
import com.lenskartapp.model.Type;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFrameRepository extends JpaRepository<Frame, Integer> {
    //Derived Queries
    List<Frame> findByPriceLessThan(double price, Sort sort) throws FrameNotFoundException;

    List<Frame> getByGenderAndFrameSize(ShopBy gender, String size, Sort sort) throws FrameNotFoundException;

    //Custom Queries
    @Query("from Frame f inner join f.brand b where b.brandName like %?1%")
    List<Frame> findByFrameBrand(String brand, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.categories c where f.color like %?1% and c.material=?2")
    List<Frame> findByColorAndMaterial(String color, String material, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.brand b where f.frameSize=?1 and b.type=?2")
    List<Frame> findByFrameSizeAndType(String frameSize, Type type, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.brand b where f.price<=?1 and b.brandName like %?2%")
    List<Frame> findByPriceLessThanAndFrameBrand(double price, String brand, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.lens l where f.color like %?1% and f.price<=?2 and l.lensPower=?3")
    List<Frame> findByColorPriceAndLensPower(String color, double price, String lensPower, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.brand b where f.gender=?1 and b.type=?2")
    List<Frame> findByGenderAndType(String gender, Type type, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.brand b where f.frameSize=?1 and b.brandName=?2 ")
    List<Frame> findByFrameSizeAndBrand(String size, String brand, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.lens l where l.brand=?1 and f.frameSize=?2 ")
    List<Frame> findByLensBrandAndFrameSize(String lensBrand, String frameSize, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.lens l inner join f.brand b where l.lensPower=?1 and b.brandName=?2")
    List<Frame> findByLensPowerAndFrameBrand(String lensPower, String frameBrand, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.brand b where b.type=?1 and f.price<=?2")
    List<Frame> findByTypeAndPriceLessThan(Type type, double price, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.brand b where b.shape=?1 and f.price<=?2 and b.type=?3")
    List<Frame> findByShapePriceType(Shape shape, double price, Type type, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.lens l inner join f.brand b where b.shape=?1 and l.lensPower=?2")
    List<Frame> findByShapeAndLensPower(Shape shape, String lensPower, Sort sort) throws FrameNotFoundException;


    @Query("from Frame f inner join f.categories c where c.categoryName=?1 and  f.gender=?2")
    List<Frame> findByCategoryAndGender(String categoryName, ShopBy gender, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.categories c where c.categoryName=?1")
    List<Frame> findByCategory(String category, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.categories c inner join f.brand b where c.categoryName=?1 and b.shape=?2")
    List<Frame> findByCategoryAndShape(String categoryName, Shape shape, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.lens l where l.brand=?1")
    List<Frame> findByLensBrand(String lensBrand, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.brand b where f.name=?1 and f.gender=?2 and b.shape=?3")
    List<Frame> findByFrameNameAndGenderAndShape(String name, ShopBy gender, Shape shape, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.brand b where b.shape=?1")
    List<Frame> findByShape(Shape shape, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.categories c where c.categoryName=?1 and f.color=?2")
    List<Frame> findByCategoryAndColor(String category, String color, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.lens l where l.lensPower=?1")
    List<Frame> findByLensPower(double lenspower, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.lens l where f.frameSize=?1 and l.lensPower=?2")
    List<Frame> findByFrameSizeAndLensPower(String size, double lensPower, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.categories c where c.material=?1")
    List<Frame> findByMaterial(String material, Sort sort) throws FrameNotFoundException;

    @Query("from Frame f inner join f.brand b where b.shape=?1 and f.price=?2 and b.type=?3")
    List<Frame> findByShapePriceType(Shape shape, double price, String type, Sort sort) throws FrameNotFoundException;


}
