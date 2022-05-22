
In cadrul acestui proiect am realizat atat task-urile cerute, cat si pe cele extra.

Pentru aceasta, am creat 5 clase si doua enum-uri.

Enum-ul ShippedFrom este pentru a diferentia mai usor intre tarile de unde se livreaza.
Enum-ul NamesOfItems este pentru a diferentia mai usor intre produsele aflate in 
catalogul de produse.

Clasa Product contine numele, pretul, tara de unde se livreaza, greutatea si 
cantitatea unui produs. 

Clasa CatalogOfProducts contine o lista cu toate produsele valabile in catalogul
de produse. 

Clasa ShoppingCart contine un HashMap, in care vom pune produsele pe care vrem sa 
le cumparam, si un boolean pe care il voi folosi sa identific ofertele speciale. 
Am folosit HashMap pentru a putea tine evidenta mai usor a cantitatii
produselor. Tot in aceasta clasa am implementat atat metodele cerute, cat si pe cele
extra.  

Clasa TestShippingCart este folosita pentru testarea metodelor de calculare a 
costului subtotal, a costului de livrare si a costului total.

