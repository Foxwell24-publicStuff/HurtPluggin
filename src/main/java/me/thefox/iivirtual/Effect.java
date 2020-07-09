package me.thefox.iivirtual;

import com.sun.org.apache.bcel.internal.generic.IINC;

import java.time.Instant;
import java.util.stream.Stream;

public class Effect
{
    IIInfo type;
    long started, ending, duration;

    public Effect(IIInfo type, long durationInSecconds)
    {
        this.type = type;
        this.duration = durationInSecconds;
        started = Instant.now().getEpochSecond();
        GetEndingTime();
    }

    private void GetEndingTime()
    {
        // all the staff-set stuff
        if (Stream.of(
                IIInfo.Temporary_Blindness,
                IIInfo.Concussion,
                IIInfo.Headache,
                IIInfo.Broken_Back,
                IIInfo.Broken_LeftArm,
                IIInfo.Broken_RightArm,
                IIInfo.Broken_Leg).anyMatch(iiInfo -> (type == iiInfo)))
            ending = started + duration;
        // the only set time one
        else if (type == IIInfo.Maimed)
            ending = started + 120;
        // all the indefinate stuff
        else
            ending = Long.MAX_VALUE;
    }

    public boolean stillActive()
    {
        return Instant.now().getEpochSecond() < ending;
    }
}
