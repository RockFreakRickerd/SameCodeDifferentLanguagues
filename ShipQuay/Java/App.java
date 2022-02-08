/*
Naam: Rick van Dijk
klas:
Docent: Elvira van der Ven
*/

public class App {
    public static void main(String[] args) {

        //Aanmaken an de objecten
        Kade kade = new Kade();
        Containers container = new Containers();
        Vrachtwagens man = new Vrachtwagens("Man truck", kade, container);
        Vrachtwagens mercedes = new Vrachtwagens("Mercedes truck", kade, container);
        Vrachtwagens volvo = new Vrachtwagens("Volvo truck", kade, container);
        Containerschip schip = new Containerschip();
        Kraan kraanL = new Kraan("linker kraan", kade, schip);
        Thread kraanR = new Thread(new Kraan("rechtse kraan", kade, schip));

        //Aanmaken van de 100 containers d.m.v. een for loop
        for(int i = 0; i < schip.getCapacity(); i++){
            if (i%3 == 1){
                Containers normal = new Containers();
                container.container.add(normal);
                schip.list.add(normal);
            }
            else if (i%3 == 2){
                Containers warm = new VerwarmdeContainer();
                container.container.add(warm);
                schip.list.add(warm);
            }
            else{
                Containers cold = new VerkoeldeContainer();
                container.container.add(cold);
                schip.list.add(cold);
            }
        }

        //Aanmaken threads
        Thread t0 = new Thread(kraanL);
        Thread t1 = new Thread(kraanR);
        Thread t2 = new Thread(man);
        Thread t3 = new Thread(mercedes);
        Thread t4 = new Thread(volvo);

        //Threads starten
       t0.start();
       t1.start();
       t2.start();
       t3.start();
       t4.start();

    }
}