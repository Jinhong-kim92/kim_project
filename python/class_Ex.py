class MyClass:
    var = '안녕하세요' # 클래스멤버
    def sayHello(self): # self = java _ this
        print(self.var)


obj = MyClass()
print(obj.var)
obj.sayHello()
