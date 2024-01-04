package bowling.scorer;

import bowling.BowlingScorer;
import bowling.Flame;
import bowling.Roll;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassBasedBowlingScorer implements BowlingScorer {

  private static final int NUMBER_OF_FLAMES = 10;

  public int calculate(String gameScore) {
    int totalScore = 0;
    Flame[] flames = readScore(gameScore);
    for (int i = 0; i < flames.length; i++) {
      Flame flame = flames[i];
      int baseScore = flame.getScore();

      int bonusScore = 0;
      if (flame.isStrike()) {
        Roll nextRoll = flame.nextRoll();
        Roll oneAfterNextRoll = nextRoll.nextRoll();
        bonusScore += nextRoll.getScore() + oneAfterNextRoll.getScore();
      }

      if (flame.isSpare()) {
        Roll nextRoll = flame.nextRoll();
        bonusScore += nextRoll.getScore();
      }

      totalScore += baseScore + bonusScore;
    }

    return totalScore;
  }

  private Flame[] readScore(String gameScore) {
    Flame[] flames = new Flame[NUMBER_OF_FLAMES];
    String[] flameScores =
        Arrays.stream(gameScore.split(" ", NUMBER_OF_FLAMES))
            .map(score -> score.replaceAll(" ", ""))
            .toArray(String[]::new);
    Roll pre = null;
    for (int i = 0; i < NUMBER_OF_FLAMES; i++) {
      List<Roll> rolls = new ArrayList<>();

      for (int j = 0; j < flameScores[i].length(); j++) {
        Roll current = new Roll(flameScores[i].charAt(j), pre);
        rolls.add(current);
        if (pre != null) {
          pre.setNext(current);
        }
        pre = current;
      }

      flames[i] = new Flame(rolls);
    }
    return flames;
  }

}
