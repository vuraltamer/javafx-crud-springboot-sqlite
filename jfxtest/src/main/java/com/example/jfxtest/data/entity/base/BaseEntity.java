package com.example.jfxtest.data.entity.base;

import com.example.jfxtest.controller.dto.base.BaseDto;
import lombok.Data;
import org.dozer.DozerBeanMapper;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity<D extends BaseDto> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer identifier;

    protected Date createDate;

    protected Date updateDate;

    /**
     * Generic toDto converter for entity
     * @return
     */
    public D toDto() {
        try {
            final Type actualTypeArgument = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Class<?> aClass = Class.forName(actualTypeArgument.getTypeName());
            return (D) mapper().map(this, aClass);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static DozerBeanMapper mapper;

    private static DozerBeanMapper mapper() {
        if (mapper == null) {
            mapper = new DozerBeanMapper();
        }
        return mapper;
    }
}
