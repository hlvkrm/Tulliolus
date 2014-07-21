
verb(C) :- firstSingVerb(C);
			secondSingVerb(C);
			thirdSingVerb(C);
			firstPlurVerb(C);
			secondPlurVerb(C);
			thirdPlurVerb(C).

firstSingVerb(C):- nomFirstSingNounPhrase(A), accNounPhrase(B), append(A,B,C).
secondSingVerb(C):- nomSecondSingNounPhrase(A), accNounPhrase(B), append(A,B,C).
thirdSingVerb(C):- nomThirdSingNounPhrase(A),  accNounPhrase(B), append(A,B,C).
firstPlurVerb(C):- nomFirstPlurNounPhrase(A),  accNounPhrase(B), append(A,B,C).
secondPlurVerb(C):- nomSecondPlurNounPhrase(A),  accNounPhrase(B), append(A,B,C).
thirdPlurVerb(C):- nomThirdPlurNounPhrase(A),  accNounPhrase(B), append(A,B,C).

nomNounPhrase(C):- (nomSingNounPhrase(A); nomPlurNounPhrase(A)), modifier(B), append(A,B,C).
%%nomPronouns%%%%%%%%%%%%%%%%%
nomFirstSingPronoun([nomFirstSingPronoun]).
nomSecondSingPronoun([nomSecondSingPronoun]).

nomFirstSingPronoun([]).
nomSecondSingPronoun([]).

nomThirdSingPronoun(X):- nomThirdSingMPronoun(X);nomThirdSingFPronoun(X);nomThirdSingNPronoun(X).
nomThirdSingMPronoun([nomSingMPronoun]).
nomThirdSingFPronoun([nomSingFPronoun]).
nomThirdSingNPronoun([nomSingNPronoun]).

nomThirdSingMPronoun([]).
nomThirdSingFPronoun([]).
nomThirdSingNPronoun([]).

nomFirstPlurPronoun([nomFirstPlurPronoun]).
nomSecondPlurPronoun([nomSecondPlurPronoun]).

nomFirstPlurPronoun([]).
nomSecondPlurPronoun([]).


nomThirdPlurPronoun(X):- nomThirdPlurMPronoun(X);nomThirdPlurFPronoun(X);nomThirdPlurNPronoun(X).
nomThirdPlurMPronoun([nomPlurMPronoun]).
nomThirdPlurFPronoun([nomPlurFPronoun]).
nomThirdPlurNPronoun([nomPlurNPronoun]).
nomThirdPlurMPronoun([]).
nomThirdPlurFPronoun([]).
nomThirdPlurNPronoun([]).

nomSingMRelPronoun([nomSingMRelPronoun]).
nomSingFRelPronoun([nomSingFRelPronoun]).
nomSingNRelPronoun([nomSingNRelPronoun]).
nomPlurMRelPronoun([nomPlurMRelPronoun]).
nomPlurFRelPronoun([nomPlurFRelPronoun]).
nomPlurNRelPronoun([nomPlurNRelPronoun]).

%%nomSingNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

nomFirstSingNounPhrase(C):- nomFirstSingPronoun(A),nomSingNounPhrase(B), append(A,B,C).
nomSecondSingNounPhrase(C):- nomSecondSingPronoun(A),nomSingNounPhrase(B), append(A,B,C).
nomThirdSingNounPhrase(C):- nomThirdSingMNounPhrase(C);nomThirdSingFNounPhrase(C);nomThirdSingNNounPhrase(C).
nomThirdSingMNounPhrase(C):-nomThirdSingMPronoun(A),nomSingMNounPhrase(B), append(A,B,C).
nomThirdSingFNounPhrase(C):-nomThirdSingFPronoun(A),nomSingFNounPhrase(B), append(A,B,C).
nomThirdSingNNounPhrase(C):-nomThirdSingNPronoun(A),nomSingNNounPhrase(B), append(A,B,C).

nomSingNounPhrase(C):- (nomSingMNounPhrase(C);nomSingFNounPhrase(C);nomSingNNounPhrase(C)).

	nomSingMNounPhrase1(C):-nomSingMNoun(A), nomSingMAdjective(B), append(A,B,C).
	%nomSingMRelPronounClause(C):- nomSingMRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	nomSingMRelPronounClause([]).
nomSingMNounPhrase(C):-	nomSingMNounPhrase1(A),nomSingMRelPronounClause(B), append(A,B,C).	

	nomSingFNounPhrase1(C):-nomSingFNoun(A), nomSingFAdjective(B), append(A,B,C).
	%nomSingFRelPronounClause(C):- nomSingFRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	nomSingFRelPronounClause([]).
