input(Name) :-
    write('enter your Name: '),
    read(Name).

output(Name) :-
    write('Hello '), write(Name), nl.

main :-
    input(Name),
    output(Name).