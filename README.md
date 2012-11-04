GreenBeanLager
==============

Lagermodul för Green Bean

Lagersystemet erbjuder ett restliknande json-api över http. 
De metoder som erbjuds är

1) Hämta lagersaldo för en viss produkt
via http GET: http://<server>/<context-root>/product/{productId}

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