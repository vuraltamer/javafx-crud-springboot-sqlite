package com.example.jfxtest.controller;

import com.example.jfxtest.controller.dto.PersonDto;
import com.example.jfxtest.service.PersonService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class PersonController extends PersonBaseController {

    private final PersonService personService;

    @FXML
    public Label label;

    @FXML
    public void initialize() {
    }

    public void savePerson(ActionEvent event) {
        PersonDto personDto = createInputDto();
        personService.save(personDto.toEntity());
        label.setText("SUCCESS :)");
    }

    public void listPerson(ActionEvent event) {
        personList = (List<PersonDto>) personService.all();
        loadTableView(personList);
    }

    public void showSelectedPerson(MouseEvent event) {
        selectedPerson = findDtoInTable(event);
        updatePersonVbox.setVisible(true);
        loadModifyTextField(selectedPerson);
    }

    public void updatePerson() {
        loadModifyDto();
        personService.update(selectedPerson.toEntity());
        selectedPerson = new PersonDto();
        updatePersonVbox.setVisible(false);
        personTable.refresh();
    }

    public void deletePerson(ActionEvent event) {
        personService.delete(selectedPerson.getIdentifier());
        selectedPerson = new PersonDto();
        updatePersonVbox.setVisible(false);
        listPerson(event);
    }
}
