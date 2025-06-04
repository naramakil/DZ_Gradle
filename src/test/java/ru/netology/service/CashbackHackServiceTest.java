package ru.netology.service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CashbackHackServiceTest {

    // Тест: если сумма равна 0, нужно докупить до первой тысячи (1000)
    @Test
    public void testRemainWhenAmountIsZero() {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(0);
        int expected = 1000;
        Assert.assertEquals(actual, expected);
    }

    // Тест: если сумма точно равна 1000, то нужно докупить ещё 1000 (следующая полная тысяча)
    @Test
    public void testRemainWhenAmountIsExactlyThousand() {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(1000);
        int expected = 1000;
        Assert.assertEquals(actual, expected);
    }

    // Тест: если сумма меньше 1000, проверяем сколько не хватает до 1000
    @Test
    public void testRemainWhenAmountIsLessThanThousand() {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(900);
        int expected = 100;
        Assert.assertEquals(actual, expected);
    }

    // Тест: если сумма больше 1000, но не кратна 1000
    @Test
    public void testRemainWhenAmountIsMoreThanThousand() {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(1500);
        int expected = 500;
        Assert.assertEquals(actual, expected);
    }

    // Тест: если сумма почти кратна 1000 (например, 1999)
    @Test
    public void testRemainWhenAmountIsJustBelowMultipleOfThousand() {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(1999);
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }
}