select cita.id, cita.id_trabajo_grado, cita.fecha_cita
from cita
inner join trabajodegrado on cita.id_trabajo_grado = trabajodegrado.id
where trabajodegrado.id_usuario = :idUsuario and
year(cita.fecha_cita) = :anhoActual and month(cita.fecha_cita) = :mesActual and day(cita.fecha_cita) = :diaActual;