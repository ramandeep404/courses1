<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <form action='shownames.php' method='post'>
            Names :
            <br>
       <?php
//php program to display records from a table

$hostname = 'localhost';

$username = 'root';

$password = '';

try {
    $dbh = new PDO("mysql:host=$hostname;dbname=abcdef", $username, $password);
    
     $sql = "SELECT * FROM students";
    foreach ($dbh->query($sql) as $row)
        {
        print("<input type='checkbox' name='chknames[]' value='".$row["name"]. "'>" . " " . $row["name"] . "<br>");
        }

   
    $dbh = null;
}
catch(PDOException $e)
    {
    print($e->getMessage());
    }
?>
            <br>
            <input type='submit' value='Show Names'>

    </body>
</html>
