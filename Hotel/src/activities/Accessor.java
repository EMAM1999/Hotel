/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package activities;

/**

 @author EMAM
 */
public class Accessor {


          private static String name = "admin";
          private static String password = "admin";



          public static String getName() {
                    return name;
          }



          public static void setName(String name) {
                    Accessor.name = name;
          }



          public static String getPassword() {
                    return password;
          }



          public static void setPassword(String password) {
                    Accessor.password = password;
          }

}
