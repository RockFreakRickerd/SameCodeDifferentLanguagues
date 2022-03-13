import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Gearbox{
  private String name;
  private String type;
  private int numberOfGears;
  List<Double> ratios = new ArrayList<Double>();
  List<Long> maxSpeeds = new ArrayList<Long>();

  Double rpm = 6000.0;
  Double axle = 2.0;
  Double tireHeight = 22.0;
  Double gearFactor;
  
  public Gearbox(String name, String type, Integer numberOfGears, List<Double> ratios, Double rpm, Double axle, Double tireHeight){
    setName(name);
    setType(type);
    setNoG(numberOfGears);
    setRPM(rpm);
    setAxle(axle);
    setTireHeight(tireHeight);
    gearFactor = (rpm*tireHeight*0.002975) / axle;
    setRatios(numberOfGears, ratios);
  }

  private void setName(String name){
    this.name = name;
  }
  private void setType(String type){
    this.type = type;
  }
  private void setNoG(Integer numberOfGears){
    this.numberOfGears = numberOfGears;
  }
  private void setRPM(Double rpm){
    this.rpm = rpm;
  }
  private void setAxle(Double axle){
    this.axle = axle;
  }
  private void setTireHeight(Double tireHeight){
    this.tireHeight = tireHeight;
  }
  
  private void setRatios(Integer numberOfGears, List<Double> ratios){
    for(int i = 0; i<numberOfGears; i++){
      this.ratios.add(ratios.get(i));
      //calculation needed
      this.maxSpeeds.add(Math.round(calculateSpeed(ratios.get(i))*100.0/100.0));
    }
  }

  private Double calculateSpeed(Double ratio){
    Double speed = gearFactor / ratio;
    return speed;
  }

  public String getName(){
    return this.name;
  }
  public String getType(){
    return this.type;
  }
  public Integer getNumberOfGears(){
    return this.numberOfGears;
  }
  public void PrintInfo(){
    System.out.println("Gearbox `"+name+"` information.");
    System.out.println("Current gearbox type: "+type);
    System.out.println("Current number of gears: "+Integer.toString(numberOfGears));
    System.out.println("With current ratios and max. speeds: ");
    for(int i = 0; i< numberOfGears; i++){
      System.out.println(Integer.toString(i+1)+": "+Double.toString(ratios.get(i))+" "+Long.toString(maxSpeeds.get(i))+" km/h.");
    }
  }
}
