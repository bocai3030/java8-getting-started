package com.bocai.j8gs.itf;

import org.junit.Test;

public class TestInterface {
    @Test
    public void testInterface() {
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaulable.notRequired());

        defaulable = DefaulableFactory.create(OverridableImpl::new);
        System.out.println(defaulable.notRequired());
    }
}
