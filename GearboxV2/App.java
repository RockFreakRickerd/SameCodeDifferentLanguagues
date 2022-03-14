import java.util.*;

public class App {
    public static void main(String[] args) {
      int wantedPlace = 0;
      List<Double> ratiosM = new ArrayList <Double>();
      ratiosM.add(4.70);
      ratiosM.add(2.99);
      ratiosM.add(2.15);
      ratiosM.add(1.80);
      ratiosM.add(1.52);
      ratiosM.add(1.28);
      ratiosM.add(1.00);
      ratiosM.add(0.85);
      ratiosM.add(0.69);
      ratiosM.add(0.64);
      Gearbox Muscle = new Gearbox("Ford-GM 10-speed automatic", "Muscle", 10, ratiosM, 6000.0, 2.77, 26.0);

      List<Double> ratiosO = new ArrayList <Double>();
      ratiosO.add(4.283);
      ratiosO.add(2.365);
      ratiosO.add(1.453);
      ratiosO.add(1.00);
      ratiosO.add(0.776);
      ratiosO.add(0.646);
      Gearbox Offroad = new Gearbox("Ford mt88", "Offroad", 6, ratiosO, 6000.0, 4.46, 22.0);

      List<Double> ratiosR = new ArrayList <Double>();
      ratiosR.add(2.8);
      ratiosR.add(2.29);
      ratiosR.add(1.93);
      ratiosR.add(1.583);
      ratiosR.add(1.375);
      ratiosR.add(1.19);
      ratiosR.add(1.05);
      ratiosR.add(0.93);
      Gearbox Race = new Gearbox("Honda f1 transmission","Race", 8, ratiosR, 18000.0, 3.25, 18.0);

      List<Double> ratiosS = new ArrayList <Double>();
      ratiosS.add(3.133);
      ratiosS.add(2.045);
      ratiosS.add(1.481);
      ratiosS.add(1.161);
      ratiosS.add(0.942);
      ratiosS.add(0.763);
      Gearbox Sport = new Gearbox("Honda transmission", "Sport", 6, ratiosS, 8500.0, 2.7, 20.0);
      
      /*Sport.PrintInfo();
      System.out.println("");
      Muscle.PrintInfo();
      System.out.println("");
      Race.PrintInfo();
      System.out.println("");
      Offroad.PrintInfo();
      System.out.println("");*/
    List<Gearbox> choices = new ArrayList<Gearbox>();
    choices.add(Sport);
    choices.add(Muscle);
    choices.add(Race);
    choices.add(Offroad);

    // Introduction
    System.out.println(" ");
    System.out.println("Welcome by gearboxV2 program.");
    System.out.println("Here you get to choose a gearbox that you want to use.");
    System.out.println("Why? .. Because you can have different gears per speed.");
    System.out.println("But also different maximum speed.");
    System.out.println("One thing that won't work yet is the reverse so you can only go forward and stand still.");
    System.out.println("Let's choose the gearbox!");
    System.out.println(" ");


    // Choices
    System.out.println("Options: ");
    for(int i = 0; i< choices.size(); i++)    {
    System.out.println(Integer.toString(i+1)+": The "+choices.get(i).getType()+" transmission.");
    }

    System.out.println(" ");
    System.out.println("Choose which gearbox you want to use: type number or type!");
    Scanner sc = new Scanner(System.in);
    int wanted = sc.nextInt();
    try{
      Integer.toString(wanted);
      if(wanted <= 0){
        System.out.println(" ");
        System.out.println("These are not options chose between 1 and "+choices.size()+" next time.");
        System.out.println("You will be given the first gearbox as standard.");
        System.out.println(" ");
      }else{
        while(wanted >= choices.size()+1){
          System.out.println("Nummeric value is to high and size will be substracted till there is a nummeric value inside range.");
          wanted -= choices.size();
        }
        wantedPlace = wanted-1;
      }
    }catch(Exception E){
      System.out.println("No numeric value is given.");
    }

  System.out.println(" ");
  Gearbox chose = choices.get(wantedPlace);
  chose.PrintInfo();
  System.out.println(" ");
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/main
