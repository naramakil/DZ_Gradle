package ru.netology.service;

import org.junit.Test;
import org.junit.Assert;

public class CashbackHackServiceTest {

    // Тест: если сумма равна 0, нужно докупить до первой тысячи (1000)
    @Test
    public void testRemainWhenAmountIsZero() {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(0);         // Вызываем метод с нулём
        int expected = 1000;                     // Ожидаем 1000 рублей для докупки
        Assert.assertEquals("Должно быть 1000, если сумма равна 0", expected, actual);
    }

    // ❗ Этот тест должен упасть — здесь мы обнаружим баг
    @Test
     public void testRemainWhenAmountIsExactlyThousand_ShouldReturnZero() {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(1000);       // Пользователь потратил ровно 1000
        int expected = 0;                        // Ожидаем 0, так как кешбек уже начислен
        Assert.assertEquals("Должно быть 0, если сумма равна 1000 (кешбек уже начислен)", expected, actual);
    }

    // Тест: если сумма меньше 1000, проверяем сколько не хватает до 1000
    @Test
    public void testRemainWhenAmountIsLessThanThousand() {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(900);        // У пользователя 900 рублей
        int expected = 100;                      // До 1000 не хватает 100
        Assert.assertEquals("Должно быть 100, если сумма равна 900", expected, actual);
    }

    // Тест: если сумма больше 1000, но не кратна 1000
    @Test
    public void testRemainWhenAmountIsMoreThanThousand() {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(1500);       // У пользователя 1500 рублей
        int expected = 500;                      // До следующей тысячи (2000) не хватает 500
        Assert.assertEquals("Должно быть 500, если сумма равна 1500", expected, actual);
    }

    // Тест: если сумма почти кратна 1000 (например, 1999)
    @Test
    public void testRemainWhenAmountIsJustBelowMultipleOfThousand() {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(1999);       // Сумма чуть меньше 2000
        int expected = 1;                        // До 2000 не хватает 1 рубля
        Assert.assertEquals("Должно быть 1, если сумма равна 1999", expected, actual);
    }
}