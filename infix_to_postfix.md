## 中序转后序	
---

	Infix to Postfix Conversion 

1. We use a stack
2. When an operand is read, output it
3. When an operator is read
	a. Pop until the top of the stack has an element of lower precedence
	b. Then push it
4. When ')' is found, pop until we find the matching '(' and also pop this '(' without output
5. ( has the lowest precedence when in the stack
6. but has the highest precedence when in the input
7. When we reach the end of input, pop until the stack is
empty


---
	中序转后序
1. 我们使用栈
2. 当读到数字，直接输出
3. 当读到操作符,
	a.出栈知道栈顶的符号有更低的优先级
	b.将读到的操作符入栈
4. 当读到')'，出栈直到遇到'(' 并将这个(也出栈 (但不需输出'(')
5. '('在栈里是最低的优先级
6. 但是在输入时有最高优先级
7. 当读完输入时，出栈知道清空

---
实例.
3 + 4 * 5 / 6

|step | 	 Cur   |    Stack  | Output| Desc|
|:---:|:------:|:-----:|:---:| :---:|
|1| 3 |  | 3 | read number, output
|2| + | + | 3 | read +, push into stack 
|3| 4 | + | 3 4 | read number, output
|4| * | + * | 3 4 | read star, star > +, push into stack
|5| 5 | + * | 3 4 5 | read number, output
|6 a| / | + | 3 4 5 * | read /, / = star, thus pop stack
|6 b| / | + / | 3 4 5 * | read /, / > , push into stack
|7| 6 | + / | 3 4 5 * 6| read number, output
|8|  | + | 3 4 5 * 6 /| pop stack
|9|  |  | 3 4 5 * 6 / +| pop stack, finish

---
实例2
(300+23)*(43-21)

|step | 	 Cur   |    Stack  | Output| Desc  |
|:---:|:------:|:-----:|:---:| :---:|
|1| ( | ( |  | read (, push into stack
|2| 300 | ( | 300 | read number, output
|3| + | ( + | 300 | read +, + > (, push into stack
|4| 23 | ( + | 300 23 | read number, output
|5| ) |  | 300 23 + | pop stack until seeing '('
|6| * | * | 300 23 + | read *, push into stack
|7| ( | * ( | 300 23 + | read (, push into stack
|8| 43 | * ( | 300 23 + 43| read number, output
|9| - | * ( - | 300 23 + 43| read -, push into stack
|10| 21 | * ( - | 300 23 + 43 21| read number, output
|11| ) | * | 300 23 + 43 21 - | pop stack until seeing '('
|12|  |  | 300 23 + 43 21 - *| pop stack, finish

---

More examples can be found on 
[Slides](https://cs.nyu.edu/courses/Fall12/CSCI-GA.1133-002/notes/InfixToPostfixExamples.pdf
)	
	