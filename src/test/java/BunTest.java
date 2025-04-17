import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Name", 10); // Инициализация объекта Bun
    }

    @Test
    public void getNameReturnInValidValueTest() {
        String expectedName = "Name";
        String actualName = bun.getName();
        assertEquals("Name is incorrect", expectedName, actualName); // Сравниваем ожидаемое и фактическое имя
    }

    @Test
    public void getPriceReturnInValidValueTest() {
        float expectedPrice = 10;
        float actualPrice = bun.getPrice();
        assertEquals("Price is incorrect", expectedPrice, actualPrice, 0.01); // Сравниваем ожидаемую и фактическую цену с учетом точности
    }
}
