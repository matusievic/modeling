package by.bsuir.modeling.lab2.service

object Triangular {
  def distribution(a: Double = 5, b: Double = 10, n: Int): Seq[Double] = {
    Statistics.LCG(n = 2 * n).grouped(2).map(r => a + (b - a) * r.min).toSeq
  }
}
