/*
Naam: Rick van Dijk
VakCode: TinPRO02-4
Docent: Elvira van der Ven
Kans: tweede kans
 */

import java.awt.*;
import java.util.*;
import java.util.List;

public class Student {
    //List waarin alle vakken dat bepaald student volgt in wordt opgeslagen
    private List<Vak> vakken;

    //Info van student
    private String studentnummer;
    private String naam;
    private String geslacht;
    private String klas;
    private String studieinrichting;

    //Kleuren om tekst rood te maken en weer terug te zetten (alternatief voor error.out)
    private String red;
    private String black;

    //Constructor voor een student)
    public Student(String nummer, String naam, String geslacht, String klas, String studieinrichting){
        vakken = new ArrayList<>();
        studentnummer = nummer;
        setNaam(naam);
        setGeslacht(geslacht);
        setKlas(klas);
        setStudieinrichting(studieinrichting);
        red = "\u001B[31m";
        black = "\u001B[0m";
    }

    //Setters voor de variabelen die gebruikt gaan worden door andere klasses
    private void setNaam(String naam) {
        this.naam = naam;
    }

    private void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    private void setKlas(String klas) {
        this.klas = klas;
    }

    private void setStudieinrichting(String studieinrichting) {
        this.studieinrichting = studieinrichting;
    }

    public void newVakken(String newVak, int jaargegeven){
        Vak vak = new Vak(newVak, jaargegeven);
        vakken.add(vak);

    }

    //Getters zodat klasses de variabelen kunnen gebruiken zonder ze direct te veranderen
    public String getNaam() {
        return naam;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public String getStudentnummer() {
        return studentnummer;
    }

    public List<Vak> getVakken(){
        return vakken;
    }

    //geeft een vak terug als een student deze volgt anders een null die later opgevangen wordt.
    public Vak getVak(String moduleCode) {
        if (vakken.isEmpty()) {
            return null;
        }
            Vak vak = vakken.get(0);
            for (int i = 0; i < vakken.size(); i++) {
                vak = vakken.get(i);
                if (vak.getModuleCode().equalsIgnoreCase(moduleCode)) {
                    break;
                }
            }
            return vak;
    }

    //De deviatie die een double return zodat administratie die uit kan printen.
    public double deviatie(){
        //formule: stdDef = wortel(variantie)
        //variantie = (som((x_n - x)^2)) / n
        List<Double> gemiddeldes = new ArrayList<>();
        System.out.println("\nStandaardDeviatie van "+studentnummer+": ");
        double deviatie = 0;
        vakken.stream().forEach(x -> x.getCijfers().stream().forEach(i -> gemiddeldes.add(i)));
        if(gemiddeldes.isEmpty()){
            System.out.println(red+"No Records found"+black);
            return 0.0;
        }
        double average = gemiddeldes.stream().mapToDouble(x -> x).average().getAsDouble();
        double devKwadraat = gemiddeldes.stream()
                .mapToDouble(cijfer -> Math.pow(cijfer - average,2))
                .average()
                .getAsDouble();

        for(int i = 0; i<gemiddeldes.size(); i++){
            gemiddeldes.set(i, gemiddeldes.get(i)-average);
            gemiddeldes.set(i, gemiddeldes.get(i)*gemiddeldes.get(i));
            deviatie += gemiddeldes.get(i);
        }
        deviatie /= gemiddeldes.size();
        return Math.sqrt(deviatie);
    }
}