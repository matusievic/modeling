package by.bsuir.modeling.lab2.service

object Gaussian {
  def distribution(m: Double = 10, o: Double = 2, n: Int): Seq[Double] = {
    val sqrt = math.sqrt(2)
    Statistics.LCG(n = n * 6).grouped(6).map(r => m + o * sqrt * (r.sum - 3)).toSeq
  }
}
