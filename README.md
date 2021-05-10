# NanuElenaCristina SIMPRE 2021
CloudComputing - Documentatie - Crearea unei aplicatii mobile

#Introducere

In general, persoanele doresc sa retina diverse referinte sau note pentru a obtine date si informatii cat mai rapid din materialul pe care il parcurg. De exemplu, un student vrea sa-si noteze un titlu de la o anumita publicatie si autorul ce a scris acest document pentru a-si completa bibliografia din licenta. Acum, el isi retine aceste date intr-un document de tip „.txt”, dar dezavantajul este ca foarte probabil ca acea informatie sa se piarda din diverse motive.
Din acest motiv, am realizat aplicatia documentata mai jos care va putea stoca rapid toate aceste informatii. Mai mult, utilizatorul nu mai este nevoit sa caute datele in diferite surse, deoarece le poate gasi pe toate in cadrul acestei aplicatii.

Aplicatia urmareste sa centralizeze diferite referinte bibliografice pentru a facilita cautarile. Crearea unui cont sau logarea in contul deja creat este una simpla. Aplicatia nu doreste sa ingreuneze descoperirea acestor informatii. Astfel putem spune ca aceasta este user-friendly. De asemenea, cautarea de referinte, dar si adaugarea uneia noi este simpla. 

#Descrierea problemei

Obiectivul principal al aplicatiei este de a memora si gestiona facil diferite referinte bibliografice pentru ca utilizatorului sa ii fie usurata munca, iar aceste date sa nu se mai piarda.
Aplicatia ofera cautari pentru referinte bibliografice din cadrul Facultatii de Cibernetica, Statistica si Informatica Economica, deci se poate spune ca aceasta este realizata special pentru studentii/cadrele didactice sau persoanelor ce doresc sa memoreze diverse informatii din domeniul informatic. Insa aceasta lista de cautari este una limitata, astfel incat utilizatorul isi poate adauga diverse referinte din cadrul oricarui domeniu, fie ca vorbim de un domeniu tehnic/economic etc. sau doar de sport/cultura etc. 

Deoarece forma obiectului centralizat (referinta bibliografica) este mai mult folosita de catre studenti, se poate spune ca aplicatia este destinata tinerilor, dar acest lucru este doar aparent.  Orice persoana ce doreste a-si nota diverse carti/publicatii etc. poate utiliza aceasta aplicatie.De exemplu, un adult doreste sa-si centralizeze toate cartile pe care le-a citit, sau doreste sa le citeasca. Aplicatia este perfecta pentru aceasta actiune.

#Google MAPS

##Descrierea API

Un beneficiu pe care-l aduce acest mediu de dezvoltare (Android Studio) este reprezentat de multitudinea de API-uri (Google App Engine) ce le putem integra si folosi. Acest lucru se datoreaza faptului ca Android Studio este creat de catre Google. Ele sunt extrem de utile, iar printre acestea se numara API-uri pentru integrarea Google Maps, Gmail, Health, Google+, Drive.

API-ul de la Google Maps este alcatuit dintr-un set de metode ce returneaza informatii cu privire la datele de locatie. El poate ajuta dezvoltatorul prin date cu privire la latitudinea si longitudinea unei locatii, o adresa anume, dar si o harta pe care utilizatorul o poate vizualiza pe dispozitivul sau.
Google Maps are o acoperire de 99% din toate cele 200 de tari observate. Ba mai mult, exista aproximativ 25 de milioane de actualizari si modificari zilnice. Deci, o precizie destul de mare.
Acest cloud ofera diverse harti care reusesc sa aduca utilizatorilor finali sentimentul de realitate, cu ajutorul acestor harti statice, dar si dinamice, optiunea de Street View, dar si 3600 views. De asemenea, gasim rute, utile pentru a realiza cel mai optim drum, dar si locuri (Places), care ajuta utilizatorul sa descopere imprejurimile cu ajutorul vastelor informatii (peste 150 milioane de locatii inregistrate). 

Daca pana acum am vorbit despre afisarea hartilor pentru utilizator in functie de cererea acestuia, aflam ca Google Maps poate furniza, de asemenea, si date despre o locatie, compuse din latitudine si longitudine sau chiar date despre o adresa exacta.

##Fluxul de date

