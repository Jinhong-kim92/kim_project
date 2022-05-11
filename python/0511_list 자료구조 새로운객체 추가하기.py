list_name = ["박태호","오수철","손유일","김종오"]

list_name.append('이두희')#그냥 마지막에 추가할때

position = list_name.index("손유일") # 인덱스값 얻어오
list_name.insert(position, "홍길동")  #특정위치에 추가할때


print(position)

print(list_name)
