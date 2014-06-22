
/* Checking if any anagram of a given string is palindrome or not
Given a string, how do we check if any anagram of it can be a palindrome?

For example let us consider the string "AAC". An anagram of it is "ACA" which is a palindrome. We have to write a method which takes a string and outputs true if we can form a palindrome from any anagram of the given string. Otherwise outputs false.

We can immediately think of a solution where we can generate all anagrams of the given string and check if there is any palindrome exists. But this approach is very lengthy and has exponential time complexity (O(n!)).

The key to solve this problem efficiently is to understand how a palindrome is formed. We all know that a palindrome reads the same when you read from left to right or right to left. 

A palindrome can be broken into two halves. where in the first half is the reverse of second half. In case of odd length of strings, we have to ignore the middle character.

So for every character in the first half, there is a corresponding matching character in the second half. This indicates that all the characters in a string must occur even number of times except for one which appears in the middle of the string.

    Hence if we check if there is at most one character with odd occurrences in the string we can say that we can form a palindrome from any anagram.

Here is the Java code which implements this algorithm. For simplicity, I assumed that the input string contains only lowercase English alphabets.*/

import java.util.Scanner;

 
/**
* Created with IntelliJ IDEA.
* User: Ravi
* Date: 11/6/13
* Time: 4:46 AM
* To change this template use File | Settings | File Templates.
*/
public class AnagramPalindrome {
public static void main(String[] args)
{
Scanner reader = new Scanner(System.in);
String input = reader.nextLine();
if( checkPalindrome(input) )
System.out.println("Yes");
else
System.out.println("No");
}
public static boolean checkPalindrome(String input)
{
int [] count = new int[26];
for( int i = 0; i < input.length(); i++ )
{
char ch = input.charAt(i);
count[ch-'a']++;
}
int oddOccur = 0;
for( int cnt:count )
{
if( oddOccur > 1)
return false;
if( cnt%2 == 1 )
oddOccur++;
}
return true;
}
}
