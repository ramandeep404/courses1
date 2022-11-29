<?php
$filename=$_POST["title"];
$uploaddir = './uploads/';
$uploadfile = $uploaddir . $_FILES['file1']['name'];

if (move_uploaded_file($_FILES['file1']['tmp_name'], $uploadfile)) {
    print('File Uploaded with name ' . $filename);
    
} else {
    print("File can't be uploaded:\n");
    
}

?>