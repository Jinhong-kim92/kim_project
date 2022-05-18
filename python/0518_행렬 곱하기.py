# -*- coding: utf-8 -*-
import numpy as np

#지역 행렬
R = np.array([[5000,2000,1500],[2000,3000,1000]])

#가격 행렬

P = np.array([[2],[4],[3]])

#원가 행렬

CP = np.array([[1.8],[3.5],[2.5]])

RP = np.dot(R,P)
RCP = np.dot(R, CP)
RP_RCP = RP - RCP

print("한국과 미국의 지역별 매출\n" , RP)
flatten_list1 = RP.flatten() #flatten() 함수는 다차원 배열 1차원으로 바꿔줌
annual_sales = sum(flatten_list1)
print("지역별 연간 매출액=>",annual_sales,'\n')

print("한국과 미국의 지역별 원가\n" , RCP)
flatten_list2 = RCP.flatten() 
total_costs = sum(flatten_list2)
print("지역별 연간 총원가=>", total_costs, '\n')

print("한국과 미국의 지역별 이익\n" , RP_RCP)
flatten_list3 = RCP.flatten() 
gross_margin = sum(flatten_list3)
print("지역별 연간 총이익=>", gross_margin)