Pentru folosirea acestui tip de activitate, atunci cand se selecteaza, se va crea un fisier de resurse, ce se va afla în folder-ul values. Aici se regasesc informatii cu privire la accesarea cheii. Astfel, se deschide acel link, se preia cheia și se adauga in locul indicat:
De asemenea, pentru functionarea acestui serviciu, s-a adaugat in fisierul manifest, cat si permisiunea:
In interiorul acestei activitati, se observa ca aceasta clasa implementeaza interfata OnMapReadyCallback. Astfel, se suprascrie metoda onMapReady(). Aceasta se acceseaza doar in momentul in care harta este pregatita pentru a fi deschisa, folosita. Mai exact, atunci cand o instanta a acestei interfete este asociata unui obiect de tip MapFragment (in cazul de fata, SupportMapFragment). 
Metoda suprascrisa va instantia atributul clasei, mMap, de tip GoogleMaps. Parametrul ce insoteste metoda este nenul si este initializat in metoda onCreate().
Un obiect de tip LatLng va primi coordonatele cinematografului. Aceste coordinate sunt preluate manual. Se adauga un marker pe harta cu ajutorul metodei addMarker(). Se precizeaza coordonatele stabilite anterior prin metoda position() si se adauga un titlu. In cazul nostru, titlul este denumirea cinematografului. Instanta de tip harta va prelua valorile stabilite anterior cu ajutorul metodei moveCamera() si a parametrului acesteia, CameraUpdateFactory. Ea va stabili noile coordonate si va mari zona de vizualizare a hartii prin metoda newLatLngZoom. Aceasta primeste ca parametri coordonatele, dar si numarul ce comunica de cate ori se va realiza zoom-ul.

#FIREBASE

##Descrierea API

Firebase este o platforma de dezvoltare a aplicatiilor mobile si web care ofera dezvoltatorilor o multitudine de instruente si servicii pentru a le ajuta sa dezvolte aplicatii de inalta calitate si pentru a-si spori profitul.
Firebase ofera foarte multe functionalitati pentru focusare asupra utilizatorilor si o mult mai buna gestionare a informatiilor, cele mai renumite dintre acestea fiind: Analytics, Database, Messaging si Crash Reporting.

Firebase este dezvoltat pe o infrastructura specifica Google-ului. Produsele oferite de acest API lucreaza foarte bine individual, insa ele au un sistem de share extrem de bine pus la punct, deci o utilizare variata a mai multor servicii in aceeasi aplicatie ar putea fi o alternativa mult mai buna.
Pentru aplicatia creata, am ales sa folosesc Firebase, mai exact serviciul de storage cloud, Firebase Realtime Database, utilizata sa stocheze toti utilizatorii care se vor loga.

Firebase Realtime Database reprezinta un serviciu cloud ce poate fi integrat de catre iOS, Android sau aplicatii web si are ca scop stocarea documentelor si a fisierelor cu format JSON. Astfel, fiecare informatie este o cheie sau o valoare. Aceasta este o baza de date NoSQL si este menita sa realizeze interogari simple si rapide.
O caracteristica foarte importanta a acestei tehnologii este reprezentata de realizarea de actualizari în momentul in care dispozitivul nu este conectat la internet. Deci, atunci cand s-au comis schimbari, Firebase le sincronizeaza automat in momentul in care dispozitivul se reconecteaza.

Faptul ca Firebase foloseste formatul JSON ca mod de stocare a datelor reprezinta un mare plus, deoarece modalitatea de lucru cu astfel de fisiere este foarte usoara.
Firebase implementeaza un strat consistent de securitate, deoarece dezvoltatorul are ocazia sa-si impuna anumite reguli, cu ajutorul Firebase Realtime Database Security Rules. Datorita acestei caracteristici, utilizatorul are autorizatie sa realizeze citiri sau scrieri doar în momentul in care acesta este autentificat. Actiunea poate avea loc prin Firebase Authentication.

Metode HTTP. Request/Response: 
Acest serviciu foloseste sincronizarea in locul tipicului request HTTP, de unde rezulta ca de fiecare data cand o informatie este modificata, orice device care este conectat la aceasta baza de date va primi modificarile in cateva milisecunde. 

O veste buna este aceea ca aceasta platforma este gratis, in limita a o suta de conectari simultane si o limita de memorie de 1 GB.
Firebase Realtime Database poate fi vizualizata fara ajutorul unei alte aplicatii, ci doar cu un browser sau eventual, direct de pe un dispozitiv mobil.

##Fluxul de date

