from random import shuffle
from time import sleep

gamenum = int(input ("로또 게임 회수를 입력하세요>>"))

listdata = list(range(1,46))

for i in range(1, gamenum+1):
    shuffle(listdata)
    print("로또번호[%d]:" %i, sorted(listdata[:6]))
    sleep(1)
    
