package org.lesson8.presenters;

import org.lesson8.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver{
    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    public Collection<Table> loadTables() {
        return model.loadTables();
    }

    /**
     * Отобразить список столиков (на представлении)
     */
    public void updateUIShowTables() {
        view.showTables(loadTables());
    }

    public void updateUIShowReservationTableResult(int reservationNo) {
        view.showReservationTableResult(reservationNo);
    }

    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowReservationTableResult(reservationNo);
        } catch (RuntimeException e) {
            updateUIShowReservationTableResult(-1);
        }
    }
}
