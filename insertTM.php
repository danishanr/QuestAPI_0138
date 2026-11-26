<?php
	include_once "koneksi.php";

	header('Access-Control-Allow-Origin: *');

	$json = file_get_contents('php://input');
	$data  = json_decode($json,true);

	$nama   = $data['nama'];
	$alamat = $data['alamat'];
	$telpon = $data['telpon'];

	class emp{}


?>