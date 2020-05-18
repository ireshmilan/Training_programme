package com.company;

public class Platinum extends Handler {
    @Override
    public double applyDiscount(Invoice invoice) {
        if(invoice.getTotalBill()>20000)
        System.out.println("A Mp3 player will be given as a gift");
        invoice.setDiscount(0.1);
        System.out.println("Bill No "+invoice.getInvoiceNo()+" Total Bill is: "+((invoice.getTotalBill())-(invoice.getTotalBill()*invoice.getDiscount())));

        return invoice.getDiscount();
        }
    }

