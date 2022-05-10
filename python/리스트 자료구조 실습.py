list1 = [10,20,30,40,50]
list2 = ['a','b','c']
list3 = [10,'a','abc',[10,20,30,40,50],['a','b','c']]
list1[0] = 60
print(list1)

def myfunc():
        print('python Good!!')


list4 = [10, 20, myfunc]
list4[2]()

tuple1 = (10,20,30,40,50)
tuple2 = ('a','b','c')
tuple3 = (10,'a','abc',[10,20,30,40,50],['a','b','c'])
# tuple1[0] = 60
print(tuple1)

def myfunc():
    print('Python Good!!')

tuple4 = (10,20,myfunc)
tuple4[2]()
