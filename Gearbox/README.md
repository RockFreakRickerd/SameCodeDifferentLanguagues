# Gearbox.
The gearbox will give you the gear it you in based on given speed.

Some foolproof parts in code are:
* Maximum speed (forward and backwards).
* Integer number instead of float as speed is difficult to give in floats.
* Warning if any of these are taken place.

De keuzes die gemaakt wordt o.b.v input zie hieronder:

```mermaid
flowchart TD
    A[Input] --> B{Speed};
    B --> C{>100} --> D{>80} --> E{>60} --> F{>40} --> G{>10} --> H{>0} --> I{0} --> J{<0} --> K{<-30}
    C ----> L[You're going to fast] ----> A[Input];
    D ----> M[You're in 5th gear] ---> A[Input];
    E ----> N[You're in 4th gear] ----> A[Input];
    F ----> O[You're in 3rd gear] ----> A[Input];
    G ----> P[You're in 2nd gear] ----> A[Input];
    H ----> Q[You're in 1st gear] ----> A[Input];
    I ----> R[You're in neutral] ----> A[Input];
    J ----> S[You're in reverse] ----> A[Input];
    K ----> T[You're going to fast in reverse] ----> A[Input];
```

Hiernaast is er ook een specief aantal dat gebruikt gaat worden, maar deze is niet opgenomen in flowchart.
