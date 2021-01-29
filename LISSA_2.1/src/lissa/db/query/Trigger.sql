CREATE TRIGGER nombre {BEFORE | AFTER} {INSERT | UPDATE | DELETE [OR...]}
    ON table [FOR [EACH] {ROW | STATEMENT}]
    EXECUTE  PROCEDURE nombre_funcion(argumentos)
