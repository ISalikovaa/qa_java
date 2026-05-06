import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LionTest {

    private Feline feline;
    private Lion lion;

    @Test
    @DisplayName("Проверка,что метод getKittens() без параметра класса Lion возвращает 1")
    void getKittensDefault() throws Exception {
        feline = new Feline();
        lion = new Lion(feline, "Самка");
        assertEquals(1, lion.getKittens());
    }

    @Test
    @DisplayName("Проверка, что конструктор выбрасывает ошибку при неправильном значении пола")
    void constructorLionCheckExceptionForSex() {
        feline = new Feline();
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline, "ОНО"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    @DisplayName("Проверка, что метод getFood() класса Lion возвращает еду Хищника")
    void eatMeatReturnEatForPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        feline = new Feline();
        lion = new Lion(feline, "Самец");
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
