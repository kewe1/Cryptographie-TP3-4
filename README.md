# Cryptographie-TP3-4

TP fait en java
## Exercice 1 :
1) Utilisation de la librairie java.security pour hacher un mot de passe

2) Utilisation du fichier ods5.txt donnée dans le tp.
    Nous avons utilise une fonction a part qui trqnsforme les byte en bit et donne un type string, 
    afin aue cela soit plus rapide.
    Nous avons fait les tests avec le mot bonjour
    Nombre essaies
        pour 5 bits : 29
        pour 6 bits : 45
        pour 7 bits : 45
        pour 8 bits : 45
        pour 9 bits : 836
        pour 10 bits : 1071

    La propriete des fonctions de hachage est la resistance aux collisions
3) Nous avons trouve une collision sur le mot abaca au bout de 7 essaie avec 5 bits
    6 bits: 7 avec le mot abaca
    7 bits: 7 avec le mot abaca
    8 bits: 172 avec le mot abatardis
    9 bits: 172 avec le mot abatardis
    10 bits: 172 avec le mot abatardis

## Exercice 2 : 
    On remarque que en utilisant la même clé et le même message en utilisant SHA1 puis SHA512 on obtient :
        -Un résultat différent en octet et en hexadécimal
        -Une longueur différente (SHA1 : 40 caractères / 160 bits | SHA512 : 128 caractères / 512 bits ) 