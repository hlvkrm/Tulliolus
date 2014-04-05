s(Z) :- ((thirdpnp(X), thirdSingV(Y));
	(blanksubjp(X), vp(Y));
	(blankobjp(X), vp(Y));
	(blankobjp(X), blank(Y))), append(X,Y,Z).
	
thirdpnp(Z) :- nomNP(X), accNP(Y), append(X,Y,Z).
blanksubjp(Z) :- blank(X), accNP(Y), append(X,Y,Z).
blankobjp(Z) :- nomNP(X), blank(X), append(X,Y,Z).

nomNP(Z) :- root(X), nomEnd(Y), append(X,Y,Z).
%nomNP(Z) :- nomNP(X), genNP(Y), append(X,Y,Z).
accNP(Z) :- root(X), accEnd(Y), append(X,Y,Z).
%accNP(Z) :- accNP(X), genNP(Y), append(X,Y,Z).
genNP(Z) :- root(X), genEnd(Y), append(X,Y,Z).

vp(Z) :- (firstSingV(X);secSingV(X);thirdSingV(X);firstPluV(X);
		secPluV(X);thirdPluV(X)), blank(Y), append(X,Y,Z).
		
firstSingV(Z) :- stem(X), firstSing(Y), append(X,Y,Z).
secSingV(Z) :- stem(X), secSing(Y), append(X,Y,Z).
thirdSingV(Z) :- stem(X), thirdSing(Y), append(X,Y,Z).
firstPluV(Z) :- stem(X), firstPlu(Y), append(X,Y,Z).
secPluV(Z) :- stem(X), secPlu(Y), append(X,Y,Z).
thirdPluV(Z) :- stem(X), thirdPlu(Y), append(X,Y,Z).

root([domin]).
root([serv]).
root([fili]).

blank([ ]).

nomEnd([us]).
accEnd([um]).
genEnd([i]).


stem([am]).
stem([laud]).
stem([nec]).

firstSing([o]).
secSing([as]).
thirdSing([at]).
firstPlu([amus]).
secPlu([atis]).
thirdPlu([ant]).


