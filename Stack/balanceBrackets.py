from myStack import Stack

def matchBrackets(br1,br2):
    print("In Match")
    if(br1=='[' and br2 == ']'):
        return True
    elif(br1 =='(' and br2 ==')'):
        return True
    elif(br1 == '{' and br2 == '}'):
        return True
    else:
        # print("didnt match")
        return False


def isBalanced(inp):
    s = Stack()
    isBalancedFlag = True
    for eachBracket in inp:
        if not isBalancedFlag:
            break
        print(f"currently evaluating {eachBracket}")
        # s.printStack()
        if eachBracket in "([{":
            s.push(eachBracket)
            
        else:
            if s.isEmpty():
                isBalancedFlag = False
            else:
                br1 = s.pop()
                br2 = eachBracket
                # print(f"br1: {br1} br2: {br2}")
                if not matchBrackets(br1,br2):
                    isBalancedFlag = False
    if s.isEmpty():
        return isBalancedFlag
    else:
        return False
            
# Driver Code
inp = input("Enter the bracket sequence : ").strip()
result = isBalanced(inp)
if result:
    print("Balanced")
else:
    print("unbalanced")
