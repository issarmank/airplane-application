package LAQ5;

public class Passenger {

    private String name;
    private String seatNumber;

    public Passenger(String name, String seatNumber) {
        this.name = name;
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return name;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Passenger: " + name + " (Seat: " + seatNumber + ") ";
    }
}
