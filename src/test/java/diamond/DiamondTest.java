package diamond;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DiamondTest {

  static Stream<Arguments> diamondParams() {

    return Stream.of(
        arguments('A', """
            A"""),
        arguments('B', """
             A
            B B
             A"""),
        arguments('C', """
              A
             B B
            C   C
             B B
              A"""),
        arguments('D', """
               A
              B B
             C   C
            D     D
             C   C
              B B
               A""")
    );
  }

  @ParameterizedTest
  @MethodSource("diamondParams")
  void given_alphabet_create_some_step_diamond(char alphabet, String expected) {
    DiamondVisualizer visualizer = new DiamondVisualizer();
    assertEquals(expected, visualizer.model(alphabet));
  }
}
