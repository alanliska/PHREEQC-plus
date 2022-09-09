CLS

DIM Inp$(10001)
DIM Inp2$(10001)


Cum_S = 0
Cum_H = 0
Cum_G = 0
Cum_Probe = 0

OPEN "I", #21, "/data/data/cz.p/files/PHASES/Comp_g.par"
INPUT #21, Temperature$, G_corr$, H_corr$, S_corr$, G0_corr$, H0_corr$, S0_corr$, Conversion$, G_electron$, StateCmp$, StateSpc$
Temperature = VAL(Temperature$)
G_corr = VAL(G_corr$)
H_corr = VAL(H_corr$)
S_corr = VAL(S_corr$)
G0_corr = VAL(G0_corr$)
H0_corr = VAL(H0_corr$)
S0_corr = VAL(S0_corr$)
Conversion = VAL(Conversion$)
G_electron = VAL(G_electron$)
CLOSE #21

OPEN "I", #1, "/data/data/cz.p/files/PHASES/Thermochemistry_g.txt"
OPEN "O", #10, "/data/data/cz.p/files/PHASES/Database_g.dat"
CLOSE #10
OPEN "A", #10, "/data/data/cz.p/files/PHASES/Database_g.dat"


#PRINT #10, "PHREEQC database fragment"
#PRINT #10, "========================="
#PRINT #10, "Generation from quantum chemical results / empirical qualified estimations"
#PRINT #10, "Parameters (read from the file Comp_g.par):"
#PRINT #10, "Gcorr for compressing 1 mol gas std. state at 1 atm to 1 liter of soln. (kJ.mol-1) = ", G_corr
#PRINT #10, "Hcorr for compressing 1 mol gas std. state at 1 atm to 1 liter of soln. (kJ.mol-1) = ", H_corr
#PRINT #10, "Scorr for compressing 1 mol gas std. state at 1 atm to 1 liter of soln. (J.K-1.mol-1) = ", S_corr
#PRINT #10, "Temperature = (K) ", Temperature
#PRINT #10, "Conversion factor for units in input datasheets to kJ.mol-1 = ", Conversion
#PRINT #10, "G of electron (kJ.mol-1) = ", G_electron
#PRINT #10, ""
#PRINT #10, "Data on species: file Thermochemistry_g.txt"
#PRINT #10, "(without header and blank lines)"
#PRINT #10, "Data on ref. elements and org. fragments: file Ref_g.txt"
#PRINT #10, "(without header and blank lines)"
#PRINT #10, ""
#PRINT #10, "PHASES"
#PRINT #10, ""

DO



I% = 0

INPUT #1, LineData$

Inp$(I%) = LineData$
LenghtData% = LEN(LineData$)
Lim0% = INSTR(LineData$, " ")
Description$ = LEFT$(LineData$, Lim0%-1)
Lim1% = INSTR(LineData$, " ", Lim0%+1)
Species$ = MID$(LineData$, Lim0%+1, Lim1%-Lim0%-1)
Lim2% = INSTR(LineData$, " ", Lim1%+1)
ReferenceH$ = MID$(LineData$, Lim1%+1, Lim2%-Lim1%-1)
ReferenceS$ = ReferenceH$
Lim3% = INSTR(LineData$, " ", Lim2%+1)
TotDummy$ = MID$(LineData$, Lim2%+1, Lim3%-Lim2%-1)
Lim4% = INSTR(LineData$, " ", Lim3%+1)
H$ = MID$(LineData$, Lim3%+1, Lim4%-Lim3%-1)
H = VAL(H$) * Conversion + H_corr
Lim5% = INSTR(LineData$, " ", Lim4%+1)
DummyH$ = MID$(LineData$, Lim4%+1, Lim5%-Lim4%-1)
Lim6% = INSTR(LineData$, " ", Lim5%+1)
DummyC$ = MID$(LineData$, Lim5%+1, Lim6%-Lim5%-1)
Lim7% = INSTR(LineData$, " ", Lim6%+1)
S$ = MID$(LineData$, Lim6%+1, LenghtData%-Lim6%)
S = VAL(S$) * Conversion + S_corr

Cum_H = Cum_H + H
Cum_S = Cum_S + S

IF H$ = "" THEN 
Cum_Probe = Cum_Probe + 1
ENDIF


#z definice - vymazat �daje z p�edchoz�ho b�hu smy�ky:
Brackets$ = ""
SqBrackets$ = ""
BracketsRound$ = ""


StringEdit$ = Species$

