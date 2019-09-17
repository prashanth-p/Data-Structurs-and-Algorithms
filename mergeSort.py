#########################################################################
# Code Objective: Merge two linked list and return a sorted linked list
# Author: Prashanth Pradeep
# Timestamp: Tuesday, September 17, 2019 6:18:03 PM
#########################################################################

class LinkedListNode:
    def __init__(self, data):
        self.data = data
        self.nextNode = None

class LinkedList:
    def __init__(self):
        self.root = None
        self.length = 0

    def insert(self, value):
        if self.root == None:
            self.root = LinkedListNode(value)
            self.length = 1
            return
        else:
            newNode = LinkedListNode(value)
            currNode = self.root
            while True:
                if (newNode.data == currNode.data):
                    print("Trying to add " + str(newNode.data) + "; Value already in list")
                    return
                if currNode.nextNode == None:
                    self.length += 1
                    currNode.nextNode = newNode
                    return
                currNode = currNode.nextNode    
    
    def printList(self):
        res = []
        if self.root == None:
            return res
        currNode = self.root
        while True:
            res.append(currNode.data)            
            if currNode.nextNode == None:
                return res
            currNode = currNode.nextNode

    def mergeTwoListsAndSortIt(self, listB):
        listA = self
        if (listA.root == None) and (listB.root == None):
            print("FinalList: []") 
            return []
        elif listA.root == None:
            print("FinalList: " + str(listB.printList()))
            return listB.printList()    
        elif listB.root == None:
            print("FinalList: " + str(listA.printList()))
            return listA.printList()    
        
        listC = LinkedList()
        currentNodeA = listA.root
        currentNodeB = listB.root
        currentNodeC = None

        while True:
            if currentNodeA == None:
                # print("in condition A exhausted")
                currentNodeC.nextNode = currentNodeB
                print("FinalList: " + str(listC.printList()))
                return listC.printList()    

            elif currentNodeB == None:
                # print("in condition B exhausted")
                currentNodeC.nextNode = currentNodeA
                print("FinalList: " + str(listC.printList()))
                return listC.printList()

            if (currentNodeA.data < currentNodeB.data):
                if listC.root == None:
                    # print("Adding to node c: A<B")
                    listC.root = LinkedListNode(currentNodeA.data)
                    # print(str(currentNodeA.data))
                    # print(str(listC.root.data))
                    currentNodeA = currentNodeA.nextNode
                    currentNodeC = listC.root
                    # print(str(currentNodeC))
                else:
                    currentNodeC.nextNode = LinkedListNode(currentNodeA.data)
                    currentNodeA = currentNodeA.nextNode
                    currentNodeC = currentNodeC.nextNode
                    print("Iteration: " + str(listC.printList()))
            
            elif (currentNodeB.data < currentNodeA.data):
                if listC.root == None:
                    # print("Adding to node c: B<A")
                    listC.root = LinkedListNode(currentNodeB.data)                    
                    currentNodeB = currentNodeB.nextNode
                    currentNodeC = listC.root
                else:
                    currentNodeC.nextNode = LinkedListNode(currentNodeB.data)
                    currentNodeB = currentNodeB.nextNode
                    currentNodeC = currentNodeC.nextNode
                    print("Iteration: " + str(listC.printList()))

            elif (currentNodeB.data == currentNodeA.data):
                if listC.root == None:
                    # print("Adding to node c: B<A")
                    listC.root = LinkedListNode(currentNodeB.data)                    
                    currentNodeB = currentNodeB.nextNode
                    currentNodeA = currentNodeA.nextNode
                    currentNodeC = listC.root
                else:
                    currentNodeC.nextNode = LinkedListNode(currentNodeB.data)
                    currentNodeB = currentNodeB.nextNode
                    currentNodeA = currentNodeA.nextNode
                    currentNodeC = currentNodeC.nextNode
                    print("Iteration: " + str(listC.printList()))

# Driver Code

l1 = LinkedList()
l2 = LinkedList()

print()
print("*************** Initial Case *********************")
print("Printing l1 ......")
print("Length of l1: " + str(l1.length))
print("l1: " + str(l1.printList()))
print("Printing l2 ......")
print("Length of l2: " + str(l2.length))
print("l2: " + str(l2.printList()))
print("**************************************************")
print()

print("**************************************************")
l1Length = int(input("Enter the number of elements you want in in l1: "))
l2Length = int(input("Enter the number of elements you want in in l2: "))
print("**************************************************")
print()

if(l1Length != 0):
    print("**************************************************")
    print("Entering elements in l1 ......")
    for i in range(l1Length):
        l1.insert(int(input("Enter the " + str(i+1) + "th value: ")))
    print("-----------------------------------")
    print("Printing l1 ......")
    print("Length of l1: " + str(l1.length))
    print("l1: " + str(l1.printList()))
    print("**************************************************")
print()

if(l2Length != 0):
    print("**************************************************")
    print("Entering elements in l2 ......")
    for i in range(l2Length):
        l2.insert(int(input("Enter the " + str(i+1) + "th value: ")))
    print("-----------------------------------")
    print("Printing l2 ......")
    print("Length of l2: " + str(l2.length))
    print("l2: " + str(l2.printList()))
    print("**************************************************")
print()

print("************ Merging List A and B ****************")
l1.mergeTwoListsAndSortIt(l2)
print("**************************************************")
