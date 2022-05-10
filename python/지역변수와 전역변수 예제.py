

param = 10
strdata = '전역변수'

def func1():
    strdata = '지역변수'
    print(strdata)

def func2(param):
    param = 1

def func3():
    global param
    param = 50

func1()
print(strdata)
func2(param)
print(param)

func3()
print(param)

listdata = [10,20,30,40]
result1 = 50 in listdata
print(result1)

result2 = 40 in listdata
print(result2)
