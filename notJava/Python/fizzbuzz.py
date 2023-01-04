print("Enter number 1 (fizz): ")
num1 = input()
print("Enter number 2 (buzz): ")
num2 = input()
print("Enter limit: ")
num3 = input()

for item in range(1,num3+1):
    if (item%num1==0 and item%num2==0):
        print("fizz buzz "+str(item))
    elif item%num1==0:
        print("fizz "+str(item))
    elif item%num2==0:
        print("buzz "+str(item))