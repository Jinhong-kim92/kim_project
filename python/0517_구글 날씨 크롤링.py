from bs4 import BeautifulSoup
import requests
import re
import os

URL = 'https://www.google.com/search?client=opera&hs=iaa&ei=FHvcX9HDAtWC-QaY95HYBA&q=서울날씨&oq=서울날씨&gs_lcp=CgZwc3ktYWIQAzIICAAQsQMQgwEyBAgAEEMyAggAMgIIADICCAAyAggAMgIIADICCAAyBggAEAcQHjIGCAAQBxAeOgQIABBHOgQIABANOgcIABCxAxANUJHjBVi55wVg0OgFaAFwAngAgAFwiAHfA5IBAzQuMZgBAKABAaoBB2d3cy13aXrIAQjAAQE&sclient=psy-ab&ved=0ahUKEwjRnZqooNftAhVVQd4KHZh7BEsQ4dUDCAw&uact=5'

headers = {
    "User-Agent": 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36 OPR/67.0.3575.115'}

page = requests.get(URL, headers=headers)
soup = BeautifulSoup(page.content, 'html.parser', from_encoding="utf8")
data = soup.find("div", {"id": "wob_d"})
refine = data.findAll("span")

data_list = []

for x in refine:
    data_list.append(x.get_text())

print('[서울날씨]')
print(f'현재온도: {data_list[0]}', end="")
print(data_list[3])

print("강수확률: ", end="")
print(data_list[6])

print("습도: ", end="")
print(data_list[7])

print("풍속: ", end="")
print(data_list[9])