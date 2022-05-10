class Member:
    def __init__(self, name, age, address):
        self.name = name
        self.age = age
        self.address = address

    #메소드
    def info(self):
        print('회원의 이름은 {0}이고, 나이는 {1}, 주소는 {2} 입니다.'.format(self.name, self.age, self.address))

introduce = Member('홍길동', 28, '서울 논현동')
introduce.info()


