package org.nology;

import java.util.List;

public interface AdminInterface {
    public void makeStockCsv(List<LibraryBook> dataToLoop);
    public void showLibraryStock(List<LibraryBook> givenList);
    public void printUserList();

}
