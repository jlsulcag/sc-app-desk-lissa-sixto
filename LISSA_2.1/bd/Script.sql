ALTER TABLE PRODUCTO
	ADD COLUMN principio_activo varchar(200),
	add column accion_terapeutica varchar(200),
	add column generico integer,
	drop column nombre_generico;
	
update producto
	set generico = 0;