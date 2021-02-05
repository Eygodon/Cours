cmake_minimum_required(VERSION 3.15)
project(untitled C)

set(CMAKE_C_STANDARD 99)

add_executable(untitled main.c Floe.c Floe.h objects.h objects.c Player.c Player.h game.c game.h)