s(V,W,X,Y,Z,A,B,C,D,E) :- verb(V,W,X,Y,Z,A,B,C,D,E).%% a sentence is a verb

blank([ ]).

verb(V,W,X,Y,Z,A,B,C,D,E) :- firstSingVerb(V,W,X,Y,Z,A,B,C,D,E);
			secondSingVerb(V,W,X,Y,Z,A,B,C,D,E);
			thirdSingVerb(V,W,X,Y,Z,A,B,C,D,E);
			firstPlurVerb(V,W,X,Y,Z,A,B,C,D,E);
			secondPlurVerb(V,W,X,Y,Z,A,B,C,D,E);
			thirdPlurVerb(V,W,X,Y,Z,A,B,C,D,E).

firstSingVerb(V,W,X,Y,Z,A,B,C,D,E):- firstSingPronounPhrase(V,W,X,Y,Z,A),  accNounPhrase(B,C,D,E).
secondSingVerb(V,W,X,Y,Z,A,B,C,D,E):- secondSingPronounPhrase(V,W,X,Y,Z,A),  accNounPhrase(B,C,D,E).
thirdSingVerb(V,W,X,Y,Z,A,B,C,D,E):- thirdSingPronounPhrase(V,W,X,Y,Z,A),  accNounPhrase(B,C,D,E).
firstPlurVerb(V,W,X,Y,Z,A,B,C,D,E):- firstPlurPronounPhrase(V,W,X,Y,Z,A),  accNounPhrase(B,C,D,E).
secondPlurVerb(V,W,X,Y,Z,A,B,C,D,E):- secondPlurPronounPhrase(V,W,X,Y,Z,A),  accNounPhrase(B,C,D,E).
thirdPlurVerb(V,W,X,Y,Z,A,B,C,D,E):- thirdPlurPronounPhrase(V,W,X,Y,Z,A),  accNounPhrase(B,C,D,E).

firstSingPronounPhrase(X,Y,Z,A,B,C):- blank(C);(((firstSingPronoun(X), nomSingNounPhrase(Y,Z));
					firstSingPronoun(X)), modifier(A,B)).
secondSingPronounPhrase(X,Y,Z,A,B,C):- blank(C);(((secondSingPronoun(X), nomSingNounPhrase(Y,Z));
					secondSingPronoun(X)), modifier(A,B)).	
thirdSingPronounPhrase(X,Y,Z,A,B,C):- blank(C);(((thirdSingPronoun(X), nomSingNounPhrase(Y,Z));
					thirdSingPronoun(X)), modifier(A,B)).	
firstPlurPronounPhrase(X,Y,Z,A,B,C):- blank(C);(((firstPlurPronoun(X), nomPlurNounPhrase(Y,Z));
					firstPlurPronoun(X)), modifier(A,B)).
secondPlurPronounPhrase(X,Y,Z,A,B,C):- blank(C);(((secondPlurPronoun(X), nomPlurNounPhrase(Y,Z));
					secondPlurPronoun(X)), modifier(A,B)).	
thirdPlurPronounPhrase(X,Y,Z,A,B,C):- blank(C);(((thirdPlurPronoun(X), nomPlurNounPhrase(Y,Z));
					thirdPlurPronoun(X)), modifier(A,B)).																					

%%Pronouns
firstSingPronoun([firstSingPronoun]).
firstSingPronoun([ ]).
secondSingPronoun([secondSingPronoun]).
secondSingPronoun([ ]).
thirdSingPronoun([thirdSingPronoun]).
thirdSingPronoun([ ]).
firstPlurPronoun([firstplurPronoun]).
firstPlurPronoun([ ]).
secondPlurPronoun([secondplurPronoun]).
secondPlurPronoun([ ]).
thirdPlurPronoun([thirdplurPronoun]).
thirdPlurPronoun([ ]).



nomNounPhrase(X,Y,A,B):- (nomSingNounPhrase(X,Y); nomPlurNounPhrase(X,Y)), modifier(A,B).%% a nomNounPhrase has either a singular or plural noun phrase and a modifier.

