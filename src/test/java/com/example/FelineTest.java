package com.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;

@RunWith(JUnitParamsRunner.class)

public class FelineTest {

    @Test
    public void eatMeat() throws Exception {
            Feline feline = new Feline();
            List<String> actual = feline.eatMeat();
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Assert.assertEquals(expected, actual);
    }
    @Test
    public void getFamily() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getKittens() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }
    @Test
    @Parameters({
            "1",
            "2",
            "3"
    })
    public void testGetKittens(int kittensCount) {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        int expected = kittensCount;
        Assert.assertEquals(expected, actual);
    }
}