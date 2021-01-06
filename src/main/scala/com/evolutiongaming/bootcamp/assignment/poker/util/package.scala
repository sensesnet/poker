package com.evolutiongaming.bootcamp.assignment.poker

import com.evolutiongaming.bootcamp.assignment.poker.util.{Suit, Weight}

package object pocker {

  case class Card(weight: Weight,
                  suit: Suit)

  case class PokerHand(combination: String,
                       hand: List[Card],
                       score: Int,
                       combinationCardScore: Int = 0,
                       kickerCardScore: Int = 0)

  case class Result(
                    hand: List[Card],
                    combination: String,
                    score: Int,
                    combo_score: Int = 0,
                    kicker_score: Int = 0)
}
