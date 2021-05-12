/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package design;

import activities.Reception;
import activities.Room;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.input.*;
import javafx.scene.text.*;

/**
 FXML Controller class

 @author EMAM
 */
public class RoomsSceneController implements Initializable {


          @FXML
          private TableView table;

          @FXML
          private TableColumn<Room , Integer> numberCol;

          @FXML
          private TableColumn<Room , Room.Type> typeCol;

          @FXML
          private TableColumn<Room , Double> costCol;

          @FXML
          private TableColumn<Room , Character> avilableCol;

          @FXML
          private TextField searchField;

          @FXML
          private Text errorMessage;

          @FXML
          private Text roomNo;

          @FXML
          private Text roomType;

          @FXML
          private Text roomCost;

          @FXML
          private Text isNotBooked;

          @FXML
          private Text avilableRooms;

          @FXML
          private JFXButton bookBtn;

          @FXML
          private Button searchAvilable;

          private List<Room> roomsToSearchIn;



          @FXML
          void searchRoom(Event event) {
                    String[] search = searchField.getText().split(",");
                    List<Room> foundedRooms = new ArrayList<>();
                    for ( String word : search ) {
                              if ( !word.trim().isEmpty() ) {
                                        foundedRooms.addAll(searchInRoomToSearchInList(word.trim().toUpperCase()));
                              }
                    }
                    if ( foundedRooms.size() == 0 ) {
                              foundedRooms = Reception.getRooms();
                    }
                    refresh(foundedRooms);
          }



          @FXML
          void searchAvilableOrNot(ActionEvent event) {
                    String id = searchAvilable.getId();
                    if ( id.equalsIgnoreCase("avilable") ) {
                              roomsToSearchIn = Reception.getBookedRooms();
                              searchAvilable.setId("notAvilable");
                              searchAvilable.setText("\u2717");
                    } else if ( id.equalsIgnoreCase("notAvilable") ) {
                              roomsToSearchIn = Reception.getRooms();
                              searchAvilable.setId("all");
                              searchAvilable.setText("...");
                    } else {
                              roomsToSearchIn = Reception.getUnBookedRooms();
                              searchAvilable.setId("avilable");
                              searchAvilable.setText("\u2713");
                    }
                    refresh(roomsToSearchIn);
          }



          @FXML
          void book(ActionEvent event) {
                    bookBtn.setDisable(true);
                    try {
                              MainScreenController.switchScenes(2);
                              GuestSceneController.roomNo = roomNo.getText();
                              Parent root = FXMLLoader.load(getClass().getResource("FXMLMainScreen.fxml"));
                              Main.stage.setScene(new Scene(root));
                    } catch ( IOException ex ) {
                    }
          }



          @FXML
          void showRoom(MouseEvent event) {
                    bookBtn.setDisable(false);
                    Room r = (Room) table.getSelectionModel().getSelectedItem();
                    if ( r != null ) {
                              roomNo.setText(r.getRoomNo() + "");
                              roomType.setText(r.getType().toString());
                              roomCost.setText(r.getNightCost() + "");
                              isNotBooked.setText(r.getAvilable() + "");
                    }

          }



          @FXML
          void clear(ActionEvent event) {
                    refresh();
          }



          /**
           Initializes the controller class.

           @param url
           @param rb
           */
          @Override
          public void initialize(URL url , ResourceBundle rb) {
                    numberCol.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
                    typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
                    costCol.setCellValueFactory(new PropertyValueFactory<>("nightCost"));
                    avilableCol.setCellValueFactory(new PropertyValueFactory<>("avilable"));
                    roomsToSearchIn = Reception.getRooms();
                    System.out.println("11");
                    refresh();
          }



          private void refresh(List list) {
                    table.getItems().clear();
                    table.getItems().addAll(list);
          }



          private void refresh() {
                    refresh(Reception.getRooms());

                    bookBtn.setDisable(true);
                    errorMessage.setVisible(false);

                    searchField.clear();
                    roomNo.setText("");
                    roomType.setText("");
                    roomCost.setText("");
                    isNotBooked.setText("");
                    
                    int numberOfRooms = Reception.getUnBookedRooms().size();
                    avilableRooms.setText(numberOfRooms + "");
          }



          private List<Room> searchInRoomToSearchInList(String search) {
                    List<Room> foundedRooms = new ArrayList<>();
                    roomsToSearchIn.stream().filter((room)
                            -> ((room.getAvilable() + "").toUpperCase().contains(search)
                            || (room.getFloorNo() + "").toUpperCase().contains(search)
                            || (room.getRoomNoInTheFloor() + "").toUpperCase().contains(search)
                            || (room.getRoomNo() + "").toUpperCase().contains(search)
                            || (room.getNightCost() + "").toUpperCase().contains(search)
                            || (room.getType() + "").toUpperCase().contains(search)))
                            .forEachOrdered((room) -> foundedRooms.add(room));
                    return foundedRooms;
          }

}
