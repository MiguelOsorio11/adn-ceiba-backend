select id, id_usuario, nombre, descripcion, estado, valor, fecha_confirmacion
from trabajodegrado where trabajodegrado.id not in (select cita.id_trabajo_grado from cita)
