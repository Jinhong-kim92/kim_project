#파이썬으로 빅데이터 파일 분석처리

def countBirths():
    ret = []
    for y in range(2008,2019): #2008 ~ 2018
        count = 0
        filename = 'names/yob%d.txt' %y

        with open(filename, 'r') as f: #f는 열린파일객체
            data = f.readlines()
            for d in data:
                if d [-1] == '\n':
                    d = d[:-1]
                   
                birth = d.split(',')[2] 
                count += int(birth)
        ret.append((y,count))
    return ret
result = countBirths()
with open('birth_by_year.csv','w') as f: #f 는 쓰기 파일 객체]
    print ('년도별 출생아수')
    print('------------------------')
    for year, birth in result:
        data = '%s,%s\n'%(year, birth)
        print(data)
        f.write(data)
    
