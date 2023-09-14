# rubik
Implementation in Java of the Rubik's cube, 2D, terminal/text-based.

## Disclaimer
This is my first programming project ever, the first I autonomously built up after attending some programming classes. Being a speed cuber since middle school, the first thing I thought when I discovered matrices was the Rubik's cube itself. So, I wanted to implement a Rubik's cube simulator; however, I didn't know anything about how the graphic part could be implemented, so I made do by flattening the cube on the terminal and using characters instead of colors.  
As you can imagine, assessing the code quality is something my own eyes refuse to do. The code is also in Italian, comments are very rare and documentation does not exist at all. I'm publishing it here because I want to keep a record of this starting point in my life. Despite being an awful piece of code... it works! If you would like to try it, please proceed with the next section.

## Execution
You will only need `javac` and `java`, thus, install the Java JDK or, better, the [OpenJDK](https://openjdk.org/).  
Clone the repository
```sh
git clone https://github.com/achillelamb/rubik.git
```
Move into the main folder 
```sh
cd rubik
```
and compile the source code
```sh
javac -d bin *.java
```
Then, move into `bin`
```sh
cd bin
```
and run the application
```sh
java rubik.Main
```
You will be prompted at something like this:  
![image](https://github.com/achillelamb/rubik/assets/58937437/fb989666-1722-4232-97a8-c6db3ce71ed6)  
  
A cheatsheet of moves you can perform on the cube is available [here](https://jperm.net/3x3/moves), and a special move is `risolvi`, which will automatically solve and print the cube. The result is this:  
![image](https://github.com/achillelamb/rubik/assets/58937437/9c2e4b7e-195e-4730-8d98-72c201452cb0)

