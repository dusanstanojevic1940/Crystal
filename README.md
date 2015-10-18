# Crystal
Just another language
<br>
Crystal je moj lični programski jezik.
<br>
Crystal je funkcionalan programski jezik namenjen pisanju kratkih interaktivnih skripti.
<br>
Crystal dolazi sa standardnom bibliotekom koja definiše naredne metode:
<br>
"SUM"<br>
"DIV"<br>
"MUL"<br>
"MINUS"<br>
"PRINT"<br>
"READ"<br>
"CLOSE"<br>
"RANDOM"<br>
"TO_NUMBER"<br>
"TO_TEXT"<br>
"FOR_"<br>
"IF_"<br>
"NEGATE"<br>
"EQ"<br>
"LT"<br>
"GT"<br>
<br>
Komentari počinju #.
<br>
Crystal počinje vaš kod izvršavanjem main metode.
<br>
Hello World:
<br>
main
	PRINT_1='Unesite svoje ime'
	PRINT
	
	READ
	
	SUM_1='Uneli ste '
	SUM_2=READ_RESULT
	SUM
	
	PRINT_1=SUM_RESULT
	PRINT


<br>
Postoje dve vrste promenjljivih brojevi i tekst, boolean vrednost tačno je ekvivalent teksta 'true'.
Svaki tekst počinje i završava se sa '
<br>
Crystal podržava petlje i uslove:
	FOR_ONE_1=10
	FOR_ONE_2='blok_za_for'
	FOR_ONE
	
blok_za_for
	PRINT_1=FOR_ONE_COUNTER
	PRINT
<br>
Promenjljive se metodama prosleđuju kao globalne promenjljive, konvencija je da se parametri zovu isto kao i pozvana funkcija.
	test_metoda_1=40
	test_metoda
	
test_metoda
	SUM_1='Prvi argument je '
	SUM_2=test_metoda_1
	SUM
	PRINT_1=SUM_RESULT
	PRINT
	
