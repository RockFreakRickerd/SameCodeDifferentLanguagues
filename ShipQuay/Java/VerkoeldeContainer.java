/*
Naam: Rick van Dijk
klas:
Docent: Elvira van der Ven
*/

public class VerkoeldeContainer extends Containers {

        public VerkoeldeContainer() {
            //Gespecialiseerde naam voor verkoelde container
            this.setNaam("Verkoelde Container");
        }

    public void print(){
        System.out.println(" neem container " +getVolgnummer() + " is aangekoppeld met verkoelingsselementen");
    }
}
