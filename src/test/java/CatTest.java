import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CatTest {
    @Mock
    private Feline feline;

    private Cat cat;

    @BeforeEach
    void newCat() {
        cat = new Cat(feline);
    }

    @Test
    @DisplayName("Проверка метода getSound для класса Cat")
    public void getSoundCatTest() { // сам тест
        String actualSound = cat.getSound();
        String expectedSound = "Мяу";
        assertEquals(expectedSound, actualSound);
    }

    @Test
    @DisplayName("Проверка,что метод getFood класса Cat возвращает корректный список еды")
    void getFoodReturnPredatorsFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
        verify(feline, times(1)).eatMeat();
    }

    @Test
    @DisplayName("Проверка,что метод getFood класса Cat возвращает Exception, если eatMeat выдаст Exception")
    void getFoodThrowsWhenEatMeatThrows() throws Exception {
        when(feline.eatMeat()).thenThrow(new Exception("Error"));
        Exception ex = assertThrows(Exception.class, cat::getFood);
        assertEquals("Error", ex.getMessage());
        verify(feline).eatMeat();
    }
}