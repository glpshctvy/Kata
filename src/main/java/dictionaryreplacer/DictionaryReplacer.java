package dictionaryreplacer;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DictionaryReplacer {

  private final Pattern pattern = Pattern.compile("\\$(.*?)\\$");

  public String replace(String target, Map<String, String> dictionary) {
    String result = target;
    Matcher matcher = pattern.matcher(target);

    while (matcher.find()) {
      String matched = matcher.group();
      String word = matched.replaceAll("\\$", "");
      result = result.replaceAll("\\$%s\\$".formatted(word), dictionary.get(word));
    }
    return result;
  }
}
