BEGIN TRANSACTION;

DROP TABLE IF EXISTS Stationaries;

CREATE Table Stationaries(

id serial,
category varchar,
price decimal, -- does this need to be a map? array?
theme varchar, 
color varchar,
printType varchar,
imgURL varchar,

constraint pk_Stationaries primary key (id)

);

INSERT INTO Stationaries (category, price, theme, color, printType, imgURL) VALUES ('weddingInvite', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage');



COMMIT TRANSACTION;