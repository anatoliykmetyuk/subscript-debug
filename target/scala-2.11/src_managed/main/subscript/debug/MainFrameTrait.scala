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

implicit def key(c: subscript.vm.FormalConstrainedParameter[Char]) = subscript.DSL._script[Any](None, Symbol("key"), c.~??(Symbol("c"))){(_node: subscript.vm.Script[Any]) =>
  implicit val script = _node
subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("Scripts.key2(subscript.DSL._maybeVarCall(\"controlPanel\"), subscript.DSL._maybeVarCall(\"subscript.vm.ActualAdaptingParameter(c)\"))"))}
implicit def btn2script(b: Button) = subscript.DSL._script[Any](None, Symbol("btn2script")){(_node: subscript.vm.Script[Any]) =>
  implicit val script = _node
subscript.DSL._at[subscript.vm.model.callgraph.CallGraphNode, subscript.vm.model.template.TemplateNode.Child](here => {
  implicit val there: subscript.vm.model.callgraph.CallGraphNode = here.there;

      subscript.DSL._maybeVarCall("there.onActivate {\n        subscript.DSL._maybeVarCall(\"println(subscript.DSL._maybeVarCall(\\\"\\\\\\\"Activated \\\\\\\" + b.text\\\"))\")\n      }")

      subscript.DSL._maybeVarCall("there.onSuccess  {\n        subscript.DSL._maybeVarCall(\"println(subscript.DSL._maybeVarCall(\\\"\\\\\\\"Succeeded \\\\\\\" + b.text\\\"))\")\n      }")

      subscript.DSL._maybeVarCall("there.onExclude {\n        subscript.DSL._maybeVarCall(\"println(subscript.DSL._maybeVarCall(\\\"\\\\\\\"Excluded \\\\\\\" + b.text\\\"))\")\n      }")

      subscript.DSL._maybeVarCall("there.onDeactivate {\n        subscript.DSL._maybeVarCall(\"println(subscript.DSL._maybeVarCall(\\\"\\\\\\\"Deactivated \\\\\\\" + b.text + \\\\\\\"\\\\\\\\n\\\\\\\"\\\"))\")\n      }")

}).apply(subscript.DSL._alt(subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("Scripts.clicked(subscript.DSL._maybeVarCall(\"b\"))")), subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("b.text.head"))))}

}