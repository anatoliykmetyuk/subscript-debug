package subscript.debug

import subscript.language
import subscript.Predef._
import subscript.SubScriptApplication

// import subscript.swing.Scripts._

object Main extends SubScriptApplication {
  script live = new MainFrame
}

class MainFrame extends MainFrameTrait {
  script..
    live = [..? & b c d] s

}