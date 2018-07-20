package com.wolab.designPattern.memento.sample;

import com.wolab.designPattern.memento.MementoIF;

public class Originator  {
    private int state;

    public MementoIF createMemento(){
        return  new SimpleMemento(state);
    }

    public void restoreMemento(MementoIF m){
        Memento memento=((Memento)m);
        this.state=memento.getState();
    }


}
