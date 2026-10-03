from automate_det import AutomateDet
from exemples import ab_etoile, taille_au_plus_3
from automate_det import verifie_automate

def delta_etoile(A: AutomateDet, etat: str, u: str) -> str:
    """Retourne l'état atteint après lecture de ``u`` depuis ``etat``.

    Le mot ``u`` est supposé appartenir à ``A["alphabet"]*``.

    >>> A = ab_etoile()
    >>> delta_etoile(A, "start", "")
    'start'
    >>> delta_etoile(A, "start", "a")
    'after_a'
    >>> delta_etoile(A, "start", "abab")
    'start'
    >>> delta_etoile(A, "after_a", "b")
    'start'
    """
    state = etat
    for i in range(len(u)):
        state = A["transitions"][state][u[i]]
    return state


def evaluation(A: AutomateDet, u: str) -> bool:
    """Retourne si le mot ``u`` est accepté par l'automate ``A``.

    >>> A = ab_etoile()
    >>> evaluation(A, '')
    True
    >>> evaluation(A, 'ab')
    True
    >>> evaluation(A, 'ab' * 100)
    True
    >>> evaluation(A, 'ababaabab')
    False
    >>> evaluation(A, 'abc')
    False
    >>> B = taille_au_plus_3()
    >>> evaluation(B, 'aba')
    True
    >>> evaluation(B, 'abab')
    False
    """
    for i in u:
        if i not in A["alphabet"]:
            return False
    state = delta_etoile(A, A["initial"], u)
    return state in A["accepting"]
