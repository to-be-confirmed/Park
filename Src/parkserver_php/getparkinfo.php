<?php 
/**
 * 取得用户车位信息表单元
 */
  header("Content-Type: text/html; charset=utf-8") ;
  include('db_con.php');
  //获取客户端传递的session标识
  $sessionid=$_POST["sid"];
  $uname=$_POST["uname"];
  session_id($sessionid);
  //将会根据session id获得原来的session
  session_start(); 
  //获取服务器端原来session记录的uname,并且根据客户端传过来的uname比较进行验证操作
  $suname = $_SESSION['uname'];
  $uid = $_SESSION['uid'];
  $arr=array();//空的数组
  $rowarrs = array();//数据集数组
  $rowarr = array(); //单行
  if ($suname == $uname){
    $sqlstr = "SELECT * FROM pp_parkspace WHERE u_id = '$uid'";

    $check_query = mysqli_query($con, $sqlstr);
    if ($check_query) {
    	while($rows = mysqli_fetch_array($check_query)){
    		$rowarr = array(
		    'pid' => $rows['p_id'],
			'paddr' => $rows['p_addr'],
			'pprice' => $rows['p_price'],
			'ptimestart' => $rows['p_time_start'],
			'ptimeend' => $rows['p_time_end'],
			'pstatus' => $rows['p_status']);
			//追加
			array_push($rowarrs, $rowarr);
    	}
		$arr = array(  
    	'flag' => '200',
   		'msg' => 'success',
   		'data' => $rowarrs, 
    	'sessionid' => $sessionid);
    }
  } else {
    $arr = array(  
	'flag '=> '400',
	'msg' => 'please login before getparkinfo'); 
  }
  //
  echo json_encode($arr); 
?>