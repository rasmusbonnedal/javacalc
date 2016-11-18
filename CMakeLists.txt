cmake_minimum_required(VERSION 2.8)
project(JavaCalc)

find_package(Java REQUIRED)
include(UseJava)

set(JAR_NAME JavaCalc)
file(GLOB JAVA_SOURCE_FILES src/*.java)

add_jar(${JAR_NAME} SOURCES ${JAVA_SOURCE_FILES} ENTRY_POINT JavaCalc)
