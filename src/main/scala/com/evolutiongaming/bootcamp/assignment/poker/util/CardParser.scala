package com.evolutiongaming.bootcamp.assignment.poker.util

import com.evolutiongaming.bootcamp.assignment.poker.exception.ExceptionHandler.CardParserException
import com.evolutiongaming.bootcamp.assignment.poker.pocker.Card
import com.evolutiongaming.bootcamp.assignment.poker.exception.ExceptionMessages._

object CardParser {

  def parseCards(boardStr: String, handStrList: List[String]): (List[Card], List[List[Card]]) = {
    try {
      val board: List[Card] = parseCardsFromString(boardStr)
      val hand: List[List[Card]] = parseCardsFromList(handStrList)
      (board, hand)
    } catch {
      case e: NoSuchElementException => throw CardParserException(s"$wrongParseCard ${e.getMessage}")
    }
  }

  private def getCardByString(str: String): Card =
    Card(
      Weight.withName(s"Card_${str.head.toUpper}"),
      Suit.withNameLowercaseOnly(str.tail)
    )

  private def parseCardsFromString(str: String): List[Card] =
    str.split(s"(?<=\\G.{2})")
      .map(cons => getCardByString(cons))
      .toList

  private def parseCardsFromList(hands: List[String]): List[List[Card]] =
    hands.map(cons => parseCardsFromString(cons))

  def decodeCards(cards: List[Card]): String =
    cards.map(card => s"${card.weight.identifier}${card.suit.toString}").mkString("")
}
