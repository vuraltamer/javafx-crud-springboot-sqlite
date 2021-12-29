package com.example.jfxtest.controller;

import com.example.jfxtest.controller.base.BaseController;
import com.example.jfxtest.controller.dto.PersonDto;
import com.example.jfxtest.controller.dto.base.BaseDto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public abstract class PersonBaseController implements BaseController<PersonDto> {

    /**
     * Input Text Fields
     */
    @FXML
    public TextField userNameText;

    @FXML
    public TextField firstNameText;

    @FXML
    public TextField lastNameText;

    @FXML
    public TextField msisdnText;

    @FXML
    public TextField emailText;

    /**
     * Update Text Fields
     */
    @FXML
    public TextField modifyUserNameText;

    @FXML
    public TextField modifyFirstNameText;

    @FXML
    public TextField modifyLastNameText;

    @FXML
    public TextField modifyMsisdnText;

    @FXML
    public TextField modifyEmailText;

    /**
     * List TableView for PersonDto
     */
    @FXML
    public TableView<PersonDto> personTable;

    @FXML
    public TableColumn<PersonDto, String> userNameColumn;

    @FXML
    public TableColumn<PersonDto, String> firstNameColumn;

    @FXML
    public TableColumn<PersonDto, String> lastNameColumn;

    @FXML
    public TableColumn<PersonDto, String> msisdnColumn;

    @FXML
    public TableColumn<PersonDto, String> emailColumn;

    @FXML
    public VBox updatePersonVbox;

    protected List<PersonDto> personList;
    protected PersonDto selectedPerson;

    public PersonDto createInputDto() {
        return PersonDto.builder()
                .userName(userNameText.getText())
                .firstName(firstNameText.getText())
                .lastName(lastNameText.getText())
                .email(emailText.getText())
                .msisdn(msisdnText.getText()).build();
    }

    @Override
    public void loadTableView(List personDtoList) {
        personTable.setItems(FXCollections.observableList(personDtoList));
    }

    @Override
    public void loadModifyTextField(PersonDto personDto) {
        modifyUserNameText.setText(personDto.getUserName());
        modifyFirstNameText.setText(personDto.getFirstName());
        modifyLastNameText.setText(personDto.getLastName());
        modifyEmailText.setText(personDto.getEmail());
        modifyMsisdnText.setText(personDto.getMsisdn());
    }

    @Override
    public void loadModifyDto() {
        selectedPerson.setFirstName(modifyFirstNameText.getText());
        selectedPerson.setLastName(modifyLastNameText.getText());
        selectedPerson.setUserName(modifyUserNameText.getText());
        selectedPerson.setMsisdn(modifyMsisdnText.getText());
        selectedPerson.setEmail(modifyEmailText.getText());
    }

    @Override
    public PersonDto findDtoInTable(MouseEvent event) {
        int rowIndex = ((TableCell) event.getPickResult().getIntersectedNode()).getIndex();
        return personList.get(rowIndex);
    }
}
