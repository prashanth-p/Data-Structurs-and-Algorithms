highestTimeStamp = None
creditDict = {}
# transaction: type list, [id, ms]
def duplicate(transaction):
    transactionID = transaction[0]
    timestamp = transaction[1]
    # creditDict = {keyID: timestamp}    
    if transactionID in creditDict:
        print("Duplicate")
    else:
        print("Unique")
        creditDict[transactionID]= timestamp
        
def purge():

    creditDictTimeStamp = [*creditDict.values()]
    creditDictTimeStamp.sort()
    highestTimeStamp = creditDictTimeStamp[-1]
    limitDictValue = highestTimeStamp - 3600
    
    # Purging Data 
    itemsToDelete = []
    for eachKey,eachVal in creditDict.items():
        if eachVal < limitDictValue:
            itemsToDelete.append(eachKey)
    for eachKey in itemsToDelete:
        del creditDict[eachKey]
        
duplicate([1, 2500])
duplicate([1,2500])
duplicate([2,4000])
duplicate([3,1300])
duplicate([4,6000])

print(creditDict)
purge()
print(creditDict)
            

