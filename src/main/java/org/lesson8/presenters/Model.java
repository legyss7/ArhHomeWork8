package org.lesson8.presenters;

import org.lesson8.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationData, int tableNo, String name);

}
