<?php 
  header("Content-Type: text/html; charset=utf-8") ;
  include('db_con.php');
  //注册用户
  $uname = $_POST["uname"];
  $upassword = $_POST["upassword"];
  $urealname = $_POST["urealname"];
  $uphone = $_POST["uphone"];
  $uaddr = $_POST["uaddr"];
  $usex = $_POST["usex"];
  $uimg = $_POST["uimg"];

  $arr = array();

  //查找用户名是否已经被注册
  $sqlstr = "SELECT u_name FROM pp_users WHERE u_name = '$uname'";
  if ($result = mysqli_query($con, $sqlstr))
  {
  	$rowcount = mysqli_num_rows($result);
	// Free result set
	mysqli_free_result($result);
	if ($rowcount <> 0)
	{
      $arr = array(
          'flag' => '405',
          'msg' => 'this user name is exists, please change a user name. :p');
  	}
  	else
  	{
	  {
		  $sqlstr = "INSERT INTO pp_users(u_name, u_password, u_realname, u_phone, u_addr, u_sex, u_img) VALUES('$uname', '$upassword','$urealname', '$uphone', '$uaddr', '$usex','$uimg')"; 
		  echo $sqlstr;
		  if ($result = mysqli_query($con, $sqlstr))
		  {
		    $sqlstr = "SELECT * FROM pp_users WHERE u_name = '$uname'";
		    if ($result = mysqli_query($con, $sqlstr))
		    {
		    	$result = mysqli_fetch_array($result, MYSQLI_ASSOC);
		    	if ($result)
		    	{
		    	  $arr = array(  
		          'flag' => '200',
		          'msg' => 'success',
		          'uid' => $result['u_id'],
		          'uname' => $result['u_name'],  
		          'urealname' => $result['u_realname'],
		          'uphone' => $result['u_phone'],
		          'uaddr' => $result['u_addr'], 
		          'usex' => $result['u_sex'],
		          'uimg' => $result['u_img'],
		          'sessionid' => $sessionid); 
		    	}
		    }
		  }
		  else
		  {
		  	echo "Error creating database: " . mysql_error();
	      $arr = array(
	      'flag' => '406',
	      'msg' => 'register failed, please try again. :(');
		  }
		}
	}
  }	 //
  echo json_encode($arr); 
?>