nomSingFNounPhrase(C):-	nomSingFNounPhrase1(A),nomSingFRelPronounClause(B), append(A,B,C).
	
	nomSingNNounPhrase1(C):-nomSingNNoun(A), nomSingNAdjective(B), append(A,B,C).
	%nomSingNRelPronounClause(C):- nomSingNRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	nomSingNRelPronounClause([]).
nomSingNNounPhrase(C):-	nomSingNNounPhrase1(A),nomSingNRelPronounClause(B), append(A,B,C).								

nomSingMNoun([nomSingMNoun]).
nomSingFNoun([nomSingFNoun]).
nomSingNNoun([nomSingNNoun]).
nomSingMAdjective([nomSingMAdjective]).
nomSingFAdjective([nomSingFAdjective]).
nomSingNAdjective([nomSingNAdjective]).

nomSingMNoun([]).
nomSingFNoun([]).
nomSingNNoun([]).
nomSingMAdjective([]).
nomSingFAdjective([]).
nomSingNAdjective([]).

%%%nomPlurNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

nomFirstPlurNounPhrase(C):- nomFirstPlurPronoun(A),nomPlurNounPhrase(B), append(A,B,C).
nomSecondPlurNounPhrase(C):- nomSecondPlurPronoun(A),nomPlurNounPhrase(B), append(A,B,C).
nomThirdPlurNounPhrase(C):- nomThirdPlurMNounPhrase(C);nomThirdPlurFNounPhrase(C);nomThirdPlurNNounPhrase(C).
nomThirdPlurMNounPhrase(C):-nomThirdPlurMPronoun(A),nomPlurMNounPhrase(B), append(A,B,C).
nomThirdPlurFNounPhrase(C):-nomThirdPlurFPronoun(A),nomPlurFNounPhrase(B), append(A,B,C).
nomThirdPlurNNounPhrase(C):-nomThirdPlurNPronoun(A),nomPlurNNounPhrase(B), append(A,B,C).

nomPlurNounPhrase(C):- (nomPlurMNounPhrase(C);nomPlurFNounPhrase(C);nomPlurNNounPhrase(C)).

nomPlurMNounPhrase1(C):-nomPlurMNoun(A), nomPlurMAdjective(B), append(A,B,C).
	%nomPlurMRelPronounClause(C):- nomPlurMRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	nomPlurMRelPronounClause([]).
nomPlurMNounPhrase(C):-	nomPlurMNounPhrase1(A),nomPlurMRelPronounClause(B), append(A,B,C).	
	nomPlurFNounPhrase1(C):-nomPlurFNoun(A), nomPlurFAdjective(B), append(A,B,C).
	%nomPlurFRelPronounClause(C):- nomPlurFRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	nomPlurFRelPronounClause([]).
nomPlurFNounPhrase(C):-	nomPlurFNounPhrase1(A),nomPlurFRelPronounClause(B), append(A,B,C).	
	nomPlurNNounPhrase1(C):-nomPlurNNoun(A), nomPlurNAdjective(B), append(A,B,C).
	%nomPlurNRelPronounClause(C):- nomPlurNRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	nomPlurNRelPronounClause([]).
nomPlurNNounPhrase(C):-	nomPlurNNounPhrase1(A),nomPlurNRelPronounClause(B), append(A,B,C).								
							

nomPlurMNoun([nomPlurMNoun]).
nomPlurFNoun([nomPlurFNoun]).
nomPlurNNoun([nomPlurNNoun]).
nomPlurMAdjective([nomPlurMAdjective]).
nomPlurFAdjective([nomPlurFAdjective]).
nomPlurNAdjective([nomPlurNAdjective]).

nomPlurMNoun([]).
nomPlurFNoun([]).
nomPlurNNoun([]).
nomPlurMAdjective([]).
nomPlurFAdjective([]).
nomPlurNAdjective([]).



accNounPhrase(C):- (accSingNounPhrase(A); accPlurNounPhrase(A)), modifier(B), append(A,B,C).

%%accPronouns%%%%%%%%%%%%%%%%%
accFirstSingPronoun([accFirstSingPronoun]).
accSecondSingPronoun([accSecondSingPronoun]).

accFirstSingPronoun([]).
accSecondSingPronoun([]).

accThirdSingPronoun(X):- accThirdSingMPronoun(X);accThirdSingFPronoun(X);accThirdSingNPronoun(X).
accThirdSingMPronoun([accSingMPronoun]).
accThirdSingFPronoun([accSingFPronoun]).
accThirdSingNPronoun([accSingNPronoun]).

accThirdSingMPronoun([]).
accThirdSingFPronoun([]).
accThirdSingNPronoun([]).

accFirstPlurPronoun([accFirstPlurPronoun]).
accSecondPlurPronoun([accSecondPlurPronoun]).

