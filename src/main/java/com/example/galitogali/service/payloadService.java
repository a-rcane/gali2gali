package com.example.galitogali.service;

import com.example.galitogali.entity.payLoad;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface payloadService {

    void deleteLoad(long itemId);

    List<payLoad> getAllLoads(String sortBy,String sortDirection,String descriptionLike,String nameLike,Integer offset,Integer limit);

    Optional<payLoad> getLoadsById(long itemId);

    payLoad addLoad(payLoad load);

    payLoad updateLoad(payLoad load, long itemId);

}
