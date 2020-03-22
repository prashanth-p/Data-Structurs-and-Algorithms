class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        self.length = 0
        
        
    def add(self, data):
        headNode = self.head
        if headNode == None:
            self.head = Node(data)
            self.length = 1
            return
        else:
            currNode = headNode
            while(currNode.next != None):
                currNode = currNode.next
            
            newNode = Node(data)
            currNode.next = newNode
            self.length += 1
            return
    
    def printList(self):
        head = self.head
        currentNode = self.head
        print(f"The length of ")
        while(currentNode.next != None):
            print(f"{currentNode.data} ", end=" ")
            currentNode = currentNode.next
            

# Driver Code:
# Test
myList = LinkedList()

myList.add(5)
myList.add(6)
myList.add(8)

myList.printList()