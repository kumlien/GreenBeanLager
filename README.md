GreenBeanLager
==============

Lagermodul f�r Green Bean

Lagersystemet erbjuder ett restliknande json-api �ver http. 
De metoder som erbjuds �r

1) H�mta lagersaldo f�r en viss produkt
via http GET: http://<server>/<context-root>/product/{productId}

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