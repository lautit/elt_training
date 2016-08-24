<?php header('content-type: application/json; charset=utf-8');
$arr = array('id' => 3453, 'nombre' => 'Juan Remoto', 'apellido' => 'Perez Remoto');
echo json_encode($arr);
?>