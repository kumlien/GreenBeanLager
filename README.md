GreenBeanLager
==============

Starta appen med 
mvn -Djetty.port=8081 jetty:run


Lagermodul för Green Bean

Lagersystemet erbjuder ett restliknande json-api över http. 
De metoder som erbjuds är

1) Hämta info för en viss produkt
via http GET: http://<server>/<context-root>/product/{productId}
Returnerar en json sträng enligt

{
  "productId" : "1",
  "name" : "ett namn",
  "itemsInStock" : 500,
  "reOrderPoint" : 100
}

2) Skicka beställning
via http POST: http://<server>/<context-root>/order/{orderId}
body á la: {
  "productId" : "1",
  "qty" : "1",
  "customerName" : "Torsten Bengtsson",
  "addressStreet" : "Snösvängen 3",
  "addressCity" : "Hamrångefjärden",
  "addressZip" : "81793"
}