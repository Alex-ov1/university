from automate_det import AutomateDet, verifie_automate
from exercice_1 import evaluation

def singleton(u: str, alphabet: list[str]) -> AutomateDet:
    """Retourne un DFA qui n'accepte que le mot ``u``.

    >>> A = singleton('ab', ["a", "b"])
    >>> verifie_automate(A)
    >>> evaluation(A, 'ab')
    True
    >>> evaluation(A, '') or evaluation(A, 'aba')
    False
    """
    automate = {
        "alphabet" : alphabet,
        "states" : [],
        "initial" : "start",
        "accepting" : [],
        "transitions" : {}
    }
    for i in range(len(u)+1):
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

    for i in range(len(u)):
        etat = automate["states"][i]
        suivant = automate["states"][i+1]

        for j in alphabet:
            if j == u[i]:
                automate["transitions"][etat][j] = suivant
            else:
                automate["transitions"][etat][j] = "dead"

    for i in alphabet:
        automate["transitions"][dernier][i] = "dead"
        automate["transitions"]["dead"][i] = "dead"

    return automate
