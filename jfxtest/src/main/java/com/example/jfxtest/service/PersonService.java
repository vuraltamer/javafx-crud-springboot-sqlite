package com.example.jfxtest.service;

import com.example.jfxtest.data.entity.Person;
import com.example.jfxtest.data.repo.PersonRepository;
import com.example.jfxtest.data.repo.base.BaseRepository;
import com.example.jfxtest.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonService extends BaseService<Person, Integer> {

    private final PersonRepository repository;

    @Override
    public BaseRepository<Person, Integer> getRepository() {
        return repository;
    }
}
