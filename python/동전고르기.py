money = int(input("금액을 입력해 주세요:"))

list_money  = [50000,10000,5000,1000,500,100,50,10,1]

list_str_money = ["오만원권","만원권","오천원권","천원권","오백원","백원","오십원","십원","일원"]

for i in range(0,9):
        portion,remainder = divmod(money,list_money[i]) #divmod _몫과 나머지 한번에 구함
        money=remainder
        if portion > 0 and i <4:
            print(list_str_money[i]+' '+str(portion)+'매')
        elif portion > 0 and i >= 4:
            print(list_str_money[i]+' '+str(portion)+'개')
