package com.example.jfxtest.controller.dto.base;

import com.example.jfxtest.data.entity.base.BaseEntity;
import javafx.scene.layout.StackPane;
import lombok.Data;
import org.dozer.DozerBeanMapper;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

@Data
public abstract class BaseDto<E extends BaseEntity> extends StackPane implements Serializable {

	public BaseDto() {
		super();
	}

	protected Integer identifier;

	protected Date createDate;

	protected Date updateDate;

	/**
	 * Generic toEntity converter for dto
	 * @return
	 */
	public E toEntity() {
		try {
			final Type actualTypeArgument = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			Class<?> aClass = Class.forName(actualTypeArgument.getTypeName());
			return (E) new DozerBeanMapper().map(this, aClass);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
}
