import java.util.LinkedList;

/*
Naam: Rick van Dijk
klas:
Docent: Elvira van der Ven
*/

public class Kade {
    LinkedList<Containers> opslag = new LinkedList<>();
    //Geeft de maximaal aantal plekken aan.
    protected int opslagplek = 5;
    //Geeft het huidig aantal containers op de kade aan.
    protected int containers = 0;

    public void print(){
        System.out.println("Aantal containers op de kade is: "+containers);
    }
}
