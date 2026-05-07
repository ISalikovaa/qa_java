import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    private Lion lion;

    @Mock
    Feline feline;

    @Test
    @DisplayName("Проверка,что метод getKittens() без параметра класса Lion возвращает 1")
    void getKittensDefault() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        lion = new Lion(feline, "Самка");
        assertEquals(1, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    @DisplayName("Проверка, что конструктор выдает ошибку при неправильном значении пола")
    void constructorLionCheckExceptionForSex() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline, "ОНО"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    @DisplayName("Проверка, что метод getFood() класса Lion возвращает еду Хищника")
    void eatMeatReturnEatForPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        lion = new Lion(feline, "Самец");
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}