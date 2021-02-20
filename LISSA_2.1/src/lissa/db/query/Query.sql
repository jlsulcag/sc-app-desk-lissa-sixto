--Query que permite a hibernate trabajar con diversos esquemas
SHOW search_path;
ALTER DATABASE clinicadb2 SET search_path = farmacia,public;

--Deletes
delete from detalle_compra;
delete from compra;
delete from detalle_venta;
delete from venta;
delete from detalle_kardex;
delete from kardex;
delete from almacen_producto;


delete from producto
delete from presentacion
delete from forma_farmaceutica
delete from laboratorio

--conexiones activas
select * from pg_stat_activity
where datname = 'clinicadb'

SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'clinicadb';

--PAra actualizar en el servidor de produccion
delete from almacen_producto
where stock_actual = 0

--------DESDE AQUI-----------------------------------------------------

--PASE A PRODUCCION
--1. INSERTAR PRECIO  PRODUCTO
INSERT INTO precio_producto (id_almacenproducto, pv_min, pv_max, pv_sugerido, fecha_inicio, estado, id_usuario) 
select a.idalmacenproducto, a.precio_min, a.precio_max, a.precio_venta , current_date, 1, 7
from almacen_producto a
where a.id_almacen = 1 and a.stock_actual > 0

-------------------
INSERT INTO precio_producto (id_almacenproducto, pv_min, pv_max, pv_sugerido, fecha_inicio, estado, id_usuario) 
select a.idalmacenproducto, a.precio_min, a.precio_max, a.precio_venta , current_date, 1, 7
from almacen_producto a
where a.id_almacen = 2 and a.stock_actual > 0

------------------


--2.  CAMBIAR TIPO DE DATO  EN LA TABLA PRODUCTO IDPRODUCTO = LONG
--3. ELIMINAR   TABLA DETALLE KARDEX
--4. ACTUALIZAR CAMPOS DE LA TABLA  KARDEX DE ACUERDO AL NUEVO MODELO

-----------------------
INSERT INTO KARDEX(id_origen, id_destino, id_farcomprobante, operacion, fecha_mov, hora_mov, tipo_operacion, id_almacen_afectado, comprobante, num_serie, origen, destino, observacion, num_comprobante, grupo_numeracion, id_producto, cantidad, valor_unit, id_almacenproducto, estado, nro_orden, stock_actual)
select 1, 1, 0, 'INVENTARIO INICIAL', CURRENT_DATE, '', 'ENTRADA', 1, '', '', '', '', '', 0, 1, a.id_producto, a.stock_actual, a.valor_compra_unitario, a.idalmacenproducto, 1, a.orden_registro, a.stock_actual
FROM ALMACEN_PRODUCTO a
where a.id_almacen = 1 and a.stock_actual > 0
order by a.id_producto, a.fecha_registro asc, a.fecha_vencimiento asc

---------------------------
INSERT INTO KARDEX(id_origen, id_destino, id_farcomprobante, operacion, fecha_mov, hora_mov, tipo_operacion, id_almacen_afectado, comprobante, num_serie, origen, destino, observacion, num_comprobante, grupo_numeracion, id_producto, cantidad, valor_unit, id_almacenproducto, estado, nro_orden, stock_actual)
select 1, 1, 0, 'INVENTARIO INICIAL', CURRENT_DATE, '', 'ENTRADA', 2, '', '', '', '', '', 0, 1, a.id_producto, a.stock_actual, a.valor_compra_unitario, a.idalmacenproducto, 1, rownumber(), a.stock_actual
FROM ALMACEN_PRODUCTO a
where a.id_almacen = 2 and a.stock_actual > 0
order by a.id_producto, a.fecha_registro asc, a.fecha_vencimiento asc

--EXPORTAR  LA TABLA ALMACEN_PRODUCTO Y RE-ORDENAR EL ORDEN DE REGISTRO
select * from almacen_producto a 
where a.stock_actual>0 
order by a.id_producto, a.fecha_vencimiento asc

--BORAR  LA TABLA ALMACEN_PRODUCTO
DELETE FROM ALMACEN_PRODUCTO
--BORRAR DATA  PARA VOLVER A CARGAR
DELETE FROM PRECIO_PRODUCTO

DELETE FROM KARDEX

----
UPDATE ALMACEN_PRODUCTO
SET ESTADO = TRUE
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
--PASE A PRODUCCION 13-12-2018
--1. INSERTAR  CAMPO NUMERO CARTA  EN LA TABLA COMPROBANTE
--2. ACTUALIZAR LOS NUMEROS DE CARTA EXISTENTES EN EL NUEVO CAMPO
update comprobante a
set numero_carta = b.numero_carta
from comprobante_detalle b 
where b.id_comprobante = a.idcomprobante
--3. ELIMINAR CAMPO NUMERO CARTA DE LA  TABLA COMPROBANTE_DETALLE
--4. AGREGAR CAMPO ESTADO  A LA TABLA COMPROBANTE_DETALLE
update comprobante_detalle a
set estado = 'REG'
WHERE a.id_medicoatiendereal is null
--5. 
-----------------------------------------------------------------------------------------------------------------------------------
ALTER TABLE HISTORIAL_ATENCION_FPS
      ADD COLUMN FECHA_ATENCION DATE


UPDATE HISTORIAL_ATENCION_FPS A
SET FECHA_ATENCION = B.FECHA_VENTA
FROM VENTA B 
WHERE B.IDVENTA = A.ID_VENTA
------------------------------------------------------------------------------------------------------------------------------------
-- insertar permisos a todos los usuarios registrados

INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (7, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (8, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (9, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (10, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (11, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (12, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (13, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (14, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (15, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (16, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (17, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (18, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (19, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (20, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (21, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (22, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (23, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (24, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (25, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (26, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (27, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (28, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (29, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (30, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (31, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (32, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (33, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (34, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (35, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (36, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (37, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (38, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (39, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (41, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (42, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (43, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (44, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (45, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (46, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (47, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (48, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (49, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (50, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (51, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (52, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (53, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (54, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (55, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (56, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (57, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (58, 1, '2019-11-26', 7, 1);
INSERT INTO usuario_permiso(id_usuario, id_permiso, fecha_act, id_userreg, estado) VALUES (59, 1, '2019-11-26', 7, 1);