# Ship Quay simiultation:

Here will a ship quay simulated with schip, kranes and trucks. This all with multitreading.

```mermaid
flowchart TD
  A[Container] --> I{I <WantedAmountOfContainers} -- False --> I{I <WantedAmountOfContainers};
  I -- true --> J[Set on containership];
  B[Containership] --> K[SchipBuffer];
  C[Kraan1] --> L[Kraan1Buffer] -- Afpakken() --> K[ShipBuffer];
  K[ShipBuffer] -- return --> L[Kraan1Buffer;
  D[Kraan2] --> M[Kraan2Buffer];
  E[Kade];
  F[Vrachtwagen1];
  G[Vrachtwagen2];
  H[Vrachtwagen3];
```
