package subscript.debug

import subscript.language
import subscript.Predef._
import subscript.SubScriptApplication

// import subscript.swing.Scripts._

object Main extends SubScriptApplication {
def live = subscript.DSL._script[Any](None, Symbol("live")){(_node: subscript.vm.Script[Any]) =>
  implicit val script = _node
subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("new MainFrame"))}
}

class MainFrame extends MainFrameTrait {
def live = subscript.DSL._script[Any](None, Symbol("live")){(_node: subscript.vm.Script[Any]) =>
  implicit val script = _node
subscript.DSL._seq(subscript.DSL._par_or(subscript.DSL._optionalBreak_loop, subscript.DSL._seq(subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("b")), subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("c")), subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("d")))), subscript.DSL._maybeCall("", (here: subscript.vm.model.callgraph.CallGraphTreeNode) => subscript.DSL._maybeVarCall("s")))}

}