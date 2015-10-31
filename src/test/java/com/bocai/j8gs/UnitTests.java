package com.bocai.j8gs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.bocai.j8gs.itf.TestInterface;
import com.bocai.j8gs.lambda.TestLambda;
import com.bocai.j8gs.newf.TestNewFeather;

@RunWith(Suite.class)
@SuiteClasses({ TestLambda.class, TestInterface.class, TestNewFeather.class })
public class UnitTests {
    // run "mvn -Dtest=UnitTests test" or "mvn -Dtest=YourTestClassName test" on cmd
}
