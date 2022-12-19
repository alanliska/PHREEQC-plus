CLS

DIM Inp$(10001)
DIM Inp2$(10001)

Count_e = 0
Count_H = 0
Count__H = 0
Count_Li = 0
Count_Na = 0
Count_K = 0
Count_Rb = 0
Count_Cs = 0
Count_Fr = 0
Count_Be = 0
Count_Mg = 0
Count_Ca = 0
Count_Sr = 0
Count_Ba = 0
Count_Ra = 0
Count_Sc = 0
Count_Y = 0
Count_La = 0
Count_Ac = 0
Count_Ce = 0
Count_Pr = 0
Count_Nd = 0
Count_Pm = 0
Count_Sm = 0
Count_Eu = 0
Count_Gd = 0
Count_Tb = 0
Count_Dy = 0
Count_Ho = 0
Count_Er = 0
Count_Tm = 0
Count_Yb = 0
Count_Lu = 0
Count_Th = 0
Count_Pa = 0
Count_U = 0
Count_Np = 0
Count_Pu = 0
Count_Am = 0
Count_Cm = 0
Count_Bk = 0
Count_Cf = 0
Count_Es = 0
Count_Fm = 0
Count_Md = 0
Count_No = 0
Count_Lr = 0
Count_Ti = 0
Count_Zr = 0
Count_Hf = 0
Count_Rf = 0
Count_V = 0
Count_Nb = 0
Count_Ta = 0
Count_Db = 0
Count_Cr = 0
Count_Mo = 0
Count_W = 0
Count_Sg = 0
Count_Mn = 0
Count_Tc = 0
Count_Re = 0
Count_Bh = 0
Count_Fe = 0
Count_Ru = 0
Count_Os = 0
Count_Hs = 0
Count_Co = 0
Count_Rh = 0
Count_Ir = 0
Count_Mt = 0
Count_Ni = 0
Count_Pd = 0
Count_Pt = 0
Count_Ds = 0
Count_Cu = 0
Count_Ag = 0
Count_Au = 0
Count_Rg = 0
Count_Zn = 0
Count_Cd = 0
Count_Hg = 0
Count_Cn = 0
Count_B = 0
Count_Al = 0
Count_Ga = 0
Count_In = 0
Count_Tl = 0
Count_Nh = 0
Count_C = 0
Count__C = 0
Count_Si = 0
Count_Ge = 0
Count_Sn = 0
Count_Pb = 0
Count_Fl = 0
Count_N = 0
Count__N = 0
Count_P = 0
Count_As = 0
Count_Sb = 0
Count_Bi = 0
Count_Mc = 0
Count_O = 0
Count__O = 0
Count_S = 0
Count__S = 0
Count_Se = 0
Count_Te = 0
Count_Po = 0
Count_Lv = 0
Count_F = 0
Count__F = 0
Count_Cl = 0
Count_Br = 0
Count_I = 0
Count_At = 0
Count_Ts = 0
Count_He = 0
Count_Ne = 0
Count_Ar = 0
Count_Kr = 0
Count_Xe = 0
Count_Rn = 0
Count_Og = 0

Cum_S = 0
Cum_H = 0
Cum_C = 0
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
OPEN "O", #11, "/data/data/cz.p/files/PHASES/Fastchem_g.dat"
CLOSE #11
OPEN "A", #10, "/data/data/cz.p/files/PHASES/Database_g.dat"
OPEN "A", #11, "/data/data/cz.p/files/PHASES/Fastchem_g.dat"

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
C = VAL(DummyC$) * Conversion
Lim7% = INSTR(LineData$, " ", Lim6%+1)
S$ = MID$(LineData$, Lim6%+1, LenghtData%-Lim6%)
S = VAL(S$) * Conversion + S_corr

Cum_H = Cum_H + H
Cum_S = Cum_S + S
Cum_C = Cum_C + C

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

Count_e = CountElectrons


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
Lim103% = INSTR(Request$, " ", Lim102%+1)
RefH$ = MID$(Request$, Lim101%+1, Lim102%-Lim101%-1)
RefH = VAL(RefH$) * Conversion + H0_corr
RefS$ = MID$(Request$, Lim102%+1, Lim103%-Lim102%-1)
RefS = VAL(RefS$) * Conversion + S0_corr
RefC$ = MID$(Request$, Lim103%+1, LenghtRequest%-Lim103%)
RefC = VAL(RefC$) * Conversion


IF (Elmnt$ = RefFragm$ OR RefFragm$ = Elmnt$) AND (Elmnt$ <> "" OR RefFragm$ <> "") THEN 

Cum_H = Cum_H - ElmntCount * RefH
Cum_S = Cum_S - ElmntCount * RefS
Cum_C = Cum_C - ElmntCount * RefC

# Block for Fastchem

