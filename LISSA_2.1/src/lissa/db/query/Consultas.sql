--REPORTE TARIFARIO TOTAL
SELECT D.nombre, C.denominacion, B.codigo, B.denominacion, A.costo
FROM PROCEDIMIENTO_TARIFARIO A INNER JOIN PROCEDIMIENTO B
ON A.id_procedimiento = B.idprocedimiento INNER JOIN SERVICIO C
ON B.id_servicio = C.idservicio INNER JOIN TARIFARIO D
ON A.id_tarifario = D.idtarifario
ORDER BY 1 ASC, 2 ASC, 3 ASC

