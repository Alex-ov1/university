package hotel;
import hotel.util.Status;

/**
 * Main class for the Hotel application.
 */
public class HotelMain {
   /**
    * Main method.
    * @param args room number
    */
   public static void main(String[] args) {

    if (args.length == 0) {
        System.out.println("Usage : java hotel.HotelMain <numero de chambre>");
        return;
    }

    try {
        int number = Integer.parseInt(args[0]);
        Hotel hotel = new Hotel("Hôtel California", Status.PREMIUM, 100);
        System.out.println("Nombre de chambres : " + hotel.numberOfRooms());

        try {
            Room room = hotel.rentRoom(number);
            System.out.println("Chambre louée : " + room);
            System.out.println("Statut : " + room.getStatus());
        } catch (RoomNotAvailableException e) {
            System.out.println("Numéro de chambre invalide ou chambre indisponible.");
        }

        System.out.println("Nombre de chambres libres : " + hotel.numberOfFreeRooms());

    } catch (NumberFormatException e) {
        System.out.println("Le numéro de chambre doit être un entier.");
    }
   }
}