accFirstPlurPronoun([]).
accSecondPlurPronoun([]).


accThirdPlurPronoun(X):- accThirdPlurMPronoun(X);accThirdPlurFPronoun(X);accThirdPlurNPronoun(X).
accThirdPlurMPronoun([accPlurMPronoun]).
accThirdPlurFPronoun([accPlurFPronoun]).
accThirdPlurNPronoun([accPlurNPronoun]).
accThirdPlurMPronoun([]).
accThirdPlurFPronoun([]).
accThirdPlurNPronoun([]).

accSingMRelPronoun([accSingMRelPronoun]).
accSingFRelPronoun([accSingFRelPronoun]).
accSingNRelPronoun([accSingNRelPronoun]).
accPlurMRelPronoun([accPlurMRelPronoun]).
accPlurFRelPronoun([accPlurFRelPronoun]).
accPlurNRelPronoun([accPlurNRelPronoun]).

%%accSingNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

accFirstSingNounPhrase(C):- accFirstSingPronoun(A),accSingNounPhrase(B), append(A,B,C).
accSecondSingNounPhrase(C):- accSecondSingPronoun(A),accSingNounPhrase(B), append(A,B,C).
accThirdSingNounPhrase(C):- accThirdSingMNounPhrase(C);accThirdSingFNounPhrase(C);accThirdSingNNounPhrase(C).
accThirdSingMNounPhrase(C):-accThirdSingMPronoun(A),accSingMNounPhrase(B), append(A,B,C).
accThirdSingFNounPhrase(C):-accThirdSingFPronoun(A),accSingFNounPhrase(B), append(A,B,C).
accThirdSingNNounPhrase(C):-accThirdSingNPronoun(A),accSingNNounPhrase(B), append(A,B,C).

accSingNounPhrase(C):- (accSingMNounPhrase(C);accSingFNounPhrase(C);accSingNNounPhrase(C)).

	accSingMNounPhrase1(C):-accSingMNoun(A), accSingMAdjective(B), append(A,B,C).
	%accSingMRelPronounClause(C):- accSingMRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	accSingMRelPronounClause([]).
accSingMNounPhrase(C):-	accSingMNounPhrase1(A),accSingMRelPronounClause(B), append(A,B,C).	

	accSingFNounPhrase1(C):-accSingFNoun(A), accSingFAdjective(B), append(A,B,C).
	%accSingFRelPronounClause(C):- accSingFRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	accSingFRelPronounClause([]).
accSingFNounPhrase(C):-	accSingFNounPhrase1(A),accSingFRelPronounClause(B), append(A,B,C).
	
	accSingNNounPhrase1(C):-accSingNNoun(A), accSingNAdjective(B), append(A,B,C).
	%accSingNRelPronounClause(C):- accSingNRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	accSingNRelPronounClause([]).
accSingNNounPhrase(C):-	accSingNNounPhrase1(A),accSingNRelPronounClause(B), append(A,B,C).								

accSingMNoun([accSingMNoun]).
accSingFNoun([accSingFNoun]).
accSingNNoun([accSingNNoun]).
accSingMAdjective([accSingMAdjective]).
accSingFAdjective([accSingFAdjective]).
accSingNAdjective([accSingNAdjective]).

accSingMNoun([]).
accSingFNoun([]).
accSingNNoun([]).
accSingMAdjective([]).
accSingFAdjective([]).
accSingNAdjective([]).

%%%accPlurNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

accFirstPlurNounPhrase(C):- accFirstPlurPronoun(A),accPlurNounPhrase(B), append(A,B,C).
accSecondPlurNounPhrase(C):- accSecondPlurPronoun(A),accPlurNounPhrase(B), append(A,B,C).
accThirdPlurNounPhrase(C):- accThirdPlurMNounPhrase(C);accThirdPlurFNounPhrase(C);accThirdPlurNNounPhrase(C).
accThirdPlurMNounPhrase(C):-accThirdPlurMPronoun(A),accPlurMNounPhrase(B), append(A,B,C).
accThirdPlurFNounPhrase(C):-accThirdPlurFPronoun(A),accPlurFNounPhrase(B), append(A,B,C).
accThirdPlurNNounPhrase(C):-accThirdPlurNPronoun(A),accPlurNNounPhrase(B), append(A,B,C).

accPlurNounPhrase(C):- (accPlurMNounPhrase(C);accPlurFNounPhrase(C);accPlurNNounPhrase(C)).

accPlurMNounPhrase1(C):-accPlurMNoun(A), accPlurMAdjective(B), append(A,B,C).
	%accPlurMRelPronounClause(C):- accPlurMRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	accPlurMRelPronounClause([]).
