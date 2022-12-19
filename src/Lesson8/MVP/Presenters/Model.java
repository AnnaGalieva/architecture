package Lesson8.MVP.Presenters;

import Lesson8.MVP.Models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();
    int reservationTable(Date reservationDate, int tableNo, String name);

    void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
