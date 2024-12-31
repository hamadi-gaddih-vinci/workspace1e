import java.time.LocalDate;

public class Sejour extends FormuleSimple{
    private Hotel reservationHotel;

    public Sejour(LocalDate dateDepart, int duree, Vol volAller, Vol volRetour, Hotel reservationHotel) {
        super(dateDepart, duree, volAller, volRetour);
        this.reservationHotel = reservationHotel;
    }

    @Override
    public double trouverPrix() {
        return super.trouverPrix() + reservationHotel.getPrixParNuit();
    }

    public Hotel getReservationHotel() {
        return reservationHotel;
    }
    public String toString(){
        return super.toString() + "Reservation de l'hotel : " + reservationHotel + "\n" +
                "Prix total: " + trouverPrix() + "\n";
    }
}
