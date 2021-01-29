--FUNCION PARA RECALCULAR LOS VALORES DE LOS ITEMS DE COMPRA Y VALORES GLOBALES DE LA COMPRA
CREATE OR REPLACE FUNCTION sp_actualizar_precios_items_compra(p_idcompra integer, p_iddetallecompra INTEGER, p_pc numeric)
RETURNS VOID AS $$
BEGIN
     UPDATE DETALLE_COMPRA 
            SET PRECIO_COMPRA = p_pc,
                PRECIO_COMPRA_UNITARIO = PRECIO_COMPRA/CANTIDAD,
                IGV_ITEM = ROUND(PRECIO_COMPRA*0.18,2)
     WHERE IDDETALLECOMPRA = p_iddetallecompra;
     --COMMIT;
     UPDATE COMPRA
            SET VALOR_BRUTO = (SELECT SUM(A.PRECIO_COMPRA) FROM DETALLE_COMPRA A WHERE A.id_compra = p_idcompra),
                VALOR_DESCUENTO = (SELECT SUM (A.descuento_item) FROM DETALLE_COMPRA A WHERE A.ID_COMPRA = p_idcompra),
                VALOR_NETO = VALOR_BRUTO-VALOR_DESCUENTO,
                VALOR_IGV = ROUND(VALOR_NETO*0.18,2),
                VALOR_TOTAL = VALOR_NETO + VALOR_IGV
     WHERE IDCOMPRA = p_idcompra;
     --COMMIT;

END;
$$LANGUAGE PLPGSQL;

--2613-2621
--2613
SELECT * FROM farmacia.sp_actualizar_precios_items_compra(733, 2613, 834.89);
--2614
SELECT * FROM farmacia.sp_actualizar_precios_items_compra(733, 2614, 208.72);
--2615
SELECT * FROM farmacia.sp_actualizar_precios_items_compra(733, 2615, 1922.87);
--2616
SELECT * FROM farmacia.sp_actualizar_precios_items_compra(733, 2616, 137.18);
--2617
SELECT * FROM farmacia.sp_actualizar_precios_items_compra(733, 2617, 46.45);
--2618
SELECT * FROM farmacia.sp_actualizar_precios_items_compra(733, 2618, 62.86);
--2619
SELECT * FROM farmacia.sp_actualizar_precios_items_compra(733, 2619, 414.29);
--2620
SELECT * FROM farmacia.sp_actualizar_precios_items_compra(733, 2620, 0);
--2621
SELECT * FROM farmacia.sp_actualizar_precios_items_compra(733, 2621, 520.67);

