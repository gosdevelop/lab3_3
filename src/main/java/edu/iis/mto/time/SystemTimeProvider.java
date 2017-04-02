package edu.iis.mto.time;

/**
 * Created by Konrad Gos on 02.04.2017.
 */
public class SystemTimeProvider implements TimeInterface {
    @Override
    public long currentTimeMillis(){
        return System.currentTimeMillis();
    }
}
