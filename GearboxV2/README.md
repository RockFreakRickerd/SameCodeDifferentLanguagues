# Gearbox V2

A new version of gearbox with some changes.
These changes are mainly different gearboxes with different speeds per gear and number of gears.

The 4 standard gearboxes are:
  * Sport
  * Standard
  * Racecar
  * Rally

Next to these gearboxes, there is a change for the user to create a custom gearbox for the time the code runs.

The user inputs for this custom gearbox are:
  * Number of gears
  * Gear ratios
  * Name of gearbox
  
The class diagram is:
```mermaid
classDiagram
 App --> Gearbox
 Gearbox <|-- SportTransmission
 Gearbox <|-- StandardTransmission
 Gearbox <|-- RaceTransmission
 Gearbox <|-- RallyTransmission
 Gearbox <|-- CustomTransmission
 App: SportTransmission sport
 App: StandardTransmission standard
 App: RaceTransmission race
 App: RallyTransmission rally
 App: CustomTransmission custom
 App: SetTransmission(String transmissionType)
 App: ChangeTransmissionSettings(String transmissionType)
 Gearbox: Int numberOfGears
 Gearbox: String type
 Gearbox: List ratios
 SportTransmission: Int numberOfGears
 SportTransmission: String type
 SportTransmission: List ratios
 StandardTransmission: Int numberOfGears
 StandardTransmission: String type
 StandardTransmission: List ratios
 RaceTransmission: Int numberOfGears
 RaceTransmission: String type
 RaceTransmission: List ratios
 RallyTransmission: Int numberOfGears
 RallyTransmission: String type
 RallyTransmission: List ratios
 CustomTransmission: Int numberOfGears
 CustomTransmission: String type
 CustomTransmission: List ratios
 <<Abstract>> Gearbox
```

The flowdiagram is:
