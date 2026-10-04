package hotel;
import hotel.util.Status;

/**
 * An Hotel has a name and some rooms continuously numbered from 1
 */
public class Hotel {

   private final String name;
   private Room[] rooms;
   
   /**
    * Build an Hotel with given name, status and number of rooms.
    *
    * @param name this hotel name
    * @param status status of the rooms in this hotel
    * @param numberOfRooms number of rooms of this hotel
    */
   public Hotel(String name, Status status, int numberOfRooms) {
    this.name = name;
    this.rooms = new Room[numberOfRooms];

    for (int i = 0; i < numberOfRooms; i++) {
        this.rooms[i] = new Room(i + 1, status);
    }
   }

   /**
    * Return this hotel name.
    *
    * @return this hotel name
    */
   public String getName() {
    return this.name;
   }

   /**
    * Return the number of rooms for this hotel.
    *
    * @return the number of rooms for this hotel
    */
   public int numberOfRooms() {
    return this.rooms.length;
   }
   
   /**
    * Provide the room corresponding to given number.
    * The first room has number 1.
    * Returns null if the number is not valid.
    *
    * @param number number of the room, from 1 to this.numberOfRooms()
    * @return the room with given number or null if number is not valid
    */
   public Room getRoom(int number) {
    if (number < 1 || number > this.numberOfRooms()) {
        return null;
    }

    return this.rooms[number - 1];
   }
      
   /**
    * Rent the room corresponding to the given number.
    *
    * @param number number of the room to rent
    * @return the rented room
    * @throws RoomNotAvailableException if the number is invalid
    *         or if the room is already rented
    */
   public Room rentRoom(int number) throws RoomNotAvailableException {
    Room room = this.getRoom(number);

    if (room == null || room.isRent()) {
        throw new RoomNotAvailableException("Room " + number + " is not available");
    }

    room.rent();
    return room;
   }
   
   /**
    * Leave a room.
    * There is no effect if the room was not rented.
    *
    * @param number number of the room
    */
   public void leaveRoom(int number) {
    Room room = this.getRoom(number);

    if (room != null) {
        room.free();
    }
   }
   
   /**
    * Return the number of free rooms.
    *
    * @return the number of free rooms
    */
   public int numberOfFreeRooms() {
    int count = 0;

    for (Room room : this.rooms) {
        if (!room.isRent()) {
        count++;
        }
    }

    return count;
   }
   
   /**
    * Return the first free room number.
    * Returns 0 if the hotel is full.
    *
    * @return the first free room number, or 0 if no room is free
    */
   public int firstFreeNumber() {
    for (Room room : this.rooms) {
        if (!room.isRent()) {
        return room.getNumber();
        }
    }

    return 0;
   }
}
