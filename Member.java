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
public class Member extends Passenger {
      private int yearsOfMembership;

    /**
     *
     * @param yearsOfMembership
     * @param name
     * @param age
     */
    public Member(int yearsOfMembership, String name, int age){
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }

    /**
     *
     * @param member
     */
    public Member(Member member){
        super(member.getName(), member.getAge());
        this.yearsOfMembership = member.yearsOfMembership;
    }

    /**
     *
     * @param yearsOfMembership
     */
    public void setYearsOfMembership(int yearsOfMembership) { this.yearsOfMembership = yearsOfMembership; }

    /**
     *
     * @param p
     * @return
     */
    @Override
    public double applyDiscount(double p){
        if(yearsOfMembership > 5)
            return p * .5;
        else if(yearsOfMembership > 1)
            return p * .90;
        else
            return p;
    }
}
