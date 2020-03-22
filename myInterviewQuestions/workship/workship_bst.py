
class CreditNode:
    def __init__(self,timeStamp,transactionID):
        self.timeStamp = timeStamp
        self.transactionID = transactionID
        self.leftChild = None
        self.rightChild = None
        
    def checkDuplicateAndAdd(self, timeStamp, transactionID):
        if ((self.transactionID == transactionID) and (self.timeStamp == timeStamp)):
            print("Duplicate Value, Will not be appended")
            return False
        elif (self.timeStamp > timeStamp):
            if self.leftChild:
                return self.leftChild.checkDuplicateAndAdd(timeStamp,transactionID)
            else:
                self.leftChild = CreditNode(timeStamp, transactionID)
        else:
            if self.rightChild:
                return self.rightChild.checkDuplicateAndAdd(timeStamp,transactionID)
            else:
                self.rightChild = CreditNode(timeStamp,transactionID)
    
    def printCreditHistoryPreorder(self):
        if self:
            print("Transaction ID: " + str(self.transactionID) + " TimeStamp: " + str(self.timeStamp))
            if self.leftChild:
                # print("left Child")
                self.leftChild.printCreditHistoryPreorder()
            if self.rightChild:
                # print("right Child")
                self.rightChild.printCreditHistoryPreorder()
    
    def maxTimeStamp(self):
        current = self
        while(current.rightChild):
            current = current.rightChild
        return current.timeStamp
    
    def purge(self):
        headNode = self
        maxTimeStamp = self.maxTimeStamp()
        limitVal = maxTimeStamp - (60*60*1000)
        print("limit Val: " + str(limitVal))
        print("Max Time Value: " + str(maxTimeStamp))
        current = self
        while(current.timeStamp < limitVal):
            current = current.rightChild
        
        if current:
            if current.leftChild.timeStamp < limitVal:
                current.leftChild = None
            return current
        else:
            if headNode.leftChild.timeStamp < limitVal:
                headNode.leftChild = None
            return headNode
               

class CreditTree:
    def __init__(self):
        self.headNode = None
    
    def checkDuplicateAndAdd(self, transactionData):
        transactionID = transactionData[0]
        timeStamp = transactionData[1]
        
        if self.headNode:
            self.headNode.checkDuplicateAndAdd(timeStamp,transactionID)
        else:
            self.headNode = CreditNode(timeStamp,transactionID)
    
    def printCreditHistoryPreorder(self):
        if self.headNode:
            self.headNode.printCreditHistoryPreorder()
        else:
            print("No Data")
    
    def purge(self):
        if self.headNode:
            print()
            print("***********************")
            print("purging.....")
            print("***********************")
            self.headNode = self.headNode.purge()
        else:
            print("No Data to purge")

data = CreditTree()
data.purge()
data.printCreditHistoryPreorder()
data.checkDuplicateAndAdd([1,4000000])
data.printCreditHistoryPreorder()
data.checkDuplicateAndAdd([1,2800000])
data.printCreditHistoryPreorder()
data.checkDuplicateAndAdd([2,7500000])
data.checkDuplicateAndAdd([3,4500000])
data.checkDuplicateAndAdd([5,4800000])
data.checkDuplicateAndAdd([4,600000])
data.printCreditHistoryPreorder()

data.purge()
data.printCreditHistoryPreorder()