accPlurMNounPhrase(C):-	accPlurMNounPhrase1(A),accPlurMRelPronounClause(B), append(A,B,C).	
	accPlurFNounPhrase1(C):-accPlurFNoun(A), accPlurFAdjective(B), append(A,B,C).
	%accPlurFRelPronounClause(C):- accPlurFRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	accPlurFRelPronounClause([]).
accPlurFNounPhrase(C):-	accPlurFNounPhrase1(A),accPlurFRelPronounClause(B), append(A,B,C).	
	accPlurNNounPhrase1(C):-accPlurNNoun(A), accPlurNAdjective(B), append(A,B,C).
	%accPlurNRelPronounClause(C):- accPlurNRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	accPlurNRelPronounClause([]).
accPlurNNounPhrase(C):-	accPlurNNounPhrase1(A),accPlurNRelPronounClause(B), append(A,B,C).								
							

accPlurMNoun([accPlurMNoun]).
accPlurFNoun([accPlurFNoun]).
accPlurNNoun([accPlurNNoun]).
accPlurMAdjective([accPlurMAdjective]).
accPlurFAdjective([accPlurFAdjective]).
accPlurNAdjective([accPlurNAdjective]).

accPlurMNoun([]).
accPlurFNoun([]).
accPlurNNoun([]).
accPlurMAdjective([]).
accPlurFAdjective([]).
accPlurNAdjective([]).




%%modifiers
modifier(C):- genNounPhrase(C); datNounPhrase(C); ablNounPhrase(C).
genNounPhrase(C):- (genSingNounPhrase(C); genPlurNounPhrase(C)).
datNounPhrase(C):- (datSingNounPhrase(C); datPlurNounPhrase(C)).
ablNounPhrase(C):- (ablSingNounPhrase(C); ablPlurNounPhrase(C)).


genNounPhrase(C):- (genSingNounPhrase(A); genPlurNounPhrase(A)), modifier(B), append(A,B,C).
%%genPronouns%%%%%%%%%%%%%%%%%
genFirstSingPronoun([genFirstSingPronoun]).
genSecondSingPronoun([genSecondSingPronoun]).

genFirstSingPronoun([]).
genSecondSingPronoun([]).

genThirdSingPronoun(X):- genThirdSingMPronoun(X);genThirdSingFPronoun(X);genThirdSingNPronoun(X).
genThirdSingMPronoun([genSingMPronoun]).
genThirdSingFPronoun([genSingFPronoun]).
genThirdSingNPronoun([genSingNPronoun]).

genThirdSingMPronoun([]).
genThirdSingFPronoun([]).
genThirdSingNPronoun([]).

genFirstPlurPronoun([genFirstPlurPronoun]).
genSecondPlurPronoun([genSecondPlurPronoun]).

genFirstPlurPronoun([]).
genSecondPlurPronoun([]).


genThirdPlurPronoun(X):- genThirdPlurMPronoun(X);genThirdPlurFPronoun(X);genThirdPlurNPronoun(X).
genThirdPlurMPronoun([genPlurMPronoun]).
genThirdPlurFPronoun([genPlurFPronoun]).
genThirdPlurNPronoun([genPlurNPronoun]).
genThirdPlurMPronoun([]).
genThirdPlurFPronoun([]).
genThirdPlurNPronoun([]).

genSingMRelPronoun([genSingMRelPronoun]).
genSingFRelPronoun([genSingFRelPronoun]).
genSingNRelPronoun([genSingNRelPronoun]).
genPlurMRelPronoun([genPlurMRelPronoun]).
genPlurFRelPronoun([genPlurFRelPronoun]).
genPlurNRelPronoun([genPlurNRelPronoun]).

%%genSingNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

genFirstSingNounPhrase(C):- genFirstSingPronoun(A),genSingNounPhrase(B), append(A,B,C).
genSecondSingNounPhrase(C):- genSecondSingPronoun(A),genSingNounPhrase(B), append(A,B,C).
genThirdSingNounPhrase(C):- genThirdSingMNounPhrase(C);genThirdSingFNounPhrase(C);genThirdSingNNounPhrase(C).
genThirdSingMNounPhrase(C):-genThirdSingMPronoun(A),genSingMNounPhrase(B), append(A,B,C).
genThirdSingFNounPhrase(C):-genThirdSingFPronoun(A),genSingFNounPhrase(B), append(A,B,C).
genThirdSingNNounPhrase(C):-genThirdSingNPronoun(A),genSingNNounPhrase(B), append(A,B,C).

