package bowling;

import java.util.List;

public class Flame {

  private final List<Roll> rolls;

  public Flame(List<Roll> rolls) {
    this.rolls = rolls;
  }

  public int getScore() {
    if (isStrike()) {
      return rolls.get(0).getScore();
    }
    return rolls.get(0).getScore() + rolls.get(1).getScore();
  }

  public Roll nextRoll() {
    rolls.getLast().nextRoll();
    if (isStrike()) {
      return rolls.get(0).nextRoll();
    }
    return rolls.get(1).nextRoll();
  }

  public boolean isStrike() {
    return rolls.get(0).isStrike();
  }

  public boolean isSpare() {
    if (rolls.size() == 1) {
      return false;
    }
    return rolls.get(1).isSpare();
  }
}
