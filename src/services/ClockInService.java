package services;

import interfaces.ClockIn;

public class ClockInService {

    private ClockIn clock_in = new ClockIn();

    public ClockInService(){

    }

    public ClockIn getClock_in() {
        return clock_in;
    }

    public void setClock_in(ClockIn clock_in) {
        this.clock_in = clock_in;
    }
    
}
