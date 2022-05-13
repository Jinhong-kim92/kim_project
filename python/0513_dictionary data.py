names= {"박태호":85,"오수철":70,"손유일":90,"안재홍":65,"이두희":80}

ret1 = sorted(names)

#sorted()함수에 dictionary 데이터를 인자값으로 주면 key 값을 오름차순으로 정렬시키고 list 로 리턴해줌

print(ret1) #[이름]

def f1(x):
    return x[0]

def f2(x):
    return x[1]

ret2 = sorted(names.items(), key=f1)
print(ret2)

ret3 = sorted(names.items(),key=f2)
print(ret3)

ret4 = sorted(names.items(), key=f2, reverse =true)
print(ret4)
