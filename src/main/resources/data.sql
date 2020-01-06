INSERT INTO INV_CATEGORY (CATEGORY_ID, NAME,  PARENT_CATEGORY_ID) VALUES
(1, 'FOOD', null),
(2, 'ELECTRICAL', null),
(3, 'DRINK', null),
(4, 'TOYS', null),
(5, 'CLOTHING', null),
(6, 'CAKE', 1),
(7, 'SOFT_DRINK', 3),
(8, 'WATER', 3),
(9, 'TEA', 3)
;

INSERT INTO INVENTORY (NAME, CATEGORY_ID,  qty) VALUES
('CheeseCake', 6 , 100),
('COKE', 7 ,  3000),
('7UP', 7 ,  1000),
('Green Tea', 9 ,  2000),
('Spring Water', 8 ,  4000);
