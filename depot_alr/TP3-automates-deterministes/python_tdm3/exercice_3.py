from automate_det import AutomateDet, verifie_automate
from exercice_1 import evaluation


def u_star(u: str, alphabet: list[str]) -> AutomateDet:
    """Retourne un DFA qui accepte ``u*``. ``u`` doit être non vide.

    >>> A = u_star('ab', ["a", "b"])
    >>> verifie_automate(A)
    >>> evaluation(A, '') and evaluation(A, 'ab' * 100)
    True
    >>> evaluation(A, 'aba')
    False
    >>> B = u_star('aba', ["a", "b"])
    >>> evaluation(B, '') and evaluation(B, 'abaaba')
    True
    >>> evaluation(B, 'abaab')
    False
    """
    if not u:
        raise ValueError("u doit être non vide")

    first_letter = u[0]

    automate = {
            "alphabet" : alphabet,
            "states" : [],
            "initial" : "start",
            "accepting" : [],
            "transitions" : {}
        }
    for i in range(len(u)):
        if i == 0:
            etat = "start"
        else:
            etat = "q"+str(i)
        automate["states"].append(etat)
        automate["transitions"][etat] = {}
            
    automate["states"].append("dead")
    automate["transitions"]["dead"] = {}
    
    dernier = automate["states"][len(u)]
    automate["accepting"].append(dernier)
    automate["accepting"].append("start")
    
    for i in range(len(u)):
        etat = automate["states"][i]

        if i == len(u)-1:
            suivant = "start"
        else:
            suivant = automate["states"][i+1]
    
        for j in alphabet:
            if j == u[i]:
                automate["transitions"][etat][j] = suivant
            else:
                automate["transitions"][etat][j] = "dead"
    
    for i in alphabet:
        if i == first_letter:
            automate["transitions"][dernier][i] = "start"
        else:
            automate["transitions"][dernier][i] = "dead"
        automate["transitions"]["dead"][i] = "dead"
    
    return automate