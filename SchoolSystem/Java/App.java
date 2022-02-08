/*
Naam: Rick van Dijk
VakCode: TinPRO02-4
Docent: Elvira van der Ven
Kans: tweede kans
 */

public class App {
    public static void main(String[] args) {
        //Administratie klasse aanmaken (Deze zal voor alles zorgen)
        Administratie administratie = new Administratie();

        //Studenten aanmaken
        Student rick = new Student("09993828", "Rick", "M","TI1C", "CMI");
        Student thijmen = new Student("09993736", "Thijmen", "M","TI3C","CMI");
        Student anouk = new Student("09765634", "Anouk", "V","H5C", "HBO");
        Student sarah = new Student("09636722", "Sarah", "V","TI2C", "CMI");
        Student patrick = new Student("07665252", "Martijn", "M", "T3C", "HBO");
        Student nadine = new Student("09993433", "Nadine", "V","HBO", "HBO");

        //add students to administratie zodat deze alle info van de studenten door administratie bekeken en/of veranderen kan worden
        administratie.addStudents(rick);
        administratie.addStudents(thijmen);
        administratie.addStudents(anouk);
        administratie.addStudents(sarah);
        administratie.addStudents(patrick);
        administratie.addStudents(nadine);

        //4 vakken met elk hun eigen jaar aanmaken voor student
        administratie.setVakken(rick, "tinEng", "tinWis", "tinNW", "tinDTB", 1,2,3,2);
        administratie.setVakken(thijmen, "tinEng1-1", "tinWis2-0", "tinNW", "tinDTB", 2,1,6,4);
        administratie.setVakken(sarah, "tinEng1-1", "tinWis", "tinNW", "tinDTB", 2,1,6,4);
        administratie.setVakken(anouk, "tinEng1-1", "tinWis", "tinNW", "tinDTB", 2,1,6,4);
        administratie.setVakken(patrick, "tinPro2-1", "tinWis", "tinNW", "tinDTB", 2,1,6,4);

        //Methode waar je maar 1 vak kan toevoegen.
        administratie.newVak(rick, "TinPRO2-2", 2);

        //Print vakken van een meegegeven student
        administratie.printVakken(rick);
        administratie.printVakken(thijmen);

        //Print studenten van een meegegeven vak
        administratie.printStudents("tinEng1-1");

        //Cijfers toevoegen
        administratie.newCijfer(rick, "tinEng", 5.0);
        administratie.newCijfer(thijmen, "tinEng", 11);
        administratie.newCijfer(rick, "TinWis", 8.0);
        administratie.newCijfer(rick, "TinWis", 4.0);
        administratie.newCijfer(rick, "TinWis", 5.0);
        administratie.newCijfer(sarah, "tinWis", 6.0);
        administratie.newCijfer(rick, "TinWis", 2.0);
        administratie.newCijfer(patrick, "TinWis", 11);
        administratie.newCijfer(nadine, "TinEng", 11);

        //Print cijfers van student voor specifieke vak
//        administratie.printCijfers(nadine, "TinNW");
        administratie.printCijfers(rick, "tinEng");
        administratie.printCijfers(sarah, "TinWis");

        //Print opsomming van alle studenten die een vak hebben behaald en onbehaald
        administratie.behaald("TinWis");
        administratie.onbehaald("TinWis");
        administratie.behaald("TinNW");
        administratie.onbehaald("TinWis");

        //Print opsomming van alle studenten die een vak hebben behaald en onbehaald
        administratie.behaald(rick);
        administratie.onbehaald(rick);

        //Print standdaarddeviatie voor alle cijfers van alle vakken van een specifiek student
        administratie.printAlleCijfers(rick);
        administratie.printDeviatie(rick);
        administratie.printDeviatie(patrick);

        //Print variantie van alle cijfers die alle studenten voor een vak gehaald hebben
        administratie.printVariantie("TinWis");
        administratie.printVariantie("TinNW");

        //Wie scoren er beter voor een bepaalde vak
        administratie.battleOfTheSexte("tinWis");
        administratie.battleOfTheSexte("TinEng");
    }
}