CLS

OPEN "I", #1, "/data/data/cz.p/files/thermo_s_R1.txt"
OPEN "I", #2, "/data/data/cz.p/files/thermo_s_R2.txt"
OPEN "I", #3, "/data/data/cz.p/files/thermo_s_P1.txt"
OPEN "I", #4, "/data/data/cz.p/files/thermo_s_P2.txt"
OPEN "I", #5, "/data/data/cz.p/files/thermo_s_TS.txt"
OPEN "I", #6, "/data/data/cz.p/files/temperature.txt"

OPEN "O", #7, "/data/data/cz.p/files/thermo_s_SMS.txt"
CLOSE #7
OPEN "A", #7, "/data/data/cz.p/files/thermo_s_SMS.txt"

OPEN "O", #8, "/data/data/cz.p/files/thermo_s_SS.txt"
CLOSE #8
OPEN "A", #8, "/data/data/cz.p/files/thermo_s_SS.txt"

OPEN "O", #9, "/data/data/cz.p/files/thermo_s_KINETICS.txt"
CLOSE #9
OPEN "A", #9, "/data/data/cz.p/files/thermo_s_KINETICS.txt"

OPEN "O", #10, "/data/data/cz.p/files/thermo_s_RATES.txt"
CLOSE #10
OPEN "A", #10, "/data/data/cz.p/files/thermo_s_RATES.txt"

OPEN "I", #11, "/data/data/cz.p/files/dataset-name.txt"

INPUT #1, ThermoR1$
LenghtDataR1% = LEN(ThermoR1$)
Lim0% = INSTR(ThermoR1$, " ")
NameR1$ = MID$(ThermoR1$, 1, Lim0%-1)
Lim1% = INSTR(ThermoR1$, " ", Lim0%+1)
FormulaR1$ = MID$(ThermoR1$, Lim0%+1, Lim1%-Lim0%-1)
Lim2% = INSTR(ThermoR1$, " ", Lim1%+1)
MethodR1$ = MID$(ThermoR1$, Lim1%+1, Lim2%-Lim1%-1)
Lim3% = INSTR(ThermoR1$, " ", Lim2%+1)
TotDummyR1$ = MID$(ThermoR1$, Lim2%+1, Lim3%-Lim2%-1)
Lim4% = INSTR(ThermoR1$, " ", Lim3%+1)
HR1$ = MID$(ThermoR1$, Lim3%+1, Lim4%-Lim3%-1)
Lim5% = INSTR(ThermoR1$, " ", Lim4%+1)
Dummy1R1$ = MID$(ThermoR1$, Lim4%+1, Lim5%-Lim4%-1)
Lim6% = INSTR(ThermoR1$, " ", Lim5%+1)
Dummy2R1$ = MID$(ThermoR1$, Lim5%+1, Lim6%-Lim5%-1)
Lim7% = INSTR(ThermoR1$, " ", Lim6%+1)
SR1$ = MID$(ThermoR1$, Lim6%+1, LenghtDataR1%-Lim7%)
SR1 = VAL(SR1$)
HR1 = VAL(HR1$)

INPUT #2, ThermoR2$
LenghtDataR2% = LEN(ThermoR2$)
Lim10% = INSTR(ThermoR2$, " ")
NameR2$ = MID$(ThermoR2$, 1, Lim10%-1)
Lim11% = INSTR(ThermoR2$, " ", Lim10%+1)
FormulaR2$ = MID$(ThermoR2$, Lim10%+1, Lim11%-Lim10%-1)
Lim12% = INSTR(ThermoR2$, " ", Lim11%+1)
MethodR2$ = MID$(ThermoR2$, Lim11%+1, Lim12%-Lim11%-1)
Lim13% = INSTR(ThermoR2$, " ", Lim12%+1)
TotDummyR2$ = MID$(ThermoR2$, Lim12%+1, Lim13%-Lim12%-1)
Lim14% = INSTR(ThermoR2$, " ", Lim13%+1)
HR2$ = MID$(ThermoR2$, Lim13%+1, Lim14%-Lim13%-1)
Lim15% = INSTR(ThermoR2$, " ", Lim14%+1)
Dummy1R2$ = MID$(ThermoR2$, Lim14%+1, Lim15%-Lim14%-1)
Lim16% = INSTR(ThermoR2$, " ", Lim15%+1)
Dummy2R2$ = MID$(ThermoR2$, Lim15%+1, Lim16%-Lim15%-1)
Lim17% = INSTR(ThermoR2$, " ", Lim16%+1)
SR2$ = MID$(ThermoR2$, Lim16%+1, LenghtDataR2%-Lim17%)
SR2 = VAL(SR2$)
HR2 = VAL(HR2$)

