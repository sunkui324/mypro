package com.wolab.mockito;

import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;
import junit.framework.Assert;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CalculaterTest {


    @Test
    public void assertTestAdd() {
        Calculater calculater = new Calculater();
        int a = 1;
        int b = 2;

        int result = calculater.add(a, b);

        Assert.assertEquals(result, 3);
    }

    @Test
    public void assertTestAdd2() {
        Calculater calculater = mock(Calculater.class);
        int a = 1;
        int b = 2;

        calculater.add(a, b);

        verify(calculater).add(1,2);  //验证 add (1,2) 是否被调用过.


    }


}
