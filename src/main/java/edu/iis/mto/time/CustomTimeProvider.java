package edu.iis.mto.time;

/**
 * Created by Konrad Gos on 02.04.2017.
 */
public class CustomTimeProvider implements TimeInterface {
    @Override
    public long currentTimeMillis() {
        return System.currentTimeMillis() +  (48 * 60 * 60 * 1000);
    }
}
