import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun; // Мок-объект для класса Bun
    @Mock
    Ingredient ingredient1; // Мок-объект для класса Ingredient
    @Mock
    Ingredient ingredient2; // Мок-объект для класса Ingredient

    // Тест проверяет, что метод getPrice() возвращает правильную цену
    @Test
    public void getPriceShouldReturnValidValueTest() {
        float price = 100; // Устанавливаем цену
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient1.getPrice()).thenReturn(price);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        float expectedPrice = price * 2 + price; // Ожидаемая цена
        float actualPrice = burger.getPrice(); // Получаем фактическую цену

        assertEquals("Incorrect price", expectedPrice, actualPrice, 0.01); // Сравниваем ожидаемую и фактическую цену
    }

    // Тест проверяет, что метод getReceipt() возвращает правильный рецепт
    @Test
    public void getReceiptShouldReturnValidValueTest() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);

        burger.setBuns(bun);

        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient1.getPrice()).thenReturn(300f);

        burger.addIngredient(ingredient1);

        // Ожидаемый рецепт
        String expectedReceipt = "(==== black bun ====)\r\n= filling dinosaur =\r\n(==== black bun ====)" +
                "\r\n\r\nPrice: 500,000000\r\n";
        String actualReceipt = burger.getReceipt(); // Получаем фактический рецепт

        assertEquals("Incorrect burger receipt", expectedReceipt, actualReceipt); // Сравниваем ожидаемый и фактический рецепт
    }

    // Тест проверяет, что метод setBuns() корректно устанавливает bun
    @Test
    public void setBunsShouldIntroduceBunDependencyTest() {
        burger.setBuns(bun);
        Bun actual = burger.bun;

        assertEquals("Incorrect introduction of the bun dependency into the burger", bun, actual); // Сравниваем ожидаемый и фактический bun
    }

    // Тест проверяет, что метод addIngredient() корректно добавляет ingredient
    @Test
    public void addIngredientShouldAddIngredientToListTest() {
        burger.addIngredient(ingredient1);

        List<Ingredient> expected = List.of(ingredient1); // Ожидаемый список ингредиентов
        List<Ingredient> actual = burger.ingredients; // Получаем фактический список ингредиентов

        assertEquals("Incorrect addition of an ingredient in the list", expected, actual); // Сравниваем ожидаемый и фактический списки
    }

    // Тест проверяет, что метод removeIngredient() корректно удаляет ingredient
    @Test
    public void removeIngredientShouldRemoveIngredientFromListTest() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);

        List<Ingredient> actual = burger.ingredients; // Получаем фактический список ингредиентов

        assertEquals("Incorrect removal of an ingredient in the list", List.of(), actual); // Сравниваем ожидаемый и фактический списки
    }

    // Тест проверяет, что метод moveIngredient() корректно перемещает ingredient
    @Test
    public void moveIngredientShouldMoveIngredientInListTest() {
        // Устанавливаем поведение для ingredient1 и ingredient2
        Mockito.when(ingredient1.getName()).thenReturn("sour cream");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE); // Устанавливаем тип для ingredient1
        Mockito.when(ingredient2.getName()).thenReturn("sausage");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING); // Устанавливаем тип для ingredient2

        // Добавляем ингредиенты
        burger.addIngredient(ingredient1); // Добавляем соус
        burger.addIngredient(ingredient2); // Добавляем начинку

        // Перемещаем соус на позицию 1 (изначально он на позиции 0)
        burger.moveIngredient(0, 1);

        // Ожидаемое имя ингредиента на позиции 1
        String expectedName = "sauce"; // Изменяем ожидаемое имя на "sauce", так как это тип ingredient1
        // Получаем фактическое имя ингредиента на позиции 1
        String actualName = burger.ingredients.get(1).getName();

        // Сравниваем ожидаемое и фактическое имя
        assertEquals("Incorrect movement of an ingredient in the list", expectedName, actualName);
    }
}
