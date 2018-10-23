package com.wolab.mockito;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IMathUtilsTest {

    @Test
    public void assertThenReturn() {
        IMathUtils mathUtils=mock(IMathUtils.class);

        when(mathUtils.abs(-1)).thenReturn(1); //当调用abs(-1)的时候,返回1

        int abs =mathUtils.abs(-1);

        assertThat(abs,is(1));
    }
}
