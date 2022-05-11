from random import shuffle
from time import sleep

gamenum = input ("로또 게임 회수를 입력하세요>>")

for i in range (int(gamenum)):
    balls = list(range(1,46))  #1~45 까지 만들겠다
    lottoresult = []

    for j in range(6):
        shuffle(balls)
        number = balls.pop()
        lottoresult.append(number)
    lottoresult.sort()
    print("로또번호[%d]:" %(i+1), end = '')
    print(lottoresult)
    sleep(1)
        
