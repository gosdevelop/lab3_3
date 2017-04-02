package edu.iis.mto.time;

/**
 * Created by Konrad Gos on 02.04.2017.
 */
public class CustomTimeProvider implements TimeInterface {
    private static final long FAKE_TIME = 48 * 60 * 60 * 1000;

    @Override
    public long currentTimeMillis() {
        return System.currentTimeMillis() +  FAKE_TIME;
    }
}
