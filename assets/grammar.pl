%%% - make atom for each predicate
%%% - create method in java that places words in the order defined here
%%% - check if subject agrees with verb in java?
		
%%%note to self: maybe organize variables

s(X,Y,Z) :- subject(X), object(Y), verb(Z).%%VERB

%%ORDER
%%Sentences--> vocativePhrase, locativePhrase, nominativePhrase, accusativePhrase, verbPhrase
		%%Phrases--> genativePhrase, dativePhrase, ablativePhrase, relativeClause
				%% ~[m,f,n; plur,sing]
			%%Clauses--> Sentences
			
	%verbPhrase+=adverbs?? locative = accusative or in+abl.. 
	%ablative absolute
				
%A subject is an individual nominitive noun, a nominitive pronoun, or a nom. noun phrase
subject(X):- nomNoun(X);
		nomPronoun(X);
		nomNounPhrase(X,A).

%An object is an individual accusative noun, an accusative pronoun, or an acc. noun phrase	
object(Y):- accNoun(Y);
		accPronoun(X);
		accNounPhrase(Y,A).
		

%A nominitive noun phrase is a nom. noun/pronoun with its agreeing attributes
			%or a nom. relative clause[***DEFINE]
nomNounPhrase(X,A,B):- nomSingNoun(X), genNoun(A), nomSingAdj(B);	%*
			nomPlurNoun(X), genNoun(A), nomPlurAdj(B).	%*possessive genitives
		%;nomRelClause(B).

%%%%%%%%%% NOMINITIVE NOUN GENDERS DECLARATION
nomNoun(X):- nomSingNoun(X);
		nomPlurNoun(X).
		
nomSingNoun(X) :- nomSingMNoun(X);
		nomSingFNoun(X);
		nomSingNNoun(X).
		
nomPlurNoun(X) :- nomPlurMNoun(X);
 		nomPlurFNoun(X);
 		nomPlurNNoun(X).		
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


%%%%%%%%%% NOMINITIVE ADJECTIVE GENDERS DECLARATION

%%%%%%note to self: no "nomAdj(B)" because adjectives do not stand alone
nomSingAdj(B):- nomSingMAdj(B);
		nomSingFAdj(B);
		nomSingNAdj(B).

nomPlurAdj(B):- nomPlurMAdj(B);
		nomPlurMAdj(B);
		nomPlurMAdj(B).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


%%%%%%%%%% ACCUSATIVE NOUNS GENDERS DECLARATION
accNoun(Y):- accSingNoun(Y);
		accPlurNoun(Y).

genSingNoun(Y) :- accSingMNoun(Y);
		accSingFNoun(Y);
		accSingNNoun(Y).
		
genPlurNoun(Y) :- accPlurMNoun(Y);
 		accPlurFNoun(Y);
 		accPlurNNoun(Y).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


%%%%%%%%%% GENITIVE NOUNS GENDERS DECLARATION
genNoun(A):- genSingNoun(A);
		genPlurNoun(A).

genSingNoun(A) :- genSingMNoun(A);
		genSingFNoun(A);
		genSingNNoun(A).
		
genPlurNoun(A) :- genPlurMNoun(A);
 		genPlurFNoun(A);
 		genPlurNNoun(A).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%% DATIVE NOUNS GENDERS DECLARATION
datNoun(C):- datSingNoun(C);
		datPlurNoun(C).

datSingNoun(C) :- datSingMNoun(C);
		datSingFNoun(C);
		datSingNNoun(C).
		
datPlurNoun(C) :- datPlurMNoun(C);
 		datPlurFNoun(C);
 		datPlurNNoun(C).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%% ABLATIVE NOUNS GENDERS DECLARATION
ablNoun(D):- ablSingNoun(D);
		ablPlurNoun(D).

ablSingNoun(D) :- ablSingMNoun(D);
		ablSingFNoun(D);
		ablSingNNoun(D).
		
ablPlurNoun(D) :- ablPlurMNoun(D);
 		ablPlurFNoun(D);
 		ablPlurNNoun(D).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

 