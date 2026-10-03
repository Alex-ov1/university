import json
from pathlib import Path
from typing import Any, TypeAlias


AutomateDet: TypeAlias = dict[str, Any]


def charge_automate(chemin: str | Path) -> AutomateDet:
    """Charge et valide un automate déterministe écrit en JSON."""
    with open(chemin) as fichier:
        automate = json.load(fichier)
    verifie_automate(automate)
    return automate


def sauvegarde_automate(automate: AutomateDet, chemin: str | Path) -> None:
    """Sauvegarde un automate dans un fichier JSON lisible."""
    verifie_automate(automate)
    with open(chemin, "w") as fichier:
        json.dump(automate, fichier, ensure_ascii=False, indent=2)
        fichier.write("\n")


def verifie_automate(automate: AutomateDet) -> None:
    """Lève ValueError si ``automate`` n'est pas un DFA JSON complet."""
    champs = {"alphabet", "states", "initial", "accepting", "transitions"}
    if set(automate) != champs:
        raise ValueError(f"Champs attendus : {sorted(champs)}")

    alphabet = automate["alphabet"]
    states = automate["states"]
    initial = automate["initial"]
    accepting = automate["accepting"]
    transitions = automate["transitions"]

    if not states or len(states) != len(set(states)):
        raise ValueError("La liste states doit être non vide et sans doublon")
    if len(alphabet) != len(set(alphabet)) or any(
        not isinstance(lettre, str) or len(lettre) != 1 for lettre in alphabet
    ):
        raise ValueError("Chaque lettre de alphabet doit être une chaîne de longueur 1")
    if initial not in states:
        raise ValueError(f"L'état initial {initial!r} n'est pas déclaré")
    if not set(accepting).issubset(states):
        raise ValueError("Un état acceptant n'est pas déclaré dans states")
    if set(transitions) != set(states):
        raise ValueError("transitions doit contenir exactement une entrée par état")

    for state in states:
        if set(transitions[state]) != set(alphabet):
            raise ValueError(
                f"L'état {state!r} doit avoir exactement une transition par lettre"
            )
        for lettre, cible in transitions[state].items():
            if cible not in states:
                raise ValueError(
                    f"La transition ({state!r}, {lettre!r}) vise l'état inconnu {cible!r}"
                )
