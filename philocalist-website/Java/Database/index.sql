BEGIN TRANSACTION;


DROP TABLE IF EXISTS Photos;
DROP TABLE IF EXISTS Stationaries;

CREATE Table Stationaries(

id serial,
title varchar NOT NULL, 
category varchar NOT NULL,
price decimal NOT NULL, -- does this need to be a map? array?
theme varchar NOT NULL, 
color varchar,
printType varchar NOT NULL,
imgURL varchar,
isActive boolean NOT NULL,

constraint pk_Stationaries primary key (id)

);

INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Wedding Bundle', 'weddingInvite', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Save the Date', 'saveTheDate', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/SFS/I41/MIN-I41-SFS-001GOLD_A_PD.gif?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sedona Engagment Invitation', 'engageIntive', 5.00, 'Sedona', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/ENP/HBZ/MIN-HBZ-ENP-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sorbet Bridal Shower Invitation', 'showerInvite', 5.00, 'Sorbet', 'Pink', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/BSI/Z9V/MIN-Z9V-BSI-001J_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Shades Bachelorette Invitation', 'bachInvite', 5.00, 'Shades', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/BAC/PV7/MIN-PV7-BAC-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Favor Tags', 'favor', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/WFT/Z3S/MIN-Z3S-WFT-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Thank You Cards', 'thankYou', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/TYC/ZS7/MIN-ZS7-TYC-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Direction Cards', 'directionCard', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/DIR/HAO/MIN-HAO-DIR-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Menus', 'menu', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/MEN/ZBE/MIN-ZBE-MEN-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Programs', 'program', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/WPR/Z07/MIN-Z07-WPR-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Table Numbers', 'tableNumber', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/TBL/ZDS/MIN-ZDS-TBL-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Place Cards', 'placeCard', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/PLC/QOA/MIN-QOA-PLC-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Vines of Green Place Cards', 'welcomeSign', 5.00, 'Vines of Green', 'Green', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/AWS/004/MIN-004-AWS-001EWELCOMESIMPLEWELCOMESET3A_A_PZ.jpg', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Palm Rehearsal Dinner', 'rehearsalInvite', 5.00, 'Palm', 'Green', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/RHD/V8U/MIN-V8U-RHD-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Sand & Sun Envelopes', 'envelope', 5.00, 'Sand and Sun', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-008A_A_PZ.jpg', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Butter and Cloud Skinnywrap', 'addressLabel', 5.00, 'Butter and Cloud', 'Yellow', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/KLB/AOI/MIN-AOI-KLB-001_A_PD.jpg?_=undefined&mntd_prf=OldPdp:ProductImage', true);
INSERT INTO Stationaries (title, category, price, theme, color, printType, imgURL, isActive) VALUES ('Wedded Watercolor Wedding Bundle', 'weddingInvite', 5.00, 'Wedded Watercolor', 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/YDX/MIN-YDX-INV-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true);


CREATE TABLE Photos(

id serial,
stationary_id int,
url varchar,
title varchar,

constraint pk_Photos primary key (id),
constraint fk_Photos_Stationary foreign key (stationary_id) references Stationaries (id)

);

INSERT INTO Photos (stationary_id, url, title) VALUES (1, 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-014A_A_PZ.jpg', 'Full Suite');
INSERT INTO Photos (stationary_id, url, title) VALUES (1, 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-00B_A_PZ.jpg', 'Assembled');
INSERT INTO Photos (stationary_id, url, title) VALUES (1, 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-004_A_PZ.jpg', 'Close-up');


INSERT INTO Photos (stationary_id, url, title) VALUES (2, 'https://cdn3.minted.com/files/mintedProductsImages/MIN/SFS/I41/MIN-I41-SFS-002C_A_PZ.jpg', 'Backer Options');
INSERT INTO Photos (stationary_id, url, title) VALUES (2, 'https://cdn3.minted.com/files/mintedProductsImages/MIN/SFS/I41/MIN-I41-SFS-003GOLD_A_PZ.jpg', 'Assembled');
INSERT INTO Photos (stationary_id, url, title) VALUES (2, 'https://cdn3.minted.com/files/mintedProductsImages/MIN/SFS/I41/MIN-I41-SFS-004GOLD_A_PZ.jpg', 'Close-Up');


INSERT INTO Photos (stationary_id, url, title) VALUES (3, 'https://cdn3.minted.com/files/mintedProductsImages/MIN/ENP/HBZ/MIN-HBZ-ENP-002C_A_PZ.jpg', 'Backer Options');
INSERT INTO Photos (stationary_id, url, title) VALUES (3, 'https://cdn3.minted.com/files/mintedProductsImages/MIN/ENP/HBZ/MIN-HBZ-ENP-003_A_PZ.jpg', 'Assembled');
INSERT INTO Photos (stationary_id, url, title) VALUES (3, 'https://cdn3.minted.com/files/mintedProductsImages/MIN/ENP/HBZ/MIN-HBZ-ENP-004_A_PZ.jpg', 'Close-Up');

INSERT INTO Photos (stationary_id, url, title) VALUES (17, 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/YDX/MIN-YDX-INV-00B_A_PZ.jpg', 'Assembled');
INSERT INTO Photos (stationary_id, url, title) VALUES (17, 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/YDX/MIN-YDX-INV-002C_A_PZ.jpg', 'Backer Options');
INSERT INTO Photos (stationary_id, url, title) VALUES (17, 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/YDX/MIN-YDX-INV-004_A_PZ.jpg', 'Close-Up');



COMMIT TRANSACTION;

