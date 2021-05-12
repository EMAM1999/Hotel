/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package activities;

import java.util.ArrayList;
import java.util.List;

/**

 @author EMAM
 */
public class Reception {


          private static List<Room> rooms = new ArrayList<>();
          private static List<Guest> guests = new ArrayList<>();



          static {
                    rooms.add(new Room(101 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(102 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(103 , Room.Type.PEAR , 300));
                    rooms.add(new Room(104 , Room.Type.PEAR , 300));
                    rooms.add(new Room(105 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(106 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(107 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(108 , Room.Type.PEAR , 300));
                    rooms.add(new Room(109 , Room.Type.PEAR , 300));
                    rooms.add(new Room(110 , Room.Type.PEAR , 300));

                    rooms.add(new Room(201 , Room.Type.PEAR , 300));
                    rooms.add(new Room(202 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(203 , Room.Type.PEAR , 300));
                    rooms.add(new Room(204 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(205 , Room.Type.PEAR , 300));
                    rooms.add(new Room(206 , Room.Type.PEAR , 300));
                    rooms.add(new Room(207 , Room.Type.PEAR , 300));
                    rooms.add(new Room(208 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(209 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(210 , Room.Type.SINGLE , 200));

                    rooms.add(new Room(301 , Room.Type.PEAR , 300));
                    rooms.add(new Room(302 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(303 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(304 , Room.Type.PEAR , 300));
                    rooms.add(new Room(305 , Room.Type.PEAR , 300));
                    rooms.add(new Room(306 , Room.Type.PEAR , 300));
                    rooms.add(new Room(307 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(308 , Room.Type.PEAR , 300));
                    rooms.add(new Room(309 , Room.Type.PEAR , 300));
                    rooms.add(new Room(310 , Room.Type.SINGLE , 200));

                    rooms.add(new Room(401 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(402 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(403 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(404 , Room.Type.PEAR , 300));
                    rooms.add(new Room(405 , Room.Type.PEAR , 300));
                    rooms.add(new Room(406 , Room.Type.PEAR , 300));
                    rooms.add(new Room(407 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(408 , Room.Type.SINGLE , 200));
                    rooms.add(new Room(409 , Room.Type.PEAR , 300));
                    rooms.add(new Room(410 , Room.Type.PEAR , 300));
          }



          public static boolean addGuest(String name , String pho , String nat , int roomNo) {
                    Room r = getRoom(roomNo);
                    if ( r != null ) {
                              Guest newGuest = new Guest(name , pho , nat , r);
                              r.book();
                              guests.add(newGuest);
                              return true;
                    } else {
                              return false;
                    }
          }



          public static void checkout(int roomNo) {
                    Room r = getRoom(roomNo);
                    System.out.println("here");
                    if ( r != null ) {
                              for ( Guest guest : guests ) {
                                        if ( guest.getRoom().getRoomNo() == roomNo ) {
                                                  guests.remove(guest);
                                                  r.unBook();
                                                  break;
                                        }
                              }
                    }
          }



          public static Guest getGuest(String name) {
                    for ( Guest guest : guests ) {
                              if ( guest.getName().equalsIgnoreCase(name) ) {
                                        return guest;
                              }
                    }
                    return null;
          }



          public static List<Guest> getGuests() {
                    return guests;
          }



          public static List<Room> getRooms() {
                    return rooms;
          }



          public static List<Room> getUnBookedRooms() {
                    List<Room> unBookedRooms = new ArrayList<>();
                    for ( Room room : rooms ) {
                              if ( !room.isBooked() ) {
                                        unBookedRooms.add(room);
                              }
                    }
                    return unBookedRooms;
          }



          public static List<Room> getBookedRooms() {
                    List<Room> bookedRooms = new ArrayList<>();
                    for ( Room room : rooms ) {
                              if ( room.isBooked() ) {
                                        bookedRooms.add(room);
                              }
                    }
                    return bookedRooms;
          }



          public static Room getRoom(int roomNo) {
                    Room r = null;
                    for ( Room ele : rooms ) {
                              if ( ele.getRoomNo() == roomNo ) {
                                        r = ele;
                                        break;
                              }
                    }
                    return r;
          }

}
