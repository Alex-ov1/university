from pathlib import Path
from automates import *
from automate_det import AutomateDet, charge_automate
from automate_det import verifie_automate

DOSSIER_AUTOMATES = Path(__file__).parent / "automates"


def ab_etoile() -> AutomateDet:
    """Charge l'automate qui reconnaît (ab)*."""
    return charge_automate(DOSSIER_AUTOMATES / "ab_etoile.json")


def taille_au_plus_3() -> AutomateDet:
    """Charge l'automate des mots de longueur au plus 3."""
    return charge_automate(DOSSIER_AUTOMATES / "taille_au_plus_3.json")
