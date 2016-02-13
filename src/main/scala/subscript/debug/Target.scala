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

    override script lifecycle = @{
      there.onActivate {
        println("Activated " + this)
        activatedFlag = true
        activated += this
      }

      there.onSuccess  {
        println("Succeeded " + this)
        activated  -= this
        succeeded :+= this
      }

      there.onExclude {
        println("Excluded " + this)
        if (this == c) println(activated + " " + runIsOver)
        if (!runIsOver) activated -= this
        if (this == c) println(activated)
      }

      there.onDeactivate {
        println("Deactivated " + this + "\n")
        activatedFlag = false
      }
    }: btn

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


  script..
    runWithInputScript(sn: ScriptNode[Any]) =//, input: Seq[RecordingTrigger]) =
      let runIsOver = false
      [sn S [-] / sampleStopper reset()] || f let runIsOver = true
      println: activated

    fireTriggers(input: Seq[RecordingTrigger]) =
      var i = 0
      [
        while(i < input.size)
        triggerWithin: 50, input(i)
        let i += 1
      ]
      sleep: 50
      let runIsOver = true

    // Waits for the trigger script to be activated, but only for maxDelay
    triggerWithin(maxDelay: Long, t: RecordingTrigger) =
      var start = System.currentTimeMillis
      [while(!t.activatedFlag && System.currentTimeMillis - start <= maxDelay) sleep: 10]
      if System.currentTimeMillis - start <= maxDelay then t.trigger else sampleStopper.trigger

}
