package Lesson8.MVP.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {

    private static int counter;

    private final Collection<Reservation> reservations = new ArrayList<>();
    private final int no;

    public int getNo() {
        return no;
    }

    {
        no = ++counter;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }
}