FormulaCmp$ = Species$
### tyto dva ��dky mus� b�t zde, jinak nefunguj� kulat� z�vorky
Cumulative_Corr$ = ""
Cumulated$ = ""

### PREPROCESSING ROUND BRACKETS



CountRound = TALLY(Species$,CHR$(040))
IF CountRound = 0
GOTO Part_II
ENDIF

StringEdit$ = Species$



IF CountRound >= 1 THEN
PosChar3% = INSTR(StringEdit$, CHR$(040))
PosChar4% = INSTR(StringEdit$, CHR$(041))
u = CountRound
ij = 1

DO	
EditLengthRound% = LEN(StringEdit$)

PosChar3% = INSTR(StringEdit$, CHR$(040))
PosChar4% = INSTR(StringEdit$, CHR$(041))
LeftPartRound$ = MID$(StringEdit$, 0, PosChar3%-1)
LeftPartRound% = LEN(LeftPartRound$)
RightEndRound$ = MID$(StringEdit$, PosChar4%+1, EditLengthRound%-PosChar4%)

#velmi podstatn�!!!
#kdy� ve vzorci je po z�vorce u� jen n�boj, bral by jeho hodnotu jako po�et z�vorek, co� by pro typ XY(Z)+n bylo n a ne 1, pro typ XY(Z)-n zase -n a ne 1; nav�c by se ztratil n�boj, resp. by se na��tal n�kolikr�t, ale elektrony by se nezapo�etly

IF (INSTR(RightEndRound$, "+") = 1) OR (INSTR(RightEndRound$, "-") = 1) THEN
CountRound = 1
CountRound$ = ""
LengthCountRound% = 0
ELSE
CountRound = VAL(RightEndRound$)
	# tady �pravy k 0 ve v�znamu 1
CountRound$ = STR$(CountRound)
LengthCountRound% = LEN(CountRound$)
ENDIF


IF CountRound = 0 THEN
CountRound = 1
CountRound$ = ""
LengthCountRound% = 0
ENDIF


BracketPartRound$ = MID$(StringEdit$, PosChar3%+1, PosChar4%-PosChar3%-1)
LengthBracketPartRound% = LEN(BracketPartRound$)
RightPartRound$ = MID$(StringEdit$, PosChar4%+LengthCountRound%+1, EditLengthRound%-LeftPartRound%-LengthCountRound%-LengthBracketPartRound%)

# tato ��st kumuluje v�echny kulat� z�vorky a eliminuje je z dal��ho zpracov�n� - potom se p��d� najednou a� ke konci k�du



BracketsRound$ = BracketsRound$+";"+CHR$(040)+BracketPartRound$+CHR$(041)+CountRound$


IF LeftPartRound$ <> "" THEN
StringEdit$ = LeftPartRound$+RightPartRound$

ELSE
StringEdit$ = RightPartRound$

ENDIF

################################################################
### SPLITTING OF THE FORMULAS - nested


ABC$ = BracketPartRound$
nABC = CountRound
nABC$ = STR$(nABC)



### PREPROCESSING SQUARE BRACKETS

CountSquare = TALLY(ABC$,CHR$(091))

IF CountSquare > 0 THEN
 w = CountSquare
 j = 1
DO
EdLength% = LEN(ABC$)
PositionCharacter1% = INSTR(ABC$, CHR$(091))
PositionCharacter2% = INSTR(ABC$, CHR$(093))
LPart$ = MID$(ABC$, 0, PositionCharacter1%-1)
LPart% = LEN(LPart$)
REnd$ = MID$(ABC$, PositionCharacter2%+1, EdLength%-PositionCharacter2%)



### velmi d�le�it� - p��pady XY(Z)+n/-n

IF (INSTR(REnd$, "+") = 1) OR (INSTR(REnd$, "-") = 1) THEN
CBracket = 1
CBracket$ = ""
LengthCBracket% = 0
ELSE
CBracket = VAL(REnd$)
	# tady �pravy k 0 ve v�znamu 1
CBracket$ = STR$(CBracket)
LengthCBracket% = LEN(CBracket$)
ENDIF

IF CBracket = 0 THEN
CBracket$ = ""
CBracket = nABC
LengthCBracket% = 0
ELSE
CBracket = CBracket*nABC
CBracket$ = STR$(CBracket)
LengthCBracket% = LEN(CBracket$)
ENDIF



SquarePart$ = MID$(ABC$, PositionCharacter1%+1, PositionCharacter2%-PositionCharacter1%-1)
LengthSquarePart% = LEN(SquarePart$)
RPart$ = MID$(ABC$, PositionCharacter2%+LengthCBracket%+1, EdLength%-LPart%-LengthCBracket%-LengthSquarePart%)








