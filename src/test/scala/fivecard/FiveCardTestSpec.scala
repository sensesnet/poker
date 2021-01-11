package fivecard


import com.evolutiongaming.bootcamp.assignment.poker.poker._
import com.evolutiongaming.bootcamp.assignment.poker.util.CardChecker.getScore
import com.evolutiongaming.bootcamp.assignment.poker.util.Suit._
import com.evolutiongaming.bootcamp.assignment.poker.util.Weight._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FiveCardTestSpec extends AnyWordSpec with Matchers {

  "Full House" in {
    val board = List(
      Card(Card_2, s),
      Card(Card_3, s),
      Card(Card_J, s),
      Card(Card_7, c),
      Card(Card_4, c))

    val hand = List(
      Card(Card_7, s),
      Card(Card_8, s),
      Card(Card_9, c),
      Card(Card_8, d),
      Card(Card_8, c))

    getScore(board, hand) shouldBe PokerHand("Full House", hand, 600, 8, 7)
  }

  "Test2: Full House" in {
    val boardCombination = List(
      Card(Card_9, d),
      Card(Card_T, s),
      Card(Card_4, c),
      Card(Card_K, d),
      Card(Card_7, h))

    val hand = List(
      Card(Card_K, s),
      Card(Card_Q, s),
      Card(Card_J, s),
      Card(Card_T, s),
      Card(Card_9, s),
      Card(Card_9, h))

    getScore(boardCombination, hand) shouldBe PokerHand("Full House", hand, 600, 9, 13)
  }
}
