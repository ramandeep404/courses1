<?php

if(empty($_POST['chknames'])){
    echo "none of the boxes were checked";
}else{
    $N = count($_POST['chknames']);
   
    for($i=0; $i < $N; $i++){
        print($_POST['chknames'][$i] . " " . "<br>");
    }
}
?>