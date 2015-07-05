Cruce de tablas:

Cruce para dos tablas:
SELECT 	campos_tabla_1, 
		campos_tabla_2
FROM 	tabla_1
INNER JOIN tabla_2
ON (llave_foranea = llave_primaria);

Cruce para tres tablas:
SELECT 	campos_tabla_1, 
		campos_tabla_2,
		campos_tabla_3
FROM 	tabla_1
INNER JOIN tabla_2
ON (llave_foranea_tabla_1 = llave_primaria_tabla_2)
INNER JOIN tabla_3
ON (llave_foranea_tabla_1 = llave_primaria_tabla_3);


--Cruce de tablas sin alias
SELECT codigo_producto,
		nombre_producto,
		descripcion_de_producto,
		nombre_marca
FROM tbl_productos
INNER JOIN tbl_marcas
ON (tbl_marcas.codigo_marca = tbl_productos.codigo_marca);

--Obtener el nombre de la marca:
SELECT A.codigo_producto,
		A.nombre_producto,
		A.descripcion_de_producto,
        A.codigo_marca,
		B.nombre_marca
FROM tbl_productos A
INNER JOIN tbl_marcas B
ON (A.codigo_marca = B.codigo_marca);

--Obtener el nombre de la marca y el lote:
SELECT A.codigo_producto,
		A.nombre_producto,
		A.descripcion_de_producto,
        A.codigo_marca,
		B.nombre_marca,
        A.codigo_lote,
        C.lote
FROM tbl_productos A
INNER JOIN tbl_marcas B
ON (A.codigo_marca = B.codigo_marca)
INNER JOIN tbl_lotes C
ON (A.codigo_lote = C.codigo_lote);

--Obtener el nombre de la marca, lote y categoria:
SELECT A.codigo_producto,
		A.nombre_producto,
		A.descripcion_de_producto,
        B.nombre_marca,
        C.lote,
        D.nombre_categoria
FROM tbl_productos A
INNER JOIN tbl_marcas B
ON (A.codigo_marca = B.codigo_marca)
INNER JOIN tbl_lotes C
ON (A.codigo_lote = C.codigo_lote)
INNER JOIN tbl_categorias D
ON (A.codigo_categoria = D.codigo_categoria);


---Obtener todos los nombres en vez de codigos:

SELECT A.codigo_producto,
		A.nombre_producto,
		A.descripcion_de_producto,
        B.nombre_marca,
        C.lote,
        D.nombre_categoria,
        E.nombre_proveedor,
        F.nombre_moneda,
        G.nombre_unidad_medida
FROM tbl_productos A
INNER JOIN tbl_marcas B
ON (A.codigo_marca = B.codigo_marca)
INNER JOIN tbl_lotes C
ON (A.codigo_lote = C.codigo_lote)
INNER JOIN tbl_categorias D
ON (A.codigo_categoria = D.codigo_categoria)
INNER JOIN tbl_proveedores E
ON (A.codigo_proveedores = E.codigo_proveedor)
INNER JOIN tbl_monedas F
ON (A.codigo_moneda = F.codigo_moneda)
INNER JOIN tbl_unidad_medidas G
ON (A.codigo_unidad_medida = G.codigo_unidad_medida);


--Convertir de cadena a fecha

INSERT INTO `db_facturacion`.`tbl_productos` (`codigo_producto`, `codigo_barra`, `nombre_producto`, `descripcion_de_producto`, `precio_de_compra`, `precio_de_venta`, `existencia`, `fecha_vencimiento`, `codigo_marca`, `codigo_categoria`, `codigo_proveedores`, `codigo_moneda`, `codigo_unidad_medida`, `codigo_lote`) VALUES (NULL, '546465', 'Producto 4', 'Descripcio producto 4', '100', '200', '50', 

STR_TO_DATE('09/07/2015','%d/%m/%Y'), 

'2', '1', '2', '1', '2', '1');