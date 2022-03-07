# Gearbox.
The gearbox will give you the gear it you in based on given speed.

Some foolproof parts in code are:
* Maximum speed (forward and backwards).
* Integer number instead of float as speed is difficult to give in floats.
* Warning if any of these are taken place.

```mermaid
flowchart TD
    A[Input] --> B{Speed};
    B --> C{>100} --> D{>80} --> E{>60} --> F{>40} --> G{>10} --> H{>0} --> I{0} --> J{<0} --> H{<-30}
    C ----> K[You're going to fast] ----> A[Input];
    D ----> L[You're in 5th gear] ---> A[Input];
    E ----> M[You're in 4th gear] ----> A[Input];
    F ----> N[You're in 3rd gear] ----> A[Input];
    G ----> O[You're in 2nd gear] ----> A[Input];
    H ----> P[You're in 1st gear] ----> A[Input];
    I ----> Q[You're in neutral] ----> A[Input];
    J ----> R[You're in reverse] ----> A[Input];
    H ----> S[You're going to fast in reverse] ----> A[Input];
```
