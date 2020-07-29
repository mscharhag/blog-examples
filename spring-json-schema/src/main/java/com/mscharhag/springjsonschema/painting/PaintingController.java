package com.mscharhag.springjsonschema.painting;

import com.mscharhag.springjsonschema.validation.ValidJson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mscharhag.springjsonschema.SchemaLocations.PAINTING;

@RestController
public class PaintingController {

    @PostMapping("/paintings")
    public ResponseEntity<Void> createPainting(@ValidJson(PAINTING) Painting painting) {
        System.out.println("Validated painting: " + painting);
        return ResponseEntity.ok().build();
    }
}
