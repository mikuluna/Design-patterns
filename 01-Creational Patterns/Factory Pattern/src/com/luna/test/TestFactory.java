package com.luna.test;

import com.luna.factory.FruitStore;
import com.luna.factory.impl.FruitFactory;
import com.luna.model.Fruit;
import com.luna.model.impl.Apple;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 测试水果工厂
 */

public class TestFactory {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void main() throws Exception {
        FruitStore fruitFactory = new FruitFactory();
        Fruit fruit = fruitFactory.createFruit("Apple");
        assertTrue(fruit instanceof Apple);
        fruit.show();
        assertEquals("I am an apple", outContent.toString().replaceAll("\\p{C}", ""));
        outContent.reset();
    }
}
