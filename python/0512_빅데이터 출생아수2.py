"""
    파이썬으로 빅데이터 파일 분석/처리
    년도별 성별 구분하여 출생아 수 통계처리하는 프로그램 작성
"""
def countBirths():
    ret = []  # list 자료구조 [(2008, 35253373),(2009, 635342626), ...]
    for y in range(2008, 2019):  # 2008년 ~ 2018년 까지
        count_male = 0      # 남자 아이 출생아수
        count_female = 0    # 여자 아이 출생아수

        filename = 'names/yob%d.txt' %y
        with open(filename, 'r') as f:  # f는 열린 파일 객체
            data = f.readlines()
            for d in data:
                if d[-1] == '\n':   # 한 줄의 데이터 마지막 끝이 엔터 '\n' 이면
                    d = d[:-1]      # Emma,F,18813 을 변수에 저장 => 슬라이싱을 적용하여 코딩
                # 수정    Emma,F,18813
                temp = d.split(',')
                gender = temp[1]
                birth = temp[2]

                if gender == 'M':
                    count_male += int(birth)
                else:
                    count_female += int(birth)
        ret.append((y, count_male, count_female))      # append() 함수는 인자값 하나만 필요함!!
    return ret

result = countBirths()
with open('birth_by_gender.csv', 'w') as f:  # f는 쓰기파일객체 => 읽기는 'r' 쓰기는 'w'
    print('----------------------')
    print('년도별 성별 구분하여 출생아수')
    print('----------------------')
    for year, birth_male, birth_female in result:
        data = '%s,%s,%s\n' %(year, birth_male, birth_female)
        print(data)
        f.write(data)