genSingNounPhrase(C):- (genSingMNounPhrase(C);genSingFNounPhrase(C);genSingNNounPhrase(C)).

	genSingMNounPhrase1(C):-genSingMNoun(A), genSingMAdjective(B), append(A,B,C).
	%genSingMRelPronounClause(C):- genSingMRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	genSingMRelPronounClause([]).
genSingMNounPhrase(C):-	genSingMNounPhrase1(A),genSingMRelPronounClause(B), append(A,B,C).	

	genSingFNounPhrase1(C):-genSingFNoun(A), genSingFAdjective(B), append(A,B,C).
	%genSingFRelPronounClause(C):- genSingFRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	genSingFRelPronounClause([]).
genSingFNounPhrase(C):-	genSingFNounPhrase1(A),genSingFRelPronounClause(B), append(A,B,C).
	
	genSingNNounPhrase1(C):-genSingNNoun(A), genSingNAdjective(B), append(A,B,C).
	%genSingNRelPronounClause(C):- genSingNRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	genSingNRelPronounClause([]).
genSingNNounPhrase(C):-	genSingNNounPhrase1(A),genSingNRelPronounClause(B), append(A,B,C).								

genSingMNoun([genSingMNoun]).
genSingFNoun([genSingFNoun]).
genSingNNoun([genSingNNoun]).
genSingMAdjective([genSingMAdjective]).
genSingFAdjective([genSingFAdjective]).
genSingNAdjective([genSingNAdjective]).

genSingMNoun([]).
genSingFNoun([]).
genSingNNoun([]).
genSingMAdjective([]).
genSingFAdjective([]).
genSingNAdjective([]).

%%%genPlurNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

genFirstPlurNounPhrase(C):- genFirstPlurPronoun(A),genPlurNounPhrase(B), append(A,B,C).
genSecondPlurNounPhrase(C):- genSecondPlurPronoun(A),genPlurNounPhrase(B), append(A,B,C).
genThirdPlurNounPhrase(C):- genThirdPlurMNounPhrase(C);genThirdPlurFNounPhrase(C);genThirdPlurNNounPhrase(C).
genThirdPlurMNounPhrase(C):-genThirdPlurMPronoun(A),genPlurMNounPhrase(B), append(A,B,C).
genThirdPlurFNounPhrase(C):-genThirdPlurFPronoun(A),genPlurFNounPhrase(B), append(A,B,C).
genThirdPlurNNounPhrase(C):-genThirdPlurNPronoun(A),genPlurNNounPhrase(B), append(A,B,C).

genPlurNounPhrase(C):- (genPlurMNounPhrase(C);genPlurFNounPhrase(C);genPlurNNounPhrase(C)).

genPlurMNounPhrase1(C):-genPlurMNoun(A), genPlurMAdjective(B), append(A,B,C).
	%genPlurMRelPronounClause(C):- genPlurMRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	genPlurMRelPronounClause([]).
genPlurMNounPhrase(C):-	genPlurMNounPhrase1(A),genPlurMRelPronounClause(B), append(A,B,C).	
	genPlurFNounPhrase1(C):-genPlurFNoun(A), genPlurFAdjective(B), append(A,B,C).
	%genPlurFRelPronounClause(C):- genPlurFRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	genPlurFRelPronounClause([]).
genPlurFNounPhrase(C):-	genPlurFNounPhrase1(A),genPlurFRelPronounClause(B), append(A,B,C).	
	genPlurNNounPhrase1(C):-genPlurNNoun(A), genPlurNAdjective(B), append(A,B,C).
	%genPlurNRelPronounClause(C):- genPlurNRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	genPlurNRelPronounClause([]).
genPlurNNounPhrase(C):-	genPlurNNounPhrase1(A),genPlurNRelPronounClause(B), append(A,B,C).								
							

genPlurMNoun([genPlurMNoun]).
genPlurFNoun([genPlurFNoun]).
genPlurNNoun([genPlurNNoun]).
genPlurMAdjective([genPlurMAdjective]).
genPlurFAdjective([genPlurFAdjective]).
genPlurNAdjective([genPlurNAdjective]).

genPlurMNoun([]).
genPlurFNoun([]).
genPlurNNoun([]).
genPlurMAdjective([]).
genPlurFAdjective([]).
genPlurNAdjective([]).



datNounPhrase(C):- (datSingNounPhrase(A); datPlurNounPhrase(A)), modifier(B), append(A,B,C).
%%datPronouns%%%%%%%%%%%%%%%%%
datFirstSingPronoun([datFirstSingPronoun]).
datSecondSingPronoun([datSecondSingPronoun]).

datFirstSingPronoun([]).
datSecondSingPronoun([]).

datThirdSingPronoun(X):- datThirdSingMPronoun(X);datThirdSingFPronoun(X);datThirdSingNPronoun(X).
datThirdSingMPronoun([datSingMPronoun]).
datThirdSingFPronoun([datSingFPronoun]).
datThirdSingNPronoun([datSingNPronoun]).

