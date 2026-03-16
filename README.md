l'objectif du code était de créer l'interface pour la lecture des mail
il fallait enregistrer les éléments dans un UiState afin de garantir de ne pas supprimer les données lors du passage en paysage,
il fallait intégrer un bouton de suivi/favoris dans l'interface qui doit rester dans son état lors le passage en paysage.

Au final : les données sont bien enregistrée dans un UiState donc elles sont conservées lors du changement d'orientation, 
en revanche, les icones des boutons sont toujours en construction, le bouton ne change pas d'état lorsque l'on appuie dessus
et les deux boutons qui sont censés être en bas sont tout en haut
