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
  N -- return --> L;
  M -- Plaatsen --> N;
  N -- return --> M;
  E[Kade] --> N;
  E -- Wegbrengen --> O[Vrachtwagen1Buffer];
  O -- return --> E;
  E -- Wegbrengen --> P[Vrachtwagen2Buffer];
  P -- return --> E;
  E -- Wegbrengen --> Q[Vrachtwagen3Buffer];
  Q -- return --> E;
  F[Vrachtwagen1] --> O;
  G[Vrachtwagen2] --> P;
  H[Vrachtwagen3] --> Q;
```
