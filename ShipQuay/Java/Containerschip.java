import java.util.LinkedList;

/*
Naam: Rick van Dijk
klas:
Docent: Elvira van der Ven
*/


public class Containerschip{
    public LinkedList<Containers> list = new LinkedList<>();
    protected int capacity = 100;
    //Opgeslagen wordt gebruikt om bij te houden hoeveel er nog op het schip staan.
    protected int opgeslagen = 100;

    public int getCapacity() {
        //System.out.println(opgeslagen);
        return capacity;
    }

    //Print vertelt dat er een container opgepakt wordt.
    public void print(){
        System.out.println("Container wordt opgepakt.");
    }
}