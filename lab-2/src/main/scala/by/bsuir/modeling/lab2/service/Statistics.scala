package by.bsuir.modeling.lab2.service

import scala.annotation.tailrec

object Statistics {
  def LCG(r0: Double = 1, a: Double = 134279, m: Double = 313107, n: Int): Seq[Double] = {
    @tailrec
    def iter(acc: List[Double] = List(), r: Double, i: Int): List[Double] = {
      if (i >= n) {
        acc
      } else {
        val cur = (a * r) % m
        iter(cur / m :: acc, cur, i + 1)
      }
    }
    iter(r = r0, i = 0)
  }

  def histogram(seq: Seq[Double]): Seq[(Double, Double)] = {
    val delta = (seq.max - seq.min) / 20
    val n = seq.length.toDouble

    def iter(left: Double, i: Int): List[(Double, Double)] =
      if (i < 20) (left, seq.count(d => d >= left && d <= left + delta) / n) :: iter(left + delta, i + 1)
      else Nil

    iter(seq.min, 0)
  }

  def mean(seq: Seq[Double]): Double = seq.sum / seq.length

  def dispersion(seq: Seq[Double]): Double = {
    val m = mean(seq)
    seq.map(i => math.pow(i - m, 2)).sum / (seq.length - 1)
  }

  def deviation(seq: Seq[Double]): Double = math.sqrt(dispersion(seq))
}
