/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 *
 * @author ashwi
 */
public abstract class Passenger {
    private String name;
    private int age;

    /**
     *
     * @param name
     * @param age
     */
    public Passenger(String name, int age){
        this.name = name;
        this.age = age;
    }

    /**
     *
     * @param passenger
     */
    

    /**
     *
     * @param p
     * @return
     */
    public abstract double applyDiscount(double p);

    /**
     *
     * @param name
     */
    public void setName(String name){ this.name = name; }

    /**
     *
     * @param age
     */
    public void setAge(int age){ this.age = age; }

    /**
     *
     * @return
     */
    public String getName(){ return name; }

    /**
     *
     * @return
     */
    public int getAge(){ return age; }

}
