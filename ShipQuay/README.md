# Ship Quay simiultation:

Here will a ship quay simulated with schip, kranes and trucks. This all with multitreading.

```mermaid
sequenceDiagram
loop AddContainersToSchip
  Container->>Containerschip: Container.add()
end
loop ContainerToKade
  Kraan1->>Containerschip: Afpakken()
  Containerschip->>Kraan1: return()
  Kraan1->>Kade: Plaatsen()
  Kade->>Kraan1: return()
  Kraan2->>Containerschip: Afpakken()
  Containerschip->>Kraan2: return()
  Kraan2->>Kade: Plaatsen()
  Kade->>Kraan2: return()
end
loop ContainerVervoer
  Vrachtwagen1->>Kade: Wegbrengen()
  Kade->>Vrachtwagen1: return()
  Vrachtwagen2->>Kade: Wegbrengen()
  Kade->>Vrachtwagen2: return()
  Vrachtwagen3->>Kade: Wegbrengen()
  Kade->>Vrachtwagen3: return()
end
```

```mermaid
classDiagram
  App --> Test
```
