package com.wolab.designPattern.chainOfResponsibility;

/**
 *   货币
 * @author bruce.sun
 * @date 2018/7/24
 * @param
 * @return
 *
 */
public class Currency {
    private int amount;
    public  Currency(int amt){
     this.amount=amt;
    }
    public int getAmount(){
        return this.amount;
    }

}
