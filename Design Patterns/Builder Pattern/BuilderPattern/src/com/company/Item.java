package com.company;

import java.security.PublicKey;
import java.util.Date;

public class Item {
    private  Integer itemNo;
    private  String name;
    private  double price;
    private  Date mfd;
    private  Date epd;

    public Item(Builder builder) {
        this.itemNo=builder.itemNo;
        this.name=builder.name;
        this.price=builder.price;
        this.mfd=builder.mfd;
        this.epd=builder.epd;
    }

    static class Builder{

        private Integer itemNo;
        private String name;
        private double price;
        private Date mfd;
        private Date epd;

        public Item build(){
            return new Item(this);
        }

        public Builder(Integer itemNo, String name){

            this.itemNo=itemNo;
            this.name=name;

        }

        public Builder price(double price){
            this.price=price;
            return this;
        }
        public Builder mfd(Date mfd){
            this.mfd=mfd;
            return this;
        }
        public Builder epd(Date epd){
            this.epd=epd;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemNo=" + itemNo +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", mfd=" + mfd +
                ", epd=" + epd +
                '}';
    }
}
