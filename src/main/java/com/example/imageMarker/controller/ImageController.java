package com.example.imageMarker.controller;

import com.example.imageMarker.mark.MarkConfig;
import com.example.imageMarker.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/watermark")
    public ResponseEntity<Map<String, String>> addWatermark(@RequestBody Map<String, Object> request) {
        try {
            String base64Image = (String) request.get("image");

            Map<String, Object> markConfigMap = (Map<String, Object>) request.get("markConfig");
            String text = (String) markConfigMap.get("text");
            int posX = (Integer) markConfigMap.get("posX");
            int posY = (Integer) markConfigMap.get("posY");
            String color = (String) markConfigMap.get("color");
            int fontSize = (Integer) markConfigMap.get("fontSize");

            MarkConfig config = new MarkConfig(text, posX, posY, color, fontSize);

            String watermarkedImage = imageService.addWatermark(base64Image, config);
            return ResponseEntity.ok(Map.of("image", watermarkedImage));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Error processing image"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Unexpected error occurred"));
        }
    }
}

