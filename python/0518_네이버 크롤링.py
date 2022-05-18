# -*- coding: utf-8 -*-
"""
Created on Wed May 18 14:14:52 2022

@author: hexagon
"""


from bs4 import BeautifulSoup
from urllib.request import urlopen

url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%82%A0%EC%94%A8"
html = urlopen(url).read()
soup = BeautifulSoup(html, "html.parser")
temperature = soup.find(class_="temperature_text")
weather = soup.find(class_="weather before_slas")
