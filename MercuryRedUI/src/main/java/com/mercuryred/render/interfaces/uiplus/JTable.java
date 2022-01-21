package com.mercuryred.render.interfaces.uiplus;


import com.mercuryred.render.interfaces.uiplus.table.TableModel;

public interface JTable {

    RowSorter<? extends TableModel> getRowSorter();

    int convertColumnIndexToModel(int viewColumnIndex);
}
