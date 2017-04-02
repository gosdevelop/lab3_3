package edu.iis.mto.time;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Konrad Gos on 02.04.2017.
 */
public class OrderTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void checkIfOrderNotExpired() {
        Order order = new Order(new SystemTimeProvider());
        order.submit();
        order.confirm();
        order.realize();
        assertThat(order.getOrderState(), is(equalTo(Order.State.REALIZED)));
    }

    @Test (expected = OrderExpiredException.class)
    public void checkIfOrderExpired() {
        Order order = new Order(new CustomTimeProvider());
        order.submit();
        order.confirm();
        assertThat(order.getOrderState(), is(equalTo(Order.State.CANCELLED)));
    }

    @Test (expected = OrderStateException.class)
    public void checkIfOrderHasWrongState() {
        Order order = new Order(new CustomTimeProvider());
        order.submit();
        order.realize();
        assertThat(order.getOrderState(), is(equalTo(Order.State.SUBMITTED)));
    }
}