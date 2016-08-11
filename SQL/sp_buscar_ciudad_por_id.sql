CREATE PROCEDURE `sp_buscar_ciudad_por_id` (IN p_id_ciudad INT)
BEGIN
	select ID, Name from city where ID = p_id_ciudad;
END
