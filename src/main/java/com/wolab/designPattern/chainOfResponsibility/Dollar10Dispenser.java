package com.wolab.designPattern.chainOfResponsibility;

public class Dollar10Dispenser implements  DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        //如果金额大于10,则
        if(currency.getAmount()>=10){
            int num=currency.getAmount()/10;
            int remiander =currency.getAmount()%10;
            System.out.println("Dispensing  "+num+" 10$ note");
            if(remiander !=0){
                this.chain.dispense(new Currency(remiander));
            }
        }else{
            chain.dispense(currency);
        }


    }
}
