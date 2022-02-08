/*
Naam: Rick van Dijk
VakCode: TinPRO02-4
Docent: Elvira van der Ven
Kans: tweede kans
 */

import java.util.*;

public class Administratie {
    private List<Student> students;
    private String red;
    private String black;

    //Constructor voor administratie klasse
    public Administratie() {
        students = new ArrayList<>();
        red = "\u001B[31m";
        black = "\u001B[0m";
    }


    //Add specific students en de klasse zorgt ervoor dat de student gelijk bij alle klasses die hij meegekregen heeft uit de constructor
    public void addStudents(Student student) {
        if (students.contains(student)) {
            System.out.println(red+"Already in database"+black);
        } else {
            students.add(student);
        }
    }

    //Krijg gemiddelde van student bij een bepaalde vak
    public double gemiddelde(Student student, String vak) {
        if(student.getVak(vak) == null)
            return 0.0;
        List<Double> cijfers = student.getVak(vak).getCijfers();
        if (cijfers.isEmpty()) {
            return 0.0;
        }
        return cijfers.stream().mapToDouble(x -> x).average().getAsDouble();
    }

    //Hiermee kan bij aangegeven vak bekeken worden of mannen beter of slechter scoren dan vrouwen
    public void battleOfTheSexte(String vak) {
        System.out.println("\nMannen VS Vrouwen van het vak "+vak+":");
        List<Double> gemiddeldeMannen = new ArrayList<>();
        List<Double> gemiddeldeVrouwen = new ArrayList<>();
        double gemM = 0, gemV = 0;
        students.stream().filter(x -> x.getVak(vak) != null).filter(x -> x.getGeslacht().equalsIgnoreCase("M")).forEach(x -> gemiddeldeMannen.add(gemiddelde(x, vak)));
        students.stream().filter(x -> x.getVak(vak) != null).filter(x -> x.getGeslacht().equalsIgnoreCase("V")).forEach(x -> gemiddeldeVrouwen.add(gemiddelde(x, vak)));
        if (gemiddeldeMannen.isEmpty() && gemiddeldeVrouwen.isEmpty()) {
            System.out.println(red+"No Grades available"+black);
            return;
        } else {
            System.out.println("Gemiddeldes van alle mannen:");
            gemiddeldeMannen.stream().forEach(x -> {
                System.out.println(x);
            });
            System.out.println("Gemiddeldes van alle vrouwen:");
            gemiddeldeVrouwen.stream().forEach(x -> {
                System.out.println(x);
            });
            if (!gemiddeldeMannen.isEmpty()) {
                gemM = gemiddeldeMannen.stream().mapToDouble(x -> x).average().getAsDouble();
            }
            if (!gemiddeldeVrouwen.isEmpty()) {
                gemV = gemiddeldeVrouwen.stream().mapToDouble(x -> x).average().getAsDouble();
            }
            if (gemM > gemV) {
                System.out.println("Mannen hebben beter gescoord dan vrouwen.");
            } else if (gemM == gemV) {
                System.out.println("Mannen en vrouwen hebben gelijk gescoord.");
            } else if (gemM < gemV) {
                System.out.println("Mannen hebben slechter gescoord dan vrouwen.");
            }
            System.out.println("Gemiddelde van mannen: " + String.format("%.2f", gemM));
            System.out.println("Gemiddelde van vrouwen: " + String.format("%.2f", gemV));
        }
    }

    //Berekent de variantie van alle cijfers van alle studenten
    public void printVariantie(String vak){
        //1. verzamel alle cijfers voor sit vak
        //2. gemniddelde
        //3. variantie
        List<Double> gemiddeldes = new LinkedList<>();
        System.out.println("\nVariantie van "+vak+": ");
        double variantie = 0;
        students.stream().filter(x -> x.getVak(vak)!= null).forEach(x -> {
            List<Double> outputList = x.getVak(vak).getCijfers();
            outputList.stream().forEach(i -> gemiddeldes.add(i));
        });
        if(gemiddeldes.isEmpty()){
            System.out.println(red+"No Records found"+black);
            return;
        }
        double average = gemiddeldes.stream().mapToDouble(x -> x).average().getAsDouble();
        double devKwadraat= gemiddeldes.stream().mapToDouble(x -> Math.pow(x-average, 2)).average().getAsDouble();
        for(int i = 0; i<gemiddeldes.size(); i++){
            gemiddeldes.set(i, gemiddeldes.get(i)-average);
            gemiddeldes.set(i, gemiddeldes.get(i)*gemiddeldes.get(i));
            variantie += gemiddeldes.get(i);
        }
        variantie /= gemiddeldes.size();
        if(Double.isNaN(variantie)){
            System.out.println("Er is geen variantie.");
        }else{
            System.out.println("De variantie is: " + variantie);
        }
    }

