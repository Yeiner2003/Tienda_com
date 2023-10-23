CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `mostrarusuario` AS
    SELECT 
        `usuario`.`idUsuario` AS `idusuario`,
        `usuario`.`cargo` AS `cargo`,
        `usuario`.`sexo` AS `sexo`,
        `usuario`.`nombre` AS `nombre`,
        `usuario`.`telefono` AS `telefono`,
        `usuario`.`correo` AS `correo`,
        `usuario`.`condicion` AS `condicion`,
        `usuario`.`fechanacimiento` AS `fechanacimiento`
    FROM
        `usuario`
    WHERE
        (`usuario`.`condicion` = '1')