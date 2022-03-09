# Ship Quay simiultation:

Here will a ship quay simulated with schip, kranes and trucks. This all with multitreading.

```mermaid
flowchart TD
  A[Container] --> B{I <WantedAmountOfContainers} -- False --> B{I <WantedAmountOfContainers};
  B -- true --> C[Set on containership];
  D[Containership] --> E[SchipBuffer];
  F[Kraan1] --> G[Kraan1buffer];
```
