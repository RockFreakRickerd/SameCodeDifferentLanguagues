      ******************************************************************
      * Author: Rick van Dijk
      * Date: 23-11-2020
      * Purpose: FUN (versnellingen)
      * Tectonics: cbl
      ******************************************************************
       IDENTIFICATION DIVISION.
      *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
       PROGRAM-ID. Car-versnellingen.
       ENVIRONMENT DIVISION.
      *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
       CONFIGURATION SECTION.
      *-----------------------
       INPUT-OUTPUT SECTION.
      *-----------------------
       DATA DIVISION.
      *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
       FILE SECTION.
      *-----------------------
       WORKING-STORAGE SECTION.
      *--------------Input variable-----------------------------------*
       01 let PIC x(3).

      *--------------Input variabel opslaan-----------------------------*
       01 snelheid PIC s9(3)v99 value 0.0.
       01 checkONQ PIC x(1).

      *------------------variabelen om gemiddelde uit te kunnen rekenen-*
       01 average PIC s9(3)v99.
       01 aantal PIC s9(3).
      *------------------Count van de loop bij te houden----------------*
       01 ws-cnt PIC 9(1) value 0.
      *-----------------------
       PROCEDURE DIVISION.
      *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
      *--------------Main waar alles door loopt-------------------------*
       MainTest.
           *> Run main "methode" voor 5 keer                            *
           PERFORM Main until ws-cnt =5.
           *> RUN averager "methode" als je 5x door de main bent gegaan-*
           PERFORM averager.

           *> STop de de Main Test door deze zal hij ook gelijk naar het einde gaan en programma beeindigen.
           stop RUN.

       averager.
           *> deelt average door aantal    (average/aantal)
           DIVIDE average by aantal GIVING average.
           *> Laat gemiddelde zien
           display "Gemiddelde : "average.
           stop RUN.

       Main.
           DISPLAY "---------------------------------------------------"
           display "Kies snelheid, daarna wordt de versnelling
           doorgegeven".

           *> zet wat je krijgt in variabele let
           ACCEPT let.

           *> zet die input in snelheid en checkONQ
           MOVE let TO snelheid.
           MOVE let TO checkONQ.

           *> check if checkONQ q als input heeft
           if checkONQ = 'q'
              MOVE 300 TO snelheid
              perform averager.

           *> check welke versnelling je zit (zolang het tussen -30 en 100 zit zal de snelheid bij average toegevoegd worden.
           if snelheid GREATER OR EQUAL TO -30 AND snelheid LESS OR
               EQUAL TO 100
               ADD snelheid TO average
               *> plus 1 voor aantal keer het een geldige input is
               ADD 1 TO aantal
               ADD 1 to ws-cnt

           *> echte check met printen van welke versnelling je zit
           *> in COBOL kan je zinnen zoals GREATER THAN gebruiken maar ook > dus is jouw keuze wat je doet.
           if snelheid GREATER THAN 100
               DISPLAY "Je kan niet zo hard rijden"
           else if snelheid IS GREATER OR EQUAL TO 80
               DISPLAY "Je zit in de vijfde versnelling"
           else if snelheid IS GREATER OR EQUAL TO 60
               DISPLAY "Je zit in de vierde vernelling"
           else if snelheid IS GREATER OR EQUAL TO 30
               DISPLAY "Je zit in de derde versnelling"
           else if snelheid IS GREATER OR EQUAL TO 10
               DISPLAY "Je zit in de tweede versnelling"
           else if snelheid IS GREATER THAN 0
               DISPLAY "Je zit in de eerste versnelling"
           else if snelheid EQUAL TO 0
               DISPLAY "Je staat in z'n vrij"
           else if snelheid LESS THAN 0 AND snelheid GREATER OR EQUAL
               TO -30
               DISPLAY "Je staat in z'n achteruit"
           else
               DISPLAY "Verkeerde input"
           stop RUN.

      *----------Eindigt de programma-----------------------------------*
       END PROGRAM Car-versnellingen.
