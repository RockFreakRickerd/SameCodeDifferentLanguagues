package School
import scala.util._

class Student(nummer:String, newnaam:String, newgeslacht: String, newklas:String, newstudieInrichting:String) {
  private var vakken = List[Vak]()
  private var studentNr = nummer
  private var naam = newnaam
  private var geslacht = newgeslacht
  private var klas = newklas
  private var studieInrichting = newstudieInrichting
  private val red = "31m"
  private val black = "0m"

  def newVakken(newVak:String, jaargegeven:Int) ={
    var vak = new Vak(newVak, jaargegeven)
    vakken = vak::vakken
  }

  def getNaam():String ={
    return naam
  }

  def getGeslacht():String ={
    return geslacht
  }

  def getStudentenNummer(): String ={
    return studentNr
  }

  def getVakken(): List[Vak] ={
    return vakken
  }

  def getVak(moduleCode: String):Vak ={
    if(vakken.isEmpty){
      return null
    }
    for(i <- vakken){
      if(i.getModuleCode().equalsIgnoreCase(moduleCode)){
        return i
      }
    }
    return null
  }

  def deviatie():Double ={
    var gemiddeldes = List[Double]()
    println("\nStandaardDeviatie van "+studentNr+": ")
    var deviatie = 0.0
    for(i<- vakken) {
      for(j<- i.getCijfers())
        gemiddeldes = j::gemiddeldes
    }
    if(gemiddeldes.isEmpty){
      println("No records found")
      return 0.0
    }
    var average = 0.0
    for(i<- gemiddeldes){
      average += i
    }
    average = average/gemiddeldes.size
    var devKwadraat = 0.0
    for(i<- gemiddeldes){
      devKwadraat += math.pow(i-average, 2)
    }
    return devKwadraat/gemiddeldes.size
  }
}
