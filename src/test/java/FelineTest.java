import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    private Feline feline;

    @BeforeEach
    void newFeline() {
        feline = new Feline();
    }

    @Test
    @DisplayName("Проверка,что метод getFamily класса Feline возвращает 'Кошачьи'")
    void getFamilyReturnFeline() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    @DisplayName("Проверка,что метод getKittens() без параметра класса Feline возвращает 1")
    void getKittensDefault() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    @DisplayName("Проверка, что метод eatMeat() класса Feline возвращает еду Хищника")
    void eatMeatReturnEatForPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }
}