%%nomSingNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
nomSingNounPhrase(X,Y):- (nomSingMNounPhrase(X,Y);nomSingFNounPhrase(X,Y);nomSingNNounPhrase(X,Y)).
nomSingMNounPhrase(X,Y):-(nomSingMNoun(X), nomSingMAdjective(Y)).
nomSingFNounPhrase(X,Y):-(nomSingFNoun(X), nomSingFAdjective(Y)).
nomSingNNounPhrase(X,Y):-(nomSingNNoun(X), nomSingNAdjective(Y)).


nomSingMNoun([nomSingMNoun]).%% defining singular nouns
nomSingFNoun([nomSingFNoun]).
nomSingNNoun([nomSingNNoun]).

nomSingMAdjective([ ]).%% defining singular adjectives
nomSingMAdjective([nomSingMAdjective]).
nomSingFAdjective([ ]).
nomSingFAdjective([nomSingFAdjective]).
nomSingNAdjective([ ]).
nomSingNAdjective([nomSingNAdjective]).

%%%nomPlurNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
nomPlurNounPhrase(X,Y):- (nomPlurMNounPhrase(X,Y);nomPlurFNounPhrase(X,Y);nomPlurNNounPhrase(X,Y)).
nomPlurMNounPhrase(X,Y):-(nomPlurMNoun(X), nomPlurMAdjective(Y)).
nomPlurFNounPhrase(X,Y):-(nomPlurFNoun(X), nomPlurFAdjective(Y)).
nomPlurNNounPhrase(X,Y):-(nomPlurNNoun(X), nomPlurNAdjective(Y)).


nomPlurMNoun([nomPlurMNoun]).%% defining Plural nouns
nomPlurFNoun([nomPlurFNoun]).
nomPlurNNoun([nomPlurNNoun]).

nomPlurMAdjective([ ]).%% defining Plural adjectives
nomPlurMAdjective([nomPlurMAdjective]).
nomPlurFAdjective([ ]).
nomPlurFAdjective([nomPlurFAdjective]).
nomPlurNAdjective([ ]).
nomPlurNAdjective([nomPlurNAdjective]).


accNounPhrase(X,Y,A,B):- (accSingNounPhrase(X,Y); accPlurNounPhrase(X,Y)), modifier(A,B).%% a accNounPhrase has either a singular or plural noun phrase and a modifier.

%%accSingNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
accSingNounPhrase(X,Y):- (accSingMNounPhrase(X,Y);accSingFNounPhrase(X,Y);accSingNNounPhrase(X,Y)).
accSingMNounPhrase(X,Y):-(accSingMNoun(X), accSingMAdjective(Y);accSingMPronoun(X), accSingMAdjective(Y)).
accSingFNounPhrase(X,Y):-(accSingFNoun(X), accSingFAdjective(Y);accSingFPronoun(X), accSingFAdjective(Y)).
accSingNNounPhrase(X,Y):-(accSingNNoun(X), accSingNAdjective(Y);accSingNPronoun(X), accSingNAdjective(Y)).


accSingMNoun([accSingMNoun]).%% defining singular nouns
accSingFNoun([accSingFNoun]).
accSingNNoun([accSingNNoun]).

accSingMPronoun([accSingMPronoun]).%% defining singular pronouns
accSingFPronoun([accSingFPronoun]).
accSingNPronoun([accSingNPronoun]).

accSingMAdjective([ ]).%% defining singular adjectives
accSingMAdjective([accSingMAdjective]).
accSingFAdjective([ ]).
accSingFAdjective([accSingFAdjective]).
accSingNAdjective([ ]).
accSingNAdjective([accSingNAdjective]).

%%%accPlurNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
accPlurNounPhrase(X,Y):- (accPlurMNounPhrase(X,Y);accPlurFNounPhrase(X,Y);accPlurNNounPhrase(X,Y)).
accPlurMNounPhrase(X,Y):-(accPlurMNoun(X), accPlurMAdjective(Y);accPlurMPronoun(X), accPlurMAdjective(Y)).
accPlurFNounPhrase(X,Y):-(accPlurFNoun(X), accPlurFAdjective(Y);accPlurFPronoun(X), accPlurFAdjective(Y)).
accPlurNNounPhrase(X,Y):-(accPlurNNoun(X), accPlurNAdjective(Y);accPlurNPronoun(X), accPlurNAdjective(Y)).


