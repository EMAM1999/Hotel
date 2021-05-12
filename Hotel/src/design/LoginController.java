/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package design;

import activities.Accessor;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;

/**

 @author EMAM
 */
public class LoginController implements Initializable {


          @FXML
          private JFXTextField name;
          @FXML
          private JFXPasswordField password;
          @FXML
          private Label errorMassege;



          @FXML
          void login(ActionEvent event) throws IOException {
                    if ( correctLoginInfo() ) {
                              Parent root = FXMLLoader.load(getClass().getResource("FXMLMainScreen.fxml"));
                              Main.stage.setScene(new Scene(root));
                              errorMassege.setVisible(false);
                    } else {
                              errorMassege.setVisible(true);
                    }
          }



          @Override
          public void initialize(URL url , ResourceBundle rb) {
                    // TODO
          }



          private boolean correctLoginInfo() {
                    return name.getText().equalsIgnoreCase(Accessor.getName())
                            && password.getText().equals(Accessor.getPassword());
          }

}