INPUT #3, ThermoP1$
LenghtDataP1% = LEN(ThermoP1$)
Lim20% = INSTR(ThermoP1$, " ")
NameP1$ = MID$(ThermoP1$, 1, Lim20%-1)
Lim21% = INSTR(ThermoP1$, " ", Lim20%+1)
FormulaP1$ = MID$(ThermoP1$, Lim20%+1, Lim21%-Lim20%-1)
Lim22% = INSTR(ThermoP1$, " ", Lim21%+1)
MethodP1$ = MID$(ThermoP1$, Lim21%+1, Lim22%-Lim21%-1)
Lim23% = INSTR(ThermoP1$, " ", Lim22%+1)
TotDummyP1$ = MID$(ThermoP1$, Lim22%+1, Lim23%-Lim22%-1)
Lim24% = INSTR(ThermoP1$, " ", Lim23%+1)
HP1$ = MID$(ThermoP1$, Lim23%+1, Lim24%-Lim23%-1)
Lim25% = INSTR(ThermoP1$, " ", Lim24%+1)
Dummy1P1$ = MID$(ThermoP1$, Lim24%+1, Lim25%-Lim24%-1)
Lim26% = INSTR(ThermoP1$, " ", Lim25%+1)
Dummy2P1$ = MID$(ThermoP1$, Lim25%+1, Lim26%-Lim25%-1)
Lim27% = INSTR(ThermoP1$, " ", Lim26%+1)
SP1$ = MID$(ThermoP1$, Lim26%+1, LenghtDataP1%-Lim27%)
SP1 = VAL(SP1$)
HP1 = VAL(HP1$)

INPUT #4, ThermoP2$
LenghtDataP2% = LEN(ThermoP2$)
Lim30% = INSTR(ThermoP2$, " ")
NameP2$ = MID$(ThermoP2$, 1, Lim30%-1)
Lim31% = INSTR(ThermoP2$, " ", Lim30%+1)
FormulaP2$ = MID$(ThermoP2$, Lim30%+1, Lim31%-Lim30%-1)
Lim32% = INSTR(ThermoP2$, " ", Lim31%+1)
MethodP2$ = MID$(ThermoP2$, Lim31%+1, Lim32%-Lim31%-1)
Lim33% = INSTR(ThermoP2$, " ", Lim32%+1)
TotDummyP2$ = MID$(ThermoP2$, Lim32%+1, Lim33%-Lim32%-1)
Lim34% = INSTR(ThermoP2$, " ", Lim33%+1)
HP2$ = MID$(ThermoP2$, Lim33%+1, Lim34%-Lim33%-1)
Lim35% = INSTR(ThermoP2$, " ", Lim34%+1)
Dummy1P2$ = MID$(ThermoP2$, Lim34%+1, Lim35%-Lim34%-1)
Lim36% = INSTR(ThermoP2$, " ", Lim35%+1)
Dummy2P2$ = MID$(ThermoP2$, Lim35%+1, Lim36%-Lim35%-1)
Lim37% = INSTR(ThermoP2$, " ", Lim36%+1)
SP2$ = MID$(ThermoP2$, Lim36%+1, LenghtDataP2%-Lim37%)
SP2 = VAL(SP2$)
HP2 = VAL(HP2$)

INPUT #5, ThermoTS$
LenghtDataTS% = LEN(ThermoTS$)
Lim40% = INSTR(ThermoTS$, " ")
NameTS$ = MID$(ThermoTS$, 1, Lim40%-1)
Lim41% = INSTR(ThermoTS$, " ", Lim40%+1)
FormulaTS$ = MID$(ThermoTS$, Lim40%+1, Lim41%-Lim40%-1)
Lim42% = INSTR(ThermoTS$, " ", Lim41%+1)
MethodTS$ = MID$(ThermoTS$, Lim41%+1, Lim42%-Lim41%-1)
Lim43% = INSTR(ThermoTS$, " ", Lim42%+1)
TotDummyTS$ = MID$(ThermoTS$, Lim42%+1, Lim43%-Lim42%-1)
Lim44% = INSTR(ThermoTS$, " ", Lim43%+1)
HTS$ = MID$(ThermoTS$, Lim43%+1, Lim44%-Lim43%-1)
Lim45% = INSTR(ThermoTS$, " ", Lim44%+1)
Dummy1TS$ = MID$(ThermoTS$, Lim44%+1, Lim45%-Lim44%-1)
Lim46% = INSTR(ThermoTS$, " ", Lim45%+1)
Dummy2TS$ = MID$(ThermoTS$, Lim45%+1, Lim46%-Lim45%-1)
Lim47% = INSTR(ThermoTS$, " ", Lim46%+1)
STS$ = MID$(ThermoTS$, Lim46%+1, LenghtDataTS%-Lim47%)
STS = VAL(STS$)
HTS = VAL(HTS$)

