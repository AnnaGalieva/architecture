package Lesson8.MVP.Views;

import Lesson8.MVP.Models.Table;
import Lesson8.MVP.Presenters.View;
import Lesson8.MVP.Presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {


    private ViewObserver observer;

    public void showTables(Collection<Table> tables){
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void printReservationTableResult(int reservationNo) {
        System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d. ", reservationNo);
    }


    /**
     * СОБЫТИЕ: Пользователь нажал на кнопку бронирования
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя
     */
    public void reservationTable(Date reservationDate, int tableNo, String name){
        observer.onReservationTable(reservationDate, tableNo, name);
    }

    /**
     * TODO: ДОМАШНЯЯ РАБОТА: Доработать метод changeReservationTable, протянуть возможность изменения
     * резерва столика на уровне компонент BookingPresenter и BookingModel
     * @param reservationDate
     * @param tableNo
     * @param name
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        observer.changeReservationTable(oldReservation, reservationDate, tableNo, name);
    }

    public void printReservationTableResult(int reservationNo, String name) {
        System.out.printf("%s, Ваш столик успешно забронирован.", reservationNo,name);

    }
}
