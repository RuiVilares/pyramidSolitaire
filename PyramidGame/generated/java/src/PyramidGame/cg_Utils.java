package PyramidGame;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class cg_Utils {
  public static VDMSeq cardFigLabels =
      SeqUtil.seq("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
  public static String cardSuitLabels = new String(new char[] {'s', 'h', 'd', 'c'});
  public static VDMSeq cardPoints =
      SeqUtil.seq(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L);

  public static void printPyramid() {

    long toVar_9 = 7L;

    for (Long counter = 1L; counter <= toVar_9; counter++) {
      System.out.print(counter + " ");
      long toVar_8 = counter.longValue();

      for (Long counter2 = 1L; counter2 <= toVar_8; counter2++) {
    	  System.out.print(
            convertNumberToSuit(
                ((Number)
                    Utils.get(((VDMSeq) Utils.get(Pyramid.pyramidDeck, counter)), counter2))) + " ");
      }
      System.out.println();
    }
    System.out.println("   1  2  3  4  5  6  7\n");
  }

  public static void printAuxCards() {

    Number numCardToPrint = 0L;
    if (Pyramid.auxDeck.size() >= 2L) {
      numCardToPrint = 2L;
    } else {
      numCardToPrint = Pyramid.auxDeck.size();
    }

    System.out.print("0 ");
    long toVar_10 = numCardToPrint.longValue();

    for (Long counter = 1L; counter <= toVar_10; counter++) {
    	System.out.print(convertNumberToSuit(((Number) Utils.get(Pyramid.auxDeck, counter))) + " ");
    }
    System.out.println("\n   1  2\n");
  }

  public static void printSelectedCards() {

	System.out.print("Selected Cards: ");
    if (Utils.equals(Pyramid.selectedCards.size(), 0L)) {
      System.out.print("-");
    } else {
      long toVar_11 = Pyramid.selectedCards.size();

      for (Long counter = 1L; counter <= toVar_11; counter++) {
        if (Utils.equals(
            ((Number) Utils.get(((VDMSeq) Utils.get(Pyramid.selectedCards, counter)), 1L)), 0L)) {
        	 System.out.print(
              convertNumberToSuit(
                  ((Number)
                      Utils.get(
                          Pyramid.auxDeck,
                          ((Number)
                              Utils.get(
                                  ((VDMSeq) Utils.get(Pyramid.selectedCards, counter)), 2L))))));
        } else {
        	 System.out.print(
              convertNumberToSuit(
                  ((Number)
                      Utils.get(
                          ((VDMSeq)
                              Utils.get(
                                  Pyramid.pyramidDeck,
                                  ((Number)
                                      Utils.get(
                                          ((VDMSeq) Utils.get(Pyramid.selectedCards, counter)),
                                          1L)))),
                          ((Number)
                              Utils.get(
                                  ((VDMSeq) Utils.get(Pyramid.selectedCards, counter)), 2L))))));
        }

        System.out.print(" ");
      }
    }

    System.out.print("\n\n");
  }

  public static void printScore() {
	  
	  System.out.println("Score: " + Pyramid.score);
  }

  public static void printSelected() {

	  System.out.println("Selected: " + Pyramid.selected);
  }

  public static void printStatus() {

	System.out.println("\n - - - - - Pyramid Solitaire Game - - - - -");
    printScore();
    printSelected();
    printSelectedCards();
    printPyramid();
    printAuxCards();
  }

  public static String convertNumberToSuit(final Number num) {

    if (Utils.equals(num, 0L)) {
      return "  ";

    } else {
      return getFig(num) + new String(new char[] {getSuit(num)});
    }
  }

  public static Character getSuit(final Number num) {

    Boolean andResult_12 = false;

    if (num.longValue() >= 1L) {
      if (num.longValue() <= 13L) {
        andResult_12 = true;
      }
    }

    if (andResult_12) {
      return cardSuitLabels.charAt(Utils.index(1L));

    } else {
      Boolean andResult_13 = false;

      if (num.longValue() >= 14L) {
        if (num.longValue() <= 26L) {
          andResult_13 = true;
        }
      }

      if (andResult_13) {
        return cardSuitLabels.charAt(Utils.index(2L));

      } else {
        Boolean andResult_14 = false;

        if (num.longValue() >= 27L) {
          if (num.longValue() <= 39L) {
            andResult_14 = true;
          }
        }

        if (andResult_14) {
          return cardSuitLabels.charAt(Utils.index(3L));

        } else {
          return cardSuitLabels.charAt(Utils.index(4L));
        }
      }
    }
  }

  public static String getFig(final Number num) {

    Number x = Utils.mod(num.longValue(), 13L);
    if (Utils.equals(x, 0L)) {
      return "K";

    } else {
      return ((String) Utils.get(cardFigLabels, x));
    }
  }

  public static Number cardToPoints(final Number idCard) {

    Number points = Utils.mod(idCard.longValue(), 13L);
    if (Utils.equals(points, 0L)) {
      return 13L;

    } else {
      return ((Number) Utils.get(cardPoints, points));
    }
  }

  public static Number min(final Number x, final Number y) {

    if (x.longValue() < y.longValue()) {
      return x;

    } else {
      return y;
    }
  }

  public cg_Utils() {}

  public String toString() {

    return "cg_Utils{"
        + "cardFigLabels := "
        + Utils.toString(cardFigLabels)
        + ", cardSuitLabels := "
        + Utils.toString(cardSuitLabels)
        + ", cardPoints := "
        + Utils.toString(cardPoints)
        + "}";
  }
}
