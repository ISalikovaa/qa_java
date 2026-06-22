import com.example.Feline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParametrizedTest {

    static Stream<Object> countKittens() {
        return Stream.of(
                Arguments.of(3, 3),
                Arguments.of(8, 8),
                Arguments.of(-2, -2),
                Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("countKittens")
    @DisplayName("Проверка, что метод getKittens(int count) класса Feline верно возвращает переданное значение")
    void getKittensParameterized(int input, int expected) {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(input));
    }
}