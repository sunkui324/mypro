package com.wolab.designPattern.chainOfResponsibility;

public class Dollar50Dispenser implements  DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        //如果金额大于50,则找零50
        if(currency.getAmount()>=50){
            //找零50个数
            int num=currency.getAmount()/50;
            //剩余的找零金额,不为零,则继续找零
            int remiander =currency.getAmount()%50;

            System.out.println("Dispensing  "+num+" 50$ note");
            if(remiander !=0){
                this.chain.dispense(new Currency(remiander));
            }
        }else{
            chain.dispense(currency);
        }


    }
}
