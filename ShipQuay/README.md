# Ship Quay simiultation:

Here will a ship quay simulated with schip, kranes and trucks. This all with multitreading.

```mermaid
sequenceDiagram
loop AddContainersToSchip
  Container->>Containerschip: Container.add()
end
loop ContainerToKade
  loop !kade.checkSpace
    Kraan1->>Kraan1: wait(time)
  end
  Kraan1->>Containerschip: Afpakken()
  Containerschip->>Kraan1: return()
  Kraan1->>Kade: Plaatsen()
  Kade->>Kraan1: return()
  loop !kade.checkSpace
    Kraan2->>Kraan2: wait(time)
  end
  Kraan2->>Containerschip: Afpakken()
  Containerschip->>Kraan2: return()
  Kraan2->>Kade: Plaatsen()
  Kade->>Kraan2: return()
end
loop ContainerVervoer
  Truck1->>Kade: Wegbrengen()
  loop kadeIsEmpty
    Truck1->>Truck1: wait(time)
  end
  Kade->>Truck1: return()
  Truck2->>Kade: Wegbrengen()
  loop kadeIsEmpty
    Truck2->>Truck2: wait(time)
  end
  Kade->>Truck2: return()
  Truck3->>Kade: Wegbrengen()
  loop kadeIsEmpty
    Truck3->>Truck3: wait(time)
  end
  Kade->>Truck3: return()
end
```

Flowchart of the program:
```mermaid
classDiagram
  App --> Containerschip : creates
  App --> Kraan : creates
  App --> Kade : creates
  App --> Container : creates
  App --> Truck: creates
  Truck --> Kade : Uses
  Kraan --> Containerschip : Uses
  Kraan --> Kade : Uses
  Container <|-- HeatedContainer : Extends
  Container <|-- NormalContainer : Extends
  Container <|-- CooledContainer : Extends
  App: Kade kade
  App: Container container
  App: Truck man
  App: Truck mercedes
  App: Truck volvo
  App: Containerschip ship
  App: Kraan kraan1
  App: Kraan kraan2
  Containerschip: List containers
  Containerschip: Container container
  Containerschip: Containerschip()
  Containerschip: getSize()
  Containerschip: print()
  Containerschip: Afpakken()
  Containerschip: schipIsEmpty()
  Kraan: String naam
  Kraan: Random random
  Kraan: Containerschip ship
  Kraan: Kade kade
  Kraan: Int time
  Kraan: Int max
  Kraan: Int min
  Kraan: Kraan(String naam, Kade k, Containerschip S)
  Kraan: Run()
  Kade: LinkedList opslag
  Kade: Int capacity
  Kade: Containerschip ship
  Kade: Plaatsen()
  Kade: wegbrengen()
  Kade: print()
  Kade: getSize()
  Kade: checkSpace()
  Kade: KadeIsLeeg()
  Container: Int count
  Container: Int trackingNumber
  Container: String name
  Container: Container(String naam)
  Container: getTrackingNumber
  Container: print(Int trackingNumber)
  HeatedContainer: HeatedContainer()
  HeatedContainer: Print(Int trackingNumber)
  NormalContainer: NormalContainer()
  NormalContainer: Print(Int trackingNumber)
  CooledContainer: CooledContainer()
  CooledContainer: Print(Int trackingNumber)
  Truck: Kade kade
  Truck: Random random
  Truck: String name
  Truck: Int time
  Truck: Int max
  Truck: Int min
  Truck: Truck(String name, Kade k)
  Truck: run()
```
