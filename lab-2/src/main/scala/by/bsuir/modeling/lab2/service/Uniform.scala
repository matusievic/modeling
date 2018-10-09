package by.bsuir.modeling.lab2.service

object Uniform {
  def distribution(a: Double = 5, b: Double = 10, n: Int): Seq[Double] = {
    Statistics.LCG(n = n).map(r => a + (b - a) * r)
  }
}
