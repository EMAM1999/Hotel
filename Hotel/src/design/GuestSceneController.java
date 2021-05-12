/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package design;

import activities.Guest;
import activities.Reception;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.input.*;
import javafx.scene.text.*;

/**
 FXML Controller class

 @author EMAM
 */
public class GuestSceneController implements Initializable {


          @FXML
          private TableView table;

          @FXML
          private TableColumn<Guest , String> nameCol;

          @FXML
          private TableColumn<Guest , String> nationalityCol;

          @FXML
          private TableColumn<Guest , String> phoneCol;

          @FXML
          private TableColumn<Guest , String> roomNoCol;

          @FXML
          private JFXTextField nameField;

          @FXML
          private JFXTextField nationalityField;

          @FXML
          private JFXTextField phoneField;

          @FXML
          private JFXTextField roomNoField;

          @FXML
          private TextField searchField;

          @FXML
          private Text errorMessage;

          @FXML
          private JFXButton editBtn;

          @FXML
          private Text guestsNO;



          @FXML
          void addGuest(ActionEvent event) {
                    String name = nameField.getText().trim();
                    String nat = nationalityField.getText().trim();
                    String pho = phoneField.getText().trim();
                    try {
                              int room = Integer.parseInt(roomNoField.getText().trim());
                              if ( Reception.getRoom(room) == null ) {
                                        errorMessage.setText("Room number is wrong");
                                        errorMessage.setVisible(true);
                                        return;
                              }
                              if ( Reception.getRoom(room).isBooked() ) {
                                        errorMessage.setText("Room number is not avilable");
                                        errorMessage.setVisible(true);
                                        return;
                              }
                              if ( name.isEmpty() ) {
                                        errorMessage.setText("The name is required");
                                        errorMessage.setVisible(true);
                                        return;
                              }
                              if ( nat.isEmpty() ) {
                                        errorMessage.setText("The nationality is required");
                                        errorMessage.setVisible(true);
                                        return;
                              }
                              Reception.addGuest(name , pho , nat , room);
                              refresh();
                    } catch ( NumberFormatException e ) {
                              errorMessage.setText("Room number is wrong");
                              errorMessage.setVisible(true);
                    }
          }



          @FXML
          void editGuest(ActionEvent event) {
                    if ( table.getSelectionModel().getSelectedItem() != null ) {
                              if ( editBtn.getText().equals("save") ) {
                                        editBtn.setText("edit");
                                        saveEdit();
                              } else {
                                        editBtn.setText("save");
                                        nameField.setEditable(false);
                                        nationalityField.setEditable(false);
                                        roomNoField.setEditable(false);
                              }
                    }
          }



          void saveEdit() {
                    String phone = phoneField.getText().trim();
                    Guest g = (Guest) table.getSelectionModel().getSelectedItem();
                    if ( g != null ) {
                              g.setPhone(phone);
                    }
                    refresh();
          }



          @FXML
          void removeGuest(ActionEvent event) {
                    Guest g = (Guest) table.getSelectionModel().getSelectedItem();
                    if ( g != null ) {
                              Reception.checkout(g.getRoom().getRoomNo());
                    }
                    refresh();
          }



          @FXML
          void searchGuest(Event event) {
                    String[] search = searchField.getText().split(",");
                    List<Guest> foundedGuests = new ArrayList<>();
                    for ( String word : search ) {
                              if ( !word.trim().isEmpty() ) {
                                        System.out.println(word);
                                        foundedGuests.addAll(searchInGuestsListToSearchIn(word.trim().toUpperCase()));
                              }
                    }
                    if ( foundedGuests.isEmpty() ) {
                              foundedGuests = Reception.getGuests();
                    }
                    refresh(foundedGuests);
          }



          @FXML
          void showGuest(MouseEvent event) {
                    Guest g = (Guest) table.getSelectionModel().getSelectedItem();
                    if ( g != null ) {
                              nameField.setText(g.getName());
                              nationalityField.setText(g.getNationality());
                              phoneField.setText(g.getPhone());
                              roomNoField.setText(g.getRoom().getRoomNo() + "");
                    }
          }



          @FXML
          void clear(ActionEvent event) {
                    refresh();
                    roomNoField.clear();
          }



          /**
           Initializes the controller class.

           @param url
           @param rb
           */
          @Override
          public void initialize(URL url , ResourceBundle rb) {
                    nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
                    nationalityCol.setCellValueFactory(new PropertyValueFactory<>("nationality"));
                    phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
                    roomNoCol.setCellValueFactory(new PropertyValueFactory<>("room"));
                    roomNoField.setText(roomNo);
                    guestsListToSearchIn = Reception.getGuests();
                    refresh();
          }



          void refresh() {
                    table.getItems().clear();
                    table.getItems().addAll(Reception.getGuests());

                    errorMessage.setVisible(false);
                    editBtn.setText("edit");

                    nameField.setEditable(true);
                    nameField.clear();

                    nationalityField.setEditable(true);
                    nationalityField.clear();

                    roomNoField.setEditable(true);
//                    roomNoField.clear();

                    int numberOfRooms = Reception.getGuests().size();
                    guestsNO.setText(numberOfRooms + "");

          }
          static String roomNo = "";
          private List<Guest> guestsListToSearchIn;



          private List< Guest> searchInGuestsListToSearchIn(String search) {
                    List<Guest> foundedGuests = new ArrayList<>();
                    guestsListToSearchIn.stream().filter((guest)
                            -> ((guest.getName() + "").toUpperCase().contains(search)
                            || (guest.getNationality() + "").toUpperCase().contains(search)
                            || (guest.getPhone() + "").toUpperCase().contains(search)
                            || (guest.getRoom() + "").toUpperCase().contains(search))).forEachOrdered((room) -> foundedGuests.add(room));
                    return foundedGuests;
          }



          private void refresh(List list) {
                    table.getItems().clear();
                    table.getItems().addAll(list);
          }

}