IF Elmnt$ = "H" THEN
Count_H = Count_H + ElmntCount
ELSE IF Elmnt$ = "[H]" THEN
Count__H = Count__H + ElmntCount
ELSE IF Elmnt$ = "Li" THEN
Count_Li = Count_Li + ElmntCount
ELSE IF Elmnt$ = "Na" THEN
Count_Na = Count_Na + ElmntCount
ELSE IF Elmnt$ = "K" THEN
Count_K = Count_K + ElmntCount
ELSE IF Elmnt$ = "Rb" THEN
Count_Rb = Count_Rb + ElmntCount
ELSE IF Elmnt$ = "Cs" THEN
Count_Cs = Count_Cs + ElmntCount
ELSE IF Elmnt$ = "Fr" THEN
Count_Fr = Count_Fr + ElmntCount
ELSE IF Elmnt$ = "Be" THEN
Count_Be = Count_Be + ElmntCount
ELSE IF Elmnt$ = "Mg" THEN
Count_Mg = Count_Mg + ElmntCount
ELSE IF Elmnt$ = "Ca" THEN
Count_Ca = Count_Ca + ElmntCount
ELSE IF Elmnt$ = "Sr" THEN
Count_Sr = Count_Sr + ElmntCount
ELSE IF Elmnt$ = "Ba" THEN
Count_Ba = Count_Ba + ElmntCount
ELSE IF Elmnt$ = "Ra" THEN
Count_Ra = Count_Ra + ElmntCount
ELSE IF Elmnt$ = "Sc" THEN
Count_Sc = Count_Sc + ElmntCount
ELSE IF Elmnt$ = "Y" THEN
Count_Y = Count_Y + ElmntCount
ELSE IF Elmnt$ = "La" THEN
Count_La = Count_La + ElmntCount
ELSE IF Elmnt$ = "Ac" THEN
Count_Ac = Count_Ac + ElmntCount
ELSE IF Elmnt$ = "Ce" THEN
Count_Ce = Count_Ce + ElmntCount
ELSE IF Elmnt$ = "Pr" THEN
Count_Pr = Count_Pr + ElmntCount
ELSE IF Elmnt$ = "Nd" THEN
Count_Nd = Count_Nd + ElmntCount
ELSE IF Elmnt$ = "Pm" THEN
Count_Pm = Count_Pm + ElmntCount
ELSE IF Elmnt$ = "Sm" THEN
Count_Sm = Count_Sm + ElmntCount
ELSE IF Elmnt$ = "Eu" THEN
Count_Eu = Count_Eu + ElmntCount
ELSE IF Elmnt$ = "Gd" THEN
Count_Gd = Count_Gd + ElmntCount
ELSE IF Elmnt$ = "Tb" THEN
Count_Tb = Count_Tb + ElmntCount
ELSE IF Elmnt$ = "Dy" THEN
Count_Dy = Count_Dy + ElmntCount
ELSE IF Elmnt$ = "Ho" THEN
Count_Ho = Count_Ho + ElmntCount
ELSE IF Elmnt$ = "Er" THEN
Count_Er = Count_Er + ElmntCount
ELSE IF Elmnt$ = "Tm" THEN
Count_Tm = Count_Tm + ElmntCount
ELSE IF Elmnt$ = "Yb" THEN
Count_Yb = Count_Yb + ElmntCount
ELSE IF Elmnt$ = "Lu" THEN
Count_Lu = Count_Lu + ElmntCount
ELSE IF Elmnt$ = "Th" THEN
Count_Th = Count_Th + ElmntCount
ELSE IF Elmnt$ = "Pa" THEN
Count_Pa = Count_Pa + ElmntCount
ELSE IF Elmnt$ = "U" THEN
Count_U = Count_U + ElmntCount
ELSE IF Elmnt$ = "Np" THEN
Count_Np = Count_Np + ElmntCount
ELSE IF Elmnt$ = "Pu" THEN
Count_Pu = Count_Pu + ElmntCount
ELSE IF Elmnt$ = "Am" THEN
Count_Am = Count_Am + ElmntCount
ELSE IF Elmnt$ = "Cm" THEN
Count_Cm = Count_Cm + ElmntCount
ELSE IF Elmnt$ = "Bk" THEN
Count_Bk = Count_Bk + ElmntCount
ELSE IF Elmnt$ = "Cf" THEN
Count_Cf = Count_Cf + ElmntCount
ELSE IF Elmnt$ = "Es" THEN
Count_Es = Count_Es + ElmntCount
ELSE IF Elmnt$ = "Fm" THEN
Count_Fm = Count_Fm + ElmntCount
ELSE IF Elmnt$ = "Md" THEN
Count_Md = Count_Md + ElmntCount
ELSE IF Elmnt$ = "No" THEN
Count_No = Count_No + ElmntCount
ELSE IF Elmnt$ = "Lr" THEN
Count_Lr = Count_Lr + ElmntCount
ELSE IF Elmnt$ = "Ti" THEN
Count_Ti = Count_Ti + ElmntCount
ELSE IF Elmnt$ = "Zr" THEN
Count_Zr = Count_Zr + ElmntCount
ELSE IF Elmnt$ = "Hf" THEN
Count_Hf = Count_Hf + ElmntCount
ELSE IF Elmnt$ = "Rf" THEN
Count_Rf = Count_Rf + ElmntCount
ELSE IF Elmnt$ = "V" THEN
Count_V = Count_V + ElmntCount
ELSE IF Elmnt$ = "Nb" THEN
Count_Nb = Count_Nb + ElmntCount
ELSE IF Elmnt$ = "Ta" THEN
Count_Ta = Count_Ta + ElmntCount
ELSE IF Elmnt$ = "Db" THEN
Count_Db = Count_Db + ElmntCount
ELSE IF Elmnt$ = "Cr" THEN
Count_Cr = Count_Cr + ElmntCount
ELSE IF Elmnt$ = "Mo" THEN
Count_Mo = Count_Mo + ElmntCount
ELSE IF Elmnt$ = "W" THEN
Count_W = Count_W + ElmntCount
ELSE IF Elmnt$ = "Sg" THEN
Count_Sg = Count_Sg + ElmntCount
ELSE IF Elmnt$ = "Mn" THEN
Count_Mn = Count_Mn + ElmntCount
ELSE IF Elmnt$ = "Tc" THEN
Count_Tc = Count_Tc + ElmntCount
ELSE IF Elmnt$ = "Re" THEN
Count_Re = Count_Re + ElmntCount
ELSE IF Elmnt$ = "Bh" THEN
Count_Bh = Count_Bh + ElmntCount
ELSE IF Elmnt$ = "Fe" THEN
Count_Fe = Count_Fe + ElmntCount
ELSE IF Elmnt$ = "Ru" THEN
Count_Ru = Count_Ru + ElmntCount
ELSE IF Elmnt$ = "Os" THEN
Count_Os = Count_Os + ElmntCount
ELSE IF Elmnt$ = "Hs" THEN
Count_Hs = Count_Hs + ElmntCount
ELSE IF Elmnt$ = "Co" THEN
Count_Co = Count_Co + ElmntCount
ELSE IF Elmnt$ = "Rh" THEN
Count_Rh = Count_Rh + ElmntCount
ELSE IF Elmnt$ = "Ir" THEN
Count_Ir = Count_Ir + ElmntCount
ELSE IF Elmnt$ = "Mt" THEN
Count_Mt = Count_Mt + ElmntCount
ELSE IF Elmnt$ = "Ni" THEN
Count_Ni = Count_Ni + ElmntCount
ELSE IF Elmnt$ = "Pd" THEN
Count_Pd = Count_Pd + ElmntCount
ELSE IF Elmnt$ = "Pt" THEN
Count_Pt = Count_Pt + ElmntCount
ELSE IF Elmnt$ = "Ds" THEN
Count_Ds = Count_Ds + ElmntCount
ELSE IF Elmnt$ = "Cu" THEN
Count_Cu = Count_Cu + ElmntCount
ELSE IF Elmnt$ = "Ag" THEN
Count_Ag = Count_Ag + ElmntCount
ELSE IF Elmnt$ = "Au" THEN
Count_Au = Count_Au + ElmntCount
ELSE IF Elmnt$ = "Rg" THEN
Count_Rg = Count_Rg + ElmntCount
ELSE IF Elmnt$ = "Zn" THEN
Count_Zn = Count_Zn + ElmntCount
ELSE IF Elmnt$ = "Cd" THEN
Count_Cd = Count_Cd + ElmntCount
ELSE IF Elmnt$ = "Hg" THEN
Count_Hg = Count_Hg + ElmntCount
ELSE IF Elmnt$ = "Cn" THEN
Count_Cn = Count_Cn + ElmntCount
ELSE IF Elmnt$ = "B" THEN
Count_B = Count_B + ElmntCount
ELSE IF Elmnt$ = "Al" THEN
Count_Al = Count_Al + ElmntCount
ELSE IF Elmnt$ = "Ga" THEN
Count_Ga = Count_Ga + ElmntCount
ELSE IF Elmnt$ = "In" THEN
Count_In = Count_In + ElmntCount
ELSE IF Elmnt$ = "Tl" THEN
Count_Tl = Count_Tl + ElmntCount
ELSE IF Elmnt$ = "Nh" THEN
Count_Nh = Count_Nh + ElmntCount
ELSE IF Elmnt$ = "C" THEN
Count_C = Count_C + ElmntCount
ELSE IF Elmnt$ = "[C]" THEN
Count__C = Count__C + ElmntCount
ELSE IF Elmnt$ = "Si" THEN
Count_Si = Count_Si + ElmntCount
ELSE IF Elmnt$ = "Ge" THEN
Count_Ge = Count_Ge + ElmntCount
ELSE IF Elmnt$ = "Sn" THEN
Count_Sn = Count_Sn + ElmntCount
ELSE IF Elmnt$ = "Pb" THEN
Count_Pb = Count_Pb + ElmntCount
ELSE IF Elmnt$ = "Fl" THEN
Count_Fl = Count_Fl + ElmntCount
ELSE IF Elmnt$ = "N" THEN
Count_N = Count_N + ElmntCount
ELSE IF Elmnt$ = "[N]" THEN
Count__N = Count__N + ElmntCount
ELSE IF Elmnt$ = "P" THEN
Count_P = Count_P + ElmntCount
ELSE IF Elmnt$ = "As" THEN
Count_As = Count_As + ElmntCount
ELSE IF Elmnt$ = "Sb" THEN
Count_Sb = Count_Sb + ElmntCount
ELSE IF Elmnt$ = "Bi" THEN
Count_Bi = Count_Bi + ElmntCount
ELSE IF Elmnt$ = "Mc" THEN
Count_Mc = Count_Mc + ElmntCount
ELSE IF Elmnt$ = "O" THEN
Count_O = Count_O + ElmntCount
ELSE IF Elmnt$ = "[O]" THEN
Count__O = Count__O + ElmntCount
ELSE IF Elmnt$ = "S" THEN
Count_S = Count_S + ElmntCount
ELSE IF Elmnt$ = "[S]" THEN
Count__S = Count__S + ElmntCount
ELSE IF Elmnt$ = "Se" THEN
Count_Se = Count_Se + ElmntCount
ELSE IF Elmnt$ = "Te" THEN
Count_Te = Count_Te + ElmntCount
ELSE IF Elmnt$ = "Po" THEN
Count_Po = Count_Po + ElmntCount
ELSE IF Elmnt$ = "Lv" THEN
Count_Lv = Count_Lv + ElmntCount
ELSE IF Elmnt$ = "F" THEN
Count_F = Count_F + ElmntCount
ELSE IF Elmnt$ = "[F]" THEN
Count__F = Count__F + ElmntCount
ELSE IF Elmnt$ = "Cl" THEN
Count_Cl = Count_Cl + ElmntCount
ELSE IF Elmnt$ = "Br" THEN
Count_Br = Count_Br + ElmntCount
ELSE IF Elmnt$ = "I" THEN
Count_I = Count_I + ElmntCount
ELSE IF Elmnt$ = "At" THEN
Count_At = Count_At + ElmntCount
ELSE IF Elmnt$ = "Ts" THEN
Count_Ts = Count_Ts + ElmntCount
ELSE IF Elmnt$ = "He" THEN
Count_He = Count_He + ElmntCount
ELSE IF Elmnt$ = "Ne" THEN
Count_Ne = Count_Ne + ElmntCount
ELSE IF Elmnt$ = "Ar" THEN
Count_Ar = Count_Ar + ElmntCount
ELSE IF Elmnt$ = "Kr" THEN
Count_Kr = Count_Kr + ElmntCount
ELSE IF Elmnt$ = "Xe" THEN
Count_Xe = Count_Xe + ElmntCount
ELSE IF Elmnt$ = "Rn" THEN
Count_Rn = Count_Rn + ElmntCount
ELSE IF Elmnt$ = "Og" THEN
Count_Og = Count_Og + ElmntCount
ENDIF




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

