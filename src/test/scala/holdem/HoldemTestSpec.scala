package holdem

import com.evolutiongaming.bootcamp.assignment.poker.pocker.{Card, PokerHand}
import com.evolutiongaming.bootcamp.assignment.poker.util.Weight._
import com.evolutiongaming.bootcamp.assignment.poker.util.Suit._
import com.evolutiongaming.bootcamp.assignment.poker.util.CardChecker._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class HoldemTestSpec extends AnyWordSpec with Matchers{

  "High Card" in {
    val board = List(
      Card(Card_9, d),
      Card(Card_T, s),
      Card(Card_4, c),
      Card(Card_K, d),
      Card(Card_7, h))

    val hand = List(
      Card(Card_A, d),
      Card(Card_2, d))

    getScore(board, hand) shouldBe PokerHand("High Card", hand, 14, 39)
  }

  "Test flush" in {
    val board = List(
      Card(Card_2, s),
      Card(Card_3, s),
      Card(Card_J, s),
      Card(Card_7, c),
      Card(Card_4, c))

    val hand = List(
      Card(Card_7, s),
      Card(Card_A, s))

    getScore(board, hand) shouldBe PokerHand("Flush", hand, 500, 37)
  }

  "Test pair" in {
    val board = List(
      Card(Card_2, s),
      Card(Card_3, s),
      Card(Card_J, s),
      Card(Card_7, c),
      Card(Card_4, c))

    val hand = List(
      Card(Card_7, s),
      Card(Card_A, c))
    getScore(board, hand) shouldBe PokerHand("Pair", hand, 100, 14, 29)
  }

  "Test 3 of a kind" in {
    val board = List(
      Card(Card_J, d),
      Card(Card_J, c),
      Card(Card_J, s),
      Card(Card_2, c),
      Card(Card_4, d))

    val hand = List(
      Card(Card_9, s),
      Card(Card_A, h))

    getScore(board, hand) shouldBe PokerHand("Three of a Kind", hand, 300, 33, 23)
  }

  "Test 4 of a kind" in {
    val board = List(
      Card(Card_J, d),
      Card(Card_J, c),
      Card(Card_J, s),
      Card(Card_A, c),
      Card(Card_A, d))

    val hand = List(
      Card(Card_A, s),
      Card(Card_A, h))

    getScore(board, hand) shouldBe PokerHand("Four of a Kind", hand, 700, 56, 11)
  }

  "Test full house" in {
    val board = List(
      Card(Card_J, d),
      Card(Card_J, c),
      Card(Card_J, s),
      Card(Card_K, c),
      Card(Card_A, d))

    val hand = List(
      Card(Card_A, s),
      Card(Card_A, h))

    getScore(board, hand) shouldBe PokerHand("Full House", hand, 600, 14, 11)

    val hand2 = List(
      Card(Card_A, s),
      Card(Card_A, h))

    getScore(board, hand2) shouldBe PokerHand("Full House", hand2, 600, 14, 11)
  }

  "Test straight" in {
    val board = List(
      Card(Card_2, d),
      Card(Card_3, c),
      Card(Card_4, s),
      Card(Card_5, c),
      Card(Card_6, d))

    val hand = List(
      Card(Card_7, s),
      Card(Card_8, h))

    getScore(board, hand) shouldBe PokerHand("Straight", hand, 400, 30)

    val board2 = List(
      Card(Card_J, d),
      Card(Card_J, c),
      Card(Card_2, s),
      Card(Card_3, c),
      Card(Card_4, d))

    val hand2 = List(
      Card(Card_5, s),
      Card(Card_6, h))
    getScore(board2, hand2) shouldBe PokerHand("Straight", hand2, 400, 20)

    val board3 = List(
      Card(Card_J, d),
      Card(Card_2, c),
      Card(Card_3, s),
      Card(Card_4, c),
      Card(Card_5, d))

    val hand3 = List(
      Card(Card_6, s),
      Card(Card_K, h))
    getScore(board3, hand3) shouldBe PokerHand("Straight", hand3, 400, 20)

    val board4 = List(
      Card(Card_J, d),
      Card(Card_Q, c),
      Card(Card_3, s),
      Card(Card_4, c),
      Card(Card_5, d))

    val hand4 = List(
      Card(Card_6, s),
      Card(Card_7, h)
    )
    getScore(board4, hand4) shouldBe PokerHand("Straight", hand4, 400, 25)
  }

  "Test straight flush" in {
    val board = List(
      Card(Card_4, d),
      Card(Card_5, d),
      Card(Card_7, d),
      Card(Card_6, d),
      Card(Card_8, d))

    val hand = List(
      Card(Card_2, s),
      Card(Card_9, s))

    getScore(board, hand) shouldBe PokerHand("Straight Flush", hand, 800, 35)
  }

  "Test royal flush" in {
    val board = List(
      Card(Card_9, d),
      Card(Card_T, d),
      Card(Card_J, d),
      Card(Card_K, d),
      Card(Card_Q, d))

    val hand = List(
      Card(Card_A, d),
      Card(Card_2, d))

    getScore(board, hand) shouldBe PokerHand("Straight Flush", hand, 800, 60)
  }
}
