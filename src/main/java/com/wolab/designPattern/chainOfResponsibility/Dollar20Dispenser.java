package com.wolab.designPattern.chainOfResponsibility;

public class Dollar20Dispenser implements  DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        //如果金额大于20,则继续找零
        if(currency.getAmount()>=20){
            //找零20的个数
            int num=currency.getAmount()/20;
            //取余不为零,继续找零
            int remiander =currency.getAmount()%20;
            System.out.println("Dispensing  "+num+" 20$ note");
            if(remiander !=0){
                //取余不为零,购买其他笔记本
                this.chain.dispense(new Currency(remiander));
            }
        }else{
            chain.dispense(currency);
        }


    }
}
