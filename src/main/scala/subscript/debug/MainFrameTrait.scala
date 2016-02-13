package subscript.debug

import subscript.language
import subscript.Predef._

import subscript.swing._
// import subscript.swing.Scripts._

import scala.swing._
import scala.swing.BorderPanel.Position._

trait MainFrameTrait extends FrameProcess {
  title     = "Debug Playground"
  location  = new Point(300, 300)
  resizable = false

  // Control panel
  val a = new Button("a") {enabled = false}
  val b = new Button("b") {enabled = false}
  val c = new Button("c") {enabled = false}
  val d = new Button("d") {enabled = false}
  val e = new Button("e") {enabled = false}
  val f = new Button("f") {enabled = false}
  val g = new Button("g") {enabled = false}
  val h = new Button("h") {enabled = false}
  val i = new Button("i") {enabled = false}
  val j = new Button("j") {enabled = false}
  val k = new Button("k") {enabled = false}
  val l = new Button("l") {enabled = false}
  val m = new Button("m") {enabled = false}
  val n = new Button("n") {enabled = false}
  val o = new Button("o") {enabled = false}
  val p = new Button("p") {enabled = false}
  val q = new Button("q") {enabled = false}
  val r = new Button("r") {enabled = false}
  val s = new Button("s") {enabled = false}
  val t = new Button("t") {enabled = false}
  val u = new Button("u") {enabled = false}
  val v = new Button("v") {enabled = false}
  val w = new Button("w") {enabled = false}
  val x = new Button("x") {enabled = false}
  val y = new Button("y") {enabled = false}
  val z = new Button("z") {enabled = false}

  val controlPanel = new GridPanel(5, 6) {contents ++= Seq(
    a,b,c,d,e,
    f,g,h,i,j,
    k,l,m,n,o,
    p,q,r,s,t,
    u,v,w,x,y,
    z
  )}

  contents = controlPanel

  controlPanel.listenTo(controlPanel.keys)
  controlPanel.requestFocus

  implicit script..
    key(??c: Char) = Scripts.key2: controlPanel, ??c
    btn2script(b: Button) = @{
      there.onActivate {
        println("Activated " + b.text)
      }

      there.onSuccess  {
        println("Succeeded " + b.text)
      }

      there.onExclude {
        println("Excluded " + b.text)
      }

      there.onDeactivate {
        println("Deactivated " + b.text + "\n")
      }
    }:[Scripts.clicked(b) + b.text.head]

}