accPlurMNoun([accPlurMNoun]).%% defining Plural nouns
accPlurFNoun([accPlurFNoun]).
accPlurNNoun([accPlurNNoun]).

accPlurMPronoun([accPlurMPronoun]).%% defining Plural pronouns
accPlurFPronoun([accPlurFPronoun]).
accPlurNPronoun([accPlurNPronoun]).

accPlurMAdjective([ ]).%% defining Plural adjectives
accPlurMAdjective([accPlurMAdjective]).
accPlurFAdjective([ ]).
accPlurFAdjective([accPlurFAdjective]).
accPlurNAdjective([ ]).
accPlurNAdjective([accPlurNAdjective]).


%%modifiers
modifier([ ]).
modifier(A,B):- genNounPhrase(A,B); datNounPhrase(A,B); ablNounPhrase(A,B); locNounPhrase(A,B).
genNounPhrase(X,Y):- (genSingNounPhrase(X,Y); genPlurNounPhrase(X,Y)).
datNounPhrase(X,Y):- (datSingNounPhrase(X,Y); datPlurNounPhrase(X,Y)).
ablNounPhrase(X,Y):- (ablSingNounPhrase(X,Y); ablPlurNounPhrase(X,Y)).
locNounPhrase(X,Y):- (locSingNounPhrase(X,Y); locPlurNounPhrase(X,Y)).


%%genSingNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
genSingNounPhrase(X,Y):- (genSingMNounPhrase(X,Y);genSingFNounPhrase(X,Y);genSingNNounPhrase(X,Y)).
genSingMNounPhrase(X,Y):-(genSingMNoun(X), genSingMAdjective(Y);genSingMPronoun(X), genSingMAdjective(Y)).
genSingFNounPhrase(X,Y):-(genSingFNoun(X), genSingFAdjective(Y);genSingFPronoun(X), genSingFAdjective(Y)).
genSingNNounPhrase(X,Y):-(genSingNNoun(X), genSingNAdjective(Y);genSingNPronoun(X), genSingNAdjective(Y)).


genSingMNoun([genSingMNoun]).%% defining singular nouns
genSingFNoun([genSingFNoun]).
genSingNNoun([genSingNNoun]).

genSingMPronoun([genSingMPronoun]).%% defining singular pronouns
genSingFPronoun([genSingFPronoun]).
genSingNPronoun([genSingNPronoun]).

genSingMAdjective([ ]).%% defining singular adjectives
genSingMAdjective([genSingMAdjective]).
genSingFAdjective([ ]).
genSingFAdjective([genSingFAdjective]).
genSingNAdjective([ ]).
genSingNAdjective([genSingNAdjective]).

%%%genPlurNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
genPlurNounPhrase(X,Y):- (genPlurMNounPhrase(X,Y);genPlurFNounPhrase(X,Y);genPlurNNounPhrase(X,Y)).
genPlurMNounPhrase(X,Y):-(genPlurMNoun(X), genPlurMAdjective(Y);genPlurMPronoun(X), genPlurMAdjective(Y)).
genPlurFNounPhrase(X,Y):-(genPlurFNoun(X), genPlurFAdjective(Y);genPlurFPronoun(X), genPlurFAdjective(Y)).
genPlurNNounPhrase(X,Y):-(genPlurNNoun(X), genPlurNAdjective(Y);genPlurNPronoun(X), genPlurNAdjective(Y)).


genPlurMNoun([genPlurMNoun]).%% defining Plural nouns
genPlurFNoun([genPlurFNoun]).
genPlurNNoun([genPlurNNoun]).

genPlurMPronoun([genPlurMPronoun]).%% defining Plural pronouns
genPlurFPronoun([genPlurFPronoun]).
genPlurNPronoun([genPlurNPronoun]).

