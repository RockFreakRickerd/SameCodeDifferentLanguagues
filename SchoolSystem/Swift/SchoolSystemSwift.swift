//     Main (App)
var me = Student(studentNRI: " 0983438", naamI: "Rick", geslachtI: " M", leeftijdI: 20, studieI: "CMI", klasI: "TI3B")
me.getInfo()

var dieter = Student(studentNRI: "0983409", naamI: "Dieter", geslachtI: " M", leeftijdI: 19, studieI: "CMI", klasI: "TI3")
dieter.getInfo()

var wiskunde = Vak(module: "TinWis014", jaarGegeven: 2)
//print(wiskunde.getModuleCode())

//     STUDENTS
class Student{
    var vakken: [Vak] = []

    var studentenNummer = ""
    var naam = ""
    var geslacht = "" 
    var leeftijd = 0;
    var studieInrichting = "" 
    var klas = ""

    init(studentNRI:String, naamI: String, geslachtI: String, leeftijdI: Int, studieI: String, klasI: String) {
        studentenNummer = studentNRI
        naam = naamI
        geslacht = geslachtI
        leeftijd = leeftijdI
        studieInrichting = studieI
        klas = klasI
    }
    
    func setNaam(naamI:String){
      naam = naamI
    }
    func setGeslacht(geslachtI: String){
      geslacht = geslachtI
    }

    func getInfo(){
        print("StudentenNummer: \(studentenNummer)")
        print("Naam: \(naam)")
        print("Geslacht: \(geslacht)")
        print("Leeftijd: \(leeftijd)")
        print("Klas: \(klas)")
        print("studieInrichting: \(studieInrichting)")
    }
}

//      Subjects (Done)
class Vak{
  var cijfers :[Double] = []
  var moduleCode = ""
  var jaar = 0;

  init(module: String, jaarGegeven: Int){
    setModuleCode(moduleI: module)
    var jaarInput = jaarGegeven
    if(jaarInput > 0){
      if(jaarInput > 5){
        print("Vak \(moduleCode) staat een te hoog jaar bij.")
        print("Jaar wordt naar hoogst mogelijke jaar veranderd, dit is jaar 5")
        jaarInput = 5
      }
      setJaar(jaarI: jaarInput)
    }else{
      print("Getal moet groter zijn dan 0.")
    }
  }

  private func setJaar(jaarI: Int){
    jaar = jaarI
  }

  private func setModuleCode(moduleI: String){
    moduleCode = moduleI
  }

  public func setCijfers(cijfer: Double){
    cijfers.append(cijfer)
  }
  public func getModuleCode() -> String{
    return moduleCode
  }
  public func getCijfers() -> [Double]{
    return cijfers
  }
  public func getJaar() -> Int{
    return jaar
  }
}

//      Administration
class Administration{
  var students :[Student] = []
  
  public func addStudents(studentI: Student){
    //if students.contains(studentI){
    //  print("\(studentI) is already in database")
   // }else{
    //  students.append(studentI)
    //}
  }
}