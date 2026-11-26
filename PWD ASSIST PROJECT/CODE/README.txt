PWD ASSIST - How to run
=======================

1. Buksan ang terminal sa CODE folder.
2. Compile lahat ng java files:

   javac *.java

3. Run ang server:

   java PWDAssistServer

4. Buksan sa browser: http://localhost:8080


EMERGENCY CONTACTS
------------------
Yung Emergency Contacts page ay static lang. Listahan lang
ito ng mga importanteng hotline sa Pilipinas (911, PNP, BFP,
Red Cross, NDRRMC, DSWD, MMDA, PCG, PAGASA, PHIVOLCS).

Walang database, walang API, at walang form. Hindi kailangan
ng internet connection para makita ang page. Pwede din i
click ang number para tumawag kung naka cellphone.

Pwede din i open yung Frontend/index.html directly, pero mas
maayos kung gamit yung server para tama ang path ng images.

Note: pwede magbago ang mga numero, kaya i-check pa rin sa
official website ng ahensya.


FOLDERS
-------
Frontend/   - html, css, js, at images
*.java      - server at mga class para sa OOP at DSA


DEMO (walang browser)
---------------------
Para makita ang OOP at DSA gumagana, pwede i run ito:

   java ContactDemo

Ipapakita nya yung linked list, insertion sort (alphabetical),
at binary search gamit ang sample emergency contacts.
Console output lang ito, hiwalay sa website.
