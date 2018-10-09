package by.bsuir.modeling.lab2.service

object Exponential {
  def distribution(l: Double = 5, n: Int): Seq[Double] = {
    val den = math.log10(math.E)
    Statistics.LCG(n = n).map(r => (-1 / l) * (math.log10(r) / den))
  }
}
