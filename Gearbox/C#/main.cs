using System;

class Program {
  public static void Main (string[] args) {
    int i = 0, amount=0;
    float average, snelheid, totaal=0;
    string input;
    bool isNumber;

    do {
      amount = i;
      Console.WriteLine("Wat is uw snelheid");
      input = Console.ReadLine();
      isNumber = float.TryParse(input, out  snelheid);
      if(isNumber == false){
        if(input == "q" || input == "Q"){
          i = 10;
        }
      }else{
        if (snelheid > 0){
            if (snelheid > 100){
                Console.WriteLine("Je wilt te hard, de robot kan maximaal 100 km/h.\n");
                totaal -= snelheid;
                i -= 1;
            }else if (snelheid >= 80){
                Console.WriteLine("Je zit in de vijfde versnelling.\n");
            }else if (snelheid >= 60){
                Console.WriteLine("Je zit in de vierde versnelling.\n");
            }else if (snelheid >= 30){
                Console.WriteLine("Je zit in de derde versnelling.\n");
            }else if (snelheid >= 10){
                Console.WriteLine("Je zit in de tweede versnelling.\n");
            }else if (snelheid > 0){
                Console.WriteLine("Je zit in de eerste versnelling.\n");
            }
        }
            /* als snelheid 0 is gaat het dit checken*/
        else if (snelheid == 0){
            Console.WriteLine("Je staat in z'n vrij.\n");
        }
        /*Als snelheid is onder de 0 dan gaat het dit checken*/
        else if (snelheid < 0 && snelheid >= -30){
            Console.WriteLine("Je staat in z'n achteruit.\n");
        }else if (snelheid < -30){
            Console.WriteLine("Verkeerde input, je kan net zo snel achteruit.\n");
            totaal -= snelheid;
            i-=1;
        }
        /*alle snelheden worden hier bij elkaar opgeteld*/
        totaal += snelheid;
        i += 1;
      }
    }while (i < 10);
  average = totaal / amount;
  Console.WriteLine("gemiddelde is: "+average+"\n");
  }
}