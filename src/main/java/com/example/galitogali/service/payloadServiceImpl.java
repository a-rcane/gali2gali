package com.example.galitogali.service;

import com.example.galitogali.dao.LoadDao;
import com.example.galitogali.entity.payLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.w3c.dom.Node;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Filter;

@Service
public class payloadServiceImpl implements payloadService{

    @Autowired LoadDao loadDao;

    public payloadServiceImpl() {

    }

    @Override
    public void deleteLoad(long itemId) {
        payLoad del = loadDao.getById(itemId);
        loadDao.delete(del);
    }

    @Override
    public List<payLoad> getAllLoads(String sortBy,String sortDirection,String descriptionLike,String nameLike,Integer offset,Integer limit) {

        if(sortBy != null && sortDirection != null)
            return loadDao.findAll(Sort.by(Sort.Direction.valueOf(sortDirection),sortBy));

        else if(sortBy != null)
            return loadDao.findAll(Sort.by(Sort.Direction.ASC,sortBy));

        if(limit != null && offset != null) {
            Page<payLoad> pages = loadDao.findAll(PageRequest.of(offset, limit));
            List<payLoad> loadsList = pages.getContent();
            return loadsList;
        }

        if(descriptionLike != null) return loadDao.findByDescription(descriptionLike);

        if(nameLike != null) return loadDao.findByName(nameLike);

        else return loadDao.findAll();
    }

    @Override
    public Optional<payLoad> getLoadsById(long itemId) {
        return loadDao.findById(itemId);
    }

    @Override
    public payLoad addLoad(payLoad load) {
        loadDao.save(load);
        return load;
    }

    @Override
    public payLoad updateLoad(payLoad load, long itemId) {
        payLoad update =loadDao.getById(itemId);

        if(load.getName() != null)
            update.setName(load.getName());

        if(load.getDescription() != null)
            update.setDescription(load.getDescription());

        if(load.getPrice() != update.getPrice())
            update.setPrice(load.getPrice());

        if(load.getAvailability() != null)
            update.setAvailability(load.getAvailability());

        return loadDao.save(update);
    }
}
