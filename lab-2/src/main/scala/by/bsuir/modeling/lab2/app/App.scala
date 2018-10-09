package by.bsuir.modeling.lab2.app

import by.bsuir.modeling.lab2.service
import by.bsuir.modeling.lab2.service._

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.chart._
import scalafx.scene.control._

object App extends JFXApp {
  stage = new PrimaryStage {
    scene = new Scene {
      root = new TabPane {
        tabs = List(new Tab {
          val histogram = {
            val seq = Simpson.distribution(n = 100000)
            val histo = service.Statistics.histogram(seq)
            val dataHist = ObservableBuffer(histo map { case (x, y) => XYChart.Data[String, Number](x.toString, y) })
            new BarChart(CategoryAxis(), NumberAxis()) {
              data.get().add(XYChart.Series[String, Number]("Histogram", dataHist))
            }
          }

          content = histogram
        })
      }




      /*new HBox {
        val seq = Service.LCG(r0 = 3141592, a = 491, m = 10e14, n = 200)

        val histogram = {
          val histo = Service.histogram(seq)
          val dataHist = ObservableBuffer(histo map { case (x, y) => XYChart.Data[String, Number](x.toString, y) })
          new BarChart(CategoryAxis(), NumberAxis()) {
            data.get().add(XYChart.Series[String, Number]("Histogram", dataHist))
          }
        }

        content = histogram

        val grid = new GridPane {
          val mean = Label(f"m = ${Service.mean(seq)}%1.3f")
          val dispersion = Label(f"d = ${Service.dispersion(seq)}%1.3f")
          val deviation = Label(f"σ = ${Service.deviation(seq)}%1.3f")

          addRow(1, mean)
          addRow(2, dispersion)
          addRow(3, deviation)

          val test = {
            val t = Service.test(seq)
            Label(f"${t._1}%1.3f == ${t._2}%1.3f")
          }

          addRow(4, test)

          val r0 = new TextField {
            text = "3141592"
          }
          val a = new TextField {
            text = "491"
          }
          val m = new TextField {
            text = "10e14"
          }

          addRow(5, Label("r0 = "), r0)
          addRow(6, Label("a = "), a)
          addRow(7, Label("m = "), m)

          val calculate = new Button {
            text = "Calculate"
            onMouseClicked = _ => {
              val seq = Service.LCG(r0 = r0.text.value.toDouble, a = a.text.value.toDouble, m = m.text.value.toDouble, n = 200)
              val histo = Service.histogram(seq)
              val data = ObservableBuffer(histo map { case (x, y) => XYChart.Data[String, Number](x.toString, y) })

              histogram.getData().clear()
              histogram.getData().add(XYChart.Series("Histogram", data))

              mean.text = f"m = ${Service.mean(seq)}%1.3f"
              dispersion.text = f"d = ${Service.dispersion(seq)}%1.3f"
              deviation.text = f"σ = ${Service.deviation(seq)}%1.3f"
            }
          }

          addRow(8, calculate)

        }

        children = List(histogram, grid)
      }*/
    }
  }
}