package numbertolcd;

import java.util.ArrayList;
import java.util.List;

public class LcdConverter {

  //@formatter:off
  private static final String[] ONE = {
      "   ",
      "  |",
      "  |"
  };
  private static final String[] TWO = {
      " _ ",
      " _|",
      "|_ "
  };
  private static final String[] THREE = {
      " _ ",
      " _|",
      " _|"
  };
  private static final String[] FOUR = {
      "   ",
      "|_|",
      "  |"
  };
  private static final String[] FIVE = {
      " _ ",
      "|_ ",
      " _|"
  };
  private static final String[] SIX = {
      " _ ",
      "|_ ",
      "|_|"
  };
  private static final String[] SEVEN = {
      " _ ",
      "  |",
      "  |"
  };
  private static final String[] EIGHT = {
      " _ ",
      "|_|",
      "|_|"
  };
  private static final String[] NINE = {
      " _ ",
      "|_|",
      " _|"
  };
  private static final String[] ZERO = {
      " _ ",
      "| |",
      "|_|"
  };
  //@formatter:on

  private final int width;
  private final int height;

  public LcdConverter(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public String convert(String number) {
    LcdBuilder builder = new LcdBuilder();
    for (char digit : number.toCharArray()) {
      switch (digit) {
        case '1' -> builder.add(ONE);
        case '2' -> builder.add(TWO);
        case '3' -> builder.add(THREE);
        case '4' -> builder.add(FOUR);
        case '5' -> builder.add(FIVE);
        case '6' -> builder.add(SIX);
        case '7' -> builder.add(SEVEN);
        case '8' -> builder.add(EIGHT);
        case '9' -> builder.add(NINE);
        case '0' -> builder.add(ZERO);
      }
    }
    return builder.toString();
  }

  private class LcdBuilder {

    private String top = "";
    private String middle = "";
    private String bottom = "";

    public void add(String[] number) {
      top += extendWidth(number[0]);
      middle += extendWidth(number[1]);
      bottom += extendWidth(number[2]);
    }

    public String toString() {
      List<String> extendedTop = extendHeight(top);
      List<String> extendedMiddle = extendHeight(middle);
      List<String> extendedBottom = extendHeight(bottom);
      return String.join("\n", extendedTop) + "\n" +
          String.join("\n", extendedMiddle) + "\n" +
          String.join("\n", extendedBottom);
    }

    private List<String> extendHeight(String row) {
      List<String> result = new ArrayList<>();
      for (int i = 1; i <= height; i++) {
        if (i == height) {
          result.add(row);
        } else {
          result.add(row.replace("_", " "));
        }
      }
      return result;
    }

    private String extendWidth(String row) {
      StringBuilder builder = new StringBuilder();
      builder.append(row);
      builder.replace(1, 2, row.substring(1, 2).repeat(width));
      return builder.toString();
    }
  }
}
