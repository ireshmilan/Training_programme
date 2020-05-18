package com.company;

public class Invoice {
    int invoiceNo;
    double totalBill;
    double discount;

    protected void setDiscount(double discount){
        this.discount=discount;
    }

    public Invoice(int invoiceNo,double totalBill){
        this.invoiceNo=invoiceNo;
        this.totalBill=totalBill;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public double getDiscount() {
        return discount;
    }
}