# Fastchem:
Cum_H = -Cum_H
log_K = (-52.237/Temperature) * Cum_G

a1 = (0.43429 / 8.314) * (Cum_C * Temperature - Cum_H)
a2 = 0
a3 = log_K + (0.43429 / 8.314 ) * ((Cum_H / Temperature) - 2*Cum_C)
a4 = 0.43429 * Cum_C / (8.314 * Temperature)
a5 = 0

PRINT #11, Species$;
PRINT #11, " ";
PRINT #11, Description$;
PRINT #11, " ";
PRINT #11, ":";
IF Count_e > 0 THEN
PRINT #11, " ";
PRINT #11, "e-";
PRINT #11, " ";
PRINT #11, Count_e;
ENDIF
IF Count_H > 0 THEN
PRINT #11, " ";
PRINT #11, "H";
PRINT #11, " ";
PRINT #11, Count_H;
ENDIF
IF Count__H > 0 THEN
PRINT #11, " ";
PRINT #11, "H";
PRINT #11, " ";
PRINT #11, Count__H;
ENDIF
IF Count_Li > 0 THEN
PRINT #11, " ";
PRINT #11, "Li";
PRINT #11, " ";
PRINT #11, Count_"Li";
ENDIF
IF Count_Na > 0 THEN
PRINT #11, " ";
PRINT #11, "Na";
PRINT #11, " ";
PRINT #11, Count_Na;
ENDIF
IF Count_K > 0 THEN
PRINT #11, " ";
PRINT #11, "K";
PRINT #11, " ";
PRINT #11, Count_K;
ENDIF
IF Count_Rb > 0 THEN
PRINT #11, " ";
PRINT #11, "Rb";
PRINT #11, " ";
PRINT #11, Count_Rb;
ENDIF
IF Count_Cs > 0 THEN
PRINT #11, " ";
PRINT #11, "Cs";
PRINT #11, " ";
PRINT #11, Count_Cs;
ENDIF
IF Count_Fr > 0 THEN
PRINT #11, " ";
PRINT #11, "Fr";
PRINT #11, " ";
PRINT #11, Count_Fr;
ENDIF
IF Count_Be > 0 THEN
PRINT #11, " ";
PRINT #11, "Be";
PRINT #11, " ";
PRINT #11, Count_Be;
ENDIF
IF Count_Mg > 0 THEN
PRINT #11, " ";
PRINT #11, "Mg";
PRINT #11, " ";
PRINT #11, Count_Mg;
ENDIF
IF Count_Ca > 0 THEN
PRINT #11, " ";
PRINT #11, "Ca";
PRINT #11, " ";
PRINT #11, Count_Ca;
ENDIF
IF Count_Sr > 0 THEN
PRINT #11, " ";
PRINT #11, "Sr";
PRINT #11, " ";
PRINT #11, Count_Sr;
ENDIF
IF Count_Ba > 0 THEN
PRINT #11, " ";
PRINT #11, "Ba";
PRINT #11, " ";
PRINT #11, Count_Ba;
ENDIF
IF Count_Ra > 0 THEN
PRINT #11, " ";
PRINT #11, "Ra";
PRINT #11, " ";
PRINT #11, Count_Ra;
ENDIF
IF Count_Sc > 0 THEN
PRINT #11, " ";
PRINT #11, "Sc";
PRINT #11, " ";
PRINT #11, Count_Sc;
ENDIF
IF Count_Y > 0 THEN
PRINT #11, " ";
PRINT #11, "Y";
PRINT #11, " ";
PRINT #11, Count_Y;
ENDIF
IF Count_La > 0 THEN
PRINT #11, " ";
PRINT #11, "La";
PRINT #11, " ";
PRINT #11, Count_La;
ENDIF
IF Count_Ac > 0 THEN
PRINT #11, " ";
PRINT #11, "Ac";
PRINT #11, " ";
PRINT #11, Count_Ac;
ENDIF
IF Count_Ce > 0 THEN
PRINT #11, " ";
PRINT #11, "Ce";
PRINT #11, " ";
PRINT #11, Count_Ce;
ENDIF
IF Count_Nd > 0 THEN
PRINT #11, " ";
PRINT #11, "Nd";
PRINT #11, " ";
PRINT #11, Count_Nd;
ENDIF
IF Count_Pm > 0 THEN
PRINT #11, " ";
PRINT #11, "Pm";
PRINT #11, " ";
PRINT #11, Count_Pm;
ENDIF
IF Count_Sm > 0 THEN
PRINT #11, " ";
PRINT #11, "Sm";
PRINT #11, " ";
PRINT #11, Count_Sm;
ENDIF
IF Count_Eu > 0 THEN
PRINT #11, " ";
PRINT #11, "Eu";
PRINT #11, " ";
PRINT #11, Count_Eu;
ENDIF
IF Count_Gd > 0 THEN
PRINT #11, " ";
PRINT #11, "Gd";
PRINT #11, " ";
PRINT #11, Count_Gd;
ENDIF
IF Count_Tb > 0 THEN
PRINT #11, " ";
PRINT #11, "Tb";
PRINT #11, " ";
PRINT #11, Count_Tb;
ENDIF
IF Count_Dy > 0 THEN
PRINT #11, " ";
PRINT #11, "Dy";
PRINT #11, " ";
PRINT #11, Count_Dy;
ENDIF
IF Count_Ho > 0 THEN
PRINT #11, " ";
PRINT #11, "Ho";
PRINT #11, " ";
PRINT #11, Count_Ho;
ENDIF
IF Count_Er > 0 THEN
PRINT #11, " ";
PRINT #11, "Er";
PRINT #11, " ";
PRINT #11, Count_Er;
ENDIF
IF Count_Tm > 0 THEN
PRINT #11, " ";
PRINT #11, "Tm";
PRINT #11, " ";
PRINT #11, Count_Tm;
ENDIF
IF Count_Yb > 0 THEN
PRINT #11, " ";
PRINT #11, "Yb";
PRINT #11, " ";
PRINT #11, Count_Yb;
ENDIF
IF Count_Lu > 0 THEN
PRINT #11, " ";
PRINT #11, "Lu";
PRINT #11, " ";
PRINT #11, Count_Lu;
ENDIF
IF Count_Th > 0 THEN
PRINT #11, " ";
PRINT #11, "Th";
PRINT #11, " ";
PRINT #11, Count_Th;
ENDIF
IF Count_Pa > 0 THEN
PRINT #11, " ";
PRINT #11, "Pa";
PRINT #11, " ";
PRINT #11, Count_Pa;
ENDIF
IF Count_U > 0 THEN
PRINT #11, " ";
PRINT #11, "U";
PRINT #11, " ";
PRINT #11, Count_U;
ENDIF
IF Count_Np > 0 THEN
PRINT #11, " ";
PRINT #11, "Np";
PRINT #11, " ";
PRINT #11, Count_Np;
ENDIF
IF Count_Pu > 0 THEN
PRINT #11, " ";
PRINT #11, "Pu";
PRINT #11, " ";
PRINT #11, Count_Pu;
ENDIF
IF Count_Am > 0 THEN
PRINT #11, " ";
PRINT #11, "Am";
PRINT #11, " ";
PRINT #11, Count_Am;
ENDIF
IF Count_Cm > 0 THEN
PRINT #11, " ";
PRINT #11, "Cm";
PRINT #11, " ";
PRINT #11, Count_Cm;
ENDIF
IF Count_Bk > 0 THEN
PRINT #11, " ";
PRINT #11, "Bk";
PRINT #11, " ";
PRINT #11, Count_Bk;
ENDIF
IF Count_Cf > 0 THEN
PRINT #11, " ";
PRINT #11, "Cf";
PRINT #11, " ";
PRINT #11, Count_Cf;
ENDIF
IF Count_Es > 0 THEN
PRINT #11, " ";
PRINT #11, "Es";
PRINT #11, " ";
PRINT #11, Count_Es;
ENDIF
IF Count_Fm > 0 THEN
PRINT #11, " ";
PRINT #11, "Fm";
PRINT #11, " ";
PRINT #11, Count_Fm;
ENDIF
IF Count_Md > 0 THEN
PRINT #11, " ";
PRINT #11, "Md";
PRINT #11, " ";
PRINT #11, Count_Md;
ENDIF
IF Count_No > 0 THEN
PRINT #11, " ";
PRINT #11, "No";
PRINT #11, " ";
PRINT #11, Count_No;
ENDIF
IF Count_Lr > 0 THEN
PRINT #11, " ";
PRINT #11, "Lr";
PRINT #11, " ";
PRINT #11, Count_Lr;
ENDIF
IF Count_Ti > 0 THEN
PRINT #11, " ";
PRINT #11, "Ti";
PRINT #11, " ";
PRINT #11, Count_Ti;
ENDIF
IF Count_Zr > 0 THEN
PRINT #11, " ";
PRINT #11, "Zr";
PRINT #11, " ";
PRINT #11, Count_Zr;
ENDIF
IF Count_Hf > 0 THEN
PRINT #11, " ";
PRINT #11, "Hf";
PRINT #11, " ";
PRINT #11, Count_Hf;
ENDIF
IF Count_Rf > 0 THEN
PRINT #11, " ";
PRINT #11, "Rf";
PRINT #11, " ";
PRINT #11, Count_Rf;
ENDIF
IF Count_V > 0 THEN
PRINT #11, " ";
PRINT #11, "V";
PRINT #11, " ";
PRINT #11, Count_V;
ENDIF
IF Count_Nb > 0 THEN
PRINT #11, " ";
PRINT #11, "Nb";
PRINT #11, " ";
PRINT #11, Count_Nb;
ENDIF
IF Count_Ta > 0 THEN
PRINT #11, " ";
PRINT #11, "Ta";
PRINT #11, " ";
PRINT #11, Count_Ta;
ENDIF
IF Count_Db > 0 THEN
PRINT #11, " ";
PRINT #11, "Db";
PRINT #11, " ";
PRINT #11, Count_Db;
ENDIF
IF Count_Cr > 0 THEN
PRINT #11, " ";
PRINT #11, "Cr";
PRINT #11, " ";
PRINT #11, Count_Cr;
ENDIF
IF Count_Mo > 0 THEN
PRINT #11, " ";
PRINT #11, "Mo";
PRINT #11, " ";
PRINT #11, Count_Mo;
ENDIF
IF Count_W > 0 THEN
PRINT #11, " ";
PRINT #11, "W";
PRINT #11, " ";
PRINT #11, Count_W;
ENDIF
IF Count_Sg > 0 THEN
PRINT #11, " ";
PRINT #11, "Sg";
PRINT #11, " ";
PRINT #11, Count_Sg;
ENDIF
IF Count_Mn > 0 THEN
PRINT #11, " ";
PRINT #11, "Mn";
PRINT #11, " ";
PRINT #11, Count_Mn;
ENDIF
IF Count_Tc > 0 THEN
PRINT #11, " ";
PRINT #11, "Tc";
PRINT #11, " ";
PRINT #11, Count_Tc;
ENDIF
IF Count_Re > 0 THEN
PRINT #11, " ";
PRINT #11, "Re";
PRINT #11, " ";
PRINT #11, Count_Re;
ENDIF
IF Count_Bh > 0 THEN
PRINT #11, " ";
PRINT #11, "Bh";
PRINT #11, " ";
PRINT #11, Count_Bh;
ENDIF
IF Count_Fe > 0 THEN
PRINT #11, " ";
PRINT #11, "Fe";
PRINT #11, " ";
PRINT #11, Count_Fe;
ENDIF
IF Count_Ru > 0 THEN
PRINT #11, " ";
PRINT #11, "Ru";
PRINT #11, " ";
PRINT #11, Count_Ru;
ENDIF
IF Count_Os > 0 THEN
PRINT #11, " ";
PRINT #11, "Os";
PRINT #11, " ";
PRINT #11, Count_Os;
ENDIF
IF Count_Hs > 0 THEN
PRINT #11, " ";
PRINT #11, "Hs";
PRINT #11, " ";
PRINT #11, Count_Hs;
ENDIF
IF Count_Co > 0 THEN
PRINT #11, " ";
PRINT #11, "Co";
PRINT #11, " ";
PRINT #11, Count_Co;
ENDIF
IF Count_Rh > 0 THEN
PRINT #11, " ";
PRINT #11, "Rh";
PRINT #11, " ";
PRINT #11, Count_Rh;
ENDIF
IF Count_Ir > 0 THEN
PRINT #11, " ";
PRINT #11, "Ir";
PRINT #11, " ";
PRINT #11, Count_Ir;
ENDIF
IF Count_Mt > 0 THEN
PRINT #11, " ";
PRINT #11, "Mt";
PRINT #11, " ";
PRINT #11, Count_Mt;
ENDIF
IF Count_Ni > 0 THEN
PRINT #11, " ";
PRINT #11, "Ni";
PRINT #11, " ";
PRINT #11, Count_Ni;
ENDIF
IF Count_Pd > 0 THEN
PRINT #11, " ";
PRINT #11, "Pd";
PRINT #11, " ";
PRINT #11, Count_Pd;
ENDIF
IF Count_Pt > 0 THEN
PRINT #11, " ";
PRINT #11, "Pt";
PRINT #11, " ";
PRINT #11, Count_Pt;
ENDIF
IF Count_Ds > 0 THEN
PRINT #11, " ";
PRINT #11, "Ds";
PRINT #11, " ";
PRINT #11, Count_Ds;
ENDIF
IF Count_Cu > 0 THEN
PRINT #11, " ";
PRINT #11, "Cu";
PRINT #11, " ";
PRINT #11, Count_Cu;
ENDIF
IF Count_Ag > 0 THEN
PRINT #11, " ";
PRINT #11, "Ag";
PRINT #11, " ";
PRINT #11, Count_Ag;
ENDIF
IF Count_Au > 0 THEN
PRINT #11, " ";
PRINT #11, "Au";
PRINT #11, " ";
PRINT #11, Count_Au;
ENDIF
IF Count_Rg > 0 THEN
PRINT #11, " ";
PRINT #11, "Rg";
PRINT #11, " ";
PRINT #11, Count_Rg;
ENDIF
IF Count_Zn > 0 THEN
PRINT #11, " ";
PRINT #11, "Zn";
PRINT #11, " ";
PRINT #11, Count_Zn;
ENDIF
IF Count_Cd > 0 THEN
PRINT #11, " ";
PRINT #11, "Cd";
PRINT #11, " ";
PRINT #11, Count_Cd;
ENDIF
IF Count_Hg > 0 THEN
PRINT #11, " ";
PRINT #11, "Hg";
PRINT #11, " ";
PRINT #11, Count_Hg;
ENDIF
IF Count_Cn > 0 THEN
PRINT #11, " ";
PRINT #11, "Cn";
PRINT #11, " ";
PRINT #11, Count_Cn;
ENDIF
IF Count_B > 0 THEN
PRINT #11, " ";
PRINT #11, "B";
PRINT #11, " ";
PRINT #11, Count_B;
ENDIF
IF Count_Al > 0 THEN
PRINT #11, " ";
PRINT #11, "Al";
PRINT #11, " ";
PRINT #11, Count_Al;
ENDIF
IF Count_Ga > 0 THEN
PRINT #11, " ";
PRINT #11, "Ga";
PRINT #11, " ";
PRINT #11, Count_Ga;
ENDIF
IF Count_In > 0 THEN
PRINT #11, " ";
PRINT #11, "In";
PRINT #11, " ";
PRINT #11, Count_In;
ENDIF
IF Count_Tl > 0 THEN
PRINT #11, " ";
PRINT #11, "Tl";
PRINT #11, " ";
PRINT #11, Count_Tl;
ENDIF
IF Count_Nh > 0 THEN
PRINT #11, " ";
PRINT #11, "Nh";
PRINT #11, " ";
PRINT #11, Count_Nh;
ENDIF
IF Count_C > 0 THEN
PRINT #11, " ";
PRINT #11, "C";
PRINT #11, " ";
PRINT #11, Count_C;
ENDIF
IF Count__C > 0 THEN
PRINT #11, " ";
PRINT #11, "C";
PRINT #11, " ";
PRINT #11, Count__C;
ENDIF
IF Count_Si > 0 THEN
PRINT #11, " ";
PRINT #11, "Si";
PRINT #11, " ";
PRINT #11, Count_Si;
ENDIF
IF Count_Ge > 0 THEN
PRINT #11, " ";
PRINT #11, "Ge";
PRINT #11, " ";
PRINT #11, Count_Ge;
ENDIF
IF Count_Sn > 0 THEN
PRINT #11, " ";
PRINT #11, "Sn";
PRINT #11, " ";
PRINT #11, Count_Sn;
ENDIF
IF Count_Pb > 0 THEN
PRINT #11, " ";
PRINT #11, "Pb";
PRINT #11, " ";
PRINT #11, Count_Pb;
ENDIF
IF Count_Fl > 0 THEN
PRINT #11, " ";
PRINT #11, "Fl";
PRINT #11, " ";
PRINT #11, Count_Fl;
ENDIF
IF Count_N > 0 THEN
PRINT #11, " ";
PRINT #11, "N";
PRINT #11, " ";
PRINT #11, Count_N;
ENDIF
IF Count__N > 0 THEN
PRINT #11, " ";
PRINT #11, "N";
PRINT #11, " ";
PRINT #11, Count__N;
ENDIF
IF Count_P > 0 THEN
PRINT #11, " ";
PRINT #11, "P";
PRINT #11, " ";
PRINT #11, Count_P;
ENDIF
IF Count_As > 0 THEN
PRINT #11, " ";
PRINT #11, "As";
PRINT #11, " ";
PRINT #11, Count_As;
ENDIF
IF Count_Sb > 0 THEN
PRINT #11, " ";
PRINT #11, "Sb";
PRINT #11, " ";
PRINT #11, Count_Sb;
ENDIF
IF Count_Bi > 0 THEN
PRINT #11, " ";
PRINT #11, "Bi";
PRINT #11, " ";
PRINT #11, Count_Bi;
ENDIF
IF Count_Mc > 0 THEN
PRINT #11, " ";
PRINT #11, "Mc";
PRINT #11, " ";
PRINT #11, Count_Mc;
ENDIF
IF Count_O > 0 THEN
PRINT #11, " ";
PRINT #11, "O";
PRINT #11, " ";
PRINT #11, Count_O;
ENDIF
IF Count__O > 0 THEN
PRINT #11, " ";
PRINT #11, "O";
PRINT #11, " ";
PRINT #11, Count__O;
ENDIF
IF Count_S > 0 THEN
PRINT #11, " ";
PRINT #11, "S";
PRINT #11, " ";
PRINT #11, Count_S;
ENDIF
IF Count__S > 0 THEN
PRINT #11, " ";
PRINT #11, "S";
PRINT #11, " ";
PRINT #11, Count__S;
ENDIF
IF Count_Se > 0 THEN
PRINT #11, " ";
PRINT #11, "Se";
PRINT #11, " ";
PRINT #11, Count_Se;
ENDIF
IF Count_Te > 0 THEN
PRINT #11, " ";
PRINT #11, "Te";
PRINT #11, " ";
PRINT #11, Count_Te;
ENDIF
IF Count_Po > 0 THEN
PRINT #11, " ";
PRINT #11, "Po";
PRINT #11, " ";
PRINT #11, Count_Po;
ENDIF
IF Count_Lv > 0 THEN
PRINT #11, " ";
PRINT #11, "Lv";
PRINT #11, " ";
PRINT #11, Count_Lv;
ENDIF
IF Count_F > 0 THEN
PRINT #11, " ";
PRINT #11, "F";
PRINT #11, " ";
PRINT #11, Count_F;
ENDIF
IF Count__F > 0 THEN
PRINT #11, " ";
PRINT #11, "F";
PRINT #11, " ";
PRINT #11, Count__F;
ENDIF
IF Count_Cl > 0 THEN
PRINT #11, " ";
PRINT #11, "Cl";
PRINT #11, " ";
PRINT #11, Count_Cl;
ENDIF
IF Count_Br > 0 THEN
PRINT #11, " ";
PRINT #11, "Br";
PRINT #11, " ";
PRINT #11, Count_Br;
ENDIF
IF Count_I > 0 THEN
PRINT #11, " ";
PRINT #11, "I";
PRINT #11, " ";
PRINT #11, Count_I;
ENDIF
IF Count_At > 0 THEN
PRINT #11, " ";
PRINT #11, "At";
PRINT #11, " ";
PRINT #11, Count_At;
ENDIF
IF Count_Ts > 0 THEN
PRINT #11, " ";
PRINT #11, "Ts";
PRINT #11, " ";
PRINT #11, Count_Ts;
ENDIF
IF Count_He > 0 THEN
PRINT #11, " ";
PRINT #11, "He";
PRINT #11, " ";
PRINT #11, Count_He;
ENDIF
IF Count_Ne > 0 THEN
PRINT #11, " ";
PRINT #11, "Ne";
PRINT #11, " ";
PRINT #11, Count_Ne;
ENDIF
IF Count_Ar > 0 THEN
PRINT #11, " ";
PRINT #11, "Ar";
PRINT #11, " ";
PRINT #11, Count_Ar;
ENDIF
IF Count_Kr > 0 THEN
PRINT #11, " ";
PRINT #11, "Kr";
PRINT #11, " ";
PRINT #11, Count_Kr;
ENDIF
IF Count_Xe > 0 THEN
PRINT #11, " ";
PRINT #11, "Xe";
PRINT #11, " ";
PRINT #11, Count_Xe;
ENDIF
IF Count_Rn > 0 THEN
PRINT #11, " ";
PRINT #11, "Rn";
PRINT #11, " ";
PRINT #11, Count_Rn;
ENDIF
IF Count_Og > 0 THEN
PRINT #11, " ";
PRINT #11, "Og";
PRINT #11, " ";
PRINT #11, Count_Og;
ENDIF
PRINT #11, " ";
PRINT #11, "# Source: NBS tables, other values are theoretical, i.e. Cp = 5/2 R"

