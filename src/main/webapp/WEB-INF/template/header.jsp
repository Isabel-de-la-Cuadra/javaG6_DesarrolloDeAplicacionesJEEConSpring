<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>${param.title}</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Isabel de la Cuadra Lunas">

<!-- Bootstrap CSS 5.1.3-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<style>

/*
body{

background-image: linear-gradient(to right, rgba(94,69,255,0), rgba(94,69,255,1));

}
*/

#card {

background-image: linear-gradient(to bottom right, rgba(0, 0, 255, 0.2), rgba(0, 0, 255, 0.9));

}

/*
#botonColor::before,
#botonColor::after{
content:"";
display:block;
position:absolute;
inset: 0;
z-index: -1;
} 

#botonColor:before{
background-image: linear-gradient(to bottom right, #aeffb9 0%, #a091ff 100%);
transition: transform 200 ms;
}

#botonColor:after{
background-color: rgba(160,170,255);
}

#botonColor:hover::before,
#botonColor:focus::before{
transform: scale(1.1);
}
*/

img {
  position: relative;
  animation-name: auto;
  animation-duration: 4s;
}

@keyframes auto {
  0%   {left:0px; top:0px;}
  50%  {left:280px; top:0px;}
  100% {left:0px; top:0px;}
}

</style>

</head>