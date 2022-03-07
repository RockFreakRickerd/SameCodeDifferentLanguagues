# Gearbox.
The gearbox will give you the gear it you in based on given speed.

Some foolproof parts in code are:
* Maximum speed (forward and backwards).
* Integer number instead of float as speed is difficult to give in floats.
* Warning if any of these are taken place.

```mermaid
flowchart TD
    A[Input] --> B{Speed};
    B -- >100 --> C[You're going to fast];
    B -- >80 --> D[You're in 5th gear];
    B -- >60 --> E[You're in 4th gear];
    B -- >40 --> F[You're in 3rd gear];
    B -- >10 --> G[You're in 2nd gear];
    B -- >0  --> H[You're in 1st gear];
    B -- 0   --> I[You're in neutral];
    B -- <0  --> J[You're in reverse];
    B -- <-30 --> K[You're going to fast in reverse];
    C ----> A[Input]
    D ----> A[Input]
    E ----> A[Input]
    F ----> A[Input]
    G ----> A[Input]
    H ----> A[Input]
    I ----> A[Input]
    J ----> A[Input]
    K ----> A[Input]
```
