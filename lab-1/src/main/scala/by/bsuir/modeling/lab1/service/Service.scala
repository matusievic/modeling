package by.bsuir.modeling.lab1.service

object Service {
  def LCG(r0: Double, a: Double, m: Double, n: Int): Seq[Double] = {
    def iter(r: Double, i: Int): List[Double] =
      if (i <= n) {
        val cur = a * r % m
        (r / m) :: iter(cur, i + 1)
      }
      else Nil

    iter(r0, 0)
  }

  def histogram(seq: Seq[Double]): Seq[(Double, Double)] = {
    val delta = (seq.max - seq.min) / 20
    val n = seq.length.toDouble

    def iter(left: Double, i: Int): List[(Double, Double)] =
      if (i < 20) (left, seq.count(d => d >= left && d <= left + delta) / n) :: iter(left + delta, i + 1)
      else Nil

    iter(seq.min, 0)
  }
}
