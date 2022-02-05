package com.mercuryred.render.interfaces.ui.print;

import com.mercuryred.render.interfaces.ui.print.PageFormat;



public interface PrinterJob {

    void setPageable(Pageable document);
    boolean printDialog();
    boolean printDialog(PrintRequestAttributeSet attributes);
    PageFormat validatePage(PageFormat page);
    void print();
    void print(PrintRequestAttributeSet attributes);
    void setJobName(String jobName);
    void cancel();
}
