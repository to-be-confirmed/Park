<?php
header("Content-Type: text/html; charset=utf-8") ;
$uname = $_POST["uname"];
$upassword = $_POST["upassword"];

include('db_con.php');
//数据库查找下
$sqlstr = "SELECT * FROM pp_users WHERE u_name = '$uname' and u_password = '$upassword'";
$check_query = mysqli_query($con, $sqlstr);
$arr = array();//空的数组
if ($check_query) {
	$result = mysqli_fetch_array($check_query, MYSQLI_ASSOC);
    if($result){
    	session_start();
	    //登录成功
	    $_SESSION['uname'] = $result['u_name'];
	    $_SESSION['uid'] = $result['u_id'];
	    $sessionid = session_id();
	    $_SESSION['$sessionid'] = $sessionid;
	    
	    $arr = array(  
	    'flag' => '200',
	    'msg' => 'success',
	    'uname' => $result['u_name'],  
	    'uid' => $result['u_id'],  
	    'sessionid' => $sessionid); 
    }
} else {
	$arr = array(  
	'flag '=> '400',
	'msg' => 'can not query data'); 
}
//
echo json_encode($arr); 
?>