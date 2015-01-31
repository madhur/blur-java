#Demo of Gaussian Blur using Java

This repo contains demonstration of compression of images using Gaussian Blur. 
The images are scaled down to 200x200 size and a Gaussian blur is applied. 

The best use of this mechanism is in transferring preview images over mobile network. 

###Input [Height = 3264, Width = 2448, Size = 1.2 MB]
<img src="https://raw.githubusercontent.com/madhur/blur-java/gh-pages/img.jpg" height="286" width="214"/>

###Output [Height = 200, Width = 200, Size = 4KB]
<img src="https://raw.githubusercontent.com/madhur/blur-java/gh-pages/blurredthumbnail.jpg" />

##Usage

```text
git clone
gradle fatjar
cd build/libs
java -jar blur-java-1.0.jar
```