genPlurMAdjective([ ]).%% defining Plural adjectives
genPlurMAdjective([genPlurMAdjective]).
genPlurFAdjective([ ]).
genPlurFAdjective([genPlurFAdjective]).
genPlurNAdjective([ ]).
genPlurNAdjective([genPlurNAdjective]).

%%datSingNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
datSingNounPhrase(X,Y):- (datSingMNounPhrase(X,Y);datSingFNounPhrase(X,Y);datSingNNounPhrase(X,Y)).
datSingMNounPhrase(X,Y):-(datSingMNoun(X), datSingMAdjective(Y);datSingMPronoun(X), datSingMAdjective(Y)).
datSingFNounPhrase(X,Y):-(datSingFNoun(X), datSingFAdjective(Y);datSingFPronoun(X), datSingFAdjective(Y)).
datSingNNounPhrase(X,Y):-(datSingNNoun(X), datSingNAdjective(Y);datSingNPronoun(X), datSingNAdjective(Y)).


datSingMNoun([datSingMNoun]).%% defining singular nouns
datSingFNoun([datSingFNoun]).
datSingNNoun([datSingNNoun]).

datSingMPronoun([datSingMPronoun]).%% defining singular pronouns
datSingFPronoun([datSingFPronoun]).
datSingNPronoun([datSingNPronoun]).

datSingMAdjective([ ]).%% defining singular adjectives
datSingMAdjective([datSingMAdjective]).
datSingFAdjective([ ]).
datSingFAdjective([datSingFAdjective]).
datSingNAdjective([ ]).
datSingNAdjective([datSingNAdjective]).

%%%datPlurNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
datPlurNounPhrase(X,Y):- (datPlurMNounPhrase(X,Y);datPlurFNounPhrase(X,Y);datPlurNNounPhrase(X,Y)).
datPlurMNounPhrase(X,Y):-(datPlurMNoun(X), datPlurMAdjective(Y);datPlurMPronoun(X), datPlurMAdjective(Y)).
datPlurFNounPhrase(X,Y):-(datPlurFNoun(X), datPlurFAdjective(Y);datPlurFPronoun(X), datPlurFAdjective(Y)).
datPlurNNounPhrase(X,Y):-(datPlurNNoun(X), datPlurNAdjective(Y);datPlurNPronoun(X), datPlurNAdjective(Y)).


datPlurMNoun([datPlurMNoun]).%% defining Plural nouns
datPlurFNoun([datPlurFNoun]).
datPlurNNoun([datPlurNNoun]).

datPlurMPronoun([datPlurMPronoun]).%% defining Plural pronouns
datPlurFPronoun([datPlurFPronoun]).
datPlurNPronoun([datPlurNPronoun]).

datPlurMAdjective([ ]).%% defining Plural adjectives
datPlurMAdjective([datPlurMAdjective]).
datPlurFAdjective([ ]).
datPlurFAdjective([datPlurFAdjective]).
datPlurNAdjective([ ]).
datPlurNAdjective([datPlurNAdjective]).
%%ablSingNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
ablSingNounPhrase(X,Y):- (ablSingMNounPhrase(X,Y);ablSingFNounPhrase(X,Y);ablSingNNounPhrase(X,Y)).
ablSingMNounPhrase(X,Y):-(ablSingMNoun(X), ablSingMAdjective(Y);ablSingMPronoun(X), ablSingMAdjective(Y)).
ablSingFNounPhrase(X,Y):-(ablSingFNoun(X), ablSingFAdjective(Y);ablSingFPronoun(X), ablSingFAdjective(Y)).
ablSingNNounPhrase(X,Y):-(ablSingNNoun(X), ablSingNAdjective(Y);ablSingNPronoun(X), ablSingNAdjective(Y)).


ablSingMNoun([ablSingMNoun]).%% defining singular nouns
ablSingFNoun([ablSingFNoun]).
ablSingNNoun([ablSingNNoun]).

ablSingMPronoun([ablSingMPronoun]).%% defining singular pronouns
ablSingFPronoun([ablSingFPronoun]).
ablSingNPronoun([ablSingNPronoun]).

