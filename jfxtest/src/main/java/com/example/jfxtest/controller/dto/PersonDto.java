package com.example.jfxtest.controller.dto;

import com.example.jfxtest.controller.dto.base.BaseDto;
import com.example.jfxtest.data.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto extends BaseDto<Person> {

    private String userName;

    private String firstName;

    private String lastName;

    private String msisdn;

    private String email;
}
