homem(miguel).
homem(joao).
homem(pedro).
homem(marco).
homem(carlos).

mulher(maria).
mulher(paula).
mulher(carla).
mulher(cristina).
mulher(ana).

clube(porto).
clube(academica).
clube(sporting).
clube(benfica).
clube(setubal).

animal(raposa).
animal(cavalo).
animal(tartaruga).
animal(cao).
animal(gato).

bebida(agua).	
bebida(cha).
bebida(leite).
bebida(sumo).
bebida(cafe).

cor(amarela).
cor(azul).
cor(vermelha).
cor(branca).
cor(verde).

casa(1).
casa(2).
casa(3).
casa(4).
casa(5).

pref(miguel,paula,5).
pref(miguel,ana,4).
pref(miguel,maria,3).
pref(miguel,carla,2).
pref(miguel,cristina,1).

pref(maria,carlos,5).
pref(maria,miguel,4).
pref(maria,marco,3).
pref(maria,joao,2).
pref(maria,pedro,1).

pref(joao,maria,5).
pref(joao,paula,4).
pref(joao,carla,3).
pref(joao,cristina,2).
pref(joao,ana,1).

pref(paula,marco,5).
pref(paula,carlos,4).
pref(paula,joao,3).
pref(paula,miguel,2).
pref(paula,pedro,1).

pref(pedro,paula,5).
pref(pedro,carla,4).
pref(pedro,ana,3).
pref(pedro,cristina,2).
pref(pedro,maria,1).

pref(carla,miguel,5).
pref(carla,marco,4).
pref(carla,joao,3).
pref(carla,pedro,2).
pref(carla,carlos,1).

pref(marco,maria,5).
pref(marco,carla,4).
pref(marco,paula,3).
pref(marco,cristina,2).
pref(marco,ana,1).

pref(cristina,pedro,5).
pref(cristina,joao,4).
pref(cristina,marco,3).
pref(cristina,miguel,2).
pref(cristina,carlos,1).

pref(carlos,ana,5).
pref(carlos,carla,4).
pref(carlos,paula,3).
pref(carlos,maria,2).
pref(carlos,cristina,1).

pref(ana,marco,5).
pref(ana,joao,4).
pref(ana,pedro,3).
pref(ana,carlos,2).
pref(ana,miguel,1).

casado(X,Y) :- homem(X), mulher(Y).
adepto(X,Y) :- homem(X); casa(X), clube(Y).

adepto(X,Y) :- homem(X); casa(X), clube(Y).
corCasa(X,Y) :- casa(X), cor(Y), X!=1, Y != amarela.
