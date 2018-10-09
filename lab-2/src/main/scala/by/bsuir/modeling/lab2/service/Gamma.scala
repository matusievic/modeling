package by.bsuir.modeling.lab2.service

object Gamma {
  def distribution(l: Double = 5, n: Int): Seq[Double] = {
    val den = math.log10(math.E)
    Statistics.LCG(n = 6 * n).grouped(6).map(r => (-1 / l) * math.log10(r.product) / den).toSeq
  }
}
