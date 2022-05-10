#자료구조 결정

sales_performance = {"1월": 59870000, "2월" :37650000, "3월":89425000}

#최적화 소스
items = sales_performance.items()

for key, value in items:
    print(key + "판매실적:",format(value,",")+"원")
    
#포맷(항목, 형식지정자)
    
