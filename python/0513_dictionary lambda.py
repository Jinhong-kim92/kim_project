names= {"박태호":85,"오수철":70,"손유일":90,"안재홍":65,"이두희":80}

ret1 = sorted(names)

#sorted()함수에 dictionary 데이터를 인자값으로 주면 key 값을 오름차순으로 정렬시키고 list 로 리턴해줌

print(ret1) #[이름]


ret2 = sorted(names.items(), key=lambda x:x[0])
print(ret2)

ret3 = sorted(names.items(), key=lambda x:x[1])
print(ret3)

ret4 = sorted(names.items(), key=lambda x:x[1], reverse =True)
print(ret4)

