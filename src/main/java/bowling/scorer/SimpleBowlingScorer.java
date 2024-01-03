package bowling.scorer;

import bowling.BowlingScorer;

public class SimpleBowlingScorer implements BowlingScorer {

  public int calculate(String gameScore) {
    String sequentialScore = gameScore.replace(" ", "");

    int totalScore = 0;
    int cursor = 0;
    for (int i = 0; i < 10; i++) {
      char firstRoll = sequentialScore.charAt(cursor);
      totalScore += toRollScore(firstRoll);

      if (firstRoll == 'X') {
        char firstBonus = sequentialScore.charAt(cursor + 1);
        totalScore += toRollScore(firstBonus);
        char secondBonus = sequentialScore.charAt(cursor + 2);
        totalScore += secondBonus == '/' ? 10 - toRollScore(firstBonus) : toRollScore(secondBonus);
        cursor++;
        continue;
      }

      char secondRoll = sequentialScore.charAt(cursor + 1);
      if (secondRoll == '/') {
        totalScore += 10 - toRollScore(firstRoll);
        char firstBonus = sequentialScore.charAt(cursor + 2);
        totalScore += toRollScore(firstBonus);
        cursor += 2;
        continue;
      }
      totalScore += toRollScore(secondRoll);
      cursor += 2;
    }

    return totalScore;
  }

  private int toRollScore(char roll) {
    return switch (roll) {
      case 'X' -> 10;
      case '-' -> 0;
      default -> Integer.parseInt(Character.toString(roll));
    };
  }
}
