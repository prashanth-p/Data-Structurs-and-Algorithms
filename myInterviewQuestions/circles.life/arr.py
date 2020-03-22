class Stack:
    def __init__(self):
        self.arr = []
    
    def push(self, val):
        self.arr.append(val)
    
    def pop(self):
        return self.arr.pop()
    
    def getLen(self):
        return len(self.arr)
    
    def printStack(self):
        print(self.arr)
        

bracketCheck = input("Enter the brackets")

for eachBracket in bracketCheck:
    print(eachBracket)