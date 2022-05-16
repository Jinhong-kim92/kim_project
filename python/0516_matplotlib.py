# matplotlib 라이브러리 활용하여 상품 판매실적 데이터 차트화 시키기

from matplotlib import pyplot as plt
from matplotlib import font_manager, rc

font_name = font_manager.FontProperties(fname="c:/Windows/Fonts/malgun.ttf").get_name()
rc("font",family=font_name)

# plot () 함수를 활용해서 선 그래프 만들기

plt.plot(['1월','2월','3월',],[120,95,150]) # 스마트폰 판매량
plt.plot(['1월','2월','3월',],[50,30,70]) #컴퓨터 판매량
plt.plot(['1월','2월','3월',],[20,15,30]) #oled 판매

plt.xlabel('월별')
plt.ylabel('판매량')
plt.legend('대리점 2022년 상반기 판매실적')
plt.legend(['스마트폰','컴퓨터','oled tv'])

plt.savefig('./output/matplotSales.svg')
