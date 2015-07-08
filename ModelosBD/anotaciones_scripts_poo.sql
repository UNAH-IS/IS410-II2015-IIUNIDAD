INSERT INTO db_facturacion.tbl_marcas (codigo_marca, nombre_marca) VALUES (NULL, 'Marca 1'), (NULL, 'Marca 2');


INSERT INTO nombre_tabla (campos)
VALUES (valores);


INSERT INTO tbl_marcas (nombre_marca) 
VALUES ('Marca 3');


INSERT INTO tbl_productos (
	codigo_barra, nombre_producto, descripcion_de_producto, precio_de_compra, precio_de_venta, existencia, fecha_vencimiento, codigo_marca, codigo_categoria, codigo_proveedores, codigo_moneda, codigo_unidad_medida, codigo_lote
) 
VALUES (
	'123456', 'Producto 1', 'Descripcion', 123, 2345, 100, '2015-07-08', 2, 1, 1, 1, 1, 2
);


Instrucciones SQL:
DDL (Data Definition Language):
	Instrucciones que sirven para crear/modificar/eliminar estructuras o elementos fisicos de la base de datos.
	Por ejemplo:
	*Crear/Modificar/Eliminar Tablas, procesos, columnas, vistas, etc.
DML (Data Manipulation Language):
	Instrucciones que sirven para insertar/modificar/eliminar informacion de las tablas.
	Por ejemplo:
	*Insertar/Modificar/Eliminar registros.
	Insert,Update,Delete
QL (Query Language):
	Instrucciones que sirven para consultar informacion.
	Por Ejemplo:
	Consultar los empleados que el sueldo es mayor a 20mil.



UPDATE tbl_marcas 
SET nombre_marca = 'Marca Cuatro' 
WHERE codigo_marca = 4;


UPDATE tbl_marcas 
SET nombre_marca = 'Marca 4' 
WHERE codigo_marca = 4;

UPDATE nombre_tabla
SET nombre_campo_1 = nuevo_valor_1,
	nombre_campo_2 = nuevo_valor_2,
	...
	nombre_campo_n = nuevo_valor_n
WHERE codicion;

--Utilizar en la condicion un criterio relacionado con la llave primaria.



DELETE FROM tbl_marcas 
WHERE codigo_marca = 4;

DELETE FROM nombre_tabla
WHERE criterio;

--Eliminar todos los registros de la tabla
--DDL
TRUNCATE TABLE nombre_tabla;



SELECT * 
FROM `tbl_lotes`;


SELECT nombre_campos
FROM tabla
WHERE condicion;


SELECT codigo_lote, nombre_lote
FROM tbl_lotes
WHERE codigo_lote = 2;



--Consultar los productos que tengan el precio de compra mayor a 100


SELECT nombre_producto, precio_de_compra
FROM tbl_productos
WHERE precio_de_compra > 100;

--Consultar los productos que la moneda sea dolares:
SELECT nombre_producto, precio_de_compra, codigo_moneda
FROM tbl_productos
WHERE codigo_moneda = 2;

--Consultar los productos que la moneda sea dolares y que el precio de compra sea mayor que 100:

SELECT nombre_producto, precio_de_compra, codigo_moneda
FROM tbl_productos
WHERE codigo_moneda = 2
AND precio_compra > 100;


Operadores logicos:
AND
OR
NOT
BETWEEN