datThirdSingMPronoun([]).
datThirdSingFPronoun([]).
datThirdSingNPronoun([]).

datFirstPlurPronoun([datFirstPlurPronoun]).
datSecondPlurPronoun([datSecondPlurPronoun]).

datFirstPlurPronoun([]).
datSecondPlurPronoun([]).


datThirdPlurPronoun(X):- datThirdPlurMPronoun(X);datThirdPlurFPronoun(X);datThirdPlurNPronoun(X).
datThirdPlurMPronoun([datPlurMPronoun]).
datThirdPlurFPronoun([datPlurFPronoun]).
datThirdPlurNPronoun([datPlurNPronoun]).
datThirdPlurMPronoun([]).
datThirdPlurFPronoun([]).
datThirdPlurNPronoun([]).

datSingMRelPronoun([datSingMRelPronoun]).
datSingFRelPronoun([datSingFRelPronoun]).
datSingNRelPronoun([datSingNRelPronoun]).
datPlurMRelPronoun([datPlurMRelPronoun]).
datPlurFRelPronoun([datPlurFRelPronoun]).
datPlurNRelPronoun([datPlurNRelPronoun]).

%%datSingNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

datFirstSingNounPhrase(C):- datFirstSingPronoun(A),datSingNounPhrase(B), append(A,B,C).
datSecondSingNounPhrase(C):- datSecondSingPronoun(A),datSingNounPhrase(B), append(A,B,C).
datThirdSingNounPhrase(C):- datThirdSingMNounPhrase(C);datThirdSingFNounPhrase(C);datThirdSingNNounPhrase(C).
datThirdSingMNounPhrase(C):-datThirdSingMPronoun(A),datSingMNounPhrase(B), append(A,B,C).
datThirdSingFNounPhrase(C):-datThirdSingFPronoun(A),datSingFNounPhrase(B), append(A,B,C).
datThirdSingNNounPhrase(C):-datThirdSingNPronoun(A),datSingNNounPhrase(B), append(A,B,C).

datSingNounPhrase(C):- (datSingMNounPhrase(C);datSingFNounPhrase(C);datSingNNounPhrase(C)).

	datSingMNounPhrase1(C):-datSingMNoun(A), datSingMAdjective(B), append(A,B,C).
	%datSingMRelPronounClause(C):- datSingMRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	datSingMRelPronounClause([]).
datSingMNounPhrase(C):-	datSingMNounPhrase1(A),datSingMRelPronounClause(B), append(A,B,C).	

	datSingFNounPhrase1(C):-datSingFNoun(A), datSingFAdjective(B), append(A,B,C).
	%datSingFRelPronounClause(C):- datSingFRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	datSingFRelPronounClause([]).
datSingFNounPhrase(C):-	datSingFNounPhrase1(A),datSingFRelPronounClause(B), append(A,B,C).
	
	datSingNNounPhrase1(C):-datSingNNoun(A), datSingNAdjective(B), append(A,B,C).
	%datSingNRelPronounClause(C):- datSingNRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	datSingNRelPronounClause([]).
datSingNNounPhrase(C):-	datSingNNounPhrase1(A),datSingNRelPronounClause(B), append(A,B,C).								

datSingMNoun([datSingMNoun]).
datSingFNoun([datSingFNoun]).
datSingNNoun([datSingNNoun]).
datSingMAdjective([datSingMAdjective]).
datSingFAdjective([datSingFAdjective]).
datSingNAdjective([datSingNAdjective]).

datSingMNoun([]).
datSingFNoun([]).
datSingNNoun([]).
datSingMAdjective([]).
datSingFAdjective([]).
datSingNAdjective([]).

%%%datPlurNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

datFirstPlurNounPhrase(C):- datFirstPlurPronoun(A),datPlurNounPhrase(B), append(A,B,C).
datSecondPlurNounPhrase(C):- datSecondPlurPronoun(A),datPlurNounPhrase(B), append(A,B,C).
datThirdPlurNounPhrase(C):- datThirdPlurMNounPhrase(C);datThirdPlurFNounPhrase(C);datThirdPlurNNounPhrase(C).
datThirdPlurMNounPhrase(C):-datThirdPlurMPronoun(A),datPlurMNounPhrase(B), append(A,B,C).
datThirdPlurFNounPhrase(C):-datThirdPlurFPronoun(A),datPlurFNounPhrase(B), append(A,B,C).
datThirdPlurNNounPhrase(C):-datThirdPlurNPronoun(A),datPlurNNounPhrase(B), append(A,B,C).

