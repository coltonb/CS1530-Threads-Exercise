## Threads Exercise

Unfortunately, my old single core laptop appears to gain little from threading,
so I had to run the program from my Windows gaming PC.  
Windows has no simple UNIX-like command to time the execution of
programs, so I had to implement a quick delta time calculation to verify
that my program was in fact seeing improved runtimes with the use of more threads. Output from my testing can be found below.

### My Sample Output
```
PS F:\Projects\CS1530-Threads-Exercise> java Pi 2 100
Total   = 100
Inside  = 78
Ratio   = 0.78
Pi      = 3.12

Time    = 47 ms
PS F:\Projects\CS1530-Threads-Exercise> java Pi 4 100
Total   = 100
Inside  = 80
Ratio   = 0.8
Pi      = 3.2

Time    = 47 ms
PS F:\Projects\CS1530-Threads-Exercise> java Pi 4 1000000000
Total   = 1000000000
Inside  = 785383261
Ratio   = 0.785383261
Pi      = 3.141533044

Time    = 2047 ms
PS F:\Projects\CS1530-Threads-Exercise> java Pi 1 1000000000
Total   = 1000000000
Inside  = 785400737
Ratio   = 0.785400737
Pi      = 3.141602948

Time    = 5962 ms
PS F:\Projects\CS1530-Threads-Exercise> java Pi 2 1000000000
Total   = 1000000000
Inside  = 785416205
Ratio   = 0.785416205
Pi      = 3.14166482

Time    = 3074 ms
PS F:\Projects\CS1530-Threads-Exercise> java Pi 20 1000000000
Total   = 1000000000
Inside  = 785383308
Ratio   = 0.785383308
Pi      = 3.141533232

Time    = 1939 ms
```