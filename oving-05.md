# Øving 5 - Fullstack applikasjonsutvikling IDATT2105

Innleveringsfrist 31. mars.



## Del 01

Øvingen blir å lage en backend databaseløsning (med Spring BOOT og Spring JDBC eller Spring JPA) for kalkulatoren.
Kalkulatoren skal nå endres (eller utvides om du vil) slik at man kan logge inn med flere brukere, men kun om gangen. 

Det holder (foreløpig) med brukernavn og ev. passord i klartekst om du vil.

For hver bruker så skal det være mulig å sende og lagre regnestykker i en database (valgfritt hvilket DBMS som brukes).
Mao. så må man ha to databasetabeller i et en-til-mange forhold.

Hver bruker skal ha mulighet til å hente opp (fra databasen) tidligere regnestykker. Disse kan godt presenteres i en liste, slik at brukeren kan velge mellom dem. Vurder om det kan være lurt å "pageinate", slik at man ikke blir servert alle regnestykker fra tidenes morgen (kan bli mange). Minimum de ti siste regnestykkene skal kunne velges.

Husk lagdeling (arkitektur).

## Del 02

Øvingen blir å bruke "JWT token-basert autentisering" og "session storage" for kalkulatoren.
1. Implementere JWT token-basert autenseting/påloggingsfunksjonalitet i kalkulatoren ved bruk Spring security, og:

    * Egen endpunkt for generering av JWT token. Token skal være gyldig max for 5 min.
    * Custom/egen authorization filter for token validering.
2. Bruk "session storage" for lagre token og tilby session funksjonalitet til sluttbruker.
3. Husk at token skal være gyldig max for 5 min. Nytt token må hentes av frontend når token er gått ut.

Ta insperasjon fra denne repoen - https://gitlab.com/sysdev-tutorials/javascript/04-authentication/

