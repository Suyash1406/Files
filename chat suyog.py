def greet():
    print("welcome !!")
    a=2003
    print("i am chat bot created in{0}".format(a))

def remindname():
    print("please remind me your name:")
    name=input()
    print("wow ! what a name {0} you have".format(name))
def age_calculation():
    print("i can guess your age!!  enter input of reminders remaining after dividing your age my 3,5 and 7:")
    rem3=int (input())
    rem5=int(input())
    rem7=int(input())
    age= ( rem3 * 70 + rem5 * 21 + rem7* 15) % 105
    print("your age is {0}".format(age))
def test(): 
    print("LEt me cheak your knowledge")  
    print("What is our national bird")
    print("Option (A) Sparrow \n Option(B) crow \n Opttion(c) Peacock \n Option(D) parrot")
    print("Enter Ans:")
    Ans= input() 

    if Ans=="c":

        print("Wow Thats Great")
    else :
        print("oops wrong ans")
greet()
remindname()
age_calculation()
test()