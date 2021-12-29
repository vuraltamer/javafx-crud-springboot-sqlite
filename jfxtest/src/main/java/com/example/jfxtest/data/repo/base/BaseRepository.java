package com.example.jfxtest.data.repo.base;

import com.example.jfxtest.data.entity.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface BaseRepository<T extends BaseEntity, PK extends Serializable> extends JpaRepository<T, PK> {

}
