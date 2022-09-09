CLS

DIM Inp$(10001)
DIM Inp2$(10001)

OPEN "I", #1, "/data/data/cz.p/files/arcfile1.txt"
OPEN "I", #2, "/data/data/cz.p/files/mopoutfile.txt"
OPEN "I", #4, "/data/data/cz.p/files/dampfile.txt"
INPUT #4, DampFact$
DampFact = VAL(DampFact$)
CLOSE #4
OPEN "O", #3, "/data/data/cz.p/files/chemsolinput.txt"
CLOSE #3
OPEN "A", #3, "/data/data/cz.p/files/chemsolinput.txt"


I% = 0
J% = 0
DO



INPUT #1, ZmatOrig$
Inp$(I%) = ZmatOrig$
Element$ = MID$(ZmatOrig$, 3, 2)
X$ = MID$(ZmatOrig$, 5, 15)
X = VAL(X$)
Y$ = MID$(ZmatOrig$, 24, 11)
Y = VAL(Y$)
Z$ = MID$(ZmatOrig$, 40, 11)
Z = VAL(Z$)

INPUT #2, ChargeBlock$
Inp2$(J%) = ChargeBlock$
Charge$ = MID$(ChargeBlock$, 20, 16)
Charge = VAL(Charge$)
DampCharge = Charge * DampFact

