package School
import java.time.LocalDateTime

import School._

object App {
  def main(args: Array[String]): Unit = {

    println(LocalDateTime.now())
    val administratie = new Administratie()

    val rick = new Student("0983438", "Rick", "M", "TI2B", "CMI")
    val thijmen = new Student("09993736", "Thijmen", "M", "TI3C", "CMI")
    val anouk = new Student("0976534", "Anouk", "V", "H5C", "HBO")
    val sarah = new Student("09636722", "Sarah", "V", "TI2C", "CMI")
    val patrick = new Student("07665252", "Patrick", "M", "T3C", "HBO")
    val luca = new Student("09993433", "Luca", "V", "CMD3B", "HBO")

    //add students to administratie zodat deze alle info van de studenten door administratie bekeken en/of veranderen kan worden
    administratie.addStudents(rick)
    administratie.addStudents(thijmen)
    administratie.addStudents(anouk)
    administratie.addStudents(sarah)
    administratie.addStudents(patrick)
    administratie.addStudents(luca)

    //4 vakken met elk hun eigen jaar aanmaken voor student
    administratie.setVakken(rick, "tinEng", "tinWis", "tinNW", "tinDTB", 1, 2, 3, 2)
    administratie.setVakken(thijmen, "tinEng1-1", "tinWis2-0", "tinNW", "tinDTB", 2, 1, 6, 4)
    administratie.setVakken(sarah, "tinEng1-1", "tinWis", "tinNW", "tinDTB", 2, 1, 6, 4)
    administratie.setVakken(anouk, "tinEng1-1", "tinWis", "tinNW", "tinDTB", 2, 1, 6, 4)
    administratie.setVakken(patrick, "tinPro2-1", "tinWis", "tinNW", "tinDTB", 2, 1, 6, 4)

    //Methode waar je maar 1 vak kan toevoegen.
    administratie.newVak(rick, "TinPRO2-2", 2)

    //Print vakken van een meegegeven student
    administratie.printVakken(rick)
    administratie.printVakken(thijmen)

    //Print studenten van een meegegeven vak
    administratie.printStudents("tinEng1-1")

    //Cijfers toevoegen
    administratie.newCijfer(rick, "tinEng", 5.0)
    administratie.newCijfer(thijmen, "tinEng", 11)
    administratie.newCijfer(rick, "TinWis", 8.0)
    administratie.newCijfer(rick, "TinWis", 4.0)
    administratie.newCijfer(rick, "TinWis", 5.0)
    administratie.newCijfer(sarah, "tinWis", 6.0)
    administratie.newCijfer(rick, "TinWis", 2.0)
    administratie.newCijfer(patrick, "TinWis", 11)
    administratie.newCijfer(luca, "TinEng", 11)

    //Print cijfers van student voor specifieke vak
    //        administratie.printCijfers(nadine, "TinNW");
    administratie.printCijfers(rick, "tinEng")
    administratie.printCijfers(sarah, "TinWis")

    //Print opsomming van alle studenten die een vak hebben behaald en onbehaald
    administratie.behaald("TinWis")
    administratie.onbehaald("TinWis")
    administratie.behaald("TinNW")
    administratie.onbehaald("TinWis")


    administratie.behaald(rick)
    administratie.onbehaald(rick)

    //Print standdaarddeviatie voor alle cijfers van alle vakken van een specifiek student
    administratie.printAlleCijfers(rick)
    administratie.printDeviatie(rick)
    administratie.printDeviatie(patrick)

    //Print variantie van alle cijfers die alle studenten voor een vak gehaald hebben
    administratie.printVariatie("TinWis")
    administratie.printVariatie("TinNW")

    //Wie scoren er beter voor een bepaalde vak
    administratie.battleOfTheSexte("tinWis")
    administratie.battleOfTheSexte("TinEng")

    println(LocalDateTime.now())
  }
}