# bmi (체질량지수) 계산하기를 파이썬 프로그램으로 작성
#bmi 바디 메스 인덱스의 약자로 체중을 신장의 제곱으로 나눈 값으로
#체지방 축적을 잘 반영하기 때문에 비만도 판정에 많이 사용한다.

#<신체 지수에 의한 비만의 분류>
#정상: bmi 20~25
#과체중(1도비만):bmi 25.1 ~29.9
#비만(2도) : bmi 30~40
#고도 : bmi 40.1 이상


weight = float(input("몸무게를 kg 단위로 입력하세요 >>"))
height = float(input("키를 미터 단위로 입력하세요>>>"))
#bmi = (몸무게(실수) /(키(실수)**2))
bmi = (weight/(height*2))
if bmi >=  20 and bmi <= 25:
     decision = "정상"
elif bmi >= 25.1 and bmi <= 29.9:
     decision = "과체중(1도 비만)"
elif bmi >=  30 and bmi <= 40:
     decision = "비만(2도)입니다"
elif 40 < bmi:
     decision = "고도비만입니다"

print("당신의 비만지수 = ", bmi)
print("비만의 분류=",decision)


