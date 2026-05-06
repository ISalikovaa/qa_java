import com.example.Feline;
import com.example.LionAlex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LionAlexTest {

    private LionAlex lionAlex;

    @BeforeEach
    void newLionAlex() throws Exception {
        Feline feline = new Feline();
        lionAlex = new LionAlex(feline);
    }

    @Test
    @DisplayName("Проверка,что метод getKittens() класса LionAlex возвращает 0")
    void getKittensDefault()  {
        assertEquals(0, lionAlex.getKittens());
    }

    @Test
    @DisplayName("Проверка,что Алекс всегда 'Cамец'")
    void alexIsMale(){
        assertTrue(lionAlex.doesHaveMane());
    }

    @Test
    @DisplayName("Проверка,что метод getFriends() возвращает список друзей льва Алекса")
    void getFriendsReturnsExpected() {
        List<String> actualFriends = lionAlex.getFriends();
        List<String> expectedFriends = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        assertEquals(expectedFriends, actualFriends);
    }

    @Test
    @DisplayName("Проверка,что метод getPlaceOfLiving() класса LionAlex возвращает Нью-Йоркский зоопарк")
    void getPlaceOfLivingReturnsZoo(){
        assertEquals("Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }

    @Test
    @DisplayName("Проверка,что метод getFood() класса LionAlex возвращает еду Хищника")
    void getFoodDelegatesToFeline() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = lionAlex.getFood();
        assertEquals(expectedFood, actualFood);
    }
}