IF TALLY(FormulaR1$,"+")>0 THEN
LenR1% = LEN(FormulaR1$)
PosR1% = INSTR(FormulaR1$, "+")
ChargeCharacterR1$ = MID$(FormulaR1$, PosR1%, LenR1%-PosR1%+1)
SMS_R1$ = CHR$(091)+FormulaR1$+CHR$(093)
FormulaR1$ = CHR$(091)+FormulaR1$+CHR$(093)+ChargeCharacterR1$
ELSE IF TALLY(FormulaR1$,"-")>0 THEN
LenR1% = LEN(FormulaR1$)
PosR1% = INSTR(FormulaR1$, "-")
ChargeCharacterR1$ = MID$(FormulaR1$, PosR1%, LenR1%-PosR1%+1)
SMS_R1$ = CHR$(091)+FormulaR1$+CHR$(093)
FormulaR1$ = CHR$(091)+FormulaR1$+CHR$(093)+ChargeCharacterR1$
ELSE
SMS_R1$ = CHR$(091)+FormulaR1$+CHR$(093)
FormulaR1$ = CHR$(091)+FormulaR1$+CHR$(093)
ENDIF

IF TALLY(FormulaR2$,"+")>0 THEN
LenR2% = LEN(FormulaR2$)
PosR2% = INSTR(FormulaR2$, "+")
ChargeCharacterR2$ = MID$(FormulaR2$, PosR2%, LenR2%-PosR2%+1)
SMS_R2$ = CHR$(091)+FormulaR2$+CHR$(093)
FormulaR2$ = CHR$(091)+FormulaR2$+CHR$(093)+ChargeCharacterR2$
ELSE IF TALLY(FormulaR2$,"-")>0 THEN
LenR2% = LEN(FormulaR2$)
PosR2% = INSTR(FormulaR2$, "-")
ChargeCharacterR2$ = MID$(FormulaR2$, PosR2%, LenR2%-PosR2%+1)
SMS_R2$ = CHR$(091)+FormulaR2$+CHR$(093)
FormulaR2$ = CHR$(091)+FormulaR2$+CHR$(093)+ChargeCharacterR2$
ELSE
SMS_R2$ = CHR$(091)+FormulaR2$+CHR$(093)
FormulaR2$ = CHR$(091)+FormulaR2$+CHR$(093)
ENDIF

IF TALLY(FormulaP1$,"+")>0 THEN
LenP1% = LEN(FormulaP1$)
PosP1% = INSTR(FormulaP1$, "+")
ChargeCharacterP1$ = MID$(FormulaP1$, PosP1%, LenP1%-PosP1%+1)
SMS_P1$ = CHR$(091)+FormulaP1$+CHR$(093)
FormulaP1$ = CHR$(091)+FormulaP1$+CHR$(093)+ChargeCharacterP1$
ELSE IF TALLY(FormulaP1$,"-")>0 THEN
LenP1% = LEN(FormulaP1$)
PosP1% = INSTR(FormulaP1$, "-")
ChargeCharacterP1$ = MID$(FormulaP1$, PosP1%, LenP1%-PosP1%+1)
SMS_P1$ = CHR$(091)+FormulaP1$+CHR$(093)
FormulaP1$ = CHR$(091)+FormulaP1$+CHR$(093)+ChargeCharacterP1$
ELSE
SMS_P1$ = CHR$(091)+FormulaP1$+CHR$(093)
FormulaP1$ = CHR$(091)+FormulaP1$+CHR$(093)
ENDIF

