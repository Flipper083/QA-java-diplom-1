import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import java.util.EnumSet;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    // Ожидаемый тип ингредиента, который будет передан в тест
    IngredientType expectedType;

    // Конструктор для инициализации ожидаемого типа ингредиента
    public IngredientTypeTest(IngredientType expectedType) {
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    // Тест проверяет, что ожидаемый тип ингредиента содержится в перечислении IngredientType
    @Test
    public void containsCorrectEnumTest() {
        assertTrue(EnumSet.allOf(IngredientType.class).contains(expectedType)); // Проверяем, что перечисление содержит ожидаемый тип
    }
}