
def foo(num) :
    # num을 문자열로 만들어서 뒤집는다. num이 1234이면 a는 '4321'
    a = str(num)[::-1]
    # a를 가지고 (index, a[index]) 의 iter 를 만든다.
    # 그리고  index > 0 and index % 3 == 0 일때 a[index] 뒤에 ','를 붙인 list를 만든다.
    # b = ['4', '3', '2', '1,'] 형태가 된다.
    b = [c + ',' if (i and (i % 3 == 0)) else c for i, c in enumerate(a)]
    # 뒤집어진 문자열로 작업했기 때문에 다시 뒤집는다.
    b = b[::-1]
    # 문자열로 합쳐서 결과를 돌려준다.
    return string.join(b, '').replace('-,', '-')

