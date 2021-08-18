<?php

include 'DbConnect.php' ;
 
 // $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);
 
 $type = $_POST['type'];
 $date = $_POST['date'];

 $Sql_Query = "insert into bookingtbl (type,date) values ('$type','$date')";
 
 if(mysqli_query($conn,$Sql_Query)){
 
 echo 'Data Submit Successfully';
 
 }
 else{
 echo "Error: " . $sql . "<br>" . mysqli_error($conn);
 echo 'Try Again';
 
 }
 mysqli_close($conn);
?>