/*
Naam: Rick van Dijk
VakCode: TinPRO02-4
Docent: Elvira van der Ven
Kans: tweede kans
 */

import java.util.*;

public class Vak {
    //Hierin worden alle cijfers van een student opgeslagen in de list
    private List<Double> cijfers;

    //Info van het vak zelf
    private String moduleCode;
    private int jaar;

    //Constructor met parameters voor modulecode en jaar waarin het gegeven wordt
    public Vak(String module, int jaarGegeven){
        cijfers = new ArrayList<>();
        setModuleCode(module);
        if(jaarGegeven > 0 ) {
            if(jaarGegeven >5){
                System.err.println("Vak "+moduleCode+" staat een te hoog jaar bij");
                System.err.println("Jaar wordt naar hoogst mogelijke jaar veranderd, dit is jaar 5");
                jaarGegeven = 5;
            }
            setJaar(jaarGegeven);
        }else{
            System.err.println("getal moet groter dan 0 zijn");
             return;
        }
    }

    //Setters voor de variabelen die gebruikt gaan worden door andere klasses
    private void setJaar(int jaar) { this.jaar = jaar; }

    private void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setCijfers(double cijfer){ cijfers.add(cijfer);}

    //Getters zodat klasses de variabelen kunnen gebruiken zonder ze direct te veranderen
    public String getModuleCode() {
        return moduleCode;
    }

    public List<Double> getCijfers(){
        return cijfers;
    }

    public int getJaar() {
        return jaar;
    }
}