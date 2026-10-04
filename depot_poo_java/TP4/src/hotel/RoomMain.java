package hotel;
import hotel.util.Status;

/** main class for TP4 example  */

public class RoomMain {

    /** main with no args 
     * @param args none used
    */
    public static void main(String[] args) {
        Room someRoom = new Room(12, Status.COSY);
        System.out.println(someRoom);
    }

}
