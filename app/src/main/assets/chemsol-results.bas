CLS

OPEN "I", #1, "/data/data/cz.p/files/thermo_s1.txt"
OPEN "I", #2, "/data/data/cz.p/files/chemsoloutfile.txt"
OPEN "O", #3, "/data/data/cz.p/files/thermo_s2.txt"
CLOSE #3
OPEN "A", #3, "/data/data/cz.p/files/thermo_s2.txt"



INPUT #1, ThermoG$
LenghtData% = LEN(ThermoG$)
Lim0% = INSTR(ThermoG$, " ")
Name$ = MID$(ThermoG$, 1, Lim0%-1)
Lim1% = INSTR(ThermoG$, " ", Lim0%+1)
Formula$ = MID$(ThermoG$, Lim0%+1, Lim1%-Lim0%-1)
Lim2% = INSTR(ThermoG$, " ", Lim1%+1)
Method$ = MID$(ThermoG$, Lim1%+1, Lim2%-Lim1%-1)
Lim3% = INSTR(ThermoG$, " ", Lim2%+1)
TotDummy$ = MID$(ThermoG$, Lim2%+1, Lim3%-Lim2%-1)
Lim4% = INSTR(ThermoG$, " ", Lim3%+1)
H$ = MID$(ThermoG$, Lim3%+1, Lim4%-Lim3%-1)
Lim5% = INSTR(ThermoG$, " ", Lim4%+1)
Dummy1$ = MID$(ThermoG$, Lim4%+1, Lim5%-Lim4%-1)
Lim6% = INSTR(ThermoG$, " ", Lim5%+1)
Dummy2$ = MID$(ThermoG$, Lim5%+1, Lim6%-Lim5%-1)
Lim7% = INSTR(ThermoG$, " ", Lim6%+1)
S$ = MID$(ThermoG$, Lim6%+1, LenghtData%-Lim7%)
S = VAL(S$)
H = VAL(H$)

INPUT #2, Solvation$
Ssolv$ = MID$(Solvation$, 35, 7)
Ssolv = VAL(Ssolv$)
Hsolv$ = MID$(Solvation$, 58, 9)
Hsolv = VAL(Hsolv$)

Sreal = 1000*Ssolv/298.15

Htot = H+Hsolv
Stot = S+Sreal

#PRINT #3, Name$;" ";Formula$;" ";Method$;" ";TotDummy$;" ";Htot;" ";Dummy1$;" ";Dummy2$;" ";Stot
PRINT #3, Name$;" ";Formula$;" ";Method$;" ";"0";" ";Htot;" ";"0";" ";"0";" ";Stot

CLOSE #1
CLOSE #2
CLOSE #3


END
EXIT