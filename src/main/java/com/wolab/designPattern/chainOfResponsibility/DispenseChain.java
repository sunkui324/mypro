package com.wolab.designPattern.chainOfResponsibility;

/**
 *   责任链接口
 * @author bruce.sun
 * @date 2018/7/24
 * @param
 * @return
 *
 */
public interface DispenseChain {
    /**
     *   设置后继责任链
     * @author bruce.sun
     * @date 2018/7/24
     * @param
     * @return
     *
     */
    void setNextChain(DispenseChain nextChain);
    /**    
     *   找零
     * @author bruce.sun  
     * @date 2018/7/24
     * @param   
     * @return   
     * 
     */  
    void dispense(Currency currency);
}
