<?php
/**
 * 数据库连接单元
 */
define("DB_HOST", "localhost");
define("DB_USER", "park");
define("DB_PASSWORD", "yukongjian");
define("DB_DATABASE", "parkpark");

$con = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE);
mysqli_set_charset ($con,'utf8');
if (mysqli_connect_errno($con))
{
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
?>