package com.company;

public abstract class Handler {
    protected Handler succoser;

    public void setSuccoser(Handler succoser) {
        this.succoser = succoser;
    }

    public abstract double applyDiscount(Invoice invoice);
}
