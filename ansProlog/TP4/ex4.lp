% instance
set(1). element(1,a). element(1,b). element(1,c).
set(2). element(2,a). element(2,c). element(2,d).
set(3). element(3,b). element(3,c). 

% 



%podesse colocar u limite inferior e superior, antes e depois do "{"
{select(X) : element(Y,X)} :- set(Y).

select(X) :- element(Y,X), set(Y).

% apenas mostra os selects
#show select/1.




%////////////////////////////EX. 4.2////////////////////////////////

% instance
vertex(1). vertex(2). vertex(3). vertex(4). vertex(5). vertex(6).
edge(1,2). edge(1,3). edge(2,4). edge(3,5). edge(4,5). edge(4,6).
threshold(2).

edge(X,Y) :- edge(Y,X).

{test(X): vertex(X)}2:- threshold(2).

reach(Y) :- vertex(X), select(X), vertex(Y), not select(Y), edge(X,Y).

:- vertex(X), not select(X), not reach(X).

#show select/1.

%////////////////////////////EX. 4.3////////////////////////////////

%instance
vertex(1). vertex(2). vertex(3). vertex(4). vertex(5). vertex(6).
edge(1,2). edge(1,3). edge(2,4). edge(3,5). edge(4,5). edge(4,6).
threshold(3).

{select(X): vertex(X)}3:- threshold(3).

covered(X,Y) :- edge(X,Y), select(X).
covered(X,Y) :- edge(X,Y), select(Y).

:- edge(X,Y), not covered(X,Y).

#show select/1.