ablSingMAdjective([ ]).%% defining singular adjectives
ablSingMAdjective([ablSingMAdjective]).
ablSingFAdjective([ ]).
ablSingFAdjective([ablSingFAdjective]).
ablSingNAdjective([ ]).
ablSingNAdjective([ablSingNAdjective]).

%%%ablPlurNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
ablPlurNounPhrase(X,Y):- (ablPlurMNounPhrase(X,Y);ablPlurFNounPhrase(X,Y);ablPlurNNounPhrase(X,Y)).
ablPlurMNounPhrase(X,Y):-(ablPlurMNoun(X), ablPlurMAdjective(Y);ablPlurMPronoun(X), ablPlurMAdjective(Y)).
ablPlurFNounPhrase(X,Y):-(ablPlurFNoun(X), ablPlurFAdjective(Y);ablPlurFPronoun(X), ablPlurFAdjective(Y)).
ablPlurNNounPhrase(X,Y):-(ablPlurNNoun(X), ablPlurNAdjective(Y);ablPlurNPronoun(X), ablPlurNAdjective(Y)).


ablPlurMNoun([ablPlurMNoun]).%% defining Plural nouns
ablPlurFNoun([ablPlurFNoun]).
ablPlurNNoun([ablPlurNNoun]).

ablPlurMPronoun([ablPlurMPronoun]).%% defining Plural pronouns
ablPlurFPronoun([ablPlurFPronoun]).
ablPlurNPronoun([ablPlurNPronoun]).

ablPlurMAdjective([ ]).%% defining Plural adjectives
ablPlurMAdjective([ablPlurMAdjective]).
ablPlurFAdjective([ ]).
ablPlurFAdjective([ablPlurFAdjective]).
ablPlurNAdjective([ ]).
ablPlurNAdjective([ablPlurNAdjective]).

%%locSingNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
locSingNounPhrase(X,Y):- (locSingMNounPhrase(X,Y);locSingFNounPhrase(X,Y);locSingNNounPhrase(X,Y)).
locSingMNounPhrase(X,Y):-(locSingMNoun(X), locSingMAdjective(Y);locSingMPronoun(X), locSingMAdjective(Y)).
locSingFNounPhrase(X,Y):-(locSingFNoun(X), locSingFAdjective(Y);locSingFPronoun(X), locSingFAdjective(Y)).
locSingNNounPhrase(X,Y):-(locSingNNoun(X), locSingNAdjective(Y);locSingNPronoun(X), locSingNAdjective(Y)).

locSingMNoun([locSingMNoun]).%% defining singular nouns
locSingFNoun([locSingFNoun]).
locSingNNoun([locSingNNoun]).

locSingMPronoun([locSingMPronoun]).%% defining singular pronouns
locSingFPronoun([locSingFPronoun]).
locSingNPronoun([locSingNPronoun]).

locSingMAdjective([ ]).%% defining singular adjectives
locSingMAdjective([locSingMAdjective]).
locSingFAdjective([ ]).
locSingFAdjective([locSingFAdjective]).
locSingNAdjective([ ]).
locSingNAdjective([locSingNAdjective]).

%%%locPlurNounPhrase%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%% DOES A LOCATIVE PLURAL EXIST??
locPlurNounPhrase(X,Y):- (locPlurMNounPhrase(X,Y);locPlurFNounPhrase(X,Y);locPlurNNounPhrase(X,Y)).
locPlurMNounPhrase(X,Y):-locPlurMNoun(X), locPlurMAdjective(Y).
locPlurFNounPhrase(X,Y):-locPlurFNoun(X), locPlurFAdjective(Y).
locPlurNNounPhrase(X,Y):-locPlurNNoun(X), locPlurNAdjective(Y).

locPlurMNoun([locPlurMNoun]).%% defining Plural nouns
locPlurFNoun([locPlurFNoun]).
locPlurNNoun([locPlurNNoun]).

locPlurMAdjective([ ]).%% defining Plural adjectives
locPlurMAdjective([locPlurMAdjective]).
locPlurFAdjective([ ]).
locPlurFAdjective([locPlurFAdjective]).
locPlurNAdjective([ ]).
locPlurNAdjective([locPlurNAdjective]).