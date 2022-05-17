# -*- coding: utf-8 -*-
"""
Created on Tue May 17 14:24:13 2022

@author: hexagon
"""
from wordcloud import WordCloud, STOPWORDS
import matplotlib.pyplot as plt
from PIL import Image
import numpy as np

#텍스트 파일

text = open ('./data/usa_president_message.txt', encoding='UTF-8').read()

#image masking

image_path = './data/usa_map.jpg'
usa_map = np.array(Image.oper(image_path))

#이미지 생성

wordcloud = WordCloud(background_color='white', 
                        max_font_size = 100,
                        max_words = 1000,
                        stopwords = STOPWORDS,
                        mask = usa_map).generate(text)



fig = plt.figure(figsize=(15,15))
plt.imshow(wordcloud, interpolation='bilinear')
plt.axis('off')
plt.savefig('./output/usa_president_massege_wordcloud_map02.svg)






















































'