IF LPart$ <> "" THEN
ABC$ = LPart$+RPart$
ELSE
ABC$ = RPart$
ENDIF
IF SquarePart$ <> ""
SqBrackets$ = SqBrackets$+";"+CHR$(091)+SquarePart$+CHR$(093)+STR$(CBracket)
ENDIF

EXIT IF j >= w

j = j+1

ENDIF 

LOOP

w = 0
j = 0

### PREPROCESSING ELEMENTS+COUNTS

# tady mus� b�t p�v. species, proto�e pak dole to rozhoduje o uveden�-neuveden� pr�zdn�ch hranat�ch z�vorek
#CountConstr = TALLY(ABC$,CHR$(091))
#	# PRINT #2, "countbracket = ",CountBracket
#	# PRINT #2, "species = "+ABC$
CountA = TALLY(ABC$,"A")
CountB = TALLY(ABC$,"B")
CountC = TALLY(ABC$,"C")
CountD = TALLY(ABC$,"D")
CountE = TALLY(ABC$,"E")
CountF = TALLY(ABC$,"F")
CountG = TALLY(ABC$,"G")
CountH = TALLY(ABC$,"H")
CountI = TALLY(ABC$,"I")
CountJ = TALLY(ABC$,"J")
CountK = TALLY(ABC$,"K")
CountL = TALLY(ABC$,"L")
CountM = TALLY(ABC$,"M")
CountN = TALLY(ABC$,"N")
CountO = TALLY(ABC$,"O")
CountP = TALLY(ABC$,"P")
CountQ = TALLY(ABC$,"Q")
CountR = TALLY(ABC$,"R")
CountS = TALLY(ABC$,"S")
CountT = TALLY(ABC$,"T")
CountU = TALLY(ABC$,"U")
CountV = TALLY(ABC$,"V")
CountW = TALLY(ABC$,"W")
CountX = TALLY(ABC$,"X")
CountY = TALLY(ABC$,"Y")
CountZ = TALLY(ABC$,"Z")
#CountRound = TALLY(ABC$,CHR$(040))


IF CountA > 0 THEN

 PosChar% = INSTR(ABC$, "A")
 x = CountA
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "A", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

#takhle ne - jinak d�l� chyby typu H3P + W + 40 O, H2P + 2 O atd.
#EXIT IF k >= x

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0





IF CountB > 0 THEN

 PosChar% = INSTR(ABC$, "B")
 x = CountB
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "B", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountC > 0 THEN

 PosChar% = INSTR(ABC$, "C")
 x = CountC
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "C", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0
	
IF CountD > 0 THEN

 PosChar% = INSTR(ABC$, "D")
 x = CountD
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "D", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0
	
IF CountE > 0 THEN

 PosChar% = INSTR(ABC$, "E")
 x = CountE
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "E", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountF > 0 THEN

 PosChar% = INSTR(ABC$, "F")
 x = CountF
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "F", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountG > 0 THEN

 PosChar% = INSTR(ABC$, "G")
 x = CountG
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "G", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountH > 0 THEN

 PosChar% = INSTR(ABC$, "H")
 x = CountH
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "H", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountI > 0 THEN

 PosChar% = INSTR(ABC$, "I")
 x = CountI
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "I", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountJ > 0 THEN

 PosChar% = INSTR(ABC$, "J")
 x = CountJ
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "J", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountK > 0 THEN

 PosChar% = INSTR(ABC$, "K")
 x = CountK
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "K", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountL > 0 THEN

 PosChar% = INSTR(ABC$, "L")
 x = CountL
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "L", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountM > 0 THEN

 PosChar% = INSTR(ABC$, "M")
 x = CountM
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "M", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountN > 0 THEN

 PosChar% = INSTR(ABC$, "N")
 x = CountN
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "N", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountO > 0 THEN

 PosChar% = INSTR(ABC$, "O")
 x = CountO
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "O", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountP > 0 THEN

 PosChar% = INSTR(ABC$, "P")
 x = CountP
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "P", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountQ > 0 THEN

 PosChar% = INSTR(ABC$, "Q")
 x = CountQ
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "Q", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountR > 0 THEN

 PosChar% = INSTR(ABC$, "R")
 x = CountR
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "R", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountS > 0 THEN

 PosChar% = INSTR(ABC$, "S")
 x = CountS
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "S", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountT > 0 THEN

 PosChar% = INSTR(ABC$, "T")
 x = CountT
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "T", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountU > 0 THEN

 PosChar% = INSTR(ABC$, "U")
 x = CountU
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "U", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountV > 0 THEN

 PosChar% = INSTR(ABC$, "V")
 x = CountV
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "V", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountW > 0 THEN

 PosChar% = INSTR(ABC$, "W")
 x = CountW
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "W", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountX > 0 THEN

 PosChar% = INSTR(ABC$, "X")
 x = CountX
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "X", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountY > 0 THEN

 PosChar% = INSTR(ABC$, "Y")
 x = CountY
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "Y", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountZ > 0 THEN

 PosChar% = INSTR(ABC$, "Z")
 x = CountZ
 k = 1

