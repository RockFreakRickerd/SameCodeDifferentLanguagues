# Ship Quay simiultation:

Here will a ship quay simulated with schip, kranes and trucks. This all with multitreading.

```mermaid
flowchart TD
  A[Container] --> I{I <WantedAmountOfContainers} -- False --> I{I <WantedAmountOfContainers};
  I -- true --> J[Set on containership];
  B[Containership] --> K[SchipBuffer];
  C[Kraan1] --> L[Kraan1Buffer] -- Afpakken() --> K[ShipBuffer];
```