Baza de date Firebase Realtime permite construirea de aplicatii bogate, de colaborare, permitand accesul securizat la baza de date direct din codul clientului. Datele sunt persistente la nivel local si, chiar si in timp ce sunt offline, evenimentele in timp real continua sa se declanseze, oferind utilizatorului final o experienta receptiva. 
Cand dispozitivul isi recapata conexiunea, baza de date Realtime sincronizeaza modificarile de date locale cu actualizarile de la distanta care au avut loc in timp ce clientul era offline, fuzionand automat conflictele.

Firebase Realtime detine o serie de reguli, acestea fiind grupate sub denumirea de Firebase Realtime Database Security Rules, pentru a defini modul in care trebuie sa fie structurate datele si cand pot fi citite sau scrise. Atunci cand sunt integrate cu autentificarea Firebase, dezvoltatorii pot defini cine are acces la ce date si cum pot sa le acceseze.
Atunci cand se insereaza in baza de date, se creeaza o cheie unica pentru fiecare inregistrare. In urmatorul screenshot, vom observa ca fiecare inregistrare (referinta) detine o cheie primara generata aleator, in tabela listaMea:

#Autentificarea in aplicatie - Logarea/Crearea unui cont

Aplicatia se va deschide cu o pagina de logare. Se poate observa ca parola prezinta un sistem de securizare pentru a nu fi observata si de alte persoane.

In cazul in care utilizatorul nu detine un cont, acesta poate accesa un buton de creare. Se va deschide o noua activitate in care user-ul isi va putea salva un cont. Si de data aceasta, parola este securizata. Dupa conectarea utilizatorului, se deschide o activitate ce va retine toate referintele salvate. Daca user-ul tocmai si-a creat un cont, atunci aceasta pagina va fi goala.

#Utilizarea aplicatiei

Daca utilizatorul doreste sa-si introduca o noua referinta manual, atunci acesta va accesa meniul din dreapta, sus, „Adauga”. Se deschide o pagina noua. Se completeaza datele din aceasta pagina, apoi se acceseaza butonul „AUTORI” . Aici se va introduce autorul. Cu ajutorul butonului „ADAUGA”, se va reveni la pagina anterioara si se va da click pe butonul cu acelasi nume.

Pentru a vizualiza o referinta, atunci utilizatorul va da click pe titlul dorit. Pentru a-i usura munca, utilizatorul va primi la fiecare actiune cate un mesaj pe ecran. Pentru a vedea lista cu referinta adaugata, user-ul acceseaza butonul de revenire al telefonului. In „Lista mea”, se va da refresh la pagina cu ajutorul butonului ce poarta acelasi nume. 

Pentru a vizualiza date despre persoana ce a realizat aceasta aplicatie, atunci se va accesa din meniul din dreapta, sus, optiunea „Despre”. In pagina noua se poate afla si contactul persoanei, cu ajutorul butonului „CONTACT”. Se va deschide o pagina noua Google Maps.

Pentru a vizualiza lista actualizata, se va folosi iar butonul „REFRESH”.

O referinta va fi adaugata in baza de date de tip Firebase atunci cand se va efectua actiunea de „long click” pe referinta dorita.

#Implementarea - Tehnici folosite

##Activitatea Logare
            
Aceasta clasa contine trei textView-uri ca si etichete (Nume, Parola, Login - titlu), doua editText-uri in care se vor introduce datele si doua butoane, unul pentru conectare si unul pentru a crea un cont nou. 
Pentru a nu afisa parola, s-a introdus in layout-ul activitatii proprietatea android:password=”true”. 
Fundalul a fost inserat in layout cu ajutorul unui element din drawable. De asemenea, toate textele de la textView si butoane se afla in res/strings, iar culorile textului si cele ale butoanelor, tot in res/colors.
Activitatea contine si tehnica de „SharedPreferences”. Aceasta a fost realizata cu ajutorul metodei preferinte().
Toate conturile sunt salvate intr-o baza de date de tip SQLite. Astfel, atunci cand se acceseaza butonul „CONECTARE”, se apeleaza o clasa „Dao”. Aceasta clasa implementeaza o metoda ce verifica daca acest user face parte din baza de date. Daca nu, atunci se va afisa un mesaj ce comunica faptul ca user-ul nu este corect. Daca da, atunci se va deschide activitatea „PagPrincipala”, cu ajutorul unui intent. Deoarece este nevoie de user, se va transmite cu ajutorul metodei putExtra() numele de cont. Se va afisa un mesaj: „Conectare reusita!”.

 	
##Activitatea CreareUser

