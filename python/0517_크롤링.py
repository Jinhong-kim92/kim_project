#웹 크롤링

from bs4 import BeautifulSoup
from urllib.request import urlopen

url = 'https://music.bugs.co.kr/chart/track/week/total?chartdate=20220517'

f = urlopen(url)
fp = f.read()
f.close()

soup = BeautifulSoup(fp, 'html.parser')
titles = soup.select('p.title')
artists = soup.select('p.artist')
print("<금일 가요 top 10>")
for i in range(0,10):
    title = titles[i].text.strip()
    artist = artists[i].text.strip()
    print(i+1, title, artist)

    
