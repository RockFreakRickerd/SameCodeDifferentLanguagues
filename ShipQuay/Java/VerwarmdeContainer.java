/*
Naam: Rick van Dijk
klas:
Docent: Elvira van der Ven
*/

public class VerwarmdeContainer extends Containers {

        public VerwarmdeContainer(){
            this.setNaam("Verwarmde Container");
        }

        public void print(){
            System.out.println("neem container "+getVolgnummer()+" is aangekoppeld met verwarmingselementen");
        }
}
