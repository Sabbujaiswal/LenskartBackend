package com.lenskartapp.service;

import com.lenskartapp.exceptions.FrameNotFoundException;
import com.lenskartapp.model.Frame;
import com.lenskartapp.model.Gender;
import com.lenskartapp.model.Shape;
import com.lenskartapp.model.Type;
import com.lenskartapp.repository.IFrameRepository;
import net.bytebuddy.TypeCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.net.Proxy;
import java.util.List;
import java.util.Locale;

@Service
public class FrameServiceImpl implements IFrameService {

    IFrameRepository frameRepository;

    @Autowired
    public void setLenskartRepository(IFrameRepository frameRepository) {
        this.frameRepository = frameRepository;
    }

    @Override
    public Frame addFrame(Frame frame) {
        return frameRepository.save(frame);
    }

    @Override
    public void updateFrame(Frame frame) {
        frameRepository.save(frame);

    }

    @Override
    public void deleteFrame(int frameId) {
        frameRepository.deleteById(frameId);
    }

    @Override
    public List<Frame> getAll() {

        return frameRepository.findAll();
    }

    @Override
    public Frame getById(int frameId) throws FrameNotFoundException {
        Frame frame = null;
        return frameRepository.findById(frameId).orElseThrow(() -> new FrameNotFoundException("Frame with is Id not found"));


    }

    @Override
    public List<Frame> getByLessPrice(double price) throws FrameNotFoundException {
        Sort sort = Sort.by("price");
        List<Frame> frames = frameRepository.findByPriceLessThan(price, sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with in this price");
        }
        return frames;
    }

    @Override
    public List<Frame> getByFrameSizeAndType(String frameSize, String type) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByFrameSizeAndType(frameSize.toLowerCase(), Type.valueOf(type.toUpperCase()), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this size and type");
        }
        return frames;
    }

    @Override
    public List<Frame> getByFrameBrand(String brand) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByFrameBrand(brand.toLowerCase(), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this brand");
        }
        return frames;
    }

    @Override
    public List<Frame> getByGenderAndFrameSize(String gender, String size) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.getByGenderAndFrameSize(Gender.valueOf(gender.toUpperCase()), size.toLowerCase(), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this size and gender");
        }
        return frames;
    }

    @Override
    public List<Frame> getByCategoryAndGender(String categoryName, String gender) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByCategoryAndGender(categoryName.toLowerCase(), Gender.valueOf(gender.toUpperCase()), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this category and gender");
        }
        return frames;
    }

    @Override
    public List<Frame> getByCategory(String category) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByCategory(category, sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this category");
        }
        return frames;
    }

    @Override
    public List<Frame> getByCategoryAndShape(String categoryName, String shape) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByCategoryAndShape(categoryName.toLowerCase(), Shape.valueOf(shape.toUpperCase()), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this size and gender");
        }
        return frames;
    }

    @Override
    public List<Frame> getByLensBrand(String lensBrand) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByLensBrand(lensBrand.toLowerCase(), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this lens brand");
        }
        return frames;
    }

    @Override
    public List<Frame> getByFrameNameAndGenderAndShape(String name, String gender, String shape) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByFrameNameAndGenderAndShape(name.toLowerCase(), Gender.valueOf(gender.toUpperCase()), Shape.valueOf(shape.toUpperCase()), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this name and shape and gender");
        }
        return frames;
    }

    @Override
    public List<Frame> getByShape(String shape) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByShape(Shape.valueOf(shape.toUpperCase()), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this shape");
        }
        return frames;
    }

    @Override
    public List<Frame> getByCategoryAndColor(String category, String color) throws FrameNotFoundException {

        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByCategoryAndColor(category.toLowerCase(), color.toLowerCase(), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this category and color");
        }
        return frames;
    }

    @Override
    public List<Frame> getByLensPower(double lenspower) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByLensPower(lenspower, sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this lenspower");
        }
        return frames;
    }

    @Override
    public List<Frame> getByFrameSizeAndLensPower(String size, double lensPower) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByFrameSizeAndLensPower(size.toLowerCase(), lensPower, sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this size and lenspower");
        }
        return frames;
    }

    @Override
    public List<Frame> getByMaterial(String material) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByMaterial(material.toLowerCase(), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this material");
        }
        return frames;
    }

    @Override
    public List<Frame> getByColorAndMaterial(String color, String material) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByColorAndMaterial(color.toLowerCase(), material.toLowerCase(), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this color and material");
        }
        return frames;
    }

    @Override
    public List<Frame> getByPriceLessThanAndFrameBrand(double price, String brand) throws FrameNotFoundException {
        Sort sort = Sort.by("price").descending();
        List<Frame> frames = frameRepository.findByPriceLessThanAndFrameBrand(price, brand.toLowerCase(), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this price and frame-brand");
        }
        return frames;
    }

    @Override
    public List<Frame> getByColorPriceAndLensPower(String color, double price, String lensPower) throws FrameNotFoundException {
        Sort sort = Sort.by("price").descending();
        List<Frame> frames = frameRepository.findByColorPriceAndLensPower(color.toLowerCase(), price, lensPower.toLowerCase(), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this color,price,lenspower");
        }
        return frames;
    }

    @Override
    public List<Frame> getByGenderAndType(String gender, String type) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByGenderAndType(gender.toLowerCase(), Type.valueOf(type.toUpperCase()), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this gender and type");
        }
        return frames;
    }

    @Override
    public List<Frame> getByFrameSizeAndBrand(String size, String brand) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByFrameSizeAndBrand(size.toLowerCase(), brand.toLowerCase(), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this size and brand");
        }
        return frames;
    }

    @Override
    public List<Frame> getByLensBrandAndFrameSize(String lensBrand, String frameSize) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByLensBrandAndFrameSize(lensBrand.toLowerCase(), frameSize.toLowerCase(), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this brand and frame-size");
        }
        return frames;
    }

    @Override
    public List<Frame> getByShapePriceType(String shape, double price, String type) {
        Sort sort = Sort.by("price");
        List<Frame> frames = frameRepository.findByShapePriceType(Shape.valueOf(shape.toUpperCase()), price, Type.valueOf(type.toUpperCase()), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with in this price and shape");
        }
        return frames;
    }

    @Override
    public List<Frame> getByLensPowerAndFrameBrand(String lensPower, String frameBrand) throws FrameNotFoundException {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByLensPowerAndFrameBrand(lensPower.toLowerCase(), frameBrand.toLowerCase(), sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this lenspower and frame brand");
        }
        return frames;
    }

    @Override
    public List<Frame> getByTypeAndPriceLessThan(String type, double price) throws FrameNotFoundException {
        Sort sort = Sort.by("price");
        List<Frame> frames = frameRepository.findByTypeAndPriceLessThan(Type.valueOf(type.toUpperCase()), price, sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this price and type");
        }
        return frames;
    }

    @Override
    public List<Frame> getByShapeAndLensPower(String shape, String lensPower) {
        Sort sort = Sort.by("name");
        List<Frame> frames = frameRepository.findByShapeAndLensPower(Shape.valueOf(shape.toUpperCase()), lensPower, sort);
        if (frames.isEmpty()) {
            throw new FrameNotFoundException("Frame not found with this shape and lenspower");
        }
        return frames;
    }


}
