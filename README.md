![Cover](https://user-images.githubusercontent.com/101304191/206330668-9b093515-5285-4955-8331-95bac419d53b.png)



# einfachtierisch
Final ExamProjekt


AbschlussprüfungProjekt Einfach tierisch .....

Hallo liebe Leser und Leserinnen

Dieses Projekt ist meine Abschlussprüfung zum Android Junior Developer im Syntax Institut und das Thema war mein persönlicher Herzenswunsch, 
da ich erstens selber einen Hund besitze und weiss wie wichtig manchmal Unterstützung ist sei es drum um welche Art und Weiße,
es sich dabei handelt. Deshalb wollte ich eine Social Media App entwicklen bei der sich Hundeliebhaber und Hundehalter in Kontakt treten können und miteinander schreiben, sich Treffen vereinbaren können und oder alles andere, was den Hund und den Hundbesitzer betrifft besprechen. Natürlich eine Funktion für die Hundepatenschaft, bei der Sie diesen Hund und seine Familie nur dann unterstützen können, wenn die Situation dies erfordert in Planung.

Implementierte Funktionen

Als Intent

Facebook
Instagram 
Github

Sie können sich in der App authentifiezieren und anmelden (die Memberdaten werden in Firebase gespeichert)
Nach erfolgreichen Login wird man automatisch zum DashFragment navigiert

Danach kann man sein Profil vervollständigen wo auch wieder Daten in den Firebase Storage gelangen

Anschliessend kan man sich alle Hunderassen anschauen und sich informieren (Daten kommen aus einer API

Sie können sich in der App anmelden und registrieren, danach gelangen Sie zu einem Dashboard, wo der Rest der Navigation übernommen wird. Sie können eine neue Anfrage hinzufügen, wo andere Benutzer sie sehen und kommentieren können!!

![Bildschirm­foto 2022-12-07 um 12 36 32](https://user-images.githubusercontent.com/101304191/206327505-f66bc0e4-53d5-4ae7-bbcf-e46e3e05015e.png)

Zur Registrierung

Hier könnt ihr euch in aller Ruhe registrieren.
und alles was ihr dazu braucht ist eine Emailaddresse 
und ein Passwort mit dazugehörigem Nickname


![Bildschirm­foto 2022-12-07 um 12 36 56](https://user-images.githubusercontent.com/101304191/206327385-c2e4e0e8-4661-470c-8047-5d4f14a57115.png)
![Bildschirm­foto 2022-12-07 um 12 39 23](https://user-images.githubusercontent.com/101304191/206327409-86e164d4-7db7-4c2e-8c8f-a0b9fe803a2e.png)
![Bildschirm­foto 2022-12-07 um 12 36 10](https://user-images.githubusercontent.com/101304191/206327498-7fb503fb-b395-4151-95ab-1536c705a95f.png)

Verwendet wurden MVVM Architecture

Fragments

- NavHostFragment
- Nav_Graphen

Adapter 

- für die HundeAPI ein DogAdapter 
- und der MessageAdapter 
- sowie eine ContactAdapter

MainViewModel

- Wo alle LiveDatas gespeichert werden und alle Möglichen Funktionen für die App liegen.

Das Repository

- verwaltet momentan noch Hardgecodete Texte die in einer RecyclerView angezeigt werden sollen 
- aber dies wird erst nach Abschluss des Moduls passieren

HelpDeskFragment soll dem HilfeRequest entsprechen wenn irgendwelche Userfragen 
an den Support gehen aber dieser ist noch nicht fertig implementiert

MessageAdapter 

Dem User ist es möglich seine zuletzt erhaltene Nachricht im 
ContactFragment zusehen.



Ansonsten wünsche ich euch noch viel Freude mit dem Anschauen meines Repos 
und bis dahin wünsche ich euch alles gute und vielleicht bis bald.



