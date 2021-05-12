/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package activities;

/**

 @author EMAM
 */
public class Room {


          private final int roomNo;
          private Type type;
          private double nightCost;
          private boolean booked;
          private String description;
          private char avilable;



          public Room(int roomNo) {
                    this.roomNo = roomNo;
                    this.booked = false;
                    this.avilable = '\u2713';
          }



          public Room(int roomNo , Type type , double nightCost) {
                    this(roomNo);
                    this.type = type;
                    this.nightCost = nightCost;
          }



          public Room(int roomNo , Type type , double nightCost , String description) {
                    this(roomNo , type , nightCost);
                    this.description = description;
          }



          public char getAvilable() {
                    return avilable;
          }



          public String getDescription() {
                    return description;
          }



          public void setDescription(String description) {
                    this.description = description;
          }



          public int getRoomNo() {
                    return roomNo;
          }



          public int getFloorNo() {
                    return roomNo / 100;
          }



          public double getNightCost() {
                    return nightCost;
          }



          public void setNightCost(double nightCost) {
                    this.nightCost = nightCost;
          }



          public int getRoomNoInTheFloor() {
                    return roomNo % 100;
          }



          public Type getType() {
                    return type;
          }



          public boolean isBooked() {
                    return booked;
          }



          @Override
          public String toString() {
                    return this.roomNo + "";
          }



          public void unBook() {
                    this.booked = false;
                    this.avilable = '\u2713';
          }



          public void book() {
                    this.booked = true;
                    this.avilable = '\u2717';
          }

          public enum Type {
                    SINGLE, PEAR;
          }

}
