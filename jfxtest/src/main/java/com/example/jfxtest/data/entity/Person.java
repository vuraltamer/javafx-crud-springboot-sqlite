package com.example.jfxtest.data.entity;

import com.example.jfxtest.controller.dto.PersonDto;
import com.example.jfxtest.data.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity<PersonDto> {

    private String userName;

    private String firstName;

    private String lastName;

    private String msisdn;

    private String email;
}
