package com.bocai.j8gs.lambda;

import org.junit.Before;
import org.junit.Test;

public class TestLambda {
    private Lambda lambda;

    @Before
    public void before() {
        this.lambda = new Lambda();
    }

    @Test
    public void testUsingLambda() {
        this.lambda.usingLambda();
    }

}
