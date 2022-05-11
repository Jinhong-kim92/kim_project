from random import shuffle

male = ["김진홍","윤종인","홍지수","이형준","유동희"]
female = ["성지영","김은정","김선정","이현아","이은진"]

shuffle(male)
shuffle(female)

couples = zip(male, female)#zip 형식은  list 로 형변화 필요

couples_data = list(couples)

for i, couple in enumerate(couples_data):
    print ('♡%s♡♡%s♡'%(couple[0], couple[1]))
