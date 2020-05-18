package com.company;

public class Gold extends Handler {
    @Override
    public double applyDiscount(Invoice invoice) {
        if(invoice.getTotalBill()>=10000 && invoice.getTotalBill()<=20000) {
            System.out.println("A Pen will be given as a gift");
            invoice.setDiscount(0.05);
            System.out.println("Bill No "+invoice.getInvoiceNo()+" Total Bill is: "+((invoice.getTotalBill())-(invoice.getTotalBill()*invoice.getDiscount())));
            return invoice.getDiscount();
        }else {
            return succoser.applyDiscount(invoice);
        }
    }
}
