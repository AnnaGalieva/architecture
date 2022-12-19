package Lesson8.MVP.Presenters;


import Lesson8.MVP.Models.Table;

import java.util.Collection;

public interface View {
    void showTables(Collection<Table> tables);

    void setObserver(ViewObserver observer);

    void printReservationTableResult(int reservationNo);
}
