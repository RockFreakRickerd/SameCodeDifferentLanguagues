# Gearbox.
The gearbox will give you the gear it you in based on given speed.

Some foolproof parts in code are:
* Maximum speed (forward and backwards).
* Integer number instead of float as speed is difficult to give in floats.
* Warning if any of these are taken place.

```mermaid
flowchart TD
    A[Input] --> B{Speed};
    B --> C{>100} --> K[You're going to fast] ----> A[Input];
    C --> D{>80} --> L[You're in 5th gear] ---> A[Input];
    D --> E{>60} --> M[You're in 4th gear] ----> A[Input];
    E --> F{>40} --> N[You're in 3rd gear] ----> A[Input];
    F --> G{>10} --> O[You're in 2nd gear] ----> A[Input];
    G --> H{>0}  --> P[You're in 1st gear] ----> A[Input];
    H --> I{0}   --> Q[You're in neutral] ----> A[Input];
    I --> J{<0}  --> R[You're in reverse] ----> A[Input];
    J --> H{<-30} --> S[You're going to fast in reverse] ----> A[Input];
```
