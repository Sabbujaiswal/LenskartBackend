package com.lenskartapp.service;

import com.lenskartapp.exceptions.FrameNotFoundException;
import com.lenskartapp.model.Frame;

import java.util.List;

public interface IFrameService {

    Frame addFrame(Frame frame);

    void updateFrame(Frame frame);

    void deleteFrame(int frameId) throws FrameNotFoundException;

    List<Frame> getAll();

    Frame getById(int frameId) throws FrameNotFoundException;


    List<Frame> getByLessPrice(double price);


    List<Frame> getByFrameSizeAndType(String frameSize, String type) throws FrameNotFoundException;


    List<Frame> getByFrameBrand(String brand) throws FrameNotFoundException;

    List<Frame> getByGenderAndFrameSize(String gender, String size) throws FrameNotFoundException;

    List<Frame> getByCategoryAndGender(String categoryName, String gender) throws FrameNotFoundException;

    List<Frame> getByCategory(String category) throws FrameNotFoundException;

    List<Frame> getByCategoryAndShape(String categoryName, String shape) throws FrameNotFoundException;

    List<Frame> getByLensBrand(String lensBrand) throws FrameNotFoundException;

    List<Frame> getByFrameNameAndGenderAndShape(String name, String gender, String shape) throws FrameNotFoundException;

    List<Frame> getByShape(String shape) throws FrameNotFoundException;

    List<Frame> getByCategoryAndColor(String category, String color) throws FrameNotFoundException;

    List<Frame> getByLensPower(double lenspower) throws FrameNotFoundException;

    List<Frame> getByFrameSizeAndLensPower(String size, double lensPower) throws FrameNotFoundException;

    List<Frame> getByMaterial(String material) throws FrameNotFoundException;

    List<Frame> getByShapePriceType(String shape, double price, String type) throws FrameNotFoundException;

    List<Frame> getByShapeAndLensPower(String shape, String lensPower) throws FrameNotFoundException;

    List<Frame> getByColorAndMaterial(String color, String material) throws FrameNotFoundException;

    List<Frame> getByPriceLessThanAndFrameBrand(double price, String brand) throws FrameNotFoundException;

    List<Frame> getByColorPriceAndLensPower(String color, double price, String lensPower) throws FrameNotFoundException;

    List<Frame> getByGenderAndType(String gender, String type) throws FrameNotFoundException;

    List<Frame> getByFrameSizeAndBrand(String size, String brand) throws FrameNotFoundException;

    List<Frame> getByLensBrandAndFrameSize(String lensBrand, String frameSize) throws FrameNotFoundException;


    List<Frame> getByLensPowerAndFrameBrand(String lensPower, String frameBrand) throws FrameNotFoundException;

    List<Frame> getByTypeAndPriceLessThan(String type, double price) throws FrameNotFoundException;


}
