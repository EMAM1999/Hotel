/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package design;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.input.*;

/**
 FXML Controller class

 @author EMAM
 */
public class ReceptionSceneController implements Initializable {


          @FXML
          void entered(MouseEvent event) {
                    ((Node) (event.getSource())).setScaleX(1.1);
                    ((Node) (event.getSource())).setScaleY(1.1);
          }



          @FXML
          void exited(MouseEvent event) {
                    ((Node) (event.getSource())).setScaleX(1);
                    ((Node) (event.getSource())).setScaleY(1);
          }



          @FXML
          void switchScenes(MouseEvent event) {
                    String id = ((Node) (event.getSource())).getId();
                    String pathName = "";
                    if ( id.equalsIgnoreCase("back") ) {
                              pathName = "FXMLLogin.fxml";
                    } else if ( id.equalsIgnoreCase("guests") ) {
                              MainScreenController.switchScenes(2);
                              pathName = "FXMLMainScreen.fxml";
                    } else if ( id.equalsIgnoreCase("rooms") ) {
                              MainScreenController.switchScenes(3);
                              pathName = "FXMLMainScreen.fxml";
                    } else if ( id.equalsIgnoreCase("settings") ) {
                              MainScreenController.switchScenes(4);
                              pathName = "FXMLMainScreen.fxml";
                    }
                    System.out.println(pathName);
                    try {
                              Parent root = FXMLLoader.load(getClass().getResource(pathName));
                              Main.stage.setScene(new Scene(root));
                    } catch ( IOException ex ) {
                    }
          }



          /**
           Initializes the controller class.

           @param url
           @param rb
           */
          @Override
          public void initialize(URL url , ResourceBundle rb) {
                    // TODO
          }

}
