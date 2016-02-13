package subscript.debug

import subscript.language
import subscript.Predef._
import subscript.objectalgebra._

import subscript.swing._
import scala.swing._

import subscript.vm._

trait Target {this: MainFrameTrait =>

  class RecordingTrigger(btn: Button) extends Trigger {
    var activatedFlag = false

override def lifecycle = subscript.DSL._script[Any](None, Symbol("lifecycle")){(_node: subscript.vm.Script[Any]) =>
  implicit val script = _node
subscript.DSL._at[subscript.vm.model.callgraph.CallGraphNode, subscript.vm.model.template.TemplateNode.Child](here => {
  implicit val there: subscript.vm.model.callgraph.CallGraphNode = here.there;

      subscript.DSL._maybeVarCall("there.onActivate {\n        subscript.DSL._maybeVarCall(\"println(subscript.DSL._maybeVarCall(\\\"\\\\\\\"Activated \\\\\\\" + this\\\"))\")\n        subscript.DSL._maybeVarCall(\"subscript.DSL._maybeVarAssignment(\\\"activatedFlag\\\", subscript.DSL._maybeVarCall(\\\"true\\\"))\")\n        subscript.DSL._maybeVarCall(\"activated += this\")\n      }")

      subscript.DSL._maybeVarCall("there.onSuccess  {\n        subscript.DSL._maybeVarCall(\"println(subscript.DSL._maybeVarCall(\\\"\\\\\\\"Succeeded \\\\\\\" + this\\\"))\")\n        subscript.DSL._maybeVarCall(\"activated  -= this\")\n        subscript.DSL._maybeVarCall(\"succeeded :+= this\")\n      }")

      subscript.DSL._maybeVarCall("there.onExclude {\n        subscript.DSL._maybeVarCall(\"println(subscript.DSL._maybeVarCall(\\\"\\\\\\\"Excluded \\\\\\\" + this\\\"))\")\n        if (subscript.DSL._maybeVarCall(\"this == c\")) subscript.DSL._maybeVarCall(\"println(subscript.DSL._maybeVarCall(\\\"activated + \\\\\\\" \\\\\\\" + runIsOver\\\"))\")\n        if (subscript.DSL._maybeVarCall(\"!runIsOver\")) subscript.DSL._maybeVarCall(\"activated -= this\")\n        if (subscript.DSL._maybeVarCall(\"this == c\")) subscript.DSL._maybeVarCall(\"println(subscript.DSL._maybeVarCall(\\\"activated\\\"))\")\n      }")

      subscript.DSL._maybeVarCall("there.onDeactivate {\n        subscript.DSL._maybeVarCall(\"println(subscript.DSL._maybeVarCall(\\\"\\\\\\\"Deactivated \\\\\\\" + this + \\\\\\\"\\\\\\\\n\\\\\\\"\\\"))\")\n        subscript.DSL._maybeVarCall(\"subscript.DSL._maybeVarAssignment(\\\"activatedFlag\\\", subscript.DSL._maybeVarCall(\\\"false\\\"))\")\n      }")

}).apply(subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("btn")))}

    override def toString = btn.text
  }

  var succeeded: List[RecordingTrigger] = Nil
  var activated: Set [RecordingTrigger] = Set()
  var runIsOver = true
  def reset() {
    succeeded = Nil
    activated = Set()
    runIsOver = true
  }

  val B = new RecordingTrigger(b)
  val C = new RecordingTrigger(c)
  val D = new RecordingTrigger(d)
  val E = new RecordingTrigger(e)
  val F = new RecordingTrigger(f)
  val G = new RecordingTrigger(g)
  val H = new RecordingTrigger(h)

  val S = new RecordingTrigger(s)


  val sampleStopper = new Trigger


def runWithInputScript(sn: ScriptNode[Any]) = subscript.DSL._script[Any](None, Symbol("runWithInputScript")){(_node: subscript.vm.Script[Any]) =>
  implicit val script = _node
subscript.DSL._seq(subscript.DSL._tiny[Any] (_node => {
  implicit val here = _node
subscript.DSL._maybeVarCall("subscript.DSL._maybeVarAssignment(\"runIsOver\", subscript.DSL._maybeVarCall(\"false\"))")
}, true), subscript.DSL._par_or2(subscript.DSL._disrupt(subscript.DSL._seq(subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("sn")), subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("S")), subscript.DSL._deadlock), subscript.DSL._seq(subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("sampleStopper")), subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("reset()")))), subscript.DSL._seq(subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("f")), subscript.DSL._tiny[Any] (_node => {
  implicit val here = _node
subscript.DSL._maybeVarCall("subscript.DSL._maybeVarAssignment(\"runIsOver\", subscript.DSL._maybeVarCall(\"true\"))")
}, true))), subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("println(subscript.DSL._maybeVarCall(\"activated\"))")))}
def fireTriggers(input: Seq[RecordingTrigger]) = {
  val i = subscript.DSL._declareNoType("subscript.DSL._maybeVarCall(\"0\")", scala.Symbol("i"))
  subscript.DSL._script[Any](None, Symbol("fireTriggers")){(_node: subscript.vm.Script[Any]) =>
  implicit val script = _node
subscript.DSL._seq(subscript.DSL._var(i, subscript.DSL._valueCodeNoType("subscript.DSL._maybeVarCall(\"0\")")), subscript.DSL._seq(subscript.DSL._while (_node => {
  implicit val here = _node
subscript.DSL._maybeVarCall("i < input.size")
}), subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("triggerWithin(subscript.DSL._maybeVarCall(\"50\"), subscript.DSL._maybeVarCall(\"input(subscript.DSL._maybeVarCall(\\\"i\\\"))\"))")), subscript.DSL._tiny[Any] (_node => {
  implicit val here = _node
subscript.DSL._maybeVarCall("i += 1")
}, true)), subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("sleep(subscript.DSL._maybeVarCall(\"50\"))")), subscript.DSL._tiny[Any] (_node => {
  implicit val here = _node
subscript.DSL._maybeVarCall("subscript.DSL._maybeVarAssignment(\"runIsOver\", subscript.DSL._maybeVarCall(\"true\"))")
}, true))}
  
}
def triggerWithin(maxDelay: Long, t: RecordingTrigger) = {
  val start = subscript.DSL._declareNoType("subscript.DSL._maybeVarCall(\"System.currentTimeMillis\")", scala.Symbol("start"))
  subscript.DSL._script[Any](None, Symbol("triggerWithin")){(_node: subscript.vm.Script[Any]) =>
  implicit val script = _node
subscript.DSL._seq(subscript.DSL._var(start, subscript.DSL._valueCodeNoType("subscript.DSL._maybeVarCall(\"System.currentTimeMillis\")")), subscript.DSL._seq(subscript.DSL._while (_node => {
  implicit val here = _node
subscript.DSL._maybeVarCall("!t.activatedFlag && System.currentTimeMillis - start <= maxDelay")
}), subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("sleep(subscript.DSL._maybeVarCall(\"10\"))"))), subscript.DSL._if_else (_node => {
  implicit val here = _node
subscript.DSL._maybeVarCall("System.currentTimeMillis - start <= maxDelay")
})(subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("t.trigger")), subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("sampleStopper.trigger"))))}
  
}

}