Butonul „CREARE CONT” va deschide o activitate noua cu ajutorul unui intent.
Aceasta activitatea are scopul de a crea un nou utilizator. S-au folosit tot trei textView-uri pt etichete si doua editText-uri pentru introducere de date. Butonul „CREARE CONT” va folosi un obiect de tip „Dao” ce va verifica daca user-ul exista cu ajutorul metodei existaUser(). Daca da, atunci se va afisa un mesaj corespunzator. In caz contrar, user-ul va fi introdus in baza de date si se va introduce pe ecran un mesaj: „Cont creat!”. Metoda finish() va inchide activitatea si va reveni la cea de logare.
Pentru crearea bazei de date „user” s-a folosit interfata „ConstanteDatabaseUser”.

##Activitatea PagPrincipala

Pentru a afisa toate referintele salvate, se foloseste un listView. Acesta foloseste un adaptor personalizat (clasa AdaptorReferinte) si va fi afisat doar titlul referintei (toate acestea se implementeaza cu metoda listare() ). Daca se doreste vizualizarea tuturor campurilor dintr-o referinta, atunci se va selecta referinta si cu ajutorul metodei setOnItemClickListener(). Se va deschide o alta activitate, „AfiseazaReferinta”.
Toate referintele salvate vor fi memorate intr-o tabela „referinta”. Aceasta foloseste interfata „ConstanteDatabaseReferinta”. Exista o legatura 1:n intre tabela „user” si tabela „referinta”.
Clasa „DatabaseHandler” implementeaza instructiunile de creare, respectiv stergere a celor doua tabele.
Daca se doreste memorarea unei referinte intr-o baza de date Firebase, atunci utilizatorul va realiza un long click pe referinta respectiva. Actiunea a fost facuta cu ajutorul metodei setOnItemLongClickLIistener(). 

Atunci cand se acceseaza butonul „REFRESH”, se apeleaza functia restart() si se listeaza iar listView-ul.
Pentru raport, butonul „RAPORT” foloseste metoda raport(). Se afiseaza un mesaj daca fisierul a fost creat cu succes. Fisierul va purta numele de „raportLista.txt”.
Activitatea contine un menuItem cu 2 comenzi: Despre, Adaugare. Se foloseste metoda suprascrisa onOptionsItemSelected(). Pentru afisarea acestul menuItem, s-a folosit un meniu, aflat in res/menu.

##Activitatea AfiseazaReferinta - au fost folosite textViews, referinta afisata din baza de date

Butonul „STERGE” va sterge referinta. Acesta foloseste metoda stergere(). 

Butonul „RAPORT” realizeaza aceeasi actiune ca la activitatea anterioara. Fisierul va fi salvat sub forma id_referinta.txt.

##Activitatea AdaugaReferinta - foloseste textViews pentru etichete si editTexts pentru completare

Butonul „AUTORI” va deschide o activitate noua (ScriereAutori) cu ajutorul metodei deschidePaginaAutori() pentru a completa si sectiunea de autori, in timp ce butonul „ADAUGA” va actualiza tabela „referinta” si va introduce referinta nou creeata, cu ajutorul unui obiect de tip „Dao”. Se va afisa un mesaj: „S-a adaugat o referinta”. Pentru a primi autorul din clasa accesata, s-a folosit metoa onActivityResult(). 

##Activitatea ScriereAutori

Cu ajutorul editText-urilor se vor introduce datele pentru autor. Metodele putExtra() si setResult() vor transmite autorul nou inapoi la activitatea „AdaugaReferinta”.

##Activitatea Despre

In interiorul acestei activitati se vor observa datele de contact ale persoanei ce a realizat aceasta aplicatie, cu ajutorul textView-urilor. 

Butonul „CONTACT” va deschide Google Maps si va arata locatia unde aceasta persoana ar putea fi gasita. Se foloseste un intent pentru a deschide activitatea Maps.
Sigla „CSIE” a fost preluata din directorul res/drawable, cu ajutorul unui imageView.
La sursa se afla: app:srcCompact=”@drawable/csie”.

##Activitatea Maps - Coordonatele din Google Maps din activitatea „Despre” sunt introduse in aceasta pagina. Aceasta este cea care ajuta la regasirea pe harta a locatiei din „CONTACT”.

 







