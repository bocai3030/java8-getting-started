package com.bocai.j8gs.lambda;

import java.util.Arrays;

public class Lambda {
    int i = 3;

    public void usingLambda() {
        Arrays.asList("a", "b").forEach(e -> System.out.println(e + this.i));
        Arrays.asList(100000, 200000).forEach(e -> System.out.println(e));
        Arrays.asList(1, 2, 3).forEach(e -> System.out.print(e + "-"));
        Arrays.asList(1, 3, 2).sort((a, b) -> {
            System.out.println(this.getClass().toString());
            return a.compareTo(b);
        });

        // TODO 从http://www.open-open.com/lib/view/open1403232177575.html开始看default method
    }
}