    //Laat alle cijfers zien van een student van alle vakken
    public void printAlleCijfers(Student student){
        List<Vak> vakkenVanStudent = student.getVakken();
        List<Double> cijfers;
        for (Vak vak: vakkenVanStudent) {
            cijfers = getCijfer(student, vak.getModuleCode());
            System.out.println("\nCijfers van student "+student.getNaam()+" voor vak "+vak.getModuleCode()+":");
            if(cijfers.isEmpty()){
                System.out.println(red+"No grades found."+black);
            }else {
                cijfers.forEach(x -> System.out.println(x));
            }
        }
    }

    //Print alle vakken uit die meegegeven student volgt
    public void printVakken(Student student){
        List<Vak> vakkenVanStudent = student.getVakken();
        System.out.println("\nVakken die student "+student.getNaam()+" volgt:");
        vakkenVanStudent.forEach(x-> System.out.println(x.getModuleCode()+ " en wordt gegeven in jaar "+x.getJaar()));
    }

    //Print de deviatie uit
    public void printDeviatie(Student student){
        double deviatie = student.deviatie();
        System.out.println("Deviatie van "+student.getNaam()+" is "+String.format("%.2f", deviatie));
    }

    //De behaald en onbehaald van studenten en vakken
    public void behaald(Student student){
        List<Vak> vakkenVanStudent = student.getVakken();
        System.out.println("\nvakken die student "+student.getStudentnummer()+" heeft behaald");
        vakkenVanStudent.stream().filter(x-> gemiddelde(student, x.getModuleCode()) >= 6.0).forEach(x -> System.out.println(x.getModuleCode()));
    }

    public void behaald(String vak){
        System.out.println("\nStudenten die deze vak behaald hebben "+vak+":");
        students.stream().filter(x-> gemiddelde(x,vak) >= 6.0).forEach(x -> System.out.println(x.getNaam()));
    }

    public void onbehaald(Student student){
        List<Vak> vakkenVanStudent = student.getVakken();
        System.out.println("\nvakken die student "+student.getStudentnummer()+" niet heeft behaald");
        vakkenVanStudent.stream().filter(x-> gemiddelde(student, x.getModuleCode()) < 6.0).forEach(x -> System.out.println(x.getModuleCode()));
    }

    public void onbehaald(String vak){
        System.out.println("\nStudenten die deze vak niet behaald hebben "+vak+":");
        students.stream().filter(x-> gemiddelde(x,vak) < 6.0).forEach(x -> System.out.println(x.getNaam()));
    }

    //Print students van een vak
    public void printStudents(String vak){
        System.out.println("\nStudenten die vak "+vak+" volgen:");
        students.stream().filter(x -> x.getVak(vak)!= null).forEach(x -> System.out.println(x.getNaam()));
    }

    //New cijfer om toe te voegen
    public void newCijfer(Student student, String vak, double cijfer){
        Vak vakStudent = student.getVak(vak);
        String studentenNR = student.getStudentnummer();
        System.out.println("\nGrade is putting in.....");
        if(cijfer >= 0.0 && cijfer < 10.0){
            if(student.getVak(vak) == null){
                System.out.println(red+"Student "+studentenNR+" is not following "+vak+" at this point of time"+black);
            }else{
                vakStudent.setCijfers(cijfer);
                System.out.println("Grade "+cijfer+" has put in correctly for student "+studentenNR+" in subject "+vak);
            }
        }else{
            System.out.println(red+"Number is not correct number needs to be between 0 and 10"+black);
        }
    }

    //Get cijfer
    private List<Double> getCijfer(Student student, String vak) {
        return student.getVak(vak).getCijfers();
    }

    //Print alle cijfers van bepaalde student bij bepaalde vak
    public void printCijfers(Student student, String vak){
        List<Double> cijfers = getCijfer(student, vak);
        String vakS = student.getVak(vak).getModuleCode();
        System.out.println("\nCijfers van student "+student.getNaam()+" van vak "+vakS);
        if(cijfers.isEmpty()){
            System.out.println(red+"NO Grades"+black);
        }else{
            cijfers.stream().forEach(x -> System.out.println(x));
        }
    }

    //Om vakken toe te voegen 1 of meerdere vakken
    public void newVak(Student student, String newVakken, int jaar){
        student.newVakken(newVakken, jaar);
    }

    public void setVakken(Student stud, String vak1,String vak2,String vak3,String vak4, int jaar1,int jaar2,int jaar3,int jaar4){
            newVak(stud, vak1, jaar1);
            newVak(stud, vak2, jaar2);
            newVak(stud, vak3, jaar3);
            newVak(stud, vak4, jaar4);
    }
}