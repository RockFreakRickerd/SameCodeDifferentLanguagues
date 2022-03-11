# Ship Quay simiultation:

Here will a ship quay simulated with schip, kranes and trucks. This all with multitreading.

```mermaid
sequenceDiagram
loop AddContainersToSchip
  Container->>Containerschip: Container.add()
end
loop ContainerToQuay
  loop !kade.checkSpace
    Crane1->>Crane1: wait(time)
  end
  Crane1->>Containerschip: Afpakken()
  Containerschip->>Crane1: return()
  Crane1->>Quay: Plaatsen()
  Quay->>Crane1: return()
  loop !kade.checkSpace
    Crane2->>Crane2: wait(time)
  end
  Crane2->>Containerschip: Afpakken()
  Containerschip->>Crane2: return()
  Crane2->>Quay: Plaatsen()
  Quay->>Crane2: return()
end
loop ContainerVervoer
  Truck1->>Quay: Wegbrengen()
  loop kadeIsEmpty
    Truck1->>Truck1: wait(time)
  end
  Quay->>Truck1: return()
  Truck2->>Quay: Wegbrengen()
  loop kadeIsEmpty
    Truck2->>Truck2: wait(time)
  end
  Quay->>Truck2: return()
  Truck3->>Quay: Wegbrengen()
  loop kadeIsEmpty
    Truck3->>Truck3: wait(time)
  end
  Quay->>Truck3: return()
end
```

Flowchart of the program:
```mermaid
classDiagram
  App --> Containerschip : creates
  App --> Crane : creates
  App --> Quay : creates
  App --> Container : creates
  App --> Truck: creates
  Quay <|-- Truck : Uses
  Crane --> Containerschip : Uses
  Crane --> Quay : Uses
  Container <|-- HeatedContainer : Extends
  Container <|-- NormalContainer : Extends
  Container <|-- CooledContainer : Extends
  App: Quay kade
  App: Container container
  App: Truck man
  App: Truck mercedes
  App: Truck volvo
  App: Containerschip ship
  App: Crane Crane1
  App: Crane Crane2
  Containerschip: List containers
  Containerschip: Container container
  Containerschip: Containerschip()
  Containerschip: GetSize()
  Containerschip: PrintInfo()
  Containerschip: CarryOff()
  Containerschip: schipIsEmpty()
  Crane: String name
  Crane: Random random
  Crane: Containerschip ship
  Crane: Quay quay
  Crane: Int time
  Crane: Int max
  Crane: Int min
  Crane: Crane(String name, Quay k, Containerschip S)
  Crane: Run()
  Quay: LinkedList storage
  Quay: Int capacity
  Quay: Containerschip ship
  Quay: Place()
  Quay: CarryOff()
  Quay: PrintInfo()
  Quay: GetSize()
  Quay: checkSpace()
  Quay: QuayIsEmpty()
  Container: Int count
  Container: Int trackingNumber
  Container: String name
  Container: Container(String name)
  Container: GetTrackingNumber()
  Container: PrintInfo(Int trackingNumber)
  HeatedContainer: HeatedContainer()
  HeatedContainer: PrintInfo(Int trackingNumber)
  NormalContainer: NormalContainer()
  NormalContainer: PrintInfo(Int trackingNumber)
  CooledContainer: CooledContainer()
  CooledContainer: PrintInfo(Int trackingNumber)
  Truck: Quay kade
  Truck: Random random
  Truck: String name
  Truck: Int time
  Truck: Int max
  Truck: Int min
  Truck: Truck(String name, Quay k)
  Truck: run()
```