IF Element$="H " THEN
ProtonNumber=1
ELSE IF Element$="He" THEN
ProtonNumber=2
ELSE IF Element$="Li" THEN
ProtonNumber=3
ELSE IF Element$="Be" THEN
ProtonNumber=4
ELSE IF Element$="B " THEN
ProtonNumber=5
ELSE IF Element$="C " THEN
ProtonNumber=6
ELSE IF Element$="N " THEN
ProtonNumber=7
ELSE IF Element$="O " THEN
ProtonNumber=8
ELSE IF Element$="F " THEN
ProtonNumber=9
ELSE IF Element$="Ne" THEN
ProtonNumber=10
ELSE IF Element$="Na" THEN
ProtonNumber=11
ELSE IF Element$="Mg" THEN
ProtonNumber=12
ELSE IF Element$="Al" THEN
ProtonNumber=13
ELSE IF Element$="Si" THEN
ProtonNumber=14
ELSE IF Element$="P " THEN
ProtonNumber=15
ELSE IF Element$="S " THEN
ProtonNumber=16
ELSE IF Element$="Cl" THEN
ProtonNumber=17
ELSE IF Element$="Ar" THEN
ProtonNumber=18
ELSE IF Element$="K " THEN
ProtonNumber=19
ELSE IF Element$="Ca" THEN
ProtonNumber=20
ELSE IF Element$="Sc" THEN
ProtonNumber=21
ELSE IF Element$="Ti" THEN
ProtonNumber=22
ELSE IF Element$="V " THEN
ProtonNumber=23
ELSE IF Element$="Cr" THEN
ProtonNumber=24
ELSE IF Element$="Mn" THEN
ProtonNumber=25
ELSE IF Element$="Fe" THEN
ProtonNumber=26
ELSE IF Element$="Co" THEN
ProtonNumber=27
ELSE IF Element$="Ni" THEN
ProtonNumber=28
ELSE IF Element$="Cu" THEN
ProtonNumber=29
ELSE IF Element$="Zn" THEN
ProtonNumber=30
ELSE IF Element$="Ga" THEN
ProtonNumber=31
ELSE IF Element$="Ge" THEN
ProtonNumber=32
ELSE IF Element$="As" THEN
ProtonNumber=33
ELSE IF Element$="Se" THEN
ProtonNumber=34
ELSE IF Element$="Br" THEN
ProtonNumber=35
ELSE IF Element$="Kr" THEN
ProtonNumber=36
ELSE IF Element$="Rb" THEN
ProtonNumber=37
ELSE IF Element$="Sr" THEN
ProtonNumber=38
ELSE IF Element$="Y " THEN
ProtonNumber=39
ELSE IF Element$="Zr" THEN
ProtonNumber=40
ELSE IF Element$="Nb" THEN
ProtonNumber=41
ELSE IF Element$="Mo" THEN
ProtonNumber=42
ELSE IF Element$="Tc" THEN
ProtonNumber=43
ELSE IF Element$="Ru" THEN
ProtonNumber=44
ELSE IF Element$="Rh" THEN
ProtonNumber=45
ELSE IF Element$="Pd" THEN
ProtonNumber=46
ELSE IF Element$="Ag" THEN
ProtonNumber=47
ELSE IF Element$="Cd" THEN
ProtonNumber=48
ELSE IF Element$="In" THEN
ProtonNumber=49
ELSE IF Element$="Sn" THEN
ProtonNumber=50
ELSE IF Element$="Sb" THEN
ProtonNumber=51
ELSE IF Element$="Te" THEN
ProtonNumber=52
ELSE IF Element$="I " THEN
ProtonNumber=53
ELSE IF Element$="Xe" THEN
ProtonNumber=54
ELSE IF Element$="Cs" THEN
ProtonNumber=55
ELSE IF Element$="Ba" THEN
ProtonNumber=56
ELSE IF Element$="La" THEN
ProtonNumber=57
ELSE IF Element$="Ce" THEN
ProtonNumber=58
ELSE IF Element$="Pr" THEN
ProtonNumber=59
ELSE IF Element$="Nd" THEN
ProtonNumber=60
ELSE IF Element$="Pm" THEN
ProtonNumber=61
ELSE IF Element$="Sm" THEN
ProtonNumber=62
ELSE IF Element$="Eu" THEN
ProtonNumber=63
ELSE IF Element$="Gd" THEN
ProtonNumber=64
ELSE IF Element$="Tb" THEN
ProtonNumber=65
ELSE IF Element$="Dy" THEN
ProtonNumber=66
ELSE IF Element$="Ho" THEN
ProtonNumber=67
ELSE IF Element$="Er" THEN
ProtonNumber=68
ELSE IF Element$="Tm" THEN
ProtonNumber=69
ELSE IF Element$="Yb" THEN
ProtonNumber=70
ELSE IF Element$="Lu" THEN
ProtonNumber=71
ELSE IF Element$="Hf" THEN
ProtonNumber=72
ELSE IF Element$="Ta" THEN
ProtonNumber=73
ELSE IF Element$="W " THEN
ProtonNumber=74
ELSE IF Element$="Re" THEN
ProtonNumber=75
ELSE IF Element$="Os" THEN
ProtonNumber=76
ELSE IF Element$="Ir" THEN
ProtonNumber=77
ELSE IF Element$="Pt" THEN
ProtonNumber=78
ELSE IF Element$="Au" THEN
ProtonNumber=79
ELSE IF Element$="Hg" THEN
ProtonNumber=80
ELSE IF Element$="Tl" THEN
ProtonNumber=81
ELSE IF Element$="Pb" THEN
ProtonNumber=82
ELSE IF Element$="Bi" THEN
ProtonNumber=83
ELSE IF Element$="Po" THEN
ProtonNumber=84
ELSE IF Element$="At" THEN
ProtonNumber=85
ELSE IF Element$="Rn" THEN
ProtonNumber=86
ELSE IF Element$="Fr" THEN
ProtonNumber=87
ELSE IF Element$="Ra" THEN
ProtonNumber=88
ELSE IF Element$="Ac" THEN
ProtonNumber=89
ELSE IF Element$="Th" THEN
ProtonNumber=90
ELSE IF Element$="Pa" THEN
ProtonNumber=91
ELSE IF Element$="U " THEN
ProtonNumber=92
ELSE IF Element$="Np" THEN
ProtonNumber=93
ELSE IF Element$="Pu" THEN
ProtonNumber=94
ELSE IF Element$="Am" THEN
ProtonNumber=95
ELSE IF Element$="Cm" THEN
ProtonNumber=96
ELSE IF Element$="Bk" THEN
ProtonNumber=97
ELSE IF Element$="Cf" THEN
ProtonNumber=98
ELSE IF Element$="Es" THEN
ProtonNumber=99
ELSE IF Element$="Fm" THEN
ProtonNumber=100
ELSE IF Element$="Md" THEN
ProtonNumber=101
ELSE IF Element$="No" THEN
ProtonNumber=102
ELSE IF Element$="Lr" THEN
ProtonNumber=103
ELSE IF Element$="Rf" THEN
ProtonNumber=104
ENDIF

EXIT IF (I% = 10000 OR ZmatOrig$ = "")

PRINT #3, Element$;" ";ProtonNumber;" ";DampCharge;" ";X$;" ";Y$;" ";Z$

I% = I% + 1
J% = J% + 1

LOOP

CLOSE #1
CLOSE #2
CLOSE #3


END
EXIT