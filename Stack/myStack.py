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
        
    def isEmpty(self):
        return self.arr == []
    
    def peek(self):
        return self.arr[-1]
    
    
    