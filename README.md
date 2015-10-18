# Crystal
Just another language

Crystal je moj lični programski jezik.

Crystal je funkcionalan programski jezik namenjen pisanju kratkih interaktivnih skripti.

Crystal dolazi sa standardnom bibliotekom koja definiše naredne metode:

"SUM"
"DIV"
"MUL"
"MINUS"
"PRINT"
"READ"
"CLOSE"
"RANDOM"
"TO_NUMBER"
"TO_TEXT"
"FOR_"
"IF_"
"NEGATE"
"EQ"
"LT"
"GT"

Komentari počinju #.

Crystal počinje vaš kod izvršavanjem main metode.

Hello World:
main
  PRINT_1='Unesite svoje ime'
	PRINT
	
	READ
	
	SUM_1='Uneli ste '
	SUM_2=READ_RESULT
	SUM
	
	PRINT_1=SUM_RESULT
	PRINT



Postoje dve vrste promenjljivih brojevi i tekst, boolean vrednost tačno je ekvivalent teksta 'true'.
Svaki tekst počinje i završava se sa '

Crystal podržava petlje i uslove:
	FOR_ONE_1=10
	FOR_ONE_2='blok_za_for'
	FOR_ONE
	
blok_za_for
  PRINT_1=FOR_ONE_COUNTER
  PRINT

Promenjljive se metodama prosleđuju kao globalne promenjljive, konvencija je da se parametri zovu isto kao i pozvana funkcija.
	test_metoda_1=40
	test_metoda
	
test_metoda
	SUM_1='Prvi argument je '
	SUM_2=test_metoda_1
	SUM
	PRINT_1=SUM_RESULT
	PRINT
	
