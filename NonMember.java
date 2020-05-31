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
public class NonMember extends Passenger{
    
    public NonMember(String name, int age){
        super(name, age);
    }

    /**
     *
     * @param nonMember
     */
    @Override
    public double applyDiscount(double p){
        if(this.getAge() > 65)
            return p * .90;//10 percent discount
        else
            return p;
    }
}

