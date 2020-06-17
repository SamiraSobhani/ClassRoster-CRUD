package com.ClassRoster.ClassRoster.ClassRosterUI;

import com.ClassRoster.ClassRoster.ClassRosterUI.UserIO;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message){

        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt){
        System.out.println(prompt);
        double menuSelection = sc.nextDouble();
        return menuSelection;
    }

    @Override
    public double readDouble(String prompt, double min, double max){
        System.out.println(prompt);
        double menuSelection = sc.nextDouble();
        if(min>menuSelection || menuSelection>max) {
            System.out.println("please enter a valid amount");
        }else;
        return menuSelection;

    }
    @Override
    public float readFloat(String prompt){
        System.out.println(prompt);
        float menuSelection = sc.nextFloat();
        return menuSelection;
    }
    @Override
    public float readFloat(String prompt, float min, float max){
        System.out.println(prompt);
        float menuSelection = sc.nextFloat();
        if(min>menuSelection || menuSelection>max) {
            System.out.println("please enter a valid amount");
        }else;
        return menuSelection;
    }
    @Override
    public int readInt(String prompt){
        System.out.println(prompt);
        int menuSelection = sc.nextInt();
        return menuSelection;
    }


    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int menuSelection = sc.nextInt();
        if(min>menuSelection || menuSelection>max) {
            System.out.println("please enter a valid amount");
        }else;
        return menuSelection;
        }


    @Override
    public long readLong(String prompt){
        System.out.println(prompt);
        long menuSelection = sc.nextLong();
        return menuSelection;
    }
    @Override
    public long readLong(String prompt, long min, long max){
        System.out.println(prompt);
        long menuSelection = sc.nextLong();
        if(min>menuSelection || menuSelection>max) {
            System.out.println("please enter a valid amount");
        }else;
        return menuSelection;
    }
    @Override
    public String readString(String prompt){
        System.out.println(prompt);
        String menuSelection = sc.next();
        return menuSelection;

    }
}
