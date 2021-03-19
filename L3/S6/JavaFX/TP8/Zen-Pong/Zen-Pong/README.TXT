Software architecture of Zen-Pong
=================================

Location:'Zen-Pong' directory
Contents
--------
.
├── bin
├── README.TXT
└── src
    ├── Makefile
    └── zen_pong_no_fxml
        ├── Paddle.java
        ├── PongAnimation.java
        ├── PongComponents.java
        └── ZenPong.java

3 directories, 6 files

---------
Compiling
---------

1. Change to 'src' directory then use 'make all' command:
$ cd src
$ make all
javac -d ../bin -Xlint:all -Xdiags:verbose  zen_pong_no_fxml/Paddle.java
javac -d ../bin -Xlint:all -Xdiags:verbose  zen_pong_no_fxml/PongComponents.java
javac -d ../bin -Xlint:all -Xdiags:verbose  zen_pong_no_fxml/ZenPong.java
javac -d ../bin -Xlint:all -Xdiags:verbose  zen_pong_no_fxml/PongAnimation.java
find . -name "*.fxml" -exec cp {} ../bin/{} \;

2. Go back to parent directory to get the generated files, located in 'bin' sub-directories:
$ cd ..
.
├── bin
│   └── zen_pong_no_fxml
│       ├── Paddle.class
│       ├── PongAnimation.class
│       ├── PongComponents$1.class
│       ├── PongComponents.class
│       └── ZenPong.class
├── README.TXT
└── src
    ├── Makefile
    └── zen_pong_no_fxml
        ├── Paddle.java
        ├── PongAnimation.java
        ├── PongComponents.java
        └── ZenPong.java

4 directories, 11 files

---------
Executing 
---------

Change to 'bin' sub-directory then execute different Java classes
$ cd bin
$ java zen_pong_no_fxml.ZenPong
