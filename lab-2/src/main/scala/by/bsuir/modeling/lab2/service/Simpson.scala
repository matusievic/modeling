package by.bsuir.modeling.lab2.service

object Simpson {
  def distribution(a: Double = 5, b: Double = 10, n: Int): Seq[Double] = {
    Uniform.distribution(a = a / 2, b = b / 2, n = 2 * n).grouped(2).map(_.sum).toSeq
  }
}
