var average = 0
var snelheid = 0
var totaal = 0
var aantal = 0
var q = ""

func berekenGem(aantal: Int, totaal: Int) -> Int {
    print("Totaal: \(totaal)")
    print(aantal)
    if aantal == 0{
        print("Division by zero isn't possible")
        return 0
    }else{
        average = totaal/aantal
        return average
    }
}

func versnellingBerekener(snelheid: Int) -> Void {
        if snelheid > -30 && snelheid < 100{  
            aantal += 1;
            if (snelheid >= 80){       
                print("Je zit in de vijfde versnelling.\n");
            }else if (snelheid >= 60){
                print("Je zit in de vierde versnelling.\n");
            }else if (snelheid >= 30){
                print("Je zit in de derde versnelling.\n");
            }else if (snelheid >= 10){
                print("Je zit in de tweede versnelling.\n");
            }else if (snelheid > 0){
                print("Je zit in de eerste versnelling.\n");
            }else if (snelheid == 0){                                               
                print("Je staat in z'n vrij.\n");
            }else if (snelheid < 0 && snelheid >= -30){                                                  
                print("Je staat in z'n achteruit.\n");
            } 
            totaal += snelheid;
        }else if snelheid > 100{
            print("Snelheid is te hoog!! tussen 100 en -30")
        }else{
            print("Snelheid te hoog achteruig!! tussen 100 en -30")
        } 
}

for n in 1...10{
    print("Name a speed between \nNOTE-30 and 100!")
    if let input = readLine()
{
    if let int = Int(input)
    {
        //print("Entered input is \(int) of the type:\(type(of: int))")
        snelheid = int
        versnellingBerekener(snelheid: snelheid)
    }
    else{
        print("Entered input is \(input) of the type:\(type(of: input))")
        q = input
        if q == "q" || q == "Quit"{
            print("Gemiddelde is: \(berekenGem(aantal: aantal, totaal: totaal))")
            break
        }
    }
}
if n == 10{
    print ("Gemiddelde na 10 snelheden: \(berekenGem(aantal: aantal, totaal: totaal))")
}
print("Totaal \(totaal)")
print("Time \(n)")
}