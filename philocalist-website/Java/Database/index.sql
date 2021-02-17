BEGIN TRANSACTION;

DROP TABLE IF EXISTS Stationaries;

CREATE Table Stationaries(

id serial,
title varchar, 
category varchar,
price decimal, -- does this need to be a map? array?
theme varchar, 
color varchar,
printType varchar,
imgURL varchar,
isActive boolean,

constraint pk_Stationaries primary key (id)

);

INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Wedding Bundle', 'weddingInvite', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & SSun Save the Date', 'saveTheDate', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Engagment Invitation', 'engageIntive', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Bridal Shower Invitation', 'showerInvite', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Bachelorette Invitation', 'bachInvite', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Thank You Card', 'thankYou', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);



COMMIT TRANSACTION;