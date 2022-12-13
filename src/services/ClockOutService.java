package services;

import interfaces.ClockOut;

public class ClockOutService {

    private ClockOut clock_out = new ClockOut();

    public ClockOutService(){

    }

    public ClockOut getClock_out() {
        return clock_out;
    }

    public void setClock_out(ClockOut clock_out) {
        this.clock_out = clock_out;
    }
    
    
}