DO	
EditLength% = LEN(ABC$)
PosChar% = INSTR(ABC$, "Z", NewPos%)
LeftPart$ = MID$(ABC$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(ABC$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
ABC$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
ABC$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0













WHILE LEN(ABC$)
  SPLIT ABC$,";",0,b$,ABC$





beta_test% = MAX(INSTR(b$, "A"), INSTR(b$, "a"), INSTR(b$, "B"), INSTR(b$, "b"), INSTR(b$, "C"), INSTR(b$, "c"), INSTR(b$, "D"), INSTR(b$, "d"), INSTR(b$, "E"), INSTR(b$, "e"), INSTR(b$, "F"), INSTR(b$, "f"), INSTR(b$, "G"), INSTR(b$, "g"), INSTR(b$, "H"), INSTR(b$, "h"), INSTR(b$, "I"), INSTR(b$, "i"), INSTR(b$, "J"), INSTR(b$, "j"), INSTR(b$, "K"), INSTR(b$, "k"), INSTR(b$, "L"), INSTR(b$, "l"), INSTR(b$, "M"), INSTR(b$, "m"), INSTR(b$, "N"), INSTR(b$, "n"), INSTR(b$, "O"), INSTR(b$, "o"), INSTR(b$, "P"), INSTR(b$, "p"), INSTR(b$, "Q"), INSTR(b$, "q"), INSTR(b$, "R"), INSTR(b$, "r"), INSTR(b$, "S"), INSTR(b$, "s"), INSTR(b$, "T"), INSTR(b$, "t"), INSTR(b$, "U"), INSTR(b$, "u"), INSTR(b$, "V"), INSTR(b$, "v"), INSTR(b$, "W"), INSTR(b$, "w"), INSTR(b$, "X"), INSTR(b$, "x"), INSTR(b$, "Y"), INSTR(b$, "y"), INSTR(b$, "Z"), INSTR(b$, "z"), INSTR(b$, CHR$(091)), INSTR(b$, CHR$(093)))
# mus� se napsat i lev� i prav� hranat� z�vorka - aby na�lo spr�vn�
ABCLength% = LEN(b$)

IF beta_test% = ABCLength% THEN
ElmntABC$ = b$
ElmntABCCount = 1
ELSE 
ElmntABC$ = MID$(b$, 1, beta_test%)
ElmntABCCount$ = MID$(b$, beta_test%+1, ABCLength%-beta_test%)
ElmntABCCount = VAL(ElmntABCCount$)
ENDIF

ElmntABCCount = ElmntABCCount*nABC

Cumulative_Corr$ = Cumulative_Corr$+";"+ElmntABC$+STR$(ElmntABCCount)


ABD$ = Cumulative_Corr$

CumulatedNumbers$ = ElmntABC$+STR$(ElmntABCCount)
Cumulated$ = Cumulated$+";"+CumulatedNumbers$

  INC ik
  
WEND
######################################################################










EXIT IF ij >= u


ij = ij+1

ENDIF

LOOP
u = 0
ij = 0
CountRound = 0


	






































Part_II:




### PREPROCESSING SQUARE BRACKETS

CountConstr = TALLY(StringEdit$,CHR$(091))

IF CountConstr > 0 THEN

 w = CountConstr
 j = 1

DO
LeftPart$ = ""
RightEnd$ = ""

EditLength% = LEN(StringEdit$)
PosChar1% = INSTR(StringEdit$, CHR$(091))
PosChar2% = INSTR(StringEdit$, CHR$(093))
LeftPart$ = MID$(StringEdit$, 0, PosChar1%-1)
LeftPart% = LEN(LeftPart$)
RightEnd$ = MID$(StringEdit$, PosChar2%+1, EditLength%-PosChar2%)

### velmi d�le�it� - p��pady XY(Z)+n/-n

IF (INSTR(RightEnd$, "+") = 1) OR (INSTR(RightEnd$, "-") = 1) THEN
CountBracket = 1
CountBracket$ = ""
LengthCountBracket% = 0
ELSE
CountBracket = VAL(RightEnd$)
	# tady �pravy k 0 ve v�znamu 1
CountBracket$ = STR$(CountBracket)
LengthCountBracket% = LEN(CountBracket$)
ENDIF

IF CountBracket = 0 THEN
CountBracket = 1
CountBracket$ = ""
LengthCountBracket% = 0
ENDIF









BracketPart$ = MID$(StringEdit$, PosChar1%+1, PosChar2%-PosChar1%-1)
LengthBracketPart% = LEN(BracketPart$)
RightPart$ = MID$(StringEdit$, PosChar2%+LengthCountBracket%+1, EditLength%-LeftPart%-LengthCountBracket%-LengthBracketPart%)
IF j > 1 
Brackets$ = Brackets$+";"+CHR$(091)+BracketPart$+CHR$(093)+CountBracket$
ELSE IF j = 1 AND BracketPart$ <> ""
Brackets$ = ";"+CHR$(091)+BracketPart$+CHR$(093)+CountBracket$
ENDIF
IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+RightPart$
ELSE
StringEdit$ = RightPart$
ENDIF

EXIT IF j >= w

j = j+1

ENDIF 

LOOP

w = 0
j = 0
CountConstr = 0



### PREPROCESSING ELEMENTS+COUNTS

# tady mus� b�t p�v. species, proto�e pak dole to rozhoduje o uveden�-neuveden� pr�zdn�ch hranat�ch z�vorek
CountConstr = TALLY(Species$,CHR$(091))
	# PRINT #2, "countbracket = ",CountBracket
	# PRINT #2, "species = "+Species$
CountA = TALLY(StringEdit$,"A")
CountB = TALLY(StringEdit$,"B")
CountC = TALLY(StringEdit$,"C")
CountD = TALLY(StringEdit$,"D")
CountE = TALLY(StringEdit$,"E")
CountF = TALLY(StringEdit$,"F")
CountG = TALLY(StringEdit$,"G")
CountH = TALLY(StringEdit$,"H")
CountI = TALLY(StringEdit$,"I")
CountJ = TALLY(StringEdit$,"J")
CountK = TALLY(StringEdit$,"K")
CountL = TALLY(StringEdit$,"L")
CountM = TALLY(StringEdit$,"M")
CountN = TALLY(StringEdit$,"N")
CountO = TALLY(StringEdit$,"O")
CountP = TALLY(StringEdit$,"P")
CountQ = TALLY(StringEdit$,"Q")
CountR = TALLY(StringEdit$,"R")
CountS = TALLY(StringEdit$,"S")
CountT = TALLY(StringEdit$,"T")
CountU = TALLY(StringEdit$,"U")
CountV = TALLY(StringEdit$,"V")
CountW = TALLY(StringEdit$,"W")
CountX = TALLY(StringEdit$,"X")
CountY = TALLY(StringEdit$,"Y")
CountZ = TALLY(StringEdit$,"Z")
CountRound = TALLY(Species$,CHR$(040))


#StringEdit$ = Species$ - tohle u� te� ne, proto�e nejd��v zmiz� oblasti v hranat�ch z�vork�ch

IF CountA > 0 THEN

 PosChar% = INSTR(StringEdit$, "A")
 x = CountA
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "A", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0





IF CountB > 0 THEN

 PosChar% = INSTR(StringEdit$, "B")
 x = CountB
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "B", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountC > 0 THEN

 PosChar% = INSTR(StringEdit$, "C")
 x = CountC
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "C", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0
	
IF CountD > 0 THEN

 PosChar% = INSTR(StringEdit$, "D")
 x = CountD
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "D", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0
	
IF CountE > 0 THEN

 PosChar% = INSTR(StringEdit$, "E")
 x = CountE
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "E", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountF > 0 THEN

 PosChar% = INSTR(StringEdit$, "F")
 x = CountF
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "F", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountG > 0 THEN

 PosChar% = INSTR(StringEdit$, "G")
 x = CountG
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "G", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountH > 0 THEN

 PosChar% = INSTR(StringEdit$, "H")
 x = CountH
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "H", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountI > 0 THEN

 PosChar% = INSTR(StringEdit$, "I")
 x = CountI
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "I", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountJ > 0 THEN

 PosChar% = INSTR(StringEdit$, "J")
 x = CountJ
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "J", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountK > 0 THEN

 PosChar% = INSTR(StringEdit$, "K")
 x = CountK
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "K", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountL > 0 THEN

 PosChar% = INSTR(StringEdit$, "L")
 x = CountL
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "L", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountM > 0 THEN

 PosChar% = INSTR(StringEdit$, "M")
 x = CountM
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "M", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountN > 0 THEN

 PosChar% = INSTR(StringEdit$, "N")
 x = CountN
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "N", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountO > 0 THEN

 PosChar% = INSTR(StringEdit$, "O")
 x = CountO
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "O", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountP > 0 THEN

 PosChar% = INSTR(StringEdit$, "P")
 x = CountP
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "P", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountQ > 0 THEN

 PosChar% = INSTR(StringEdit$, "Q")
 x = CountQ
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "Q", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountR > 0 THEN

 PosChar% = INSTR(StringEdit$, "R")
 x = CountR
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "R", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountS > 0 THEN

 PosChar% = INSTR(StringEdit$, "S")
 x = CountS
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "S", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountT > 0 THEN

 PosChar% = INSTR(StringEdit$, "T")
 x = CountT
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "T", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountU > 0 THEN

 PosChar% = INSTR(StringEdit$, "U")
 x = CountU
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "U", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountV > 0 THEN

 PosChar% = INSTR(StringEdit$, "V")
 x = CountV
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "V", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountW > 0 THEN

 PosChar% = INSTR(StringEdit$, "W")
 x = CountW
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "W", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountX > 0 THEN

 PosChar% = INSTR(StringEdit$, "X")
 x = CountX
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "X", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountY > 0 THEN

 PosChar% = INSTR(StringEdit$, "Y")
 x = CountY
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "Y", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0

IF CountZ > 0 THEN

 PosChar% = INSTR(StringEdit$, "Z")
 x = CountZ
 k = 1

DO	
EditLength% = LEN(StringEdit$)
PosChar% = INSTR(StringEdit$, "Z", NewPos%)
LeftPart$ = MID$(StringEdit$, 0, PosChar%-1)
LeftPart% = LEN(LeftPart$)
RightPart$ = MID$(StringEdit$, PosChar%, EditLength%-LeftPart%)

IF LeftPart$ <> "" THEN
StringEdit$ = LeftPart$+";"+RightPart$
NewPos% = PosChar%+2
ELSE
StringEdit$ = RightPart$
NewPos% = PosChar%+1
ENDIF

EXIT IF k > x

k = k+1

ENDIF 

LOOP

x = 0
k = 0






# je�t� nep�id�vat hranat� z�vorky
SegmSpecies$ = StringEdit$




### CHARGES

IF SegmSpecies$ = "+" OR SegmSpecies$ = "-" OR SegmSpecies$ = ""
SignSingularity = 1
ELSE
SignSingularity = 0
ENDIF

IF INSTR(SegmSpecies$, "+") > 0 AND (LEN(SegmSpecies$) = INSTR(SegmSpecies$, "+")) THEN

CountElectrons = -1
SegmSpecies$ = MID$(SegmSpecies$, 1, LEN(SegmSpecies$)-1)

ELSE IF INSTR(SegmSpecies$, "+") > 0 AND (LEN(SegmSpecies$) > INSTR(SegmSpecies$, "+"))

PosSign% = INSTR(SegmSpecies$, "+")
Length% = LEN(SegmSpecies$)
Root$ = MID$(SegmSpecies$, 1, PosSign%-1)
Sign$ = MID$(SegmSpecies$, PosSign%+1, Length%-PosSign%)
Sign = VAL(Sign$)
CountElectrons = (-1)*Sign
SegmSpecies$ = Root$

ELSE IF INSTR(SegmSpecies$, "-") > 0 AND (LEN(SegmSpecies$) = INSTR(SegmSpecies$, "-"))

CountElectrons = 1
SegmSpecies$ = MID$(SegmSpecies$, 1, LEN(SegmSpecies$)-1)



ELSE IF INSTR(SegmSpecies$, "-") > 0 AND (LEN(SegmSpecies$) > INSTR(SegmSpecies$, "-"))

PosSign% = INSTR(SegmSpecies$, "-")
Length% = LEN(SegmSpecies$)
Root$ = MID$(SegmSpecies$, 1, PosSign%-1)
Sign$ = MID$(SegmSpecies$, PosSign%+1, Length%-PosSign%)
Sign = VAL(Sign$)
CountElectrons = Sign
SegmSpecies$ = Root$



ELSE

CountElectrons = 0
SegmSpecies$ = SegmSpecies$

ENDIF


# i s p�idan�mi z�vorkami

IF CountConstr = 0 THEN
### kdy� tam nejsou ��dn� hranat� z�vorky, nic nep�id�vat
SegmSpecies$ = SegmSpecies$
ELSE 
### sqbrackets tady asi ne - v��e a vyn�sobit po�tem
SegmSpecies$ = SegmSpecies$+Brackets$+SqBrackets$

ENDIF

IF CountRound = 0 THEN
### kdy� tam nejsou ��dn� kulat� z�vorky, nic nep�id�vat
SegmSpecies$ = SegmSpecies$
ELSE 
SegmSpecies$ = SegmSpecies$+Cumulative_Corr$
ENDIF



Cum_G = Cum_G - CountElectrons * G_electron

PRINT #10, Description$+"(";StateCmp$;")"; " ; ";

### prav� -> lev� strana rovnice



IF CountElectrons = -1

IF SignSingularity = 0
PRINT #10, FormulaCmp$+"";
ELSE
# tohle nevyzkouseno
PRINT #10, FormulaCmp$+" = ";
ENDIF
PRINT #10, " + e- = ";

ELSE IF CountElectrons < -1 THEN

IF SignSingularity = 0
PRINT #10, FormulaCmp$+"";
ELSE
# tohle nevyzkouseno
PRINT #10, FormulaCmp$+" = ";
ENDIF
PRINT #10, " + ";(-1)*CountElectrons;" e- = ";

ELSE

IF SignSingularity = 0
PRINT #10, FormulaCmp$+" = ";
ELSE
PRINT #10, FormulaCmp$+" = ";
ENDIF

ENDIF




### SPLITTING OF THE FORMULAS

in = 1
WHILE LEN(SegmSpecies$)

  SPLIT SegmSpecies$,";",0,a$,SegmSpecies$

#pravd�podobn� je t�eba p�edefinovat znovu, proto�e SegmSpecies$ se op�t zm�nilo - te� u� obsahuje i z�vorkovou ��st
#IF SegmSpecies$ = "+" OR SegmSpecies$ = "-" OR SegmSpecies$ = ""
#SignSingularity = 1
#ELSE
#SignSingularity = 0
#ENDIF

alpha_test% = MAX(INSTR(a$, "A"), INSTR(a$, "a"), INSTR(a$, "B"), INSTR(a$, "b"), INSTR(a$, "C"), INSTR(a$, "c"), INSTR(a$, "D"), INSTR(a$, "d"), INSTR(a$, "E"), INSTR(a$, "e"), INSTR(a$, "F"), INSTR(a$, "f"), INSTR(a$, "G"), INSTR(a$, "g"), INSTR(a$, "H"), INSTR(a$, "h"), INSTR(a$, "I"), INSTR(a$, "i"), INSTR(a$, "J"), INSTR(a$, "j"), INSTR(a$, "K"), INSTR(a$, "k"), INSTR(a$, "L"), INSTR(a$, "l"), INSTR(a$, "M"), INSTR(a$, "m"), INSTR(a$, "N"), INSTR(a$, "n"), INSTR(a$, "O"), INSTR(a$, "o"), INSTR(a$, "P"), INSTR(a$, "p"), INSTR(a$, "Q"), INSTR(a$, "q"), INSTR(a$, "R"), INSTR(a$, "r"), INSTR(a$, "S"), INSTR(a$, "s"), INSTR(a$, "T"), INSTR(a$, "t"), INSTR(a$, "U"), INSTR(a$, "u"), INSTR(a$, "V"), INSTR(a$, "v"), INSTR(a$, "W"), INSTR(a$, "w"), INSTR(a$, "X"), INSTR(a$, "x"), INSTR(a$, "Y"), INSTR(a$, "y"), INSTR(a$, "Z"), INSTR(a$, "z"), INSTR(a$, CHR$(091)), INSTR(a$, CHR$(093)))
# mus� se napsat i lev� i prav� hranat� z�vorka - aby na�lo spr�vn�
FrgLength% = LEN(a$)



IF (alpha_test% = FrgLength%) THEN
Elmnt$ = a$
ElmntCount = 1

ELSE 
Elmnt$ = MID$(a$, 1, alpha_test%)
ElmntCount$ = MID$(a$, alpha_test%+1, FrgLength%-alpha_test%)
ElmntCount = VAL(ElmntCount$)

ENDIF



### mus� b�t tady p�ed ��dkem, kde se p�id�vaj� pluska,
### jinak bude v�dy jedno plusko p�eb�vat

IF in = 1 OR (in = 2 AND SignSingularity = 1)
PRINT #10, "";
ELSE IF (SignSingularity = 0) THEN
PRINT #10, "+ ";
ELSE
PRINT #10, " + ";

ENDIF

ENDIF


### a� te�

IF ElmntCount > 1 

IF SignSingularity = 0
PRINT #10, ElmntCount;" "+Elmnt$;

IF Elmnt$ <> "" THEN
PRINT #10, "(";
PRINT #10, StateSpc$;
PRINT #10, ") ";
ELSE
PRINT #10, " ";
ENDIF

ELSE IF SignSingularity = 1 THEN
PRINT #10, ElmntCount;" "+Elmnt$;

IF Elmnt$ <> "" THEN
PRINT #10, "(";
PRINT #10, StateSpc$;
PRINT #10, ")";
ENDIF

ENDIF

ELSE IF ElmntCount = 1 THEN

IF SignSingularity = 0
PRINT #10, Elmnt$;

IF Elmnt$ <> "" THEN
PRINT #10, "(";
PRINT #10, StateSpc$;
PRINT #10, ") ";
ELSE
PRINT #10, " ";
ENDIF

ELSE IF SignSingularity = 1 THEN
PRINT #10, Elmnt$;

IF Elmnt$ <> "" THEN
PRINT #10, "(";
PRINT #10, StateSpc$;
PRINT #10, ") ";
ENDIF

ENDIF
ENDIF


M% = 0

OPEN "I", #12, "/data/data/cz.p/files/PHASES/Ref_g.txt"

DO

INPUT #12, Request$
Inp2$(M%) = Request$



LenghtRequest% = LEN(Request$)
Lim101% = INSTR(Request$, " ")
RefFragm$ = LEFT$(Request$, Lim101%-1)
Lim102% = INSTR(Request$, " ", Lim101%+1)
RefH$ = MID$(Request$, Lim101%+1, Lim102%-Lim101%-1)
RefH = VAL(RefH$) * Conversion + H0_corr
RefS$ = MID$(Request$, Lim102%+1, LenghtRequest%-Lim102%)
RefS = VAL(RefS$) * Conversion + S0_corr


IF (Elmnt$ = RefFragm$ OR RefFragm$ = Elmnt$) AND (Elmnt$ <> "" OR RefFragm$ <> "") THEN 

Cum_H = Cum_H - ElmntCount * RefH
Cum_S = Cum_S - ElmntCount * RefS

ENDIF






















M% = M% + 1

EXIT IF (M% = 10000 OR Request$ = "")



LOOP

CLOSE #12






















  INC in
WEND


Elmnt$ = ""

IF CountElectrons = 1

IF SignSingularity = 0
PRINT #10, "+ e- ";
ELSE
PRINT #10, " + e-";
ENDIF

ELSE IF CountElectrons > 1 THEN

IF SignSingularity = 0
PRINT #10, "+ ";CountElectrons;" e- ";
ELSE
PRINT #10, " + ";CountElectrons;" e-";
ENDIF

ENDIF













I% = I% + 1

EXIT IF (I% = 10000 OR LineData$ = "")

Cum_G = (Cum_H * 1000 - Temperature * Cum_S)/1000

#eq_K = EXP(-(Cum_G*1000)/(8.314*Temperature))
#log_K = LOG10(eq_K)
#nahrazeno line�rn�m v�razem
log_K = (-52.237/Temperature) * Cum_G
# vychazelo se z kodu s opacnymi stranami rovnic, proto prenasobit -1
log_K = -log_K
Cum_H = -Cum_H

PRINT #10, " ; ";
PRINT #10, "","log_k",
PRINT #10, log_K USING "######.##"; " ; ";
IF Cum_Probe = 0 THEN
PRINT #10, "","delta_h",
PRINT #10, Cum_H USING "######.##"; " ; ";
ENDIF
IF Cum_Probe = 0 THEN
PRINT #10, CHR$(035), "Hf�("+StateCmp$+") = "; H USING "######.##"; " kJ.mol-1 ("+ReferenceH$+")"; " ; ";
ENDIF
PRINT #10, CHR$(035), "S�("+StateCmp$+") = "; S USING "######.##"; " J.K-1.mol-1 ("+ReferenceS$+")"

Cum_H = 0
Cum_S = 0
Cum_G = 0
log_K = 0
CountElectrons = 0
ElmntCount = 0
ZPE = 0
E = 0
H = 0
G = 0
RefZPE = 0
RefE = 0
RefH = 0
RefG = 0
Cum_Probe = 0
#Elmnt$ = ""


LOOP

EXIT

END
