package com.example.jfxtest.service.base;

import com.example.jfxtest.controller.dto.base.BaseDto;
import com.example.jfxtest.data.entity.base.BaseEntity;
import com.example.jfxtest.data.repo.base.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public abstract class BaseService<E extends BaseEntity, PK extends Serializable> {

    Logger logger = LoggerFactory.getLogger(BaseService.class);

    /*
    * Get BaseRepository
    *
    * */
    public abstract BaseRepository<E, PK> getRepository();

    /*
    * Generic save-update-delete-all methods for E entity
    *
    * */
    @Transactional
    public E save(E entity) {
        entity.setCreateDate(new Date());
        return getRepository().save(entity);
    }

    @Transactional
    public E update(E entity) {
        entity.setUpdateDate(new Date());
        return getRepository().save(entity);
    }

    public boolean delete(Integer id) {
        try {
            getRepository().deleteById((PK) id);
            return true;
        } catch (Exception e) {
            logger.error("BaseService delete :", e.getMessage());
            return false;
        }
    }

    public List<? extends BaseDto> all() {
        return toDto(getRepository().findAll());
    }


    /**
     * Generic toDto converter for list
     * @param entities
     * @return
     */
    public List<? extends BaseDto> toDto(List<? extends BaseEntity> entities) {
        try {
            List<BaseDto> resources = new ArrayList<>();
            for (BaseEntity t : entities) {
                resources.add(t.toDto());
            }
            return resources;
        } catch (Exception e) {
            logger.warn("BaseService toDto :", e.getMessage());
            return null;
        }
    }

    /**
     * Generic toEntity converter for list
     * @param dtoList
     * @return
     */
    public List<? extends BaseEntity> toEntity(List<? extends BaseDto> dtoList) {
        try {
            List<BaseEntity> entities = new ArrayList<>();
            for (BaseDto t : dtoList) {
                entities.add(t.toEntity());
            }
            return entities;
        } catch (Exception e) {
            logger.warn("BaseService toEntity :", e.getMessage());
            return null;
        }
    }
}
