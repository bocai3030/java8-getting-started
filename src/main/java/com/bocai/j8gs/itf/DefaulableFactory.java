package com.bocai.j8gs.itf;

import java.util.function.Supplier;

public interface DefaulableFactory {
    static Defaulable create(final Supplier<Defaulable> supplier) {
        return supplier.get();
    }
}
