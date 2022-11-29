<?php

for($i=1;$i<=100;$i++)
{
    $text=$i;
    //$text = rand(1,99999);
    
    $height = 25;
    $width = 65;
    
    
    $font_size = 14;
    $filename=$i . ".jpg";
    $image_p = imagecreate($width, $height);
    $black = imagecolorallocate($image_p, 250, 250, 250);
    $white = imagecolorallocate($image_p, 120, 120, 120);
    imagestring($image_p, $font_size, 5, 5, $i, $white);
    imagejpeg($image_p, $filename);
    
}
print("Images Created");
?>