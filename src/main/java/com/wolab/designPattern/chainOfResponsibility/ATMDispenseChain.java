package com.wolab.designPattern.chainOfResponsibility;

import java.util.Scanner;

/**
 *   ATM 找零钱的责任链模式
 *   其他的实例
 *   java.util.logging.Logger#log()
 *   javax.servlet.Filter#doFilter()
 *
 *   责任链模式意图:
 *   使 多个对象(50$,20$,10$)都有机会处理请求,从而避免请求的发送者和接受者之间的耦合.
 *   将这些对象连成一条链,并沿着这条链传递改请求,直到有一个对象处理它未知.
 *
 *   责任链模式的动机:
 *   提供更松的耦合,根据运行时刻的情况,决定将那些候选者参与到链中.
 *   给多个对象处理一个请求的机会,从而解耦发送盒和接受者.
 *
 *
 * @author bruce.sun
 * @date 2018/7/24
 * @param
 * @return
 *
 */
public class ATMDispenseChain {

    private DispenseChain c1;

    private ATMDispenseChain(){
        this.c1= new Dollar50Dispenser();
        DispenseChain c2=new Dollar20Dispenser();
        DispenseChain c3=new Dollar10Dispenser();

        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenseChain=new ATMDispenseChain();
        while(true){
            int amount =0;
            System.out.println("Enter amount to dispense:");
            Scanner input =new Scanner(System.in);
            amount=input.nextInt();
            if(amount%10 !=0){
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            atmDispenseChain.c1.dispense(new Currency(amount));
        }
    }
}
