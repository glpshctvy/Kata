package bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import bowling.scorer.ClassBasedBowlingScorer;
import bowling.scorer.SimpleBowlingScorer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BowlingScorerTest {

  private static final BowlingScorer[] BOWLING_SCORERS = {
      new SimpleBowlingScorer(),
      new ClassBasedBowlingScorer()
  };

  static BowlingScorer[] bowlingScorers() {
    return BOWLING_SCORERS;
  }

  @ParameterizedTest
  @MethodSource("bowlingScorers")
  void allStrikes(BowlingScorer sut) {
    assertEquals(10 * 30, sut.calculate("X X X X X X X X X X X X"));
  }

  @ParameterizedTest
  @MethodSource("bowlingScorers")
  void allStrikeExceptOne(BowlingScorer sut) {
    assertEquals((9 * 30) + (10 + 10 + 8), sut.calculate("X X X X X X X X X X X 8"));
  }

  @ParameterizedTest
  @MethodSource("bowlingScorers")
  void lastSpare(BowlingScorer sut) {
    assertEquals((8 * 30) + (10 + 10 + 2) + (10 + 10), sut.calculate("X X X X X X X X X X 2/"));
  }

  @ParameterizedTest
  @MethodSource("bowlingScorers")
  void lastNoSpare(BowlingScorer sut) {
    assertEquals((8 * 30) + (10 + 10 + 2) + (10 + 9), sut.calculate("X X X X X X X X X X 27"));
  }

  @ParameterizedTest
  @MethodSource("bowlingScorers")
  void lastMiss(BowlingScorer sut) {
    assertEquals((8 * 30) + (10 + 10 + 0) + (10 + 7), sut.calculate("X X X X X X X X X X -7"));
  }

  @ParameterizedTest
  @MethodSource("bowlingScorers")
  void lastSpareAndStrike(BowlingScorer sut) {
    assertEquals((7 * 30) + (10 + 10 + 2) + (10 + 2 + 8) + (2 + 8 + 10), sut.calculate("X X X X X X X X X 2/X"));
  }

  @ParameterizedTest
  @MethodSource("bowlingScorers")
  void noStrikeNoSpare(BowlingScorer sut) {
    assertEquals(10 * 9, sut.calculate("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-"));
  }

  @ParameterizedTest
  @MethodSource("bowlingScorers")
  void allSpares(BowlingScorer sut) {
    assertEquals(10 * 15, sut.calculate("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5"));
  }

  @ParameterizedTest
  @MethodSource("bowlingScorers")
  void allMiss(BowlingScorer sut) {
    assertEquals(0 * 15, sut.calculate("-- -- -- -- -- -- -- -- -- --"));
  }

  @ParameterizedTest
  @MethodSource("bowlingScorers")
  void generalScore(BowlingScorer sut) {
    assertEquals(
        (10 + 9)      // 7/
            + (9 + 0)       // 9-
            + (8 + 1)       // 81
            + (10 + 10)     // X
            + (10 + 3)      // 5/
            + (3 + 3)       // 33
            + (10 + 10 + 5) // X
            + (10 + 5 + 3)  // X
            + (5 + 3)       // 53
            + (10 + 9)      // 4/9
        , sut.calculate("7/ 9- 81 X 5/ 33 X X 53 4/9"));
  }

}
