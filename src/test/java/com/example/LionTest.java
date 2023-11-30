package com.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion("Самец",feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doesHaveManeTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean actual = lion.doesHaveMane();
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doesHaveManeError() throws Exception
    {
        try
        {
            Lion lion = new Lion("aa", feline);
            fail("Should have thrown SomeException but did not!");
        }
        catch( final Exception e )
        {
            final String msg = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void doesHaveManeFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean actual = lion.doesHaveMane();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, actual);
    }
}