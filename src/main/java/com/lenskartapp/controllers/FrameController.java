package com.lenskartapp.controllers;

import com.lenskartapp.exceptions.FrameNotFoundException;
import com.lenskartapp.model.Frame;
import com.lenskartapp.service.IFrameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("frame-response-api")
public class FrameController {
    private IFrameService frameService;
    @Autowired
    public void setFrameService(IFrameService frameService) {
        this.frameService = frameService;
    }

    @PostMapping("/frames")
    ResponseEntity<Frame> addFrame(@RequestBody Frame frame) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding frame");
        Frame nframe = frameService.addFrame(frame);
        return ResponseEntity.status(HttpStatus.CREATED).body(nframe);
    }

    @PutMapping("/frames")
    ResponseEntity<Void> updateFrame(@RequestBody Frame frame) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating frame");
        frameService.updateFrame(frame);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/frames/id/{frameid}")
    public ResponseEntity<String> deleteFrame(@PathVariable("frameid") int frameId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating frame");
        frameService.deleteFrame(frameId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    @GetMapping("/frames")
    public ResponseEntity<List<Frame>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all frames");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getAll();
        ResponseEntity<List<Frame>> frameResponse = new ResponseEntity(frames, headers, HttpStatus.OK);
        return frameResponse;
    }

    @GetMapping("/frames/id/{frameid}")
    public ResponseEntity<Frame> getById(@PathVariable("frameid") int frameId) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting by id");
        Frame frame = frameService.getById(frameId);
       
        return ResponseEntity.ok().headers(headers).body(frame);
    }

    @GetMapping("/frames/price/{price}")
    public ResponseEntity<List<Frame>> getByLessPrice(@PathVariable("price") double price) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames based on price");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByLessPrice(price);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/framesize/{size}/type/{type}")
    public ResponseEntity<List<Frame>> getByFrameSizeAndType(@PathVariable("size") String frameSize, @PathVariable("type") String type) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by frame size and type");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByFrameSizeAndType(frameSize, type);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/framebrand/{brand}")
    public ResponseEntity<List<Frame>> getByFrameBrand(@PathVariable("brand") String brand) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by frame-brand");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByFrameBrand(brand);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/color/{color}/material/{material}")
    public ResponseEntity<List<Frame>> getByColorAndMaterial(@PathVariable("color") String color, @PathVariable("material") String material) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by color matterial");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByColorAndMaterial(color, material);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/price/{price}/framebrand/{brand}")
    public ResponseEntity<List<Frame>> getByPriceLessThanAndFrameBrand(@PathVariable("price") double price, @PathVariable("brand") String brand) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by price, frame-brand");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByPriceLessThanAndFrameBrand(price, brand);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/color/{color}/price/{price}/lenspower/{lensPower}")
    public ResponseEntity<List<Frame>> getByColorPriceAndLensPower(@PathVariable("color") String color, @PathVariable("price") double price, @PathVariable("lensPower") String lensPower) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by color,price,lenspoower");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByColorPriceAndLensPower(color, price, lensPower);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/gender/{gender}/type/{type}")
    public ResponseEntity<List<Frame>> getByGenderAndType(@PathVariable("gender") String gender, @PathVariable("type") String type) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by gender, type");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByGenderAndType(gender, type);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/size/{size}/brand/{brand}")
    public ResponseEntity<List<Frame>> getByFrameSizeAndBrand(@PathVariable("size") String size, @PathVariable("brand") String brand) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by frame size, brand");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByFrameSizeAndBrand(size, brand);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/lensbrand/{lensbrand}/framesize/{framesize}")
    public ResponseEntity<List<Frame>> getByLensBrandAndFrameSize(@PathVariable("lensbrand") String lensBrand, @PathVariable("framesize") String frameSize) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by lens-brand,frame-size");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByLensBrandAndFrameSize(lensBrand, frameSize);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/lenspower/{lenspower}/framebrand/{framebrand}")
    public ResponseEntity<List<Frame>> getByLensPowerAndFrameBrand(@PathVariable("lenspower") String lensPower, @PathVariable("framebrand") String frameBrand) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by lens power,frame-brand");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByLensPowerAndFrameBrand(lensPower, frameBrand);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/type/{type}/price/{price}")
    public ResponseEntity<List<Frame>> getByTypeAndPriceLessThan(@PathVariable("type") String type, @PathVariable("price") double price) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by type,price");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByTypeAndPriceLessThan(type, price);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/gender/{gender}/size/{size}")
    public ResponseEntity<List<Frame>> getByGenderAndFrameSize(@PathVariable("gender") String gender, @PathVariable("size") String size) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by gender,size");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByGenderAndFrameSize(gender, size);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/categories/{categoryname}/gender/{gender}")
    public ResponseEntity<List<Frame>> getByCategoryAndGender(@PathVariable("categoryname") String categoryName, @PathVariable("gender") String gender) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by category name, gender");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByCategoryAndGender(categoryName, gender);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/categories/{categoryname}")
    public ResponseEntity<List<Frame>> getByCategory(@PathVariable("categoryname") String category) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by category");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByCategory(category);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/categories/{categoryname}/shape/{shape}")
    public ResponseEntity<List<Frame>> getByCategoryAndShape(@PathVariable("categoryname") String categoryName, @PathVariable("shape") String shape) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by category name, shape");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByCategoryAndShape(categoryName, shape);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/lensBrand/{lensbrand}")
    public ResponseEntity<List<Frame>> getByLensBrand(@PathVariable("lensbrand") String lensBrand) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by lensbrand");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByLensBrand(lensBrand);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/name/{name}/gender/{gender}/shape/{shape}")
    public ResponseEntity<List<Frame>> getByFrameNameAndGenderAndShape(String name, String gender, String shape) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by name,gender and shpe");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByFrameNameAndGenderAndShape(name, gender, shape);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/shape/{shape}")
    public ResponseEntity<List<Frame>> getByShape(@PathVariable("shape") String shape) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by shape");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByShape(shape);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/categories/{caterory}/color/{color}")
    public ResponseEntity<List<Frame>> getByCategoryAndColor(@PathVariable("category") String category, @PathVariable("color") String color) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by category,color");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByCategoryAndColor(category, color);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/lensPower/{lenspower}")
    public ResponseEntity<List<Frame>> getByLensPower(@PathVariable("lenspower") double lenspower) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by lenspower");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByLensPower(lenspower);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/size/{size}/lensPower/{lenspower}")
    public ResponseEntity<List<Frame>> getByFrameSizeAndLensPower(@PathVariable("size") String size, @PathVariable("lenspower") double lensPower) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by double,lenspower");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByFrameSizeAndLensPower(size, lensPower);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/material/{material}")
    public ResponseEntity<List<Frame>> getByMaterial(@PathVariable("material") String material) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by material");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByMaterial(material);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/shape/{shape}/price/{price}/type/{type}")
    public ResponseEntity<List<Frame>> getByShapePriceType(@PathVariable("shape") String shape, @PathVariable("price") double price, @PathVariable("type") String type) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames by shpe,price,type");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByShapePriceType(shape, price, type);
        return ResponseEntity.ok().headers(headers).body(frames);
    }

    @GetMapping("/frames/shape/{shape}/lensPower/{lenspower}")
    public ResponseEntity<List<Frame>> getByShapeAndLensPower(@PathVariable("shape") String shape, @PathVariable("lenspower") String lensPower) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the frames shape,lenspower");
        headers.add("info", "Frame details");
        List<Frame> frames = frameService.getByShapeAndLensPower(shape, lensPower);
        return ResponseEntity.ok().headers(headers).body(frames);
    }
}
