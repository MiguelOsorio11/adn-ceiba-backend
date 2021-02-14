SELECT count(*)
FROM CITA
WHERE datediff(fecha_cita, :fechaCita) = 0 AND timediff(fecha_cita , :fechaCita) = 0;