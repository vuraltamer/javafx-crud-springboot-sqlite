package com.example.jfxtest.controller.base;

import com.example.jfxtest.controller.dto.base.BaseDto;
import javafx.scene.input.MouseEvent;

import java.util.List;

public interface BaseController<D extends BaseDto> {

    /**
     * create input dto for save
     * @return
     */
    D createInputDto();

    /**
     * load TableView with Dto list
     * @param personDtoList
     */
    void loadTableView(List<D> personDtoList);

    /**
     * modifyTextFields update new Dto
     * @param personDto
     */
    void loadModifyTextField(D personDto);


    /**
     * change Dto values with TextFields
     */
    void loadModifyDto();

    /**
     * Search and get Dto in TableView
     * @param event
     * @return
     */
    D findDtoInTable(MouseEvent event);
}
