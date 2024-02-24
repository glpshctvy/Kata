package dictionaryreplacer;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DictionaryReplacerTest {

  static Stream<Arguments> argumentPattern() {
    return Stream.of(
        arguments("", "", Map.of()),
        arguments("temporary", "$temp$", Map.of("temp", "temporary")),
        arguments("temporary here comes the name John Doe", "$temp$ here comes the name $name$",
            Map.of("temp", "temporary", "name", "John Doe")),
        arguments("temporary,temp,temporary$", "$temp$,temp,$temp$$", Map.of("temp", "temporary"))

    );
  }

  @MethodSource("argumentPattern")
  @ParameterizedTest
  void replacer(String expected, String target, Map<String, String> dictionary) {
    DictionaryReplacer dictionaryReplacer = new DictionaryReplacer();
    assertEquals(expected, dictionaryReplacer.replace(target, dictionary));
  }
}
