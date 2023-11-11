package com.theatre_package;

public class Ticket {

    private int row;
    private int seat;
    private int price;
    private Person person1;

    public Ticket(int row,int seat,int price,Person person1) {
        this.row = row;
        this.seat=seat;
        this.price=price;
        this.person1=person1;

    }


    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void print(){
        System.out.println("\n     Ticket details ");
        System.out.println("   Row number  : "+this.row);
        System.out.println("   Seat number : "+this.seat);
        System.out.println("   Price       : £"+this.price);
        System.out.println("   Name        : "+person1.getName()+" "+person1.getSurname());
        System.out.println("   E-mail      : "+person1.getEmail()+"\n");



    }



}
