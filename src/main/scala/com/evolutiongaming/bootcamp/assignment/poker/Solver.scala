package com.evolutiongaming.bootcamp.assignment.poker

import com.evolutiongaming.bootcamp.assignment.poker.exception.ExceptionHandler._
import com.evolutiongaming.bootcamp.assignment.poker.poker.Card
import com.evolutiongaming.bootcamp.assignment.poker.util.CardAnalyzer._
import com.evolutiongaming.bootcamp.assignment.poker.util.CardParser._
import com.evolutiongaming.bootcamp.assignment.poker.util.GameDataAnalyzer._
import com.evolutiongaming.bootcamp.assignment.poker.exception.ExceptionMessages._

object Solver {

  def process(line: String): String =
    line.toLowerCase.split("\\s+").toList match {
      case "texas-holdem" :: board :: hands => sortForTexasHoldem(board, hands)
      case "omaha-holdem" :: board :: hands => sortForOmahaHoldem(board, hands)
      case "five-card-draw" :: board :: hands => sortForFiveCardDraw(board, hands)
      case x :: _ => s"$unrecognizedGameData"
      case _ => s"$invalidInputData"
    }

  def sortForTexasHoldem(boardStr: String, handStrList: List[String]): String = {
    try {
      val (board: List[Card], hand: List[List[Card]]) = parseCards(boardStr, handStrList)
      analyzeTexasHoldemData(board, hand)
      analyzeGame(board, hand)
    } catch {
      case e: CardParserException => e.message
      case e: TexasHoldemPokerException => e.message
      case e: GameAnalyzeException => e.message
    }
  }

  def sortForOmahaHoldem(boardStr: String, handStrList: List[String]): String = {
    try {
      val (board: List[Card], hand: List[List[Card]]) = parseCards(boardStr, handStrList)
      analyzeOmahaHoldemData(board, hand)
      analyzeGame(board, hand)
    } catch {
      case e: CardParserException => e.message
      case e: OmahaHoldemPokerException => e.message
      case e: GameAnalyzeException => e.message
    }
  }

  def sortForFiveCardDraw(boardStr: String, handStrList: List[String]): String = {
    try {
      val (board: List[Card], hand: List[List[Card]]) = parseCards(boardStr, handStrList)
      analyzeFiveCardDrawData(board, hand)
      analyzeGame(board, hand)
    } catch {
      case e: CardParserException => e.message
      case e: FiveCardDrawPokerException => e.message
      case e: GameAnalyzeException => e.message
    }
  }
}
