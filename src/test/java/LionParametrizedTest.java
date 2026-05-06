import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionParametrizedTest {

    static Stream<Object> whoDoesHaveMane() {
        return Stream.of(
                Arguments.of("Самец", true),
                Arguments.of("Самка", false)
        );
    }

    @ParameterizedTest
    @MethodSource("whoDoesHaveMane")
    @DisplayName("Проверка, что метод doesHaveMane() класса Lion возвращает верное значение")
    void getKittensParameterized(String sex, boolean expectedHasMane) throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, sex);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}