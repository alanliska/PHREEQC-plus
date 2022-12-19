CLS

DIM Dat$(200)
DIM Inp$(101)

Cum_G = 0
Cum_NA = 0

OPEN "I", #10, "/data/data/cz.p/files/iupac.txt"
INPUT #10, Iupac$
CLOSE #10

OPEN "I", #11, "/data/data/cz.p/files/gcm1formula.txt"
INPUT #11, Formula$
CLOSE #11

OPEN "I", #1, "/data/data/cz.p/files/GCM1.dat"





I% = 0

DO

INPUT #1, Item$

Lenght% = LEN(Item$)
Dat$(I%) = Item$
Delim1% = INSTR(Item$, ";")
Symbol$ = MID$(Item$, 1, Delim1%-1)
G$ = MID$(Item$, Delim1%+1, Lenght%-Delim1%)
G = VAL(G$)

J% = 0

OPEN "I", #3, "/data/data/cz.p/files/GCM1-input.txt"

DO

INPUT #3, Request$

Inp$(J%) = Request$
LenghtReq% = LEN(Request$)
Lim% = INSTR(Request$, ";")
Atom$ = LEFT$(Request$, Lim%-1)
Count$ = MID$(Request$, Lim%+1, LenghtReq%)

IF (Symbol$ = Atom$ OR Atom$ = Symbol$) AND (Symbol$ <> "" OR Atom$ <> "") THEN 
Stoich$ = Count$

Cum_G = Cum_G + G * VAL(Stoich$)
Cum_NA = Cum_NA + VAL(Stoich$)

ENDIF

J% = J% + 1
EXIT IF (J% = 100 OR Atom$ = "")
LOOP

CLOSE #3

I% = I% + 1

EXIT IF (I% = 200 OR Symbol$ = "")

LOOP

CLOSE #1

OPEN "A", #2, "/data/data/cz.p/files/GCM1.out"
PRINT #2, Iupac$;" ";Formula$;" ";"GCM-Jankowski";" ";Cum_G
CLOSE #2
EXIT
END
