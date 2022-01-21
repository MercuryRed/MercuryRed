package com.mercuryred.render.interfaces.uiplus;



public interface JTable {

    RowSorter<? extends TableModel> getRowSorter();

    int convertColumnIndexToModel(int viewColumnIndex);
}
