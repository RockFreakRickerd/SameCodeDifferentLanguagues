# School system:

This code will simulate a school system.

Some fool proof baked in:
* Numbers can only be assigned if subject and students are in system.
* Different classes for Students, Subjects, Administration and a main.

```mermaid
flowchart TD
  A[Vak Initializing] ----> B[SetModuleCode] --> C{Validate year};
  C -- <0 --> D[ERROR!];
  C ----> E{>0}
  E -- >5 --> F[yearInput == 5];
  E -- <5 --> G[SetYear]
  F ----> G[SetYear]
```

```mermaid
flowchart TD
  
```
