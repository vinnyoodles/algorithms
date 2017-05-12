## Out of Scope

The computer science department has recently recognized the need to teach students in CS 1114 about scopes. They hired the laziest graduate student Eric Williamson to create an interpreter for a simple scope language they developed. Predictably they paid him in solely pizza. Eric lacked self control and fell into a food coma after eating all of the pizza. It is now your job as an upstanding member of the department to actually do the work and help out those poor CS 1114 students.

The department designed a language that contains different scopes and has the following specification.

A __program__ consists of a series of one or more statements. that are evaluated one at a time from top to bottom.

An __Identifier__(iden) in this programming language is a sequence of one or more lowercase characters from `a` to `z`.

A __number__ in this programming language is a sequence or one or more decimal digits. The value of a number will never exceed the size of a 32 bit signed int.

__Statements__ can consist of Assignments, Scopes, and Prints.

__Assignment__ statements will fall on their own line and have the following 2 structures "iden ’=’ iden" and "iden ’=’ number".

__Print statements__ will fall on their own line and have the following structure “print’ iden"

__Scope statements__ will fall on multiple lines and contain at least 1 other statement inside of them. Scope statements are structured like:

```
{
Statement
}
```

Any identifier that has not been assigned will have the value of 0.

The __assignment statement__ associates the given identifier on the left-hand side with the number on the right hand side. If the right hand side is an identifier then the left-hand side is assigned the value of the right-hand side identifier.

The __print statement__ prints the value of the identifier given to the stdout as an Integer on its own line. The value is based on the current scope of the program in execution.

The __scope statement__ copies the assignments from the parent scope (a parent scope is the scope we are in when the scope statement is called). The scope lasts from the { token to the } token. Any assignments that are within a scope are only valid until the closing of the scope(this means they are valid for any child scopes). When a scope is closed any assignments that were performed are reverted, and the environment returns to the same set of identifier values that was present before the scope statement. Every program in the language has a base scope that is the parent of all scopes and is considered open until the end of the program.

Students have created valid programs in this language to see what the output will be. It is your job to interpret this program and provide the respective output. It is guaranteed that at least one print statement will be present in the program.

### Input

The first line in the input will be `N`, the number of lines in the student program, where 1 ≤ N ≤ 2000.

The next `N` lines will be a valid student program that matches the given spec.

### Output
Output the program output of the print statements when executing the given program. As noted in the spec each print statement will output an integer on a separate line.

#### Sample Input 1
```
15
a = b
{
c = 9
print c
}
print c
{
c = 99999
{
c = d
print c
print d
}
print c
}
```

#### Sample Output 1
```
9
0
0
0
99999
```

#### Sample Input 2
```
12
a = 4
{
print a
a = 7
print a
{
print a
a = 9
}
print a
}
print a
```

#### Sample Output 2
```
4
7
7
7
4
```

#### Sample Input 3
```
19
b = 4
b = a
print b
{
a = 7
print b
}
a = 20
{
{
{
{
print a
print b
}
}
}
}
print a
```

#### Sample Output 3
```
0
0
20
0
20
```
