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
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

/**
 FXML Controller class

 @author EMAM
 */
public class MainScreenController implements Initializable {


          @FXML
          ImageView backImage;
          @FXML
          ImageView receptionImage;
          @FXML
          ImageView guestsImage;
          @FXML
          ImageView roomImage;
          @FXML
          ImageView settingsImage;
          @FXML
          Pane dataScene;



          @FXML
          void entered(MouseEvent event) {
                    ImageView img = (ImageView) event.getSource();
                    img.setOpacity(0.75);
          }



          @FXML
          void exited(MouseEvent event) {
                    ImageView img = (ImageView) event.getSource();
                    img.setOpacity(0.5);
                    if ( thisView == img ) {
                              img.setOpacity(1);
                    }
          }



          @FXML
          void pressed(MouseEvent event) throws IOException {
                    thisView.setOpacity(0.5);

                    ImageView img = (ImageView) event.getSource();
                    thisView = img;

                    img.setOpacity(1);
                    if ( img == backImage ) {
                              refresh();
                              Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
                              Scene scene = new Scene(root);
                              Main.stage.setScene(scene);
                    } else {
                              switchScenes();
                    }
          }



          /**
           Initializes the controller class.

           @param url
           @param rb
           */
          @Override
          public void initialize(URL url , ResourceBundle rb) {
                    if ( !isInitialized ) {
                              backImage.setCursor(Cursor.HAND);
                              receptionImage.setCursor(Cursor.HAND);
                              guestsImage.setCursor(Cursor.HAND);
                              roomImage.setCursor(Cursor.HAND);
                              settingsImage.setCursor(Cursor.HAND);

                              thisView = receptionImage;
//                              isInitialized = true;
//                    } else {
                              switch ( customView ) {
                                        case 1: thisView = receptionImage;
                                                  break;
                                        case 2: thisView = guestsImage;
                                                  break;
                                        case 3: thisView = roomImage;
                                                  break;
                                        case 4: thisView = settingsImage;
                                                  break;
                              }
                    }
                    thisView.setOpacity(1);
                    switchScenes();
          }



          private void refresh() {
                    isInitialized = false;
          }

          private static boolean isInitialized;
          public static Parent thisScene;

          private ImageView thisView;

          private static int customView;



          void switchScenes() {
                    try {
                              switch ( Integer.parseInt(thisView.getId()) ) {
                                        default:
                                                  thisScene = FXMLLoader.load(getClass().getResource("FXMLReceptionScene.fxml"));
                                                  System.out.println("FXMLReceptionScene has beean loaded");
                                                  break;
                                        case 2:
                                                  thisScene = FXMLLoader.load(getClass().getResource("FXMLGuestScene.fxml"));
                                                  System.out.println("FXMLGuestScene has beean loaded");
                                                  break;
                                        case 3:
                                                  thisScene = FXMLLoader.load(getClass().getResource("FXMLRoomsScene.fxml"));
                                                  System.out.println("FXMLRoomsScene has beean loaded");
                                                  break;
                                        case 4:
                                                  thisScene = FXMLLoader.load(getClass().getResource("FXMLSettingsScene.fxml"));
                                                  System.out.println("FXMLSettingsScene has beean loaded");
                              }
                    } catch ( IOException ex ) {
                    } finally {
                              dataScene.getChildren().clear();
                              dataScene.getChildren().add(thisScene);
                    }
          }



          public static void switchScenes(int index) {
                    customView = index;
          }

}
