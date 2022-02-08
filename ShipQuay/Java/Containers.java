import java.util.LinkedList;

/*
Naam: Rick van Dijk
klas:
Docent: Elvira van der Ven
*/

public class Containers {
    //Linkedlist waarin de containers opgeslagen zijn en helemaal aan het einde door de vrachtwagens verwijderd worden.
        LinkedList<Containers> container = new LinkedList<>();
        //static count zorgt ervoor dat deze bijgehouden wordt en dus als je ++ de nieuwe waarde opslaat.
        private static int count;
        private int volgnummer;
        private String naam;

        //Constructor, deze geeft een naam meer en verhoogt de volgnummer bij 1 door een static count
        public Containers(){
            this.setNaam("Container");
            volgnummer = count++;
        }

     public int getVolgnummer() {
        return volgnummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void print(){
        System.out.println(" neemt container " +getVolgnummer() + " mee");
    }
}
