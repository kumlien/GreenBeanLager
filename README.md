GreenBeanLager
==============

Starta appen med 
mvn -Djetty.port=8081 jetty:run
eller
mvn tomcat:run


Lagermodul f�r Green Bean

Lagersystemet erbjuder ett restliknande json-api �ver http. 
De metoder som erbjuds �r

1) H�mta info f�r en viss produkt
via http GET: http://<server>/<context-root>/product/{productId}
Returnerar en json str�ng enligt

{
  "productId" : "1",
  "name" : "ett namn",
  "itemsInStock" : 500,
  "reOrderPoint" : 100
}

2) Skicka best�llning
via http POST: http://<server>/<context-root>/order/{orderId}
body � la: {
  "productId" : "1",
  "qty" : "1",
  "customerName" : "Torsten Bengtsson",
  "addressStreet" : "Sn�sv�ngen 3",
  "addressCity" : "Hamr�ngefj�rden",
  "addressZip" : "81793"
}