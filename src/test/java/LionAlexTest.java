import com.example.Feline;
import com.example.LionAlex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LionAlexTest {

    @Mock
    Feline feline;

    private LionAlex lionAlex;

    @BeforeEach
    void newLionAlex() throws Exception {
        lionAlex = new LionAlex(feline);
    }

    @Test
    @DisplayName("Проверка,что метод getKittens() класса LionAlex возвращает 0")
    void getKittensDefault() {
        assertEquals(0, lionAlex.getKittens());
    }

    @Test
    @DisplayName("Проверка,что Алекс всегда 'Cамец'")
    void alexIsMale() {
        assertTrue(lionAlex.doesHaveMane());
    }

    @Test
    @DisplayName("Проверка,что метод getFriends() возвращает список друзей льва Алекса")
    void getFriendsReturnAlexFriends() {
        List<String> actualFriends = lionAlex.getFriends();
        List<String> expectedFriends = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        assertEquals(expectedFriends, actualFriends);
    }

    @Test
    @DisplayName("Проверка,что метод getPlaceOfLiving() класса LionAlex возвращает Нью-Йоркский зоопарк")
    void getPlaceOfLivingReturnNewYorkZoo() {
        assertEquals("Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }

    @Test
    @DisplayName("Проверка,что метод getFood() класса LionAlex возвращает еду Хищника")
    void getFoodReturnEatForPredator() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(food);
        assertEquals(food, lionAlex.getFood());
        verify(feline).getFood("Хищник");
    }
}