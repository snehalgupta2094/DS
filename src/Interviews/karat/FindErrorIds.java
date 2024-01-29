package Interviews.karat;
/*
Given a collection of actions and userIds an error occurs when a userId takes a specific action in order for example

A => B => => C gives an errror
B => A => C no error and etc

Write a function that takes in a list of (Actions, UserIds) pairs and returns the user Id that ecounters the error

Sample Input:

action_user_1 = [
["A", "1"],
["B", "1"],
["B", "2"],
["C", "1"],
["C", "2"],
["C", "3"],
["A", "2],
["A", "3"],
["A", "2"],
["B", "2],
["C", "2"],
]

Expected output 1,2

action_user_2 = [
["A", "1"],
["A", "1"]
["A", "1"]
["B", "1"],
["B", "2"],
["C", "2"],
["C", "2"],
["C", "3"],
["A", "2],
["A", "3"],
["A", "2"],
["B", "2],
["C", "2"],
]

Expected output 2

Can someone provide some insight on how to solve this
Error sequence: ABC
* */
public class FindErrorIds {

}
