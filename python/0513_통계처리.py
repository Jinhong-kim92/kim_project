# 연도별 인기 있는 상위 10개 이름을 통꼐처리 프로그램 작성

from os.path import exists

def getTop10BabyName(year):
    #자료구조
    nameMale = {}
    nameFemale ={}

    filename = 'names/yob%s.txt'%year
    if not exists(filename):
        print('[%s] 파일이 존재하지 않습니다.'%filename)
        return None

    with open(filename, 'r') as f:
        data = f.readlines()
        for d in data: #d 변수에는 Emma,f,20455이 저장
            if d[-1] == '\n':
                d = d[:-1]
            temp = d.split(',')
            name = temp[0]
            gender = temp[1]
            birth = temp[2]

            if gender == 'M':
                ret = nameMale

            else:
                ret = nameFemale

            if name in ret:
                ret[name] += int(birth)
            else:
                ret[name] = int(birth)
        retM = sorted(nameMale.items(), key = lambda x:x[1], reverse=True)
        retF = sorted(nameFemale.items(), key = lambda x:x[1], reverse = True)

        for i, name in enumerate(retM):
            if i > 9:
                break
            print('Top_%d  남자아이이름:%s'%(i+1,name))
                

y = input("인기순 상위 10개 이름을 알고 싶은 출생년도를 입력하세요>>>")
getTop10BabyName(y)
