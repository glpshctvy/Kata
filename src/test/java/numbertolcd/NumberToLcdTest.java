package numbertolcd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumberToLcdTest {
  //@formatter:off

  static Stream<Arguments> singleNumbers() {
    return Stream.of(
        arguments("1",
            "   \n" +
            "  |\n" +
            "  |"),
        arguments("2",
            " _ \n" +
            " _|\n" +
            "|_ "),
        arguments("3",
            " _ \n" +
            " _|\n" +
            " _|"),
        arguments("4",
            "   \n" +
            "|_|\n" +
            "  |"),
        arguments("5",
            " _ \n" +
            "|_ \n" +
            " _|"),
        arguments("6",
            " _ \n" +
            "|_ \n" +
            "|_|"),
        arguments("7",
            " _ \n" +
            "  |\n" +
            "  |"),
        arguments("8",
            " _ \n" +
            "|_|\n" +
            "|_|"),
        arguments("9",
            " _ \n" +
            "|_|\n" +
            " _|"),
        arguments("0",
            " _ \n" +
            "| |\n" +
            "|_|")
    );
  }

  static Stream<Arguments> multipleNumbers() {
    return Stream.of(
        arguments("11",
            "      \n" +
            "  |  |\n" +
            "  |  |" ),
        arguments("1234567890",
            "    _  _     _  _  _  _  _  _ \n" +
            "  | _| _||_||_ |_   ||_||_|| |\n" +
            "  ||_  _|  | _||_|  ||_| _||_|")
        );
  }

  static Stream<Arguments> singleNumbersWithWidth() {
    return Stream.of(
        arguments("1",
            "    \n" +
            "   |\n" +
            "   |"),
        arguments("2",
            " __ \n" +
            " __|\n" +
            "|__ "),
        arguments("3",
            " __ \n" +
            " __|\n" +
            " __|"),
        arguments("4",
            "    \n" +
            "|__|\n" +
            "   |"),
        arguments("5",
            " __ \n" +
            "|__ \n" +
            " __|"),
        arguments("6",
            " __ \n" +
            "|__ \n" +
            "|__|"),
        arguments("7",
            " __ \n" +
            "   |\n" +
            "   |"),
        arguments("8",
            " __ \n" +
            "|__|\n" +
            "|__|"),
        arguments("9",
            " __ \n" +
            "|__|\n" +
            " __|"),
        arguments("0",
            " __ \n" +
            "|  |\n" +
            "|__|")
    );
  }

  static Stream<Arguments> singleNumbersWithHeight() {
    return Stream.of(
        arguments("1",
            "   \n" +
            "   \n" +
            "  |\n" +
            "  |\n" +
            "  |\n" +
            "  |"),
        arguments("2",
            "   \n" +
            " _ \n" +
            "  |\n" +
            " _|\n" +
            "|  \n" +
            "|_ "),
        arguments("3",
            "   \n" +
            " _ \n" +
            "  |\n" +
            " _|\n" +
            "  |\n" +
            " _|"),
        arguments("4",
            "   \n" +
            "   \n" +
            "| |\n" +
            "|_|\n" +
            "  |\n" +
            "  |"),
        arguments("5",
            "   \n" +
            " _ \n" +
            "|  \n" +
            "|_ \n" +
            "  |\n" +
            " _|"),
        arguments("6",
            "   \n" +
            " _ \n" +
            "|  \n" +
            "|_ \n" +
            "| |\n" +
            "|_|"),
        arguments("7",
            "   \n" +
            " _ \n" +
            "  |\n" +
            "  |\n" +
            "  |\n" +
            "  |"),
        arguments("8",
            "   \n" +
            " _ \n" +
            "| |\n" +
            "|_|\n" +
            "| |\n" +
            "|_|"),
        arguments("9",
            "   \n" +
            " _ \n" +
            "| |\n" +
            "|_|\n" +
            "  |\n" +
            " _|"),
        arguments("0",
            "   \n" +
            " _ \n" +
            "| |\n" +
            "| |\n" +
            "| |\n" +
            "|_|")
    );
  }

  static Stream<Arguments> multipleNumbersExtendWidthAndHeight() {
    return Stream.of(
        arguments("1234567890",
                "                                                            \n" +
                "                                                            \n" +
                "       ____  ____        ____  ____  ____  ____  ____  ____ \n" +
                "     |     |     ||    ||     |          ||    ||    ||    |\n" +
                "     |     |     ||    ||     |          ||    ||    ||    |\n" +
                "     | ____| ____||____||____ |____      ||____||____||    |\n" +
                "     ||          |     |     ||    |     ||    |     ||    |\n" +
                "     ||          |     |     ||    |     ||    |     ||    |\n" +
                "     ||____  ____|     | ____||____|     ||____| ____||____|")
    );
  }

  //@formatter:on

  @ParameterizedTest
  @MethodSource("singleNumbers")
  void givenSingleNumber_thenConvert(String source, String expected) {
    LcdConverter converter = new LcdConverter(1, 1);
    assertEquals(expected, converter.convert(source));
  }


  @ParameterizedTest
  @MethodSource("multipleNumbers")
  void givenMultipleNumber_thenConvert(String source, String expected) {
    LcdConverter converter = new LcdConverter(1, 1);
    assertEquals(expected, converter.convert(source));
  }

  @ParameterizedTest
  @MethodSource("singleNumbersWithWidth")
  void givenSingleNumber_thenConvert_withWidth(String source, String expected) {
    LcdConverter converter = new LcdConverter(2, 1);
    assertEquals(expected, converter.convert(source));
  }

  @ParameterizedTest
  @MethodSource("singleNumbersWithHeight")
  void givenSingleNumber_thenConvert_withHeight(String source, String expected) {
    LcdConverter converter = new LcdConverter(1, 2);
    assertEquals(expected, converter.convert(source));
  }

  @ParameterizedTest
  @MethodSource("multipleNumbersExtendWidthAndHeight")
  void givenMultipleNumber_thenConvert_withHeight_withWidth(String source, String expected) {
    LcdConverter converter = new LcdConverter(4, 3);
    assertEquals(expected, converter.convert(source));
  }
}
