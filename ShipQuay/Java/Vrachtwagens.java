import java.util.Random;

/*
Naam: Rick van Dijk
klas:
Docent: Elvira van der Ven
*/

public class Vrachtwagens extends Thread {
    private String naam;
    private int f = 0;
    Random random = new Random();
    Kade kade;
    Containers container;

    public Vrachtwagens(String naam, Kade k, Containers container){
        this.naam = naam;
        this.kade = k;
        this.container = container;
    }

    @Override
    public void run() {
        //De method die gebruikt wordt met de classes als parameters hieruit word informatie gehaald en in veranderd.
        wegbrengen(kade, container);
    }

    public synchronized void wegbrengen(Kade k, Containers container){
        //While loop zorgt ervoor dat hij blijft lopen totdat de containers Linkedlist leeg is (oftewel als er helemaal geen containers meer zijn en alles weggebracht is)
        while(container.container.size() > 0) {
            try {
                //Randomizer voor duur van handeling
                int time = random.nextInt(6000)+1000;
                //Checkt of er een container op de kade staat zo niet laat de vrachtwagen weten dat hij aan het wachten is.
                while (k.opslag.size() <= 0) {
                    System.out.println(naam+ " is aan het wachten");
                    //Vrachtwagen wacht even totdat hij weer kijkt.
                    wait(time);
                    //Telt het aantal wachtpogingen op
                    f++;
                    //Bij 4 keer is hij klaar met wachten en breekt hij eruit
                    if(f == 4){
                        break;
                    }
                }
                //Als er weer een container is reset hij de wachtpogingen
                f=0;
                notify();
                Thread.sleep(time);
                //Checkt of er nog steeds een container opstaan hij gaat hierin als dat wel het geval is
                if(kade.opslag.size() > 0) {
                    Containers temp = k.opslag.get(0);
                    //Checkt welke container hij heeft en maakt een speciale melding bij elke soort
                    if(temp.getNaam().equalsIgnoreCase("Verwarmde container"))
                        System.out.println(naam+ " neem container "+temp.getVolgnummer()+" is aangekoppeld met verwarmingselementen");
                    else if(temp.getNaam().equalsIgnoreCase("Verkoelde container"))
                        System.out.println(naam + " neem container " + temp.getVolgnummer() + " is aangekoppeld met verkoelingsselementen");
                    else
                        System.out.println(naam + " neemt container " + temp.getVolgnummer() + " mee");
                    k.opslag.remove();
                    k.containers--;
                    // System.out.println(naam+ " zal er " +(time/1000)+ "sec. over doen");
                    Thread.sleep(time);
                    //Na dat de sleep method over is verwijderd hij de container van de Linkedlist, zodat het duidelijk is dat deze weggebracht is
                    container.container.remove();
                    System.out.println("De container is weggebracht door " + naam + " en komt terug voor een nieuwe.");
                }
                else{
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
        System.out.println("Opdracht voltooid");
        return;
    }
}
