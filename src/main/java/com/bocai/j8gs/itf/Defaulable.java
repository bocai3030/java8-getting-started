package com.bocai.j8gs.itf;

public interface Defaulable {
    default String notRequired() {
        return "Default implemetation";
    }
}
