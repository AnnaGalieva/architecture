package Lesson8;
import Lesson8.MVP.Models.BookingModel;
import Lesson8.MVP.Models.Table;
import Lesson8.MVP.Presenters.BookingPresenter;
import Lesson8.MVP.Views.BookingView;

import java.util.Date;

public class Sample01 {

    public static void main(String[] args) {
        BookingModel bookingModel = new BookingModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(bookingModel, bookingView);
        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        bookingView.reservationTable(new Date(), 3, "Станислав");
        bookingView.changeReservationTable(3, new Date(), 5, "Станислав");

    }

}
