package PyramidGame;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestPyramidGame extends MyTestCase {
  public Pyramid game = new Pyramid();

  public void conversionTests() {

    super.assertEqual("As", cg_Utils.convertNumberToSuit(1L));
    super.assertEqual(1L, cg_Utils.cardToPoints(1L));
    super.assertEqual("2s", cg_Utils.convertNumberToSuit(2L));
    super.assertEqual(2L, cg_Utils.cardToPoints(2L));
    super.assertEqual("3s", cg_Utils.convertNumberToSuit(3L));
    super.assertEqual(3L, cg_Utils.cardToPoints(3L));
    super.assertEqual("4s", cg_Utils.convertNumberToSuit(4L));
    super.assertEqual(4L, cg_Utils.cardToPoints(4L));
    super.assertEqual("5s", cg_Utils.convertNumberToSuit(5L));
    super.assertEqual(5L, cg_Utils.cardToPoints(5L));
    super.assertEqual("6s", cg_Utils.convertNumberToSuit(6L));
    super.assertEqual(6L, cg_Utils.cardToPoints(6L));
    super.assertEqual("7s", cg_Utils.convertNumberToSuit(7L));
    super.assertEqual(7L, cg_Utils.cardToPoints(7L));
    super.assertEqual("8s", cg_Utils.convertNumberToSuit(8L));
    super.assertEqual(8L, cg_Utils.cardToPoints(8L));
    super.assertEqual("9s", cg_Utils.convertNumberToSuit(9L));
    super.assertEqual(9L, cg_Utils.cardToPoints(9L));
    super.assertEqual("10s", cg_Utils.convertNumberToSuit(10L));
    super.assertEqual(10L, cg_Utils.cardToPoints(10L));
    super.assertEqual("Js", cg_Utils.convertNumberToSuit(11L));
    super.assertEqual(11L, cg_Utils.cardToPoints(11L));
    super.assertEqual("Qs", cg_Utils.convertNumberToSuit(12L));
    super.assertEqual(12L, cg_Utils.cardToPoints(12L));
    super.assertEqual("Ks", cg_Utils.convertNumberToSuit(13L));
    super.assertEqual(13L, cg_Utils.cardToPoints(13L));
    super.assertEqual("Ah", cg_Utils.convertNumberToSuit(14L));
    super.assertEqual(1L, cg_Utils.cardToPoints(14L));
    super.assertEqual("2h", cg_Utils.convertNumberToSuit(15L));
    super.assertEqual(2L, cg_Utils.cardToPoints(15L));
    super.assertEqual("3h", cg_Utils.convertNumberToSuit(16L));
    super.assertEqual(3L, cg_Utils.cardToPoints(16L));
    super.assertEqual("4h", cg_Utils.convertNumberToSuit(17L));
    super.assertEqual(4L, cg_Utils.cardToPoints(17L));
    super.assertEqual("5h", cg_Utils.convertNumberToSuit(18L));
    super.assertEqual(5L, cg_Utils.cardToPoints(18L));
    super.assertEqual("6h", cg_Utils.convertNumberToSuit(19L));
    super.assertEqual(6L, cg_Utils.cardToPoints(19L));
    super.assertEqual("7h", cg_Utils.convertNumberToSuit(20L));
    super.assertEqual(7L, cg_Utils.cardToPoints(20L));
    super.assertEqual("8h", cg_Utils.convertNumberToSuit(21L));
    super.assertEqual(8L, cg_Utils.cardToPoints(21L));
    super.assertEqual("9h", cg_Utils.convertNumberToSuit(22L));
    super.assertEqual(9L, cg_Utils.cardToPoints(22L));
    super.assertEqual("10h", cg_Utils.convertNumberToSuit(23L));
    super.assertEqual(10L, cg_Utils.cardToPoints(23L));
    super.assertEqual("Jh", cg_Utils.convertNumberToSuit(24L));
    super.assertEqual(11L, cg_Utils.cardToPoints(24L));
    super.assertEqual("Qh", cg_Utils.convertNumberToSuit(25L));
    super.assertEqual(12L, cg_Utils.cardToPoints(25L));
    super.assertEqual("Kh", cg_Utils.convertNumberToSuit(26L));
    super.assertEqual(13L, cg_Utils.cardToPoints(26L));
    super.assertEqual("Ad", cg_Utils.convertNumberToSuit(27L));
    super.assertEqual(1L, cg_Utils.cardToPoints(27L));
    super.assertEqual("2d", cg_Utils.convertNumberToSuit(28L));
    super.assertEqual(2L, cg_Utils.cardToPoints(28L));
    super.assertEqual("3d", cg_Utils.convertNumberToSuit(29L));
    super.assertEqual(3L, cg_Utils.cardToPoints(29L));
    super.assertEqual("4d", cg_Utils.convertNumberToSuit(30L));
    super.assertEqual(4L, cg_Utils.cardToPoints(30L));
    super.assertEqual("5d", cg_Utils.convertNumberToSuit(31L));
    super.assertEqual(5L, cg_Utils.cardToPoints(31L));
    super.assertEqual("6d", cg_Utils.convertNumberToSuit(32L));
    super.assertEqual(6L, cg_Utils.cardToPoints(32L));
    super.assertEqual("7d", cg_Utils.convertNumberToSuit(33L));
    super.assertEqual(7L, cg_Utils.cardToPoints(33L));
    super.assertEqual("8d", cg_Utils.convertNumberToSuit(34L));
    super.assertEqual(8L, cg_Utils.cardToPoints(34L));
    super.assertEqual("9d", cg_Utils.convertNumberToSuit(35L));
    super.assertEqual(9L, cg_Utils.cardToPoints(35L));
    super.assertEqual("10d", cg_Utils.convertNumberToSuit(36L));
    super.assertEqual(10L, cg_Utils.cardToPoints(36L));
    super.assertEqual("Jd", cg_Utils.convertNumberToSuit(37L));
    super.assertEqual(11L, cg_Utils.cardToPoints(37L));
    super.assertEqual("Qd", cg_Utils.convertNumberToSuit(38L));
    super.assertEqual(12L, cg_Utils.cardToPoints(38L));
    super.assertEqual("Kd", cg_Utils.convertNumberToSuit(39L));
    super.assertEqual(13L, cg_Utils.cardToPoints(39L));
    super.assertEqual("Ac", cg_Utils.convertNumberToSuit(40L));
    super.assertEqual(1L, cg_Utils.cardToPoints(40L));
    super.assertEqual("2c", cg_Utils.convertNumberToSuit(41L));
    super.assertEqual(2L, cg_Utils.cardToPoints(41L));
    super.assertEqual("3c", cg_Utils.convertNumberToSuit(42L));
    super.assertEqual(3L, cg_Utils.cardToPoints(42L));
    super.assertEqual("4c", cg_Utils.convertNumberToSuit(43L));
    super.assertEqual(4L, cg_Utils.cardToPoints(43L));
    super.assertEqual("5c", cg_Utils.convertNumberToSuit(44L));
    super.assertEqual(5L, cg_Utils.cardToPoints(44L));
    super.assertEqual("6c", cg_Utils.convertNumberToSuit(45L));
    super.assertEqual(6L, cg_Utils.cardToPoints(45L));
    super.assertEqual("7c", cg_Utils.convertNumberToSuit(46L));
    super.assertEqual(7L, cg_Utils.cardToPoints(46L));
    super.assertEqual("8c", cg_Utils.convertNumberToSuit(47L));
    super.assertEqual(8L, cg_Utils.cardToPoints(47L));
    super.assertEqual("9c", cg_Utils.convertNumberToSuit(48L));
    super.assertEqual(9L, cg_Utils.cardToPoints(48L));
    super.assertEqual("10c", cg_Utils.convertNumberToSuit(49L));
    super.assertEqual(10L, cg_Utils.cardToPoints(49L));
    super.assertEqual("Jc", cg_Utils.convertNumberToSuit(50L));
    super.assertEqual(11L, cg_Utils.cardToPoints(50L));
    super.assertEqual("Qc", cg_Utils.convertNumberToSuit(51L));
    super.assertEqual(12L, cg_Utils.cardToPoints(51L));
    super.assertEqual("Kc", cg_Utils.convertNumberToSuit(52L));
    super.assertEqual(13L, cg_Utils.cardToPoints(52L));
  }

  public void newPyramidScn() {

    super.assertEqual(7L, game.pyramidDeck.size());
    super.assertEqual(1L, ((VDMSeq) Utils.get(game.pyramidDeck, 1L)).size());
    super.assertEqual(2L, ((VDMSeq) Utils.get(game.pyramidDeck, 2L)).size());
    super.assertEqual(3L, ((VDMSeq) Utils.get(game.pyramidDeck, 3L)).size());
    super.assertEqual(4L, ((VDMSeq) Utils.get(game.pyramidDeck, 4L)).size());
    super.assertEqual(5L, ((VDMSeq) Utils.get(game.pyramidDeck, 5L)).size());
    super.assertEqual(6L, ((VDMSeq) Utils.get(game.pyramidDeck, 6L)).size());
    super.assertEqual(7L, ((VDMSeq) Utils.get(game.pyramidDeck, 7L)).size());
    super.assertEqual(24L, game.deck.size());
    super.assertEqual(0L, game.auxDeck.size());
    super.assertEqual(7L, game.validDeck.size());
    super.assertEqual(0L, game.selectedCards.size());
    super.assertEqual(0L, game.score);
    super.assertEqual(0L, game.selected);
    super.assertEqual(true, game.bonusPyramidDeck);
    super.assertEqual(true, game.bonusDeck);
  }

  public void selectCardScn() {

    game.selectCard(1L, 7L);
    super.assertTrue(game.selected.longValue() > 0L);
    game.selectCard(1L, 7L);
    super.assertEqual(game.selected, 0L);
    game.selectCard(1L, 1L);
    super.assertEqual(0L, game.selected);
  }

  public void getAuxCardScn() {

    super.assertEqual(0L, game.auxDeck.size());
    super.assertEqual(24L, game.deck.size());
    game.getAuxCard();
    super.assertEqual(1L, game.auxDeck.size());
    super.assertEqual(23L, game.deck.size());
    super.assertEqual(8L, game.validDeck.size());
    game.getAuxCard();
    super.assertEqual(2L, game.auxDeck.size());
    super.assertEqual(22L, game.deck.size());
    super.assertEqual(9L, game.validDeck.size());
    game.getAuxCard();
    super.assertEqual(3L, game.auxDeck.size());
    super.assertEqual(21L, game.deck.size());
    super.assertEqual(9L, game.validDeck.size());
    game.selectCard(1L, 0L);
    super.assertTrue(game.selected.longValue() > 0L);
    game.selectCard(1L, 0L);
    super.assertEqual(0L, game.selected);
  }

  public void scoreScn() {

    game.score = 0L;
    game.selected = 0L;
    game.selectedCards = SeqUtil.seq();
    game.auxDeck = SeqUtil.seq();
    game.deck =
        SeqUtil.seq(
            29L, 30L, 31L, 32L, 33L, 34L, 35L, 36L, 37L, 41L, 42L, 43L, 44L, 45L, 46L, 47L, 48L,
            49L, 50L, 51L, 52L);
    game.pyramidDeck =
        SeqUtil.seq(
            SeqUtil.seq(1L),
            SeqUtil.seq(2L, 3L),
            SeqUtil.seq(4L, 5L, 6L),
            SeqUtil.seq(7L, 8L, 9L, 10L),
            SeqUtil.seq(11L, 12L, 13L, 14L, 15L),
            SeqUtil.seq(16L, 17L, 18L, 19L, 20L, 21L),
            SeqUtil.seq(22L, 23L, 24L, 25L, 26L, 27L, 28L));
    game.updateValidDeck();
    game.selectCard(5L, 7L);
    super.assertEqual(10L, game.score);
    super.assertEqual(0L, game.selected);
    super.assertEqual(0L, ((Number) Utils.get(((VDMSeq) Utils.get(game.pyramidDeck, 7L)), 5L)));
    game.selectCard(4L, 7L);
    game.selectCard(3L, 7L);
    super.assertEqual(10L, game.score);
    super.assertEqual(0L, game.selected);
    game.auxDeck = SeqUtil.seq(39L);
    game.updateValidDeck();
    game.selectCard(1L, 0L);
    super.assertEqual(20L, game.score);
    game.auxDeck = SeqUtil.seq(38L, 40L);
    game.updateValidDeck();
    game.selectCard(1L, 0L);
    game.selectCard(2L, 0L);
    super.assertEqual(40L, game.score);
  }

  public void comboScn() {

    game.score = 0L;
    game.selected = 0L;
    game.selectedCards = SeqUtil.seq();
    game.deck =
        SeqUtil.seq(
            29L, 30L, 31L, 32L, 33L, 34L, 35L, 36L, 37L, 38L, 39L, 40L, 41L, 42L, 43L, 44L, 45L,
            46L, 47L, 48L, 49L, 50L, 51L, 52L);
    game.pyramidDeck =
        SeqUtil.seq(
            SeqUtil.seq(1L),
            SeqUtil.seq(2L, 3L),
            SeqUtil.seq(4L, 5L, 6L),
            SeqUtil.seq(7L, 8L, 9L, 10L),
            SeqUtil.seq(11L, 12L, 13L, 14L, 15L),
            SeqUtil.seq(16L, 17L, 18L, 19L, 20L, 21L),
            SeqUtil.seq(22L, 23L, 24L, 25L, 26L, 27L, 28L));
    game.auxDeck = SeqUtil.seq();
    game.updateValidDeck();
    game.selectCard(6L, 7L);
    super.assertEqual(1L, game.selected);
    game.selectCard(7L, 7L);
    super.assertEqual(3L, game.selected);
    game.selectCard(2L, 7L);
    super.assertEqual(40L, game.score);
    super.assertEqual(0L, game.selected);
    super.assertEqual(0L, ((Number) Utils.get(((VDMSeq) Utils.get(game.pyramidDeck, 7L)), 6L)));
    super.assertEqual(0L, ((Number) Utils.get(((VDMSeq) Utils.get(game.pyramidDeck, 7L)), 7L)));
    super.assertEqual(0L, ((Number) Utils.get(((VDMSeq) Utils.get(game.pyramidDeck, 7L)), 2L)));
  }

  public void bonusDeckScn() {

    game.score = 0L;
    game.selected = 0L;
    game.selectedCards = SeqUtil.seq();
    game.deck = SeqUtil.seq();
    game.pyramidDeck =
        SeqUtil.seq(
            SeqUtil.seq(1L),
            SeqUtil.seq(2L, 3L),
            SeqUtil.seq(4L, 5L, 6L),
            SeqUtil.seq(7L, 8L, 9L, 10L),
            SeqUtil.seq(11L, 12L, 13L, 14L, 15L),
            SeqUtil.seq(16L, 17L, 18L, 19L, 20L, 21L),
            SeqUtil.seq(22L, 23L, 24L, 25L, 26L, 27L, 28L));
    game.updateValidDeck();
    game.selectCard(5L, 7L);
    super.assertEqual(40L, game.score);
    super.assertEqual(0L, game.selected);
    super.assertEqual(0L, ((Number) Utils.get(((VDMSeq) Utils.get(game.pyramidDeck, 7L)), 5L)));
    super.assertEqual(0L, game.deck.size());
    super.assertEqual(false, game.bonusDeck);
  }

  public void bonusPyramidDeckScn() {

    game.score = 0L;
    game.selected = 0L;
    game.selectedCards = SeqUtil.seq();
    game.deck =
        SeqUtil.seq(
            29L, 30L, 31L, 32L, 33L, 34L, 35L, 36L, 37L, 38L, 39L, 40L, 41L, 42L, 43L, 44L, 45L,
            46L, 47L, 48L, 49L, 50L, 51L, 52L);
    game.pyramidDeck =
        SeqUtil.seq(
            SeqUtil.seq(13L),
            SeqUtil.seq(0L, 0L),
            SeqUtil.seq(0L, 0L, 0L),
            SeqUtil.seq(0L, 0L, 0L, 0L),
            SeqUtil.seq(0L, 0L, 0L, 0L, 0L),
            SeqUtil.seq(0L, 0L, 0L, 0L, 0L, 0L),
            SeqUtil.seq(0L, 0L, 0L, 0L, 0L, 0L, 0L));
    game.bonusDeck = true;
    game.updateValidDeck();
    game.selectCard(1L, 1L);
    super.assertEqual(60L, game.score);
    super.assertEqual(0L, game.selected);
    super.assertEqual(0L, ((Number) Utils.get(((VDMSeq) Utils.get(game.pyramidDeck, 1L)), 1L)));
    super.assertEqual(false, game.bonusPyramidDeck);
  }

  public void noPossiblePlaysScn() {

    game.deck = SeqUtil.seq(1L);
    game.pyramidDeck =
        SeqUtil.seq(
            SeqUtil.seq(11L),
            SeqUtil.seq(0L, 0L),
            SeqUtil.seq(0L, 0L, 0L),
            SeqUtil.seq(0L, 0L, 0L, 0L),
            SeqUtil.seq(0L, 0L, 0L, 0L, 0L),
            SeqUtil.seq(0L, 0L, 0L, 0L, 0L, 0L),
            SeqUtil.seq(0L, 0L, 0L, 0L, 0L, 0L, 0L));
    game.bonusPyramidDeck = true;
    game.score = 0L;
    game.selected = 0L;
    game.selectedCards = SeqUtil.seq();
    game.auxDeck = SeqUtil.seq();
    game.updateValidDeck();
    game.selectCard(1L, 7L);
    super.assertEqual(0L, game.selected);
    game.getAuxCard();
    super.assertEqual(false, game.continueGame());
    super.assertEqual(false, game.isFinished());
  }

  public void winnerScn() {

    game.deck = SeqUtil.seq();
    game.auxDeck = SeqUtil.seq();
    game.pyramidDeck =
        SeqUtil.seq(
            SeqUtil.seq(0L),
            SeqUtil.seq(0L, 0L),
            SeqUtil.seq(0L, 0L, 0L),
            SeqUtil.seq(0L, 0L, 0L, 0L),
            SeqUtil.seq(0L, 0L, 0L, 0L, 0L),
            SeqUtil.seq(0L, 0L, 0L, 0L, 0L, 0L),
            SeqUtil.seq(0L, 0L, 0L, 0L, 0L, 0L, 0L));
    game.score = 100L;
    game.updateValidDeck();
    game.bonusDeck = false;
    game.bonusPyramidDeck = false;
    cg_Utils.printStatus();
    super.assertEqual(false, game.continueGame());
    super.assertEqual(true, game.isFinished());
  }

  public void main() {

    conversionTests();
    newPyramidScn();
    selectCardScn();
    getAuxCardScn();
    scoreScn();
    comboScn();
    bonusDeckScn();
    bonusPyramidDeckScn();
    noPossiblePlaysScn();
    winnerScn();
  }

  public TestPyramidGame() {}

  public String toString() {

    return "TestPyramidGame{" + "game := " + Utils.toString(game) + "}";
  }
}
