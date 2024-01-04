package bowling;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = {"pre", "next"})
public class Roll {

  @Getter
  private final Character symbol;
  private final Roll pre;
  @Setter
  private Roll next;


  public Roll(Character symbol, Roll pre) {
    this.symbol = symbol;
    this.pre = pre;
  }

  public boolean isStrike() {
    return symbol.equals('X');
  }

  public boolean isSpare() {
    return symbol.equals('/');
  }

  public Roll nextRoll() {
    return next;
  }

  public int getScore() {
    return switch (symbol) {
      case 'X' -> 10;
      case '/' -> 10 - pre.getScore();
      case '-' -> 0;
      default -> Integer.parseInt(symbol.toString());
    };
  }

}
