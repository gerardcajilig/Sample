package com.company;

import java.util.Scanner;

import static java.lang.System.*;

public class ComputeWage {

    private String name;
    private double gtotal;
    private int hours;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGtotal() {
        return gtotal;
    }

    public void setGtotal(double gtotal) {
        this.gtotal = gtotal;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
//accepts data
    //continuous with the loop until place proper integer

    public void acceptData(){
        boolean inputValid = false;
        Scanner key = new Scanner(System.in);

        System.out.println("Enter the Name ");
        name = key.nextLine();

        while(!inputValid){
            System.out.println("enter the hours");
            String input = key.next();

            try{

                hours = Integer.parseInt(input);
                inputValid = true;

            }
            //NumberFormat if not number it will do this process
            catch(NumberFormatException e){

                System.out.println("You Didn't Put a correct integer");

            }



        }


    }


    //wage formula
    public double computeWage(){
        if (this.hours>40 ){
            gtotal = (40 * 15) + (16.5 * (this.hours-40)); // what happens here?
        }else {
            //normal wage without overtime
            this.gtotal = this.hours *15;
        }

        return this.gtotal;

    }

    //to show the data
    public void display(){
        System.out.println(" The total wage of " + this.name + " is " + this.gtotal);

    }

}
