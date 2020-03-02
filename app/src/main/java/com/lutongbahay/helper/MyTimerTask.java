package com.lutongbahay.helper;


import com.lutongbahay.interfaces.OnTimerChangeListener;

import java.util.TimerTask;


/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */


public class MyTimerTask extends TimerTask {
    private int timeCounter = 0;
    private OnTimerChangeListener onTimerChangeListener;

    public MyTimerTask(int timeCounter, OnTimerChangeListener onTimerChangeListener) {
        this.timeCounter = timeCounter;
        this.onTimerChangeListener = onTimerChangeListener;
    }

    @Override
    public void run() {
        if (timeCounter == 0) {
            onTimerChangeListener.stopTimer();
            onTimerChangeListener.updateTimerProgress(timeCounter);
            return;
        }
        onTimerChangeListener.updateTimerProgress(timeCounter);
        timeCounter--;
    }
}