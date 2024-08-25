package org.lesson8;

import org.lesson8.models.TableModel;
import org.lesson8.presenters.BookingPresenter;
import org.lesson8.presenters.Model;
import org.lesson8.presenters.View;
import org.lesson8.views.BookingView;

import java.util.Date;


public class Program {
    public static void main(String[] args) {
        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateUIShowTables();

        view.reservationTable(new Date(), 2, "Станислав");

//        view.changerReservationTabel(1001, new Date(), 3, "Станислав" );
    }


}
