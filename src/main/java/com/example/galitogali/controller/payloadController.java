package com.example.galitogali.controller;

import com.example.galitogali.entity.payLoad;
import com.example.galitogali.service.payloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class payloadController {

    @Autowired
    private payloadService Loads;

    @GetMapping("host/v1/items")
    public List<payLoad> getAllLoads(@RequestParam(name = "sortBy", required = false)String sortBy,
                                     @RequestParam(name = "sortDirection", required = false)String sortDirection,
                                     @RequestParam(name = "descriptionLike", required = false)String descriptionLike,
                                     @RequestParam(name = "nameLike", required = false)String nameLike,
                                     @RequestParam(name = "offset", required = false)Integer offset,
                                     @RequestParam(name = "limit", required = false)Integer limit
                                     ){
        return this.Loads.getAllLoads(sortBy, sortDirection, descriptionLike, nameLike, offset, limit);
    }

    @GetMapping("host/v1/items/{itemId}")
    public Optional<payLoad> getLoadsById(@PathVariable String itemId) {
        return this.Loads.getLoadsById(Long.parseLong(itemId));
    }


    @PostMapping("host/v1/items")
    public payLoad addLoad(@RequestBody payLoad load) {
        return this.Loads.addLoad(load);
    }


    @PatchMapping("host/v1/items/id/{itemId}")
    public payLoad updateLoad(@RequestBody payLoad load, @PathVariable String itemId){
        return this.Loads.updateLoad(load, Long.parseLong(itemId));
    }


    @DeleteMapping("host/v1/items/id/{itemId}")
    public ResponseEntity<HttpStatus> deleteLoad(@PathVariable String itemId) {
        try {
            this.Loads.deleteLoad(Long.parseLong(itemId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
