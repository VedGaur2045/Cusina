package com.lutongbahay.interfaces;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public interface OnTimerChangeListener {
    public void updateTimerProgress(int timeCounter);
    public void stopTimer();
}
