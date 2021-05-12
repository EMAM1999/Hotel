/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package activities;

/**

 @author EMAM
 */
public class Guest {


          private final String name;
          private String nationality;
          private String phone;
          private final Room room;



          public Guest(String name , Room room) {
                    this.name = name;
                    this.room = room;
          }



          public Guest(String name , String nationality , Room room) {
                    this(name , room);
                    this.nationality = nationality;
          }



          public Guest(String name , String phone , String nationality , Room room) {
                    this(name , nationality , room);
                    this.phone = phone;
          }



          public String getName() {
                    return name;
          }



          public String getNationality() {
                    return nationality;
          }



          public String getPhone() {
                    return phone;
          }



          public void setPhone(String phone) {
                    this.phone = phone;
          }



          public Room getRoom() {
                    return room;
          }



          @Override
          public String toString() {
                    return "name: "+getName();
          }

}
