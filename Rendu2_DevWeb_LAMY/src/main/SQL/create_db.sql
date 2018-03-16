CREATE TABLE `articles` (
  `article_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `brand` VARCHAR(100) NULL,
  `gender` VARCHAR(100) NULL,
  `price` VARCHAR(100) NULL,
  PRIMARY KEY (`article_id`));

CREATE TABLE `utilisateurs` (
  `utilisateur_id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`utilisateur_id`));


  INSERT INTO articles (name, brand, gender, price) VALUES ("Jupe","Sandro","Femme","140");
  INSERT INTO articles (name, brand, gender, price) VALUES ("Pantalon","The Kooples","Homme","239");
  INSERT INTO articles (name, brand, gender, price) VALUES ("Robe","Maje","Femme","99");
  INSERT INTO articles (name, brand, gender, price) VALUES ("Costume","Armani","Homme","545");
