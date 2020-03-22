from myStack import Stack
unsortedStack = Stack()
sortedStack = Stack()
temp = None


# Driver Code

inp = [int(each) for each in input("Enter the elements of the stack: ").strip().split(" ")]
inpStack = Stack()
for each in inp:
    inpStack.push(each)
    
print("Your input Stack is: ")
inpStack.printStack()
