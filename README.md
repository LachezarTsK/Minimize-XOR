# Minimize-XOR
Challenge at LeetCode.com. Tags: Bitwise Operations, Greedy.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

The solution for each language is in two versions: with Lambda Expression and without Lambda Expression.

Fundamentally, both of these types of solutions have the same approach to the problem but the variant with Lambda Expression adds a pinch of sophistication to the solution.<br/>

Both of these approaches run for approximately the same time for most of the languages presented here, i.e., 0 milliseconds.<br/>
But it seems that for Java and Kotlin (and occasionally, on and off, for other languages) the combined cost of introducing an additional method and a lambda expression and having only one if-statement (the if-statement checks only for one condition) in the loop for minXor is greater than the cost of having two if-statements (where each if-statement checks for two conditions) in the loop for minXor.<br/>
In this case, the application runs for 1 to 3 milliseconds.

Basically, concerning the loop for minXor, the Lambda Expression reduces the two if-statements (where each if-statement, in turn, checks for two conditions) to one if-statement (where each if-statement checks only for one condition).