datPlurNounPhrase(C):- (datPlurMNounPhrase(C);datPlurFNounPhrase(C);datPlurNNounPhrase(C)).

datPlurMNounPhrase1(C):-datPlurMNoun(A), datPlurMAdjective(B), append(A,B,C).
	%datPlurMRelPronounClause(C):- datPlurMRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	datPlurMRelPronounClause([]).
datPlurMNounPhrase(C):-	datPlurMNounPhrase1(A),datPlurMRelPronounClause(B), append(A,B,C).	
	datPlurFNounPhrase1(C):-datPlurFNoun(A), datPlurFAdjective(B), append(A,B,C).
	%datPlurFRelPronounClause(C):- datPlurFRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	datPlurFRelPronounClause([]).
datPlurFNounPhrase(C):-	datPlurFNounPhrase1(A),datPlurFRelPronounClause(B), append(A,B,C).	
	datPlurNNounPhrase1(C):-datPlurNNoun(A), datPlurNAdjective(B), append(A,B,C).
	%datPlurNRelPronounClause(C):- datPlurNRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	datPlurNRelPronounClause([]).
datPlurNNounPhrase(C):-	datPlurNNounPhrase1(A),datPlurNRelPronounClause(B), append(A,B,C).								
							

datPlurMNoun([datPlurMNoun]).
datPlurFNoun([datPlurFNoun]).
datPlurNNoun([datPlurNNoun]).
datPlurMAdjective([datPlurMAdjective]).
datPlurFAdjective([datPlurFAdjective]).
datPlurNAdjective([datPlurNAdjective]).

datPlurMNoun([]).
datPlurFNoun([]).
datPlurNNoun([]).
datPlurMAdjective([]).
datPlurFAdjective([]).
datPlurNAdjective([]).




ablNounPhrase(C):- (ablSingNounPhrase(A); ablPlurNounPhrase(A)), modifier(B), append(A,B,C).
%%ablPronouns%%%%%%%%%%%%%%%%%
ablFirstSingPronoun([ablFirstSingPronoun]).
ablSecondSingPronoun([ablSecondSingPronoun]).

ablFirstSingPronoun([]).
ablSecondSingPronoun([]).

ablThirdSingPronoun(X):- ablThirdSingMPronoun(X);ablThirdSingFPronoun(X);ablThirdSingNPronoun(X).
ablThirdSingMPronoun([ablSingMPronoun]).
ablThirdSingFPronoun([ablSingFPronoun]).
ablThirdSingNPronoun([ablSingNPronoun]).

ablThirdSingMPronoun([]).
ablThirdSingFPronoun([]).
ablThirdSingNPronoun([]).

ablFirstPlurPronoun([ablFirstPlurPronoun]).
ablSecondPlurPronoun([ablSecondPlurPronoun]).

ablFirstPlurPronoun([]).
ablSecondPlurPronoun([]).


ablThirdPlurPronoun(X):- ablThirdPlurMPronoun(X);ablThirdPlurFPronoun(X);ablThirdPlurNPronoun(X).
ablThirdPlurMPronoun([ablPlurMPronoun]).
ablThirdPlurFPronoun([ablPlurFPronoun]).
ablThirdPlurNPronoun([ablPlurNPronoun]).
ablThirdPlurMPronoun([]).
ablThirdPlurFPronoun([]).
ablThirdPlurNPronoun([]).

ablSingMRelPronoun([ablSingMRelPronoun]).
ablSingFRelPronoun([ablSingFRelPronoun]).
ablSingNRelPronoun([ablSingNRelPronoun]).
ablPlurMRelPronoun([ablPlurMRelPronoun]).
ablPlurFRelPronoun([ablPlurFRelPronoun]).
ablPlurNRelPronoun([ablPlurNRelPronoun]).

%%ablSingNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

ablFirstSingNounPhrase(C):- ablFirstSingPronoun(A),ablSingNounPhrase(B), append(A,B,C).
ablSecondSingNounPhrase(C):- ablSecondSingPronoun(A),ablSingNounPhrase(B), append(A,B,C).
ablThirdSingNounPhrase(C):- ablThirdSingMNounPhrase(C);ablThirdSingFNounPhrase(C);ablThirdSingNNounPhrase(C).
ablThirdSingMNounPhrase(C):-ablThirdSingMPronoun(A),ablSingMNounPhrase(B), append(A,B,C).
ablThirdSingFNounPhrase(C):-ablThirdSingFPronoun(A),ablSingFNounPhrase(B), append(A,B,C).
ablThirdSingNNounPhrase(C):-ablThirdSingNPronoun(A),ablSingNNounPhrase(B), append(A,B,C).

