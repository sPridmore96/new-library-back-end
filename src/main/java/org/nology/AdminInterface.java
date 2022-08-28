package org.nology;

import java.util.List;

public interface AdminInterface {
    public List<LibraryBook> getStockCheck();
    public void printCsvReport();
}
