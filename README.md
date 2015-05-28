  ***Introducere***
  
   Proiectul consta in realizarea unei aplicatii de mici dimensiuni, al carei scenariu sa fie inspirat din viata reala.
   In realizarea aplicatiei se vor implementa cateva dintre design patternurile studiate la curs,corespunzatoare 
   scenariului abordat. La final se va testa corectitudinea implementarii prin realizarea de teste unitare, folosind JUnit Testing.
   
  ***Scenariu Aplicatie***
  
  Aplicatia isi propune sa simuleze o licitatie. Entitatile care interactioneaza in acest scenariu sunt: Client, Product si Auction
  Un client poate licita pentru un produs, in anumite conditii. In continuarea voi exemplica structura celor doua entitati.
  
  Un PRODUS se caracterizeaza prin:
  - denumire
  - categorie
  - bid minim (valoare minima de la care incepe licitarea)
  - bid curent (valoarea ultimei licitari)
  
  OBS! Categoriile utilizate in aplicatie sunt: Jewellery, Paintings si Others. In functie de categoria din care face parte obiectul
  supus licitatiei, bid-ul minim are o valoare diferita. Initial bidul minim si bidul curent au aceeasi valoare.
  
  Un CLIENT are proprii urmatoarele atribute:
  - nume
  - lista cu produsele pe care le-a obtinut in urma licitatiei.
  
  OBS! Un client nu poate licita pentru un produs cu o suma inferioara bidului minim sau bidului curent.
  
  
  ***Design patternuri implementate***

  
  1. Builder - pentru crearea unui obiect complex, de tip Auction, prin setarea/actualizarea valorilor campurilor.
  2. Chain of Responsability pentru setarea bidului minim al fiecarui produs oferit spre licitatie, in functie de categoria din
  care produsul face parte.
  3. Factory -  pentru lucrul cu fisiere Excel. Fisierele Excel au fost folosite pentru stocarea datelor de test in 
  efectuarea testelor unitare. In functie de versiunea de Excel disponibila (.xls sau .xlsx) un factory va crea un obiect 
  corespunzator si se va ocupa cu parsarea acestuia.
  
  
  ***Functionalitati implementate***

  - licitare produs, in conditiile impuse mai sus. In caz contrar, tentativa va fi atentionata prin aruncarea de exceptii create
  de utilizator: LowerThanMinBidValueException si LowerThanCurrentBidException
  - procesare input din fisier, recunoasterea obiectelor de tip Product si stabilirea bidului minim in functie de categorie.
  - functionalitati in scop estetic, cum ar fi formatarea datei pentru afisarea intr-un format preferat de utilizator
  - funcionalitati ajutatoare pentru converia in/din diferite formate. Exemplu: din String in Date si viceversa.
  
  ***Teste realizate***

  Testele realizate au in vedere verificarea corectitudinii metodelor create. In acest sens s-au gandit mai multe cazuri de 
  testare, ce "acopera" cat mai multe posibilitati. 
  1. testare metoda care seteaza bid minim, dupa categorie. Pentru "Jewellery" bidul de start este 2000, pentru "Paintings" 
  este 3000, iar pentru "Others" este 500.
    -inputul precum si outputul asteptat au fost furnizate de fisierul Excel.
  2. testare metoda ce permite clientului sa liciteze pentru un produs, tinand cont de conditiile enuntate mai sus. S-au luat 
  in calcul diferite cazuri de testare. Datele folosite in aplicarea testelor au fost citite dintr-un fisier .csv.
  
  OBS! 
  - Clasele de test au fost rulate prin intermediul unui Runner, dar si prin implementarea unui Test Suite.
  - Au fost folosite obiecte mock pentru simularea resurselor indisponibile, acolo unde a fost cazul.
  
  
  


