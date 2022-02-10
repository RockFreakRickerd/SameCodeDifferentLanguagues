/* 
    Author: Rick van Dijk
    studentNummer: 0983438
    Klas: TI1C
    Vak:TINPRO02-1
    Dit is de eerste kans.
*/
#include <stdio.h>
int main(){
    /*Eerste vraag start bij 0 gaat tot 10 door.*/
    int i = 0;
    float average, snelheid = 0, totaal;
    char  qInput;
    
    for(i = 0; i < 10; i++){            /*i begint met 0 en bij elke keer goede input +1 tot dat i 10 is.*/
        error:
        printf("Wat is uw snelheid?\n");
        scanf("%f", &snelheid);
        scanf("%c", &qInput);
        if (qInput == 'q'){
            goto average;
        }
        if (snelheid > 0){
            if (snelheid > 100){
                printf("Je wilt te hard, de robot kan maximaal 100 km/h.\n");
                goto error;
            }else if (snelheid >= 80){
                printf("Je zit in de vijfde versnelling.\n");
            }else if (snelheid >= 60){
                printf("Je zit in de vierde versnelling.\n");
            }else if (snelheid >= 30){
                printf("Je zit in de derde versnelling.\n");
            }else if (snelheid >= 10){
                printf("Je zit in de tweede versnelling.\n");
            }else if (snelheid > 0){
                printf("Je zit in de eerste versnelling.\n");
            }
        }
            /* als snelheid 0 is gaat het dit checken*/
        else if (snelheid == 0){
            printf("Je staat in z'n vrij.\n");
        }
        /*Als snelheid is onder de 0 dan gaat het dit checken*/
        else if (snelheid < 0 && snelheid >= -30){
            printf("Je staat in z'n achteruit.\n");
        }else if (snelheid < -30){
            printf("Verkeerde input, je kan net zo snel achteruit.\n");
            goto error;
        }
        /*alle snelheden worden hier bij elkaar opgeteld*/
        totaal += snelheid;
    }
    /*Hier word de totaal gedeelt door i en komt tot de gemiddelde snelheid.*/
    average:
    average = totaal / i;
    printf("gemiddelde is: %.2f\n", average);

    return 0;
}