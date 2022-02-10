import scala.util._
import Scala._

class Administratie {
  private var students = List[Student]()
  private val red = "\u001B[31m"
  private val black = "\u001B[0m"

  def addStudents(student: Student): Unit = {
    if(students.contains(student)){
      println(red+"Already in database"+black)
    }else{
      students = student::students
    }
  }

  def gemiddelde(student: Student, vak: String): Double ={
    if(student.getVak(vak) == null){
      return 0.0
    }
    var cijfers = student.getVak(vak).getCijfers()
    if(cijfers.isEmpty){
      return 0.0
    }
    var average = 0.0
    for(i<- cijfers){
      average+=i
    }
    return average/cijfers.size
  }

  def battleOfTheSexte(vak:String): Any ={
    println("\n\nMannen vs Vrouwen voor vak "+vak+": ")
    var gemiddeldeMannen = List[Double]()
    var gemiddeldeVrouwen = List[Double]()
    var gemM = 0.0
    var gemV = 0.0
    for(i<- students
        if i.getVak(vak) != null
        if i.getGeslacht().equalsIgnoreCase("M")){
      gemiddeldeMannen = gemiddelde(i, vak)::gemiddeldeMannen
    }
    for(i<- students
        if i.getVak(vak) != null
        if i.getGeslacht().equalsIgnoreCase("V")){
      gemiddeldeVrouwen = gemiddelde(i, vak)::gemiddeldeVrouwen
    }
    if(gemiddeldeMannen.isEmpty && gemiddeldeVrouwen.isEmpty){
      println(red+"No grades available"+black)
      return
    }else {
      println("Gemiddeldes van alle mannen:")
      gemiddeldeMannen.foreach(x => println(x))
      println("Gemiddeldes van alle vrouwen:")
      gemiddeldeVrouwen.foreach(x=>println(x))
      if(!gemiddeldeMannen.isEmpty){
        gemiddeldeMannen.foreach(x=> gemM +=x)
        gemM /= gemiddeldeMannen.size
      }
      if(!gemiddeldeVrouwen.isEmpty){
        gemiddeldeVrouwen.foreach(x=> gemV +=x)
        gemV /= gemiddeldeVrouwen.size
      }

      if(gemM> gemV){
        println("\nMannen hebben beter gescoord dan vrouwen.")
      }else if (gemM == gemV){
        println("\nMannen en vrouwen hebben gelijkmatig gescoord")
      }else if (gemM < gemV){
        println("\nMannen hebben slechter gescoord dan vrouwen")
      }
      printf("\nGemiddelde van mannen: %.2f", gemM)
      printf("\nGemiddelde van vrouwen: %.2f", gemV)
    }
  }
//-----------------------Tot hier staat het in c++---------------------
//---------------Na dit stukje van Administratie alleen App nog -------
  
  def printVariatie(vak: String): Any={
    var gemiddeldes = List[Double]()
    println(s"\nVariantie van $vak: ")
    var variantie = 0
    var outputList = List[Double]()
    students.filter(x=> x.getVak(vak) != null).foreach(x=> outputList = x.getVak(vak).getCijfers())
    println(outputList)
    outputList.foreach(i=> gemiddeldes = i::gemiddeldes)
    if(gemiddeldes.isEmpty){
      println(red+"No records found"+black)
      return
    }
    var average = 0.0
    gemiddeldes.foreach(x=> average += x)
    average /= gemiddeldes.size
    var devKwadraat= 0.0
    gemiddeldes.foreach(x=> devKwadraat += Math.pow(x-average, 2))
    devKwadraat /= gemiddeldes.size
    if(devKwadraat.isNaN){
      println("Er is geen variantie.")
    }else{
      println("De variantie is "+devKwadraat)
    }
  }

