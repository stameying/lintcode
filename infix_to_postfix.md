	Infix to Postfix Conversion
1. We use a stack
2. When an operand is read, output it
3. When an operator is read
	a. Pop until the top of the stack has an element of lower precedence
	b. Then push it
4. When ) is found, pop until we find the matching (
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
4. 当读到')'，出栈知道遇到'('
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
	
	