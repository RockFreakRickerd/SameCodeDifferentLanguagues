//     Main (App)
var me = student(studentNRI: " 0983438", naamI: "Rick", geslachtI: " M", leeftijdI: 19, studieI: "CMI", klasI: "TI2A")
me.getInfo()

//     STUDENTS
class student{
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

//      Subjects
class Vak{
  var cijfers :[Float] = []
  var moduleCode = ""
  var jaar = 0;

  init(module: String, jaarGegeven: Int){
    moduleCode = module
    jaar = jaarGegeven
  }

  func getModuleCode(){
    print("Module code:")
  }
}

//      Administration