  def printAlleCijfers(student: Student): Unit ={
    var vakkenVanStudent = student.getVakken()
    var cijfers = List[Double]()
    for(vak <- vakkenVanStudent){
      cijfers = getCijfer(student, vak.getModuleCode())
      println("\nCijfers van student "+student.getNaam()+" voor vak "+vak.getModuleCode()+":")
      if(cijfers.isEmpty){
        println("No grades found.")
      }else{
        cijfers.foreach(x=> println(x))
      }
    }
  }

  def printVakken(student: Student): Unit ={
    var vakkenVanStudent = student.getVakken()
    println("\nVakken die student "+student.getNaam()+"volgt:")
    vakkenVanStudent.foreach(x=> println(x.getModuleCode()+" en wordt gegeven in jaar "+x.getJaar()))
  }

  def printDeviatie(student: Student): Unit ={
    var deviatie = student.deviatie()
    printf("Deviatie van "+student.getNaam()+" is %.2f", deviatie)
  }

  def behaald(student: Student): Unit ={
    val vakkenVanStudent = student.getVakken()
    println("\nVakken die student "+student.getStudentenNummer()+" heeft behaald")
    vakkenVanStudent.filter(x=> gemiddelde(student, x.getModuleCode())>= 6.0).foreach(x=> println(x.getModuleCode()))
  }

  def behaald(vak: String): Unit ={
    println("\nStudenten die deze vak behaald hebben "+vak+": ")
    students.filter(x=> gemiddelde(x, vak) >=6.0).foreach(x=> println(x.getNaam()))
  }

  def onbehaald(student: Student): Unit ={
    val vakkenVanStudent = student.getVakken()
    println("\nVakken die student "+student.getStudentenNummer()+" niet heeft behaald.")
    vakkenVanStudent.filter(x=> gemiddelde(student, x.getModuleCode()) <6.0).foreach(x=>println(x.getModuleCode()))
  }

  def onbehaald(vak:String): Unit ={
    println("\nStudenten die deze vak niet hebben behaald "+vak+": ")
    students.filter(x=> gemiddelde(x, vak) <6.0).foreach(x=>println(x.getNaam()))
  }

  def printStudents(vak:String): Unit ={
    println("\nStudenten die vak "+vak+" volgen:")
    students.filter(x=> x.getVak(vak) != null).foreach(x=>println(x.getNaam()))
  }

  def newCijfer(student: Student, vak:String, cijfer:Double): Unit ={
    val vakStudent = student.getVak(vak)
    val studentenNR = student.getStudentenNummer()
    println("\nGrade is put in.....")
    if(cijfer >= 0.0 && cijfer < 10.0){
      if(student.getVak(vak) == null){
        println("Student "+studentenNR+" is not following "+vak+" at this point.")
      }else{
        vakStudent.setCijfers(cijfer)
        println("Grade "+cijfer+" has been put in correctly for student "+studentenNR+" in subject "+vak)
      }
    }else{
      println("Number is not correct, needs to be between 0 and 10")
    }
  }

  def getCijfer(student: Student, vak:String):List[Double] ={
      return student.getVak(vak).getCijfers()
  }

  def printCijfers(student: Student, vak:String): Unit ={
    val cijfers = getCijfer(student, vak)
    val vakS = student.getVak(vak).getModuleCode()
    println("\nCijfers van student "+student.getNaam()+" van vak "+vakS)
    if(cijfers.isEmpty){
      println("NO Grades")
    }else{
      cijfers.foreach(x=> println(x))
    }
  }

  def newVak(student: Student, newVak:String, jaar:Int): Unit ={
    student.newVakken(newVak, jaar)
  }

  def setVakken(stud:Student, vak1:String, vak2:String, vak3:String, vak4:String, jaar1:Int, jaar2:Int, jaar3:Int, jaar4:Int): Unit ={
    newVak(stud, vak1, jaar1)
    newVak(stud, vak2, jaar2)
    newVak(stud, vak3, jaar3)
    newVak(stud, vak4, jaar4)
  }

}
