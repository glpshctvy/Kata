package diamond;

import java.util.ArrayList;
import java.util.List;

public class DiamondVisualizer {

  private static final char BEGIN = 'A';
  private static final char END = 'Z';

  public String model(char target) {
    if (target < BEGIN || target > END) {
      throw new IllegalArgumentException();
    }
    List<String> result = model(BEGIN, target);
    return String.join("\n", result);
  }

  private List<String> model(char current, char target) {
    if (target == BEGIN) {
      return List.of(String.valueOf(BEGIN));
    }
    if (current == target) {
      String currentLine = "%c%s%c".formatted(current,
          " ".repeat((current - BEGIN) * 2 - 1), current);
      return List.of(currentLine);
    }
    if (current == BEGIN) {
      String currentLine = "%s%c".formatted(" ".repeat(target - current), current);
      List<String> diamondLines = model((char) (current + 1), target);
      return modelDiamond(currentLine, diamondLines);
    }
    String currentLine = "%s%c%s%c".formatted(" ".repeat(target - current), current,
        " ".repeat((current - BEGIN) * 2 - 1), current);
    List<String> diamondLines = model((char) (current + 1), target);
    return modelDiamond(currentLine, diamondLines);
  }
  
  private List<String> modelDiamond(String currentLine, List<String> diamondLines) {
    List<String> result = new ArrayList<>();
    result.add(currentLine);
    result.addAll(diamondLines);
    result.add(currentLine);

    return result;
  }
}
