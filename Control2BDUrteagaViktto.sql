CREATE TABLE productos (
    idprod INT AUTO_INCREMENT PRIMARY KEY,
    nombreprod VARCHAR(255) NOT NULL,
    descripcionprod TEXT,
    cantidadprod INT,
    fechaVencimientoprod DATE
);

INSERT INTO productos (nombreprod, descripcionprod, cantidadprod, fechaVencimientoprod)
VALUES
    ('Producto 1', 'Descripción 1', 10, '2023-12-31'),
    ('Producto 2', 'Descripción 2', 50, '2023-11-15'),
    ('Producto 3', 'Descripción 3', 200, '2024-02-28'),
    ('Producto 4', 'Descripción 4', 150, '2023-10-10'),
    ('Producto 5', 'Descripción 5', 8, '2024-01-20');
   