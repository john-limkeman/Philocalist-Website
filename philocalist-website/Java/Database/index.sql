BEGIN TRANSACTION;


DROP TABLE IF EXISTS Photos;
DROP TABLE IF EXISTS Stationaries;
DROP TABLE IF EXISTS Themes;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP TABLE IF EXISTS websiteInformation;

CREATE TABLE websiteInformation (
        id serial,
        aboutMessage varchar NOT NULL,
        aboutImageURL varchar NOT NULL,
        email varchar NOT NULL,
        phone varchar NOT NULL,
        contactMessage varchar NOT NULL,
        homeMessage varchar NOT NULL,

        CONSTRAINT pk_info PRIMARY KEY (id)
);

INSERT INTO websiteInformation (id, aboutMessage, aboutImageURL, email, phone, contactMessage, homeMessage) VALUES (1,
'Beth Schuurman is a wedding stationary designer. There are lots of facts about her that exist. Some will be listed here.',
'/Users/johnlimkeman/Desktop/Projects/Philocalist/Philocalist-Website - git repo/philocalist-website/Vue/src/assets/Beth-Ethan-Wedding.jpg',
'philocalist@gmail.com',
'555-555-5555',
'Reach out if you have any questions!',
'Welcome to Philocalist Stationary! Thanks for stopping by!');

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE TABLE users (
        user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
        username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('beth','$2a$10$ZgjBSuT4iByZtiPDX0cAteqpEDsfsEGFnrjpjMqebxsDyWhrA9ckG','ROLE_ADMIN');

CREATE Table Themes(
        id serial,
        hero_image varchar NOT NULL,
        name varchar NOT NULL,
        description varchar,
        is_featured boolean,

        constraint pk_Themes primary key (id)

);

INSERT INTO Themes (hero_image, name, description, is_featured) VALUES ('https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-014A_A_PZ.jpg','Sand & Sun','So warm and refreshing, great for a beach or nautical themed wedding', true);
INSERT INTO Themes (hero_image, name, description, is_featured) VALUES ('https://cdn3.minted.com/files/mintedProductsImages/MIN/ENP/HBZ/MIN-HBZ-ENP-003_A_PZ.jpg','Sedona','nice and laidback style, colorful yet simple', false);
INSERT INTO Themes (hero_image, name, description, is_featured) VALUES ('https://cdn3.minted.com/files/mintedProductsImages/MIN/BSI/Z9V/MIN-Z9V-BSI-003_B_PZ.jpg','Sorbet','yummy', false);
INSERT INTO Themes (hero_image, name, description, is_featured) VALUES ('https://cdn3.minted.com/files/mintedProductsImages/MIN/BAC/PV7/MIN-PV7-BAC-003_A_PZ.jpg','Shades','cool', false);
INSERT INTO Themes (hero_image, name, description, is_featured) VALUES ('https://cdn3.minted.com/files/mintedProductsImages/MIN/TBF/ZNP/MIN-ZNP-TBF-002C_A_PZ.jpg','Vines of Green','so trendy, you are going to love it', false);
INSERT INTO Themes (hero_image, name, description, is_featured) VALUES ('https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/YR9/MIN-YR9-INV-002C_A_PZ.jpg','Palm','palm sunday vibes are the perfect vibes for a wedding', false);
INSERT INTO Themes (hero_image, name, description, is_featured) VALUES ('https://cdn3.minted.com/files/mintedProductsImages/MIN/KLB/AOI/MIN-AOI-KLB-001_A_PD.jpg?_=undefined&mntd_prf=OldPdp:ProductImage','Butter and Cloud','butter and cloud pretty much says it all', false);
INSERT INTO Themes (hero_image, name, description, is_featured) VALUES ('https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/YDX/MIN-YDX-INV-002C_A_PZ.jpg','Wedded Watercolor','fun and abstract, like your relationship', false);




CREATE Table Stationaries(

        id serial,
        title varchar NOT NULL, 
        category varchar NOT NULL,
        price decimal NOT NULL,
        theme_id int NOT NULL, -- fk
        description varchar,
        height decimal NOT NULL,
        width decimal NOT NULL,
        color varchar,
        printType varchar NOT NULL,
        imgURL varchar,
        isActive boolean NOT NULL,

        constraint pk_Stationaries primary key (id),
        constraint fk_Stationaries_theme foreign key (theme_id) references Themes (id)
);

INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Wedding Bundle', 'weddingInvite', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Save the Date', 'saveTheDate', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/SFS/I41/MIN-I41-SFS-001GOLD_A_PD.gif?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sedona Engagment Invitation', 'engageIntive', 5.00, 2, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/ENP/HBZ/MIN-HBZ-ENP-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sorbet Bridal Shower Invitation', 'showerInvite', 5.00, 3, 'Pink', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/BSI/Z9V/MIN-Z9V-BSI-001J_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Shades Bachelorette Invitation', 'bachInvite', 5.00, 4, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/BAC/PV7/MIN-PV7-BAC-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Favor Tags', 'favor', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/WFT/Z3S/MIN-Z3S-WFT-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Thank You Cards', 'thankYou', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/TYC/ZS7/MIN-ZS7-TYC-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Menus', 'menu', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/MEN/ZBE/MIN-ZBE-MEN-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Programs', 'program', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/WPR/Z07/MIN-Z07-WPR-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Table Numbers', 'tableNumber', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/TBL/ZDS/MIN-ZDS-TBL-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Place Cards', 'placeCard', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/PLC/QOA/MIN-QOA-PLC-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Vines of Green Place Cards', 'welcomeSign', 5.00, 5, 'Green', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/AWS/004/MIN-004-AWS-001EWELCOMESIMPLEWELCOMESET3A_A_PZ.jpg', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Palm Rehearsal Dinner', 'rehearsalInvite', 5.00, 6, 'Green', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/RHD/V8U/MIN-V8U-RHD-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Envelopes', 'envelope', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/ZXL/MIN-ZXL-INV-008A_A_PZ.jpg', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Butter and Cloud Skinnywrap', 'addressLabel', 5.00, 7, 'Yellow', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/KLB/AOI/MIN-AOI-KLB-001_A_PD.jpg?_=undefined&mntd_prf=OldPdp:ProductImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Wedded Watercolor Wedding Bundle', 'weddingInvite', 5.00, 8, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/INV/YDX/MIN-YDX-INV-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Direction Cards', 'directionCard', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/DIR/HAO/MIN-HAO-DIR-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Events Card', 'eventsCard', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/DIR/HAO/MIN-HAO-DIR-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Print RSVP', 'rsvpPrint', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/DIR/HAO/MIN-HAO-DIR-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);
INSERT INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive, description, height, width) VALUES ('Sand & Sun Online RSVP', 'rsvpOnline', 5.00, 1, 'Blue', 'digital', 'https://cdn3.minted.com/files/mintedProductsImages/MIN/DIR/HAO/MIN-HAO-DIR-001_A_PZ.jpg?mntd_prf=Pdp:HeroImage', true, 'description of the item here is very cool and nice and its a description', 5.8, 9.2);


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