ablSingNounPhrase(C):- (ablSingMNounPhrase(C);ablSingFNounPhrase(C);ablSingNNounPhrase(C)).

	ablSingMNounPhrase1(C):-ablSingMNoun(A), ablSingMAdjective(B), append(A,B,C).
	%ablSingMRelPronounClause(C):- ablSingMRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	ablSingMRelPronounClause([]).
ablSingMNounPhrase(C):-	ablSingMNounPhrase1(A),ablSingMRelPronounClause(B), append(A,B,C).	

	ablSingFNounPhrase1(C):-ablSingFNoun(A), ablSingFAdjective(B), append(A,B,C).
	%ablSingFRelPronounClause(C):- ablSingFRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	ablSingFRelPronounClause([]).
ablSingFNounPhrase(C):-	ablSingFNounPhrase1(A),ablSingFRelPronounClause(B), append(A,B,C).
	
	ablSingNNounPhrase1(C):-ablSingNNoun(A), ablSingNAdjective(B), append(A,B,C).
	%ablSingNRelPronounClause(C):- ablSingNRelPronoun(A),thirdSingVerb(B), append(A,B,C).
	ablSingNRelPronounClause([]).
ablSingNNounPhrase(C):-	ablSingNNounPhrase1(A),ablSingNRelPronounClause(B), append(A,B,C).								

ablSingMNoun([ablSingMNoun]).
ablSingFNoun([ablSingFNoun]).
ablSingNNoun([ablSingNNoun]).
ablSingMAdjective([ablSingMAdjective]).
ablSingFAdjective([ablSingFAdjective]).
ablSingNAdjective([ablSingNAdjective]).

ablSingMNoun([]).
ablSingFNoun([]).
ablSingNNoun([]).
ablSingMAdjective([]).
ablSingFAdjective([]).
ablSingNAdjective([]).

%%%ablPlurNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

ablFirstPlurNounPhrase(C):- ablFirstPlurPronoun(A),ablPlurNounPhrase(B), append(A,B,C).
ablSecondPlurNounPhrase(C):- ablSecondPlurPronoun(A),ablPlurNounPhrase(B), append(A,B,C).
ablThirdPlurNounPhrase(C):- ablThirdPlurMNounPhrase(C);ablThirdPlurFNounPhrase(C);ablThirdPlurNNounPhrase(C).
ablThirdPlurMNounPhrase(C):-ablThirdPlurMPronoun(A),ablPlurMNounPhrase(B), append(A,B,C).
ablThirdPlurFNounPhrase(C):-ablThirdPlurFPronoun(A),ablPlurFNounPhrase(B), append(A,B,C).
ablThirdPlurNNounPhrase(C):-ablThirdPlurNPronoun(A),ablPlurNNounPhrase(B), append(A,B,C).

ablPlurNounPhrase(C):- (ablPlurMNounPhrase(C);ablPlurFNounPhrase(C);ablPlurNNounPhrase(C)).

ablPlurMNounPhrase1(C):-ablPlurMNoun(A), ablPlurMAdjective(B), append(A,B,C).
	%ablPlurMRelPronounClause(C):- ablPlurMRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	ablPlurMRelPronounClause([]).
ablPlurMNounPhrase(C):-	ablPlurMNounPhrase1(A),ablPlurMRelPronounClause(B), append(A,B,C).	
	ablPlurFNounPhrase1(C):-ablPlurFNoun(A), ablPlurFAdjective(B), append(A,B,C).
	%ablPlurFRelPronounClause(C):- ablPlurFRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	ablPlurFRelPronounClause([]).
ablPlurFNounPhrase(C):-	ablPlurFNounPhrase1(A),ablPlurFRelPronounClause(B), append(A,B,C).	
	ablPlurNNounPhrase1(C):-ablPlurNNoun(A), ablPlurNAdjective(B), append(A,B,C).
	%ablPlurNRelPronounClause(C):- ablPlurNRelPronoun(A),thirdPlurVerb(B), append(A,B,C).
	ablPlurNRelPronounClause([]).
ablPlurNNounPhrase(C):-	ablPlurNNounPhrase1(A),ablPlurNRelPronounClause(B), append(A,B,C).								
							

ablPlurMNoun([ablPlurMNoun]).
ablPlurFNoun([ablPlurFNoun]).
ablPlurNNoun([ablPlurNNoun]).
ablPlurMAdjective([ablPlurMAdjective]).
ablPlurFAdjective([ablPlurFAdjective]).
ablPlurNAdjective([ablPlurNAdjective]).

ablPlurMNoun([]).
ablPlurFNoun([]).
ablPlurNNoun([]).
ablPlurMAdjective([]).
ablPlurFAdjective([]).
ablPlurNAdjective([]).


