# task-search-repo

## 기능 설명
searchview에 입력한 검색어를 이용해 깃허브 레포지토리를 검색하고, 결과를 목록으로 표현한다.

## 사용 라이브러리
- retrofit
- moshi
- viewmodel
- livedata

## 동작
1. searchView를 클릭해 검색어를 입력해 결과를 얻는다.
<table>
<tr>
  <td>
  <img src="https://user-images.githubusercontent.com/23499504/148016801-06c88537-9c6b-4d51-a987-b37f5a225496.png" width="200"/> 
  <img src="https://user-images.githubusercontent.com/23499504/148016655-91a86787-e197-45a2-97f2-385129ce4afe.png" width="200"/>
  </td>
</tr>
</table>

2. drop-down-arrow가 있는 텍스트를 눌러 sort 기준을 선택한다.

오른쪽의 화살표를 이용해서 내림차순 또는 오름차순으로 정렬할 수 있다.
<table>
<tr>
  <td>
  <img src="https://user-images.githubusercontent.com/23499504/148017096-52b9a120-3c3b-4394-aad6-bf3ae800423a.png" width="200"/>
  <img src="https://user-images.githubusercontent.com/23499504/148017111-e9c7fc56-1d24-48bb-8327-47e3eb39157b.png" width="200"/>
  <img src="https://user-images.githubusercontent.com/23499504/148017204-0fbe0d7a-de20-4cde-a121-4db52328be9e.png" width="200"/>
  </td>
</tr>
</table>

3. 아래로 스크롤을 내려 다음 페이지의 정보를 가져올 수 있다.

![image](https://user-images.githubusercontent.com/23499504/148018324-10023bfe-37c5-46cb-8b2b-ba0d7e6e2cd8.gif)
