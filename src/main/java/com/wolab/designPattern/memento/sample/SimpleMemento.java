package com.wolab.designPattern.memento.sample;

import com.wolab.designPattern.memento.MementoIF;

public class SimpleMemento implements MementoIF {
    private int state;

    public SimpleMemento( int state){
        this.state=state;
    }
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
