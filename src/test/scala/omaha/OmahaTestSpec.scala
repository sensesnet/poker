package omaha

import com.evolutiongaming.bootcamp.assignment.poker.pocker.{Card, PokerHand}
import com.evolutiongaming.bootcamp.assignment.poker.util.Suit._
import com.evolutiongaming.bootcamp.assignment.poker.util.Weight._
import com.evolutiongaming.bootcamp.assignment.poker.util.CardChecker._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class OmahaTestSpec extends AnyWordSpec with Matchers {

  "High Card" in {
    val boardCombination = List(
      Card(Card_9, d),
      Card(Card_T, s),
      Card(Card_4, c),
      Card(Card_K, d),
      Card(Card_7, h))

    val hand = List(
      Card(Card_A, c),
      Card(Card_2, c),
      Card(Card_A, d),
      Card(Card_2, d))

    getScore(boardCombination, hand) shouldBe PokerHand("Two Pairs", hand, 200,14,13)
  }
}
