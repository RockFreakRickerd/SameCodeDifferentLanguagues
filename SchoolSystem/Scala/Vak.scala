package Scala

import scala.util._

class Vak(module:String, jaargegeven: Int) {
  private var cijfers= List[Double]()
  private var moduleCode = module
  private var jaar = jaargegeven

  def setModuleCode(module: String)={
    this.moduleCode = module
  }

  def getModuleCode(): String= {
    return moduleCode
  }

  def getJaar(): Int={
    return jaar
  }

  def getCijfers(): List[Double]={
    return cijfers
  }

  def setCijfers(cijfer: Double): Unit ={
    cijfers = cijfer::cijfers
  }
}
