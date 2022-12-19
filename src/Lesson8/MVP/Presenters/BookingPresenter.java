package Lesson8.MVP.Presenters;

import Lesson8.MVP.Models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;
    private Collection<Table> tables;


    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;

        // Подписываемся на событие резервирования столика
        this.view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    public void loadTables(){
        tables= model.loadTables();
    }

    /**
     * Отобразить список столиков
     */
    public void updateView(){
        view.showTables(tables);
    }

    protected void printReservationTableResult(int reservationNo){
        view.printReservationTableResult(reservationNo);
    }

    //TODO: Должен появиться метод printChangeReservationTableResult

    /**
     * Произошло событие, клиент нажал на кнопку резерва столика
     * @param reservationDate дата резерва
     * @param tableNo номер столика
     * @param name имя
     */
    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) {
        int reservationNo = model.reservationTable(reservationDate, tableNo, name);
        printReservationTableResult(reservationNo);
    }

    @Override
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        System.out.printf("Бронь #%d отменена. ", oldReservation);
        onReservationTable(reservationDate,tableNo, name);

    }


}
