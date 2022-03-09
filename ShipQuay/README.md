# Ship Quay simiultation:

Here will a ship quay simulated with schip, kranes and trucks. This all with multitreading.

```mermaid
flowchart TD
  A[Container] --> I{I <WantedAmountOfContainers} -- False --> I{I <WantedAmountOfContainers};
  I -- true --> J[Set on containership];
  B[Containership] --> K[SchipBuffer];
  C[Kraan1] --> L[Kraan1Buffer] -- Afpakken --> K[ShipBuffer];
  K -- return --> L[Kraan1Buffer];
  M[Kraan2Buffer] -- Afpakken --> K[ShipBuffer];
  K -- return --> M[Kraan2Buffer];
  D[Kraan2] --> M;
  L -- Plaatsen --> N[KadeBuffer];
  N --> L;
  M -- Plaatsen --> N;
  N --> M;
  E[Kade] --> N;
  F[Vrachtwagen1];
  G[Vrachtwagen2];
  H[Vrachtwagen3];
```
