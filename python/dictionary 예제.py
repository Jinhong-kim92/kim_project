#문제4 'L' 이라는 전자회사의 2022년 상반기 판매 실적이 다음과 같다.
#1월: 59870000
#2월: 37650000
#3월: 89425000

#[실행결과]
#2022 상반기 판매실적
#1월 판매실적:59,870,000원
#2월 판매실적:37,650,000원
#3월 판매실적:89,425,000원


sales_performance =  {"1월" : 59870000,  "2월" : 37650000, "3월" : 89425000}
key_values = sales_performance.keys()
print(key_values)

values = sales_performance.values()
print(values)


# 알고리즘 및 로직(logic)구상 (시나리오) = > 제어문의 조합 > for 문, if 문 활용

#판매금액마다 천단위 콤마찍기

#1. 597870000 >00007895
#[0] 00007895 > 8자리 > 어떤조건일때 콤마 넣을건지? 인덱스 3 배수이고 값이 8자리하고 같지않음 3자리에 콤마넣기

for keys in key_values:
    num = str(sales_performance[keys])
    value = num[::-1]
    ret = ''
    for i, c in enumerate(value):
        i = i + 1
        if i != len(value) and i%3 == 0:
            ret = ret + (c+',')
        else:
            ret = ret + c
    ret = ret[::-1]
    print("%s 판매실적: %s 원" %(keys, ret))