#special format: logK = a1/T + a2 ln T + a3 + a4 T + a5 T^2 for FastChem
PRINT #11, "  ";
PRINT #11, a1 USING "+#.################^^^^";
PRINT #11, "  ";
PRINT #11, a2 USING "+#.################^^^^";
PRINT #11, "  ";
PRINT #11, a3 USING "+#.################^^^^";
PRINT #11, "  ";
PRINT #11, a4 USING "+#.################^^^^";
PRINT #11, "  ";
PRINT #11, a5 USING "+#.################^^^^";
PRINT #11, " "
PRINT #11, " "

Cum_H = 0
Cum_S = 0
Cum_C = 0
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
Count_e = 0
Count_H = 0
Count__H = 0
Count_Li = 0
Count_Na = 0
Count_K = 0
Count_Rb = 0
Count_Cs = 0
Count_Fr = 0
Count_Be = 0
Count_Mg = 0
Count_Ca = 0
Count_Sr = 0
Count_Ba = 0
Count_Ra = 0
Count_Sc = 0
Count_Y = 0
Count_La = 0
Count_Ac = 0
Count_Ce = 0
Count_Pr = 0
Count_Nd = 0
Count_Pm = 0
Count_Sm = 0
Count_Eu = 0
Count_Gd = 0
Count_Tb = 0
Count_Dy = 0
Count_Ho = 0
Count_Er = 0
Count_Tm = 0
Count_Yb = 0
Count_Lu = 0
Count_Th = 0
Count_Pa = 0
Count_U = 0
Count_Np = 0
Count_Pu = 0
Count_Am = 0
Count_Cm = 0
Count_Bk = 0
Count_Cf = 0
Count_Es = 0
Count_Fm = 0
Count_Md = 0
Count_No = 0
Count_Lr = 0
Count_Ti = 0
Count_Zr = 0
Count_Hf = 0
Count_Rf = 0
Count_V = 0
Count_Nb = 0
Count_Ta = 0
Count_Db = 0
Count_Cr = 0
Count_Mo = 0
Count_W = 0
Count_Sg = 0
Count_Mn = 0
Count_Tc = 0
Count_Re = 0
Count_Bh = 0
Count_Fe = 0
Count_Ru = 0
Count_Os = 0
Count_Hs = 0
Count_Co = 0
Count_Rh = 0
Count_Ir = 0
Count_Mt = 0
Count_Ni = 0
Count_Pd = 0
Count_Pt = 0
Count_Ds = 0
Count_Cu = 0
Count_Ag = 0
Count_Au = 0
Count_Rg = 0
Count_Zn = 0
Count_Cd = 0
Count_Hg = 0
Count_Cn = 0
Count_B = 0
Count_Al = 0
Count_Ga = 0
Count_In = 0
Count_Tl = 0
Count_Nh = 0
Count_C = 0
Count__C = 0
Count_Si = 0
Count_Ge = 0
Count_Sn = 0
Count_Pb = 0
Count_Fl = 0
Count_N = 0
Count__N = 0
Count_P = 0
Count_As = 0
Count_Sb = 0
Count_Bi = 0
Count_Mc = 0
Count_O = 0
Count__O = 0
Count_S = 0
Count__S = 0
Count_Se = 0
Count_Te = 0
Count_Po = 0
Count_Lv = 0
Count_F = 0
Count__F = 0
Count_Cl = 0
Count_Br = 0
Count_I = 0
Count_At = 0
Count_Ts = 0
Count_He = 0
Count_Ne = 0
Count_Ar = 0
Count_Kr = 0
Count_Xe = 0
Count_Rn = 0
Count_Og = 0
#Elmnt$ = ""


LOOP

EXIT

END
