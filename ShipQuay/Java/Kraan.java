import java.util.Random;

/*
Naam: Rick van Dijk
klas:
Docent: Elvira van der Ven
*/

public class Kraan extends Thread {
    private String naam;
    Random random = new Random();
    Containerschip schip ;
    Kade kade ;

    @Override
    public void run() {
        overplaatsen(kade, schip);
    }

    public Kraan(String naam, Kade k, Containerschip s) {
        this.naam = naam;
        this.kade = k;
        this.schip = s;
    }

    public synchronized void overplaatsen(Kade k, Containerschip s) {
        while(s.list.size() > 0) {
            try {
                int wait = random.nextInt(3000);
                while (k.opslag.size() >= k.opslagplek) {
                    System.out.println(naam + " is waiting");
                    wait(1000);
                }
                if(s.list.size() > 0) {
                    Containers temp = s.list.get(0);
                    //Deze geeft een random getal tussen 6000 en 1000, dit bepaalt hoelang de kraan over het overplaatsen doet.
                    int time = random.nextInt(5000) + 1000;
                    System.out.println(naam+" wilt container met volgnummer "+temp.getVolgnummer());
                    s.print();
                    //Deze if statements kijken of het een verwarmde,verkoelde of een normale container is en een speciaal berichtje voor te geven
                    if(temp.getNaam().equalsIgnoreCase("Verwarmde container"))
                        System.out.println("Container "+temp.getVolgnummer()+" is losgekoppeld van verwarmingselement en wordt meegenomen door "+naam);
                    else if(temp.getNaam().equalsIgnoreCase("Verkoelde container"))
                        System.out.println("Container "+temp.getVolgnummer()+" is losgekoppeld van verkoelingselement en wordt meegenomen door "+naam);
                    else
                        System.out.println("Container " +temp.getVolgnummer()+ " neemt container wordt meegenomen door "+naam);
                    //voegt container toe aan de kade terwijl deze van het schip afgehaalt wordt.
                    k.opslag.add(s.list.remove());
                    notify();
                    System.out.println("De container met volgnummer " + temp.getVolgnummer() + " wordt nu door " + naam + " op de kade gezet.");
                    s.opgeslagen--;
                    //De random nummer eerder berekent wordt hier gebruikt op de buffer voor container na deze tijd te verhogen.
                    Thread.sleep(time);
                    k.containers++;
                    //Kade print hoeveel containers er momenteel op de kade staan.
                    k.print();
                }
                else{
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Als het hele schip leeg is gaat hij uit de while en komt dit bericht tegen hierdoor weet je dat de kranen klaar zijn.
        System.out.println("Het schip is leeg");
        return;
    }
}
