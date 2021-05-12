/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package design;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**

 @author EMAM
 */
public class Main extends Application {


          static Stage stage;



          @Override
          public void start(Stage s) throws Exception {
//                    Parent root = FXMLLoader.load(getClass().getResource("FXMLRoomsScene.fxml"));
//                    Parent root = FXMLLoader.load(getClass().getResource("FXMLMainScreen.fxml"));
                    Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));

                    Scene scene = new Scene(root);
                    stage = s;
                    s.setScene(scene);
                    s.show();
          }



          /**
           @param args the command line arguments
           */
          public static void main(String[] args) {
                    launch(args);
          }

}
