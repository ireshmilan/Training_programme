package com.company;

public class DiscountFactory {
    public Discount getDiscount(String itemType){

        if(itemType==null){
            return null;
        }
        if(itemType.equalsIgnoreCase("tv")){
            return new Tv();
        }
        if(itemType.equalsIgnoreCase("radio")){
            return new Radio();
        }
        if(itemType.equalsIgnoreCase("fridge")){
            return  new Fridge();
        }
        else
            System.out.println("-----------------------invalid Item----------------------");
        return null;
    }
}
