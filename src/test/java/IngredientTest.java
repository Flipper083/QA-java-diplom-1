import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    // Тест проверяет, что метод getName() возвращает правильное имя ингредиента
    @Test
    public void getNameReturnsCorrectNameTest() {
        String expectedName = "hot sauce"; // Ожидаемое имя ингредиента
        String actualName = ingredient.getName(); // Получаем фактическое имя
        assertEquals("Incorrect values ingredient name", expectedName, actualName); // Сравниваем ожидаемое и фактическое имя
    }

    // Тест проверяет, что метод getPrice() возвращает правильную цену ингредиента
    @Test
    public void getPriceReturnsCorrectPriceTest() {
        float expectedPrice = 100; // Ожидаемая цена ингредиента
        float actualPrice = ingredient.getPrice(); // Получаем фактическую цену
        assertEquals("Incorrect values ingredient price", expectedPrice, actualPrice, 2); // Сравниваем ожидаемую и фактическую цену
    }

    // Тест проверяет, что метод getType() возвращает правильный тип ингредиента
    @Test
    public void getTypeReturnsCorrectTypeTest() {
        IngredientType expectedType = IngredientType.SAUCE; // Ожидаемый тип ингредиента
        IngredientType actualType = ingredient.getType(); // Получаем фактический тип
        assertEquals("Incorrect values ingredient type", expectedType, actualType); // Сравниваем ожидаемый и фактический тип
    }
}