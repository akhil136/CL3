package com.example.ketul.calc1;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;


/**
 * Created by ketul on 14/4/17.
 */
public class MainActivityUnitTest extends TestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testchecker(){
        MainActivity ma=new MainActivity();
        String s=ma.add(new Float(3),new Float(4));
        assertEquals("Passed a uni test","7.0",s);
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
