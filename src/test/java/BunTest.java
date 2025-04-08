import org.hamcrest.MatcherAssert;
import org.junit.Test;
import praktikum.Bun;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameReturnInValidValue() {
        Bun bun = new Bun("Name", 10); // Создаем объект Bun с именем и ценой
        String expectedName = "Name";
        String actualName = bun.getName();
        assertEquals("Name is incorrect", expectedName, actualName); // Сравниваем ожидаемое и фактическое имя
    }

    @Test
    public void getPriceReturnInValidValue() {
        Bun bun = new Bun("Name", 10); // Создаем объект Bun с именем и ценой
        float expectedPrise = 10;
        float actualPrise = bun.getPrice();
        assertEquals("Price is incorrect", expectedPrise, actualPrise, 0.01); // Сравниваем ожидаемую и фактическую цену с учетом точности
    }

    @Test
    public void getPriceReturnNotNull() {
        Bun bun = new Bun("Name", 10);
        float actualPrise = bun.getPrice();
        MatcherAssert.assertThat(actualPrise, notNullValue()); // Проверяем, что цена не равна null
    }
}