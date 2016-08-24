<?php header('content-type: application/json; charset=utf-8');
$arr = array(array('id' => 3454, 'nombre' => 'Juan Remoto', 'apellido' => 'Mazur Remoto'),
array('id' => 3455, 'nombre' => 'Maria Remoto', 'apellido' => 'Lopez Remoto'),
array('id' => 3456, 'nombre' => 'Pedro Remoto', 'apellido' => 'Perez Remoto'));
echo json_encode($arr);
?>