package com.company;

public class WageMain {

    public static void main(String[] args) {
	// write your code here

    ComputeWage compute = new ComputeWage();
    compute.acceptData();
    compute.computeWage();
    compute.display();

    }
}
