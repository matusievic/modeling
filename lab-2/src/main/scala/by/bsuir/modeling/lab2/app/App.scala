package by.bsuir.modeling.lab2.app

import by.bsuir.modeling.lab2.service._

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.chart._
import scalafx.scene.control._
import scalafx.scene.layout.{HBox, VBox}

object App extends JFXApp {
  stage = new PrimaryStage {
    scene = new Scene {
      root = new TabPane {
        tabs = List(
          new Tab {
            text = "Uniform"
            content = new HBox {
              val histogram = BarChart(CategoryAxis(), NumberAxis())

              val a = new TextField {
                text = "5"
              }
              val b = new TextField {
                text = "10"
              }

              val mean = Label("m = ?")
              val dispersion = Label("d = ?")
              val deviation = Label("σ = ?")

              val ok = new Button {
                text = "OK"
                onMouseClicked = _ => {
                  val seq = Uniform.distribution(a = a.text.value.toDouble, b = b.text.value.toDouble, n = 100000)
                  val hist = Statistics.histogram(seq)
                  val data = ObservableBuffer(hist map { case (x, y) => XYChart.Data[String, Number](x.toString, y) })
                  histogram.data = List(XYChart.Series[String, Number]("Histogram", data))

                  mean.text = f"m = ${Statistics.mean(seq)}%1.3f"
                  dispersion.text = f"d = ${Statistics.dispersion(seq)}%1.3f"
                  deviation.text = f"σ = ${Statistics.deviation(seq)}%1.3f"
                }
              }

              children = List(histogram, new VBox(Label("a:"), a, Label("b:"), b, ok, mean, deviation, dispersion))
            }
          },

          new Tab {
            text = "Gaussian"
            content = new HBox {
              val histogram = BarChart(CategoryAxis(), NumberAxis())

              val m = new TextField {
                text = "10"
              }
              val sigma = new TextField {
                text = "2"
              }

              val mean = Label("m = ?")
              val dispersion = Label("d = ?")
              val deviation = Label("σ = ?")

              val ok = new Button {
                text = "OK"
                onMouseClicked = _ => {
                  val seq = Gaussian.distribution(m = m.text.value.toDouble, sigma = sigma.text.value.toDouble, n = 100000)
                  val hist = Statistics.histogram(seq)
                  val data = ObservableBuffer(hist map { case (x, y) => XYChart.Data[String, Number](x.toString, y) })
                  histogram.data = List(XYChart.Series[String, Number]("Histogram", data))

                  mean.text = f"m = ${Statistics.mean(seq)}%1.3f"
                  dispersion.text = f"d = ${Statistics.dispersion(seq)}%1.3f"
                  deviation.text = f"σ = ${Statistics.deviation(seq)}%1.3f"
                }
              }

              children = List(histogram, new VBox(Label("m:"), m, Label("σ:"), sigma, ok, mean, deviation, dispersion))
            }
          },

          new Tab {
            text = "Exponential"
            content = new HBox {
              val histogram = BarChart(CategoryAxis(), NumberAxis())

              val l = new TextField {
                text = "5"
              }


              val mean = Label("m = ?")
              val dispersion = Label("d = ?")
              val deviation = Label("σ = ?")

              val ok = new Button {
                text = "OK"
                onMouseClicked = _ => {
                  val seq = Exponential.distribution(l = l.text.value.toDouble, n = 100000)
                  val hist = Statistics.histogram(seq)
                  val data = ObservableBuffer(hist map { case (x, y) => XYChart.Data[String, Number](x.toString, y) })
                  histogram.data = List(XYChart.Series[String, Number]("Histogram", data))

                  mean.text = f"m = ${Statistics.mean(seq)}%1.3f"
                  dispersion.text = f"d = ${Statistics.dispersion(seq)}%1.3f"
                  deviation.text = f"σ = ${Statistics.deviation(seq)}%1.3f"
                }
              }

              children = List(histogram, new VBox(Label("l:"), l, ok, mean, deviation, dispersion))
            }
          },

          new Tab {
            text = "Gamma"
            content = new HBox {
              val histogram = BarChart(CategoryAxis(), NumberAxis())

              val l = new TextField {
                text = "5"
              }

              val mean = Label("m = ?")
              val dispersion = Label("d = ?")
              val deviation = Label("σ = ?")

              val ok = new Button {
                text = "OK"
                onMouseClicked = _ => {
                  val seq = Gamma.distribution(l = l.text.value.toDouble, n = 100000)
                  val hist = Statistics.histogram(seq)
                  val data = ObservableBuffer(hist map { case (x, y) => XYChart.Data[String, Number](x.toString, y) })
                  histogram.data = List(XYChart.Series[String, Number]("Histogram", data))

                  mean.text = f"m = ${Statistics.mean(seq)}%1.3f"
                  dispersion.text = f"d = ${Statistics.dispersion(seq)}%1.3f"
                  deviation.text = f"σ = ${Statistics.deviation(seq)}%1.3f"
                }
              }

              children = List(histogram, new VBox(Label("l:"), l, ok, mean, deviation, dispersion))
            }
          },

          new Tab {
            text = "Triangular"
            content = new HBox {
              val histogram = BarChart(CategoryAxis(), NumberAxis())

              val a = new TextField {
                text = "5"
              }
              val b = new TextField {
                text = "10"
              }

              val mean = Label("m = ?")
              val dispersion = Label("d = ?")
              val deviation = Label("σ = ?")

              val ok = new Button {
                text = "OK"
                onMouseClicked = _ => {
                  val seq = Triangular.distribution(a = a.text.value.toDouble, b = b.text.value.toDouble, n = 100000)
                  val hist = Statistics.histogram(seq)
                  val data = ObservableBuffer(hist map { case (x, y) => XYChart.Data[String, Number](x.toString, y) })
                  histogram.data = List(XYChart.Series[String, Number]("Histogram", data))

                  mean.text = f"m = ${Statistics.mean(seq)}%1.3f"
                  dispersion.text = f"d = ${Statistics.dispersion(seq)}%1.3f"
                  deviation.text = f"σ = ${Statistics.deviation(seq)}%1.3f"
                }
              }

              children = List(histogram, new VBox(Label("a:"), a, Label("b:"), b, ok, mean, deviation, dispersion))
            }
          },

          new Tab {
            text = "Simpson"
            content = new HBox {
              val histogram = BarChart(CategoryAxis(), NumberAxis())

              val a = new TextField {
                text = "5"
              }
              val b = new TextField {
                text = "10"
              }


              val mean = Label("m = ?")
              val dispersion = Label("d = ?")
              val deviation = Label("σ = ?")

              val ok = new Button {
                text = "OK"
                onMouseClicked = _ => {
                  val seq = Simpson.distribution(a = a.text.value.toDouble, b = b.text.value.toDouble, n = 100000)
                  val hist = Statistics.histogram(seq)
                  val data = ObservableBuffer(hist map { case (x, y) => XYChart.Data[String, Number](x.toString, y) })
                  histogram.data = List(XYChart.Series[String, Number]("Histogram", data))

                  mean.text = f"m = ${Statistics.mean(seq)}%1.3f"
                  dispersion.text = f"d = ${Statistics.dispersion(seq)}%1.3f"
                  deviation.text = f"σ = ${Statistics.deviation(seq)}%1.3f"
                }
              }

              children = List(histogram, new VBox(Label("a:"), a, Label("b:"), b, ok, mean, deviation, dispersion))
            }
          }

        )
      }
    }
  }
}