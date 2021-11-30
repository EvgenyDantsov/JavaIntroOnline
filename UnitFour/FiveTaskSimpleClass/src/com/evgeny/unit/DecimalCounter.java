package com.evgeny.unit;

public class DecimalCounter {
    private int min, max, currentValue;

    public void setMin(int min) {
        this.min = min;
    }

    public void setCurrentValue(int current) {
        this.currentValue = current;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public DecimalCounter(int min, int max, int current) {
        this.min = min;
        this.max = max;
        this.currentValue = current;
        if (max < min) {
            int tmp = max;
            setMax(min);
            setMin(tmp);
        }
        if (current < this.min)
            setCurrentValue(this.min);
        if (current > this.max)
            setCurrentValue(this.max);
    }
    public DecimalCounter(int min, int max) {
        this(min, max, min);
        setCurrentValue(this.min);
    }
    public DecimalCounter() {
        this(0, 16, 0);
    }
    public void increase() {
        currentValue++;
        if (currentValue > max)
            setCurrentValue(min);
    }
    public void decreasing() {
        currentValue--;
        if (currentValue < min)
            setCurrentValue(max);
    }
    public int value() {
        return currentValue;
    }
}