IF TALLY(FormulaP2$,"+")>0 THEN
LenP2% = LEN(FormulaP2$)
PosP2% = INSTR(FormulaP2$, "+")
ChargeCharacterP2$ = MID$(FormulaP2$, PosP2%, LenP2%-PosP2%+1)
SMS_P2$ = CHR$(091)+FormulaP2$+CHR$(093)
FormulaP2$ = CHR$(091)+FormulaP2$+CHR$(093)+ChargeCharacterP2$
ELSE IF TALLY(FormulaP2$,"-")>0 THEN
LenP2% = LEN(FormulaP2$)
PosP2% = INSTR(FormulaP2$, "-")
ChargeCharacterP2$ = MID$(FormulaP2$, PosP2%, LenP2%-PosP2%+1)
SMS_P2$ = CHR$(091)+FormulaP2$+CHR$(093)
FormulaP2$ = CHR$(091)+FormulaP2$+CHR$(093)+ChargeCharacterP2$
ELSE
SMS_P2$ = CHR$(091)+FormulaP2$+CHR$(093)
FormulaP2$ = CHR$(091)+FormulaP2$+CHR$(093)
ENDIF

INPUT #6, Temp$
Temp = VAL(Temp$)

h = 6.626176e-34
kappa = 1
kB = 1.380662e-23
#kB = 8.314/6.022e23
R = 8.314
deltaHact_f = HTS - HR1 - HR2
deltaHact_b = HTS - HP1 - HP2
deltaSact_f = STS - SR1 - SR2
deltaSact_b = STS - SP1 - SP2
deltaGact_f = (deltaHact_f*1000 - Temp*deltaSact_f)*4.184
deltaGact_b = (deltaHact_b*1000 - Temp*deltaSact_b)*4.184
k_forward = kappa * kB * Temp * (1/h) * EXP(-deltaGact_f/(R * Temp))
k_backward = kappa * kB * Temp * (1/h) * EXP(-deltaGact_b/(R * Temp))

PRINT #7, SMS_R1$, FormulaR1$, "0", SMS_R1$, 1
PRINT #7, SMS_R2$, FormulaR2$, "0", SMS_R2$, 1
PRINT #7, SMS_P1$, FormulaP1$, "0", SMS_P1$, 1
PRINT #7, SMS_P2$, FormulaP2$, "0", SMS_P2$, 1

PRINT #8, FormulaR1$;" = ";FormulaR1$
PRINT #8, FormulaR2$;" = ";FormulaR2$
PRINT #8, FormulaP1$;" = ";FormulaP1$
PRINT #8, FormulaP2$;" = ";FormulaP2$

INPUT #11, DatasetName$

PRINT #9, DatasetName$;"_forward ; -formula ";FormulaR1$;" -1 ";FormulaR2$;" -1 ";FormulaP1$;" 1 ";FormulaP2$;" 1 "
PRINT #9, DatasetName$;"_backward ; -formula ";FormulaP1$;" -1 ";FormulaP2$;" -1 ";FormulaR1$;" 1 ";FormulaR2$;" 1 "

PRINT #10, DatasetName$;"_forward ; -start ; 10 if (MOL("+CHR$(034)+FormulaR1$+CHR$(034)+") <= 1e-15) then goto 200 ; 20 if (MOL("+CHR$(034)+FormulaR2$+CHR$(034)+") <= 1e-15) then goto 200 ; 100 moles = "+STR$(k_forward)+" "+CHR$(042)+" MOL("+CHR$(034)+FormulaR1$+CHR$(034)+") "+CHR$(042)+" MOL("+CHR$(034)+FormulaR2$+CHR$(034)+") "+CHR$(042)+" TIME ; 200 SAVE moles ; -end"
PRINT #10, DatasetName$;"_backward ; -start ; 10 if (MOL("+CHR$(034)+FormulaP1$+CHR$(034)+") <= 1e-15) then goto 200 ; 20 if (MOL("+CHR$(034)+FormulaP2$+CHR$(034)+") <= 1e-15) then goto 200 ; 100 moles = "+STR$(k_backward)+" "+CHR$(042)+" MOL("+CHR$(034)+FormulaP1$+CHR$(034)+") "+CHR$(042)+" MOL("+CHR$(034)+FormulaP2$+CHR$(034)+") "+CHR$(042)+" TIME ; 200 SAVE moles ; -end"

CLOSE #1
CLOSE #2
CLOSE #3
CLOSE #4
CLOSE #5
CLOSE #6
CLOSE #7
CLOSE #8
CLOSE #9
CLOSE #10
CLOSE #11

END
EXIT