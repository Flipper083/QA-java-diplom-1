import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    public IngredientType type; // Тип ингредиента
    public String name; // Имя ингредиента
    public float price; // Цена ингредиента

    // Конструктор для инициализации параметров теста
    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: type = {0}, name = {1}, price = {2}")
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {IngredientType.SAUCE, "chili", 20.0f}, // Тестовые данные для соуса
                {IngredientType.FILLING, "cheese", 15.5f}, // Тестовые данные для начинки
                {null, null, 0.0f} // Тестовые данные для пустых значений
        };
    }

    // Тест проверяет, что метод getType() возвращает правильный тип ингредиента
    @Test
    public void getTypeShouldReturnCorrectTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType(); // Получаем фактический тип ингредиента
        assertEquals("Incorrect values ingredient type", type, actual); // Сравниваем ожидаемый и фактический тип
    }
}