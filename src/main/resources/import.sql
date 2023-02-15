INSERT INTO ingredient(name) VALUES ('tomate');
INSERT INTO ingredient(name) VALUES ('houmous');
INSERT INTO ingredient(name) VALUES ('ail');
INSERT INTO ingredient(name) VALUES ('tomates séchées');
INSERT INTO ingredient(name) VALUES ('huile d olive');

INSERT INTO sandwich(description, "name", price) VALUES ('vide', 'italien', 4.5);
INSERT INTO sandwich(description, "name", price) VALUES ('vide', 'houmous/ail', 5);

INSERT INTO sandwich_ingredients(sandwich_id, ingredient_id) VALUES (1, 1);
INSERT INTO sandwich_ingredients(sandwich_id, ingredient_id) VALUES (1, 4);
INSERT INTO sandwich_ingredients(sandwich_id, ingredient_id) VALUES (1, 5);
INSERT INTO sandwich_ingredients(sandwich_id, ingredient_id) VALUES (2, 2);
INSERT INTO sandwich_ingredients(sandwich_id, ingredient_id) VALUES (2, 3);
INSERT INTO sandwich_ingredients(sandwich_id, ingredient_id) VALUES (2, 5);
