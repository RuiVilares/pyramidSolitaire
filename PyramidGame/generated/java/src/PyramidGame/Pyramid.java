package PyramidGame;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Pyramid {
  public VDMSeq deck = SeqUtil.seq();
  public static VDMSeq pyramidDeck = SeqUtil.seq();
  public static VDMSeq auxDeck = SeqUtil.seq();
  public VDMSet validDeck = SetUtil.set();
  public static VDMSeq selectedCards = SeqUtil.seq();
  public static Number score = 0L;
  public static Number selected = 0L;
  public Boolean bonusPyramidDeck = true;
  public Boolean bonusDeck = true;

  public void cg_init_Pyramid_1() {

    createDeck();
    createPyramidDeck();
    updateValidDeck();
    cg_Utils.printStatus();
    return;
  }

  public Pyramid() {

    cg_init_Pyramid_1();
  }

  public void selectCard(final Number xCoord, final Number yCoord) {

    long toVar_1 = Pyramid.selectedCards.size();
    System.out.println("Aqui!1");
    for (Long position = 1L; position <= toVar_1; position++) {
      if (Utils.equals(
          ((VDMSeq) Utils.get(selectedCards, position)), SeqUtil.seq(yCoord, xCoord))) {
        deselectCard(Utils.copy(Pyramid.selectedCards), position, yCoord, xCoord);
        cg_Utils.printStatus();
        return;
      }
    }System.out.println("Aqui!2");
    if (!(selectedCard(yCoord, xCoord))) {
    	System.out.println(" - Seleção inválida.");
    }
    System.out.println("Aqui!3");
    if (updateGame()) {System.out.println("Aqui!4");
      updateValidDeck();System.out.println("Aqui!5");
      if (!(continueGame())) {
    	  System.out.println(" - Perdeste! O jogo terminou por falta de jogadas possíveis.");
        return;
      }
    }

    cg_Utils.printStatus();
  }

  public Boolean continueGame() {

    Number sumCombination = 0L;
    VDMSet setValidDeck = Utils.copy(validDeck);
    if (isFinished()) {
      System.out.println(" - Parabéns! Ganhaste o jogo! O teu score é " + Pyramid.score);
      return false;
    }

    if (deck.size() > 0L) {
      return true;
    }

    for (Iterator iterator_3 = SetUtil.powerset(Utils.copy(setValidDeck)).iterator();
        iterator_3.hasNext();
        ) {
      VDMSet value = (VDMSet) iterator_3.next();
      sumCombination = SumSet(Utils.copy(value));
      if (Utils.equals(sumCombination, 13L)) {
        return true;
      }
    }
    return false;
  }

  public void createDeck() {

    VDMSeq seqCompResult_1 = SeqUtil.seq();
    VDMSet set_1 = SetUtil.range(1L, 52L);
    for (Iterator iterator_1 = set_1.iterator(); iterator_1.hasNext(); ) {
      Number i = ((Number) iterator_1.next());
      seqCompResult_1.add(i);
    }
    deck = Utils.copy(seqCompResult_1);
  }

  public void createPyramidDeck() {

    long toVar_3 = 6L;

    for (Long counter = 0L; counter <= toVar_3; counter++) {
      VDMSeq aux = SeqUtil.seq();
      long toVar_2 = counter.longValue();

      for (Long counter2 = 0L; counter2 <= toVar_2; counter2++) {
        Number value = getCard(Utils.copy(deck));
        aux = SeqUtil.conc(SeqUtil.seq(value), Utils.copy(aux));
      }
      pyramidDeck = SeqUtil.conc(Utils.copy(Pyramid.pyramidDeck), SeqUtil.seq(Utils.copy(aux)));
    }
  }

  public void updateValidDeck() {

    VDMSet validDeckLocal = SetUtil.set();
    long toVar_5 = 7L;

    for (Long i = 1L; i <= toVar_5; i++) {
      long toVar_4 = i.longValue();

      for (Long j = 1L; j <= toVar_4; j++) {
        if (checkValidCard(i, j)) {
          validDeckLocal =
              SetUtil.union(
                  SetUtil.set(((Number) Utils.get(((VDMSeq) Utils.get(pyramidDeck, i)), j))),
                  Utils.copy(validDeckLocal));
        }
      }
    }
    long toVar_6 = Pyramid.auxDeck.size();

    for (Long i = 1L; i <= toVar_6; i++) {
      if (i.longValue() < 3L) {
        validDeckLocal =
            SetUtil.union(
                SetUtil.set(((Number) Utils.get(auxDeck, i))), Utils.copy(validDeckLocal));
      }
    }
    validDeck = Utils.copy(validDeckLocal);
  }

  public Boolean checkValidCard(final Number i, final Number j) {

    if (Utils.equals(((Number) Utils.get(((VDMSeq) Utils.get(pyramidDeck, i)), j)), 0L)) {
      return false;

    } else {
      if (Utils.equals(i, 7L)) {
        return true;

      } else {
        Boolean andResult_3 = false;

        if (Utils.equals(
            ((Number) Utils.get(((VDMSeq) Utils.get(pyramidDeck, i.longValue() + 1L)), j)), 0L)) {
          if (Utils.equals(
              ((Number)
                  Utils.get(
                      ((VDMSeq) Utils.get(pyramidDeck, i.longValue() + 1L)), j.longValue() + 1L)),
              0L)) {
            andResult_3 = true;
          }
        }

        if (andResult_3) {
          return true;

        } else {
          return false;
        }
      }
    }
  }

  public void getAuxCard() {

	if (deck.size() == 0) {
		System.out.println(" - O baralho inicial está vazio. Não podes pedir mais cartas auxiliares.");
	    return;
	}
    Number value = getCard(Utils.copy(deck));
    auxDeck = SeqUtil.conc(SeqUtil.seq(value), Utils.copy(Pyramid.auxDeck));
    updateValidDeck();
    selectedCards = SeqUtil.seq();
    selected = 0L;
    if (!(continueGame())) {
      System.out.println(" - Perdeste! O jogo terminou por falta de jogadas possíveis.");
      return;
    }

    cg_Utils.printStatus();
  }

  public Boolean selectedCard(final Number i, final Number j) {

    for (Iterator iterator_4 = validDeck.iterator(); iterator_4.hasNext(); ) {
      Number value = (Number) iterator_4.next();
      Boolean orResult_2 = false;

      Boolean andResult_4 = false;

      if (Utils.equals(i, 0L)) {
        if (Utils.equals(((Number) Utils.get(auxDeck, j)), value)) {
          andResult_4 = true;
        }
      }

      if (andResult_4) {
        orResult_2 = true;
      } else {
        Boolean andResult_5 = false;

        if (!(Utils.equals(i, 0L))) {
          if (Utils.equals(((Number) Utils.get(((VDMSeq) Utils.get(pyramidDeck, i)), j)), value)) {
            andResult_5 = true;
          }
        }

        orResult_2 = andResult_5;
      }

      if (orResult_2) {
        selected = Pyramid.selected.longValue() + cg_Utils.cardToPoints(value).longValue();
        selectedCards =
            SeqUtil.conc(SeqUtil.seq(SeqUtil.seq(i, j)), Utils.copy(Pyramid.selectedCards));
        return true;
      }
    }
    return false;
  }

  public Boolean updateGame() {
	  System.out.println("Aqui!6");
    if (Utils.equals(Pyramid.selected, 13L)) {System.out.println("Aqui!10");
      removeSelectedCards();System.out.println("Aqui!11");
      calcScore();System.out.println("Aqui!12");
      selectedCards = SeqUtil.seq();System.out.println("Aqui!13");
      selected = 0L;System.out.println("Aqui!7");
      return true;
    } else {
      if (Pyramid.selected.longValue() > 13L) {
        selectedCards = SeqUtil.seq();
        selected = 0L;
        System.out.println(" - Excedeste os 13 pontos! Tenta novamente.\n");System.out.println("Aqui!8");
        return true;
      } else {System.out.println("Aqui!9");
        return false;
      }
    }
  }

  public Number combo() {

    if (Pyramid.selectedCards.size() > 2L) {
      return (Pyramid.selectedCards.size() - 2L) * 10L;

    } else {
      return 0L;
    }
  }

  public Number bonus() {

    Boolean andResult_6 = false;

    if (bonusPyramidDeck) {
      if (Utils.equals(((Number) Utils.get(((VDMSeq) Utils.get(pyramidDeck, 1L)), 1L)), 0L)) {
        andResult_6 = true;
      }
    }

    if (andResult_6) {
      bonusPyramidDeck = false;
      return 50L;

    } else {
      Boolean andResult_7 = false;

      if (bonusDeck) {
        Boolean andResult_8 = false;

        if (Utils.equals(deck.size(), 0L)) {
          if (Utils.equals(Pyramid.auxDeck.size(), 0L)) {
            andResult_8 = true;
          }
        }

        if (andResult_8) {
          andResult_7 = true;
        }
      }

      if (andResult_7) {
        bonusDeck = false;
        return 30L;

      } else {
        return 0L;
      }
    }
  }

  public void calcScore() {

    score =
        Pyramid.score.longValue()
            + Pyramid.selectedCards.size() * 10L
            + combo().longValue()
            + bonus().longValue();
  }

  public Boolean isFinished() {

    Boolean andResult_9 = false;

    if (!(bonusPyramidDeck)) {
      if (!(bonusDeck)) {
        andResult_9 = true;
      }
    }

    if (andResult_9) {
      return true;

    } else {
      return false;
    }
  }

  public static Number getPoints(final Number num) {

    Number x = Utils.mod(num.longValue(), 13L);
    if (Utils.equals(x, 0L)) {
      return 13L;

    } else {
      return x;
    }
  }

  public Number getCard(final VDMSeq deckToGet) {

    Number position = new MATH().rand(deckToGet.size()).longValue() + 1L;
    deck = removeCard(Utils.copy(deckToGet), position);
    return ((Number) Utils.get(deckToGet, position));
  }

  public VDMSeq removeCard(final VDMSeq deckToRemove, final Number position) {

    return SeqUtil.conc(
        SeqUtil.subSeq(Utils.copy(deckToRemove), 1L, position.longValue() - 1L),
        SeqUtil.subSeq(Utils.copy(deckToRemove), position.longValue() + 1L, deck.size()));
  }

  public void deselectCard(
      final VDMSeq deckToRemove, final Number position, final Number y, final Number x) {

    selectedCards =
        SeqUtil.conc(
            SeqUtil.subSeq(Utils.copy(deckToRemove), 1L, position.longValue() - 1L),
            SeqUtil.subSeq(
                Utils.copy(deckToRemove), position.longValue() + 1L, Pyramid.selectedCards.size()));
    if (Utils.equals(y, 0L)) {
      selected =
          Pyramid.selected.longValue()
              - cg_Utils.cardToPoints(((Number) Utils.get(auxDeck, x))).longValue();
    } else {
      selected =
          Pyramid.selected.longValue()
              - cg_Utils.cardToPoints(((Number) Utils.get(((VDMSeq) Utils.get(pyramidDeck, y)), x)))
                  .longValue();
    }
  }

  public void removeSelectedCards() {
	  System.out.println("Aqui!14");
    long toVar_7 = Pyramid.selectedCards.size();
    System.out.println("Aqui!15");
    for (Long i = 1L; i <= toVar_7; i++) {System.out.println("Aqui!18 + " + Utils.get(selectedCards, i) + " + " + SeqUtil.seq(0L, 1L));
    	if((Utils.equals( ((Number) Utils.get( ((VDMSeq) Utils.get(selectedCards, i)), 1L)), 0L)) && (Utils.equals( ((Number) Utils.get(( (VDMSeq)Utils.get(selectedCards, i)), 2L)), 1L)) ){System.out.println("Aqui!19");
    // if (Utils.equals(((VDMSeq) Utils.get(selectedCards, i)), ((VDMSeq) SeqUtil.seq(0L, 1L)))) {System.out.println("Aqui!19");
        auxDeck = SeqUtil.tail(Utils.copy(Pyramid.auxDeck));System.out.println("Aqui!16");
      }
      else {System.out.println("Aqui!20 + " + Utils.get(selectedCards, i) + " + " + SeqUtil.seq(0L, 2L));
        if (Utils.equals(((VDMSeq) Utils.get(selectedCards, i)), ((VDMSeq) SeqUtil.seq(0L, 2L)))) {System.out.println("Aqui!17");
          auxDeck =
              SeqUtil.conc(
                  SeqUtil.seq(((Number) Utils.get(auxDeck, 1L))),
                  SeqUtil.subSeq(Utils.copy(auxDeck), 3L, Pyramid.auxDeck.size()));
        } else {System.out.println("Aqui!21");
          Utils.mapSeqUpdate(
              ((VDMSeq)
                  Utils.get(
                      pyramidDeck,
                      ((Number) Utils.get(((VDMSeq) Utils.get(selectedCards, i)), 1L)))),
              ((Number) Utils.get(((VDMSeq) Utils.get(selectedCards, i)), 2L)),
              0L);
        }
      }
    }
  }

  public static Number SumSet(final VDMSet s) {

    if (Utils.empty(s)) {
      return 0L;

    } else {
      Number letBeStExp_1 = null;
      Number e = null;
      Boolean success_1 = false;
      VDMSet set_2 = Utils.copy(s);
      for (Iterator iterator_2 = set_2.iterator(); iterator_2.hasNext() && !(success_1); ) {
        e = ((Number) iterator_2.next());
        success_1 = true;
      }
      if (!(success_1)) {
        throw new RuntimeException("Let Be St found no applicable bindings");
      }

      letBeStExp_1 =
          getPoints(e).longValue()
              + SumSet(SetUtil.diff(Utils.copy(s), SetUtil.set(e))).longValue();
      return letBeStExp_1;
    }
  }

  public String toString() {

    return "Pyramid{"
        + "deck := "
        + Utils.toString(deck)
        + ", pyramidDeck := "
        + Utils.toString(pyramidDeck)
        + ", auxDeck := "
        + Utils.toString(auxDeck)
        + ", validDeck := "
        + Utils.toString(validDeck)
        + ", selectedCards := "
        + Utils.toString(selectedCards)
        + ", score := "
        + Utils.toString(score)
        + ", selected := "
        + Utils.toString(selected)
        + ", bonusPyramidDeck := "
        + Utils.toString(bonusPyramidDeck)
        + ", bonusDeck := "
        + Utils.toString(bonusDeck)
        + "}";
  }
}
