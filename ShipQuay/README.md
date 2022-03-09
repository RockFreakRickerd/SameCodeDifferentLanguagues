# Ship Quay simiultation:

Here will a ship quay simulated with schip, kranes and trucks. This all with multitreading.

```mermaid
flowchart TD
  A[Container] --> I{I <WantedAmountOfContainers} -- False --> I{I <WantedAmountOfContainers};
  I{I <WantedAmountOfContainers} -- true --^ B;
  B[Containership];
  C[Kraan1];
  D[Kraan2];
  E[Kade];
  F[Vrachtwagen1];
  G[Vrachtwagen2];
  H[Vrachtwagen3];
```
