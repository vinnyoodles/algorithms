## Back of the Line

Johnny Acorn is an elementary school student. In his class whenever the students line up to move to a new location, the teacher lines the students up in alphabetical order based on their last names. The teacher always leads the line. Johnny is often in the front of the line, but he is a mischievous boy. He wants to cause trouble at the back of the line.

Johnny is given the opportunity to change his last name given a word bank. He can apply a sequence of operations to the word bank before choosing one of the words for his last name.

- Reverse a word in the word bank.

- Concatenate two words in the word bank (in any order) and insert the result back into the word bank.

Help Johnny find the last name which would maximize his chances to be in the back of the line for his class. Johnny may keep `Acorn` as his last name.

Each word in the word bank will only consist of lowercase English letters but you must capitalize the first letter of the final last name.

[Wikipedia’s definition for alphabetical order](https://en.wikipedia.org/wiki/Alphabetical_order): To determine which of two strings comes first in alphabetical order, their first letters are compared. If they differ, then the string whose first letter comes earlier in the alphabet comes before the other string. If the first letters are the same, then the second letters are compared, and so on. If a position is reached where one string has no more letters to compare while the other does, then the first (shorter) string is deemed to come first in alphabetical order.

### Input
The input begins with an integer *n*,1 ≤ n ≤ 1,000, the initial size of the word bank. This is followed by *n* lines each containing a word in the word bank. Each word contains no more than 20 lowercase English letters.

### Output
Output the last name Johnny should choose.


#### Sample Input 1
```
2
apple
seed
```

#### Sample Output 1
```
Seedelppa
```

#### Sample Input 2
```
3
aa
ab
cca
```

#### Sample Output 2
```
Ccabaaa
```

#### Sample Input 3
```
2
aba
aaa
```

#### Sample Output 3
```
Acorn
```
