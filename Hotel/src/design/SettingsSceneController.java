/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package design;

import activities.Accessor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;

/**
 FXML Controller class

 @author EMAM
 */
public class SettingsSceneController implements Initializable {


          @FXML
          private JFXTextField oldNameField;
          @FXML
          private JFXTextField newNameField;
          @FXML
          private JFXPasswordField oldPassField;
          @FXML
          private JFXPasswordField newPassField;
          @FXML
          private JFXPasswordField newPassConfirmField;
          @FXML
          private JFXButton cancel;
          @FXML
          private JFXButton confirm;
          @FXML
          private Label errorMessage;



          @FXML
          void confirm(ActionEvent event) {
                    errorMessage.setVisible(true);
                    if ( oldNameField.getText().equalsIgnoreCase(Accessor.getName()) ) {
                              if ( oldPassField.getText().equals(Accessor.getPassword()) ) {
                                        if ( !newNameField.getText().trim().isEmpty() ) {
                                                  if ( !newPassField.getText().isEmpty() ) {
                                                            if ( newPassField.getText().equals(newPassConfirmField.getText()) ) {
                                                                      if ( !(newPassField.getText().equals(Accessor.getPassword())
                                                                              && newNameField.getText().equals(Accessor.getName())) ) {
                                                                                errorMessage.setVisible(false);
                                                                                Accessor.setName(newNameField.getText().trim());
                                                                                Accessor.setPassword(newPassField.getText());
                                                                                try {
                                                                                          Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
                                                                                          Scene scene = new Scene(root);
                                                                                          Main.stage.setScene(scene);
                                                                                } catch ( IOException ex ) {
                                                                                }
                                                                      } else {
                                                                                errorMessage.setText("The new data is the same as the old data");
                                                                      }
                                                            } else {
                                                                      errorMessage.setText("The password confirm is wrong");
                                                            }
                                                  } else {
                                                            errorMessage.setText("The new password is wrong");
                                                  }
                                        } else {
                                                  errorMessage.setText("The new name is empty");
                                        }
                              } else {
                                        errorMessage.setText("The old password is wrong");
                              }
                    } else {
                              errorMessage.setText("The old name is wrong");
                    }
          }



          @FXML
          void cancel(ActionEvent event) {
                    try {
                              Parent root = FXMLLoader.load(getClass().getResource("FXMLMainScreen.fxml"));
                              Main.stage.setScene(new Scene(root));
                    } catch ( IOException ex ) {
                              Logger.getLogger(SettingsSceneController.class.getName()).log(Level.SEVERE , null , ex);
                    }
          }



          /**
           Initializes the controller class.

           @param url
           @param rb
           */
          @Override
          public void initialize(URL url , ResourceBundle rb) {
                    errorMessage.setVisible